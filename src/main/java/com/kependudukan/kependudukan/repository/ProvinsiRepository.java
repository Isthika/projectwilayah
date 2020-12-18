package com.kependudukan.kependudukan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.kependudukan.kependudukan.entity.Provinsi;

@Repository
public interface ProvinsiRepository extends JpaRepository<Provinsi, Integer>{
	Provinsi findByKodeProvinsiIgnoreCase(String kodeProvinsi);

	@Query(value ="SELECT *FROM provinsi WHERE is_active = true", nativeQuery = true)
	List<Provinsi> findAllActive();
}
