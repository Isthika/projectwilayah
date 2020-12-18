package com.kependudukan.kependudukan.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.kependudukan.kependudukan.dto.ProvinsiDto;
import com.kependudukan.kependudukan.entity.Provinsi;
import com.kependudukan.kependudukan.repository.ProvinsiRepository;

@Service
@Transactional
public class ProvinsiServiceImpl implements ProvinsiService  {

		@Autowired
		private ProvinsiRepository provinsiRepository;
		
		@Override
		public List<Provinsi> getAllProvinsi() {
			List<Provinsi> allProvinsi = provinsiRepository.findAllActive();
			return allProvinsi;
		}
		
		@Override
		public Provinsi getDetailProvinsi(String kodeProvinsi) {
			Provinsi provinsi = provinsiRepository.findByKodeProvinsiIgnoreCase(kodeProvinsi);
			return provinsi;
		}
		
		
		@Override
		public Provinsi createProvinsi(ProvinsiDto provinsiDto) {
			Provinsi provinsi = new Provinsi();
			provinsi.setNamaProvinsi(provinsiDto.getNamaProvinsi());
			provinsi.setActive(true);
			provinsi.setKodeProvinsi("PROV");
			provinsiRepository.save(provinsi);
			
			String kodeProvinsi = "PROV" + provinsi.getId();
			provinsi.setKodeProvinsi(kodeProvinsi);
			
			provinsiRepository.save(provinsi);
			return provinsi;
		}

		@Override
		public Provinsi updateProvinsi(ProvinsiDto provinsiDto, String kodeProvinsi) {
			Provinsi provinsi = provinsiRepository.findByKodeProvinsiIgnoreCase(kodeProvinsi);
			provinsi.setNamaProvinsi(provinsiDto.getNamaProvinsi());
			provinsi.setKodeProvinsi(provinsiDto.getKodeProvinsi());
			provinsiRepository.save(provinsi);
			
			return provinsi;
		}

		@Override
		public Provinsi deleteProvinsi(String kodeProvinsi) {
			Provinsi provinsi = provinsiRepository.findByKodeProvinsiIgnoreCase(kodeProvinsi);
			provinsi.setActive(false);
			provinsiRepository.save(provinsi);
			
			return provinsi;
		}
}
