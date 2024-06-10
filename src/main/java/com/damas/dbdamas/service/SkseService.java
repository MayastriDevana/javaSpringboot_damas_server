package com.damas.dbdamas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbdamas.model.Skse;
import com.damas.dbdamas.payload.SkseRequest;
import com.damas.dbdamas.payload.SkseResponse;
import com.damas.dbdamas.repository.SkseRepository;

import jakarta.transaction.Transactional;

@Service
public class SkseService {

    @Autowired
    private SkseRepository skseRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public SkseResponse newSkse(SkseRequest userid, String token) {
        validationService.validateRequest(userid);

        Skse skse = new Skse();
        skse.setNosurat(userid.getNosurat());
        skse.setPerihal(userid.getPerihal());
        skse.setPic(userid.getPic());
        skse.setDepartement(userid.getDepartement());
        skse.setDeadline(userid.getDeadline());
        skse.setStatus(userid.getStatus());

        skseRepository.save(skse);

        return SkseResponse.builder().nosurat(skse.getNosurat()).perihal(skse.getPerihal()).pic(skse.getPic())
                .departement(skse.getDepartement())
                .deadline(skse.getDeadline()).status(skse.getStatus()).build();
    }

    @Transactional
    public List<SkseResponse> findSkse(String userid, String input) {

        validationService.validateRequest(userid);

        List<Skse> skseByPerihal = skseRepository.searchByPerihalorPic(input);

        List<SkseResponse> response = skseByPerihal.stream()
                .map(item -> new SkseResponse(
                        item.getId(),
                        item.getNosurat(),
                        item.getPerihal(),
                        item.getPic(),
                        item.getDepartement(),
                        item.getDeadline(),
                        item.getStatus(),
                        skseByPerihal.size()))
                .collect((Collectors.toList()));
        return response;
    }

      @Transactional
    public SkseResponse editedSkse(String userid, SkseRequest request, String input) {

        validationService.validateRequest(userid);


        Skse skse = skseRepository.findById(input)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Project not found"));

        skse.setNosurat(request.getNosurat());
        skse.setPerihal(request.getPerihal());
        skse.setPic(request.getPic());
        skse.setDepartement(request.getDepartement());
        skse.setDeadline(request.getDeadline());
        skse.setStatus(request.getStatus());
        
        skseRepository.save(skse);

        return SkseResponse.builder()
                .nosurat(skse.getNosurat())
                .perihal(skse.getPerihal())
                .pic(skse.getPic())
                .departement(skse.getDepartement())
                .deadline(skse.getDeadline())
                .status(skse.getStatus())
                .build();
    }

    @Transactional
    public List<SkseResponse> findAll(String userid, Long start, Long size) {
        validationService.validateRequest(userid);

        List<Skse> skseAll = skseRepository.findAll();

        List<SkseResponse> response = skseAll.stream()
                .skip(start).limit(size)
                .map(item -> new SkseResponse(
                    item.getId(),
                        item.getNosurat(),
                        item.getPerihal(),
                        item.getPic(),
                        item.getDepartement(),
                        item.getDeadline(),
                        item.getStatus(),
                        skseAll.size()))
                .collect(Collectors.toList());

        return response;

    }

}
