package com.kependudukan.kependudukan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kependudukan.kependudukan.dto.ProvinsiDto;
import com.kependudukan.kependudukan.dto.StatusMessageDto;
import com.kependudukan.kependudukan.entity.Provinsi;
import com.kependudukan.kependudukan.service.ProvinsiServiceImpl;

@RestController
@RequestMapping("/provinsi")
public class ProvinsiController {
	
	@Autowired
	private ProvinsiServiceImpl provinsiService;
	
	private StatusMessageDto result = new StatusMessageDto();
	
//	Get all provinsi
	@GetMapping
	public ResponseEntity<?> getAllProvinsi(){
		try {
			List<Provinsi> allProvinsi = provinsiService.getAllProvinsi();
			
			result.setStatus(200);
			result.setMessages("succsess");
			result.setData(allProvinsi);
			
			if (allProvinsi.size() == 0) {
				result.setStatus(400);
				result.setMessages("Bad Request");
				result.setData(null);
				
				return ResponseEntity.badRequest().body(result);
			}
			
			return ResponseEntity.ok(result);
		
		} catch (Exception e) {
			StatusMessageDto error = new StatusMessageDto(500,e.getMessage(), null);
			return ResponseEntity.status(500).body(error);
		}
	}
	
//	Get detail provinsi
	@GetMapping("/{kodeProvinsi}")
	public ResponseEntity<?> getDetailProvinsi(@PathVariable String kodeProvinsi){
		try {
			Provinsi provinsi = provinsiService.getDetailProvinsi(kodeProvinsi);
			
			result.setStatus(200);
			result.setMessages("succsess");
			result.setData(provinsi);
			
			if (provinsi == null) {
				result.setStatus(400);
				result.setMessages("Data not found");
				result.setData(provinsi);
			
				return ResponseEntity.status(400).body(result);
			}
			
			return ResponseEntity.ok(result);
		
		} catch (Exception e) {
			StatusMessageDto error = new StatusMessageDto(500,e.getMessage(), null);
			return ResponseEntity.status(500).body(error);
	
		}
	}
	@PostMapping
	public ResponseEntity<?> createNewProvinsi(@RequestBody ProvinsiDto provinsiDto){
		try {
			Provinsi provinsi = provinsiService.createProvinsi(provinsiDto);
			
			result.setStatus(201);
			result.setMessages("Created");
			result.setData(provinsi);
			
			return ResponseEntity.status(200).body(result);
		} catch (Exception e) {
			StatusMessageDto error = new StatusMessageDto(500,e.getMessage(), null);
			return ResponseEntity.status(500).body(error);
		}
	}
	
	@PutMapping("/{kodeProvinsi}")
	public ResponseEntity<?> updateProvinsi(@RequestBody ProvinsiDto provinsiDto, @PathVariable String kodeProvinsi){
		
		try {
			Provinsi provinsi = provinsiService.updateProvinsi(provinsiDto, kodeProvinsi);
			
			result.setStatus(200);
			result.setMessages("Updated");
			result.setData(provinsi);
			
			return ResponseEntity.status(200).body(result);
		} catch (Exception e) {
			StatusMessageDto error = new StatusMessageDto(500,e.getMessage(),null);
			return ResponseEntity.status(500).body(error);
		}
	}
	
	@DeleteMapping("/{kodeProvinsi}")
	public ResponseEntity<?> deleteProvinsi(@PathVariable String kodeProvinsi){
		try {
			Provinsi provinsi = provinsiService.deleteProvinsi(kodeProvinsi);
			
			result.setStatus(200);
			result.setMessages("Deleted");
			result.setData(provinsi);
			
			return ResponseEntity.status(200).body(result);
		}catch (Exception e) {
			StatusMessageDto error = new StatusMessageDto(500,e.getMessage(),null);
			return ResponseEntity.status(500).body(error);
		}
	}
	
}
