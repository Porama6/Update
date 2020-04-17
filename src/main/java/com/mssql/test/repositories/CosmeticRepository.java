package com.mssql.test.repositories;

import com.mssql.test.entities.Cosmetic;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CosmeticRepository  extends JpaRepository<Cosmetic, String>{

}