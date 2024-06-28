package com.damas.utils.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.utils.payload.EmailRequest;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        message.setFrom("no-reply@bcasyariah.co.id");
        mailSender.send(message);
    }

    public void scheduleEmail(EmailRequest request) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm:ss");
            LocalDateTime deadline = LocalDateTime.parse(request.getDeadline(), formatter);
            LocalDateTime deadlinepro = LocalDateTime.parse(request.getDeadlinepro(), formatter);

            LocalDateTime now = LocalDateTime.now();
            long delayStartDeadline = ChronoUnit.MILLIS.between(now, deadline);
            long delayDeadlinePro = ChronoUnit.MILLIS.between(now, deadlinepro);

            if (delayDeadlinePro > 0) {
                if (delayStartDeadline < 0) {
                    sendEmail(request.getTo(), request.getSubject(), request.getText());
                } else {
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            sendEmail(request.getTo(), request.getSubject(), request.getText());
                        }
                    }, delayStartDeadline);
                }
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "schedule must be at least one day ahead!!!");
            }
        } catch (DateTimeParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid date format in request.", e);
        } catch (Exception e) {
            e.printStackTrace(); // Menampilkan stack trace ke konsol
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected error occurred.", e);
        }
    }
}
