package com.kependudukan.kependudukan.service;

import java.util.List;

import com.kependudukan.kependudukan.dto.ProvinsiDto;
import com.kependudukan.kependudukan.entity.Provinsi;

public interface ProvinsiService {
	List<Provinsi> getAllProvinsi();
	Provinsi getDetailProvinsi(String kodeProvinsi);
	Provinsi createProvinsi(ProvinsiDto provinsiDto);
	Provinsi updateProvinsi(ProvinsiDto provinsiDto, String kodeProvinsi);
	Provinsi deleteProvinsi(String kodeProvinsi);
}
