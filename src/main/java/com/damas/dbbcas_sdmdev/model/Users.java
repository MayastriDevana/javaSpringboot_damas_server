package com.damas.dbbcas_sdmdev.model;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "catapa_id")
    private String catapaid;

    private String identificationNumber;

    private String nik;

    private String nama;
    
    private String email;

    @Column(name = "user_domain")
    private String userdomain;

    private String golongan;

    @Column(name = "kode_golongan")
    private String kodegolongan;

    private String jabatan;

    private String bagian;

    @Column(name = "bidang_fungsi")
    private String bidangfungsi;

    private String departement;

    @Column(name = "satuan_kerja")
    private String satuankerja;

    @Column(name = "tgl_join")
    private String tgljoin;

    @Column(name = "status_karyawan")
    private String statuskaryawan;

    @Column(name = "tgl_tetap")
    private String tgltetap;

    @Column(name = "lokasi_kerja")
    private String lokasikerja;

    @Column(name = "alamat_surat")
    private String alamatsurat;

    private String phone;

    @Column(name = "nomor_rekening")
    private String nomorrekening;

    private String manager;

    @Column(name = "kode_cabang")
    private String kodecabang;

    @Column(name = "last_update")
    private String last_update;

    @Column(name = "terminate_date")
    private String terminatedate;

    @Column(name = "terminate_reason")
    private String terminate_reason;

}
