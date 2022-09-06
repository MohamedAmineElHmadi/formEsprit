package com.ssd.esprithub.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssd.esprithub.entity.Cours;
import com.ssd.esprithub.entity.UE;
import com.ssd.esprithub.exception.RessourceNotFoundException;
import com.ssd.esprithub.repository.CoursRepository;
import com.ssd.esprithub.repository.UeRepository;
import com.ssd.esprithub.service.UEService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("Ue")
public class UeController {

	@Autowired
	private UeRepository ueRepository;
	
	 @GetMapping("/Ues")
	    public List <UE> getAllUE(){
	        return ueRepository.findAll();
	    }
	 @PostMapping("/Ue")
	    public UE createCours( @Validated @RequestBody UE ue) {
	    	return ueRepository.save(ue);
	    }
	 
	  @GetMapping("/Ue/{id}")
	    public ResponseEntity<UE> getUEById( @PathVariable(value="id") Long id) 
	    		throws RessourceNotFoundException {
	    UE ue= ueRepository.findById(id)
	    		.orElseThrow(()-> new RessourceNotFoundException("UE Not Found"+id));
	    return ResponseEntity.ok().body(ue);
	    }
	  
	   @PutMapping("/Ue/{id}")
		public ResponseEntity<UE> updateUE(@PathVariable(value = "id") Long Id,
				@Validated @RequestBody UE ueDetails) 
						throws RessourceNotFoundException {
			UE ue = ueRepository.findById(Id)
					.orElseThrow(() -> new RessourceNotFoundException("UE not found for this id :: " + Id));

			ue.setLibelle(ueDetails.getLibelle());
			final UE updatedUE = ueRepository.save(ue);
			return ResponseEntity.ok(updatedUE);
		}
	   
	   @DeleteMapping("/Ue/{id}")
		public Map<String, Boolean> deleteUE(@PathVariable(value = "id") Long Id)
				throws RessourceNotFoundException {
		   UE ue = ueRepository.findById(Id)
					.orElseThrow(() -> new RessourceNotFoundException("UE not found for this id :: " + Id));

		   ueRepository.delete(ue);
			Map<String, Boolean> response = new HashMap<>();
			response.put("UE has been deleted:", Boolean.TRUE);
			return response;
		}
	   
	   @Autowired
	   UEService ueService;
	   @PutMapping("/affecterCourseUE/{idCourse}/{idUe}")
	   @ResponseBody
	   public String affecterCourseUE(@PathVariable("idUe")Long idUe,@PathVariable("idCourse")Long idCourse ) {
		   ueService.affecterCoursUE(idCourse, idUe);
		   return "Done";
		   
	   }
	   


	   
}
