package com.kependudukan.kependudukan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "provinsi")
@Data
public class Provinsi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@JsonIgnore
	private Integer id;
	
	@Column(length = 10, unique = true, nullable = false)
	private String kodeProvinsi;
	
	
	@Column(nullable = false)
	private String namaProvinsi;
	
	@Column
	@JsonIgnore
	private boolean isActive;
	

}
