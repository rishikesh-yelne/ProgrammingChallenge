package com.machadolab.progchallengebackendjava.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.machadolab.progchallengebackendjava.dataaccess.MovementDataAccess;
import com.machadolab.progchallengebackendjava.models.Movement;
import com.machadolab.progchallengebackendjava.models.Population;

@Service
public class MovementService implements IMovementService {

	@Resource
	MovementDataAccess movementDA;
	@Resource
	PopulationService populationService;
	
	@Override
	public List<Movement> GetAllRecords() {
		// TODO Auto-generated method stub
		return movementDA.FetchAllMovementRecords();
	}

	@Override
	public int InsertRecord(Movement record) {
		// TODO Auto-generated method stub
		int recordId = movementDA.InsertMovementRecord(record);
		Population origin = populationService.GetPopulationRecordByPremiseId(record.OriginPremiseId);
		Population destination = populationService.GetPopulationRecordByPremiseId(record.DestinationPremiseId);
		origin.TotalAnimalCount -= record.MovedCount;
		destination.TotalAnimalCount += record.MovedCount;
		populationService.UpdateRecord(origin);
		populationService.UpdateRecord(destination);
		return recordId;
	}

}
