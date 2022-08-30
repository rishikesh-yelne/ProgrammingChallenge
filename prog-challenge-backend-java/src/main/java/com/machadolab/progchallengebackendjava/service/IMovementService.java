package com.machadolab.progchallengebackendjava.service;

import java.util.List;

import com.machadolab.progchallengebackendjava.models.Movement;

public interface IMovementService {
	List<Movement> GetAllRecords();
	int InsertRecord(Movement record);
}
