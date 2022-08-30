package com.machadolab.progchallengebackendjava.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.machadolab.progchallengebackendjava.models.Movement;
import com.machadolab.progchallengebackendjava.service.MovementService;

@RestController
@RequestMapping("/movement")
@CrossOrigin(origins = "http://localhost:4200")
public class MovementController {
	
	@Resource
	MovementService movementService;
	
	@GetMapping("/all")
	public List<Movement> GetAllMovementRecords() {
		return movementService.GetAllRecords();
	}
	
	@PostMapping("/add")
	public int InsertMovementRecord(@RequestBody Movement movementRecord) {
		return movementService.InsertRecord(movementRecord);
	}
}