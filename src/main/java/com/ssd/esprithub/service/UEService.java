package com.ssd.esprithub.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssd.esprithub.entity.Cours;
import com.ssd.esprithub.entity.Question;
import com.ssd.esprithub.entity.Tag;
import com.ssd.esprithub.entity.UE;
import com.ssd.esprithub.repository.CoursRepository;
import com.ssd.esprithub.repository.UeRepository;

@Service
public class UEService implements IUEService{

	@Autowired
	UeRepository ueRepo;
	@Autowired
	CoursRepository courseRepo;
	
		@Override
		@Transactional
		public void affecterCoursUE(Long idCours, Long idUE) {
			UE ue= ueRepo.findById(idUE).get();
			Cours course= courseRepo.findById(idCours).get();
			course.setUecours(ue);
			courseRepo.save(course);
		}
		
}
