package com.machadolab.progchallengebackendjava.controllers;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.machadolab.progchallengebackendjava.models.Population;
import com.machadolab.progchallengebackendjava.service.PopulationService;

@RestController
@RequestMapping("/population") 
@CrossOrigin(origins = "http://localhost:4200")
public class PopulationController {
	
	@Resource
	PopulationService populationService;
	
	@GetMapping("/all")
	public List<Population> GetAllPopulationRecords() {
		return populationService.GetAllRecords();
	}
	
	@GetMapping("/record")
	public Population GetPopulationRecord(@RequestParam String premiseId) {
		return populationService.GetPopulationRecordByPremiseId(premiseId);
	}
	
	@PutMapping("/update")
	public boolean UpdatePopulationCount(@RequestParam String premiseId, @RequestParam int totalCount) {
		return populationService.UpdateRecord(new Population(premiseId, totalCount));
	}
}