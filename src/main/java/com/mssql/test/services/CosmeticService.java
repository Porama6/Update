package com.mssql.test.services;

import java.util.List;
import java.util.Optional;

import com.mssql.test.entities.Cosmetic;
import com.mssql.test.repositories.CosmeticRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CosmeticService {

	@Autowired
	private CosmeticRepository cosmeticRepository;

	public List<Cosmetic> getAllCosmetics() {
		return cosmeticRepository.findAll();
	}

	public Optional<Cosmetic> getCosmeticById(String id) {
		return cosmeticRepository.findById(id);
	}

	public void addCosmetic(List<Cosmetic> cosmetics){
		cosmeticRepository.saveAll(cosmetics);
	}

	public void deleteCosmetic(String id) {
		cosmeticRepository.deleteById(id);
	}

	public void deleteAllCosmetic(List<Cosmetic> cosmetics) {
		cosmeticRepository.deleteAll(cosmetics);
	}
}