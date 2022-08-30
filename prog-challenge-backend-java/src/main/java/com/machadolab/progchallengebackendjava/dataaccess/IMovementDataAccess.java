package com.machadolab.progchallengebackendjava.dataaccess;

import java.util.List;

import com.machadolab.progchallengebackendjava.models.Movement;

public interface IMovementDataAccess {
	public List<Movement> FetchAllMovementRecords();
	public int InsertMovementRecord(Movement movementRecord);
}

