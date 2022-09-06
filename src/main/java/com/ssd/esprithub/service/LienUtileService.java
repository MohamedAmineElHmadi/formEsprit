package com.ssd.esprithub.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssd.esprithub.entity.Cours;
import com.ssd.esprithub.entity.LienUtile;
import com.ssd.esprithub.entity.UE;
import com.ssd.esprithub.repository.CoursRepository;
import com.ssd.esprithub.repository.LienUtileRepository;
import com.ssd.esprithub.repository.UeRepository;

public class LienUtileService implements ILienUtileService {
	@Autowired
	LienUtileRepository luRepo;
	@Autowired
	CoursRepository courseRepo;
	

			@Override
			@Transactional
			public void affecterLienCours(Long  idCours, Long idLien) {
				LienUtile lu= luRepo.findById(idLien).get();
				Cours course= courseRepo.findById(idCours).get();
				lu.setCourslien(course);
				luRepo.save(lu);
			}
}
