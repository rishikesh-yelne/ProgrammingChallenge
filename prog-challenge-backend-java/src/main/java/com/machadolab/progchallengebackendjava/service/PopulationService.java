package com.machadolab.progchallengebackendjava.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.machadolab.progchallengebackendjava.dataaccess.PopulationDataAccess;
import com.machadolab.progchallengebackendjava.models.Population;

@Service
public class PopulationService implements IPopulationService {

	@Resource
	PopulationDataAccess populationDA;
	
	@Override
	public List<Population> GetAllRecords() {
		// TODO Auto-generated method stub
		return populationDA.FetchAllRecords();
	}

	@Override
	public boolean UpdateRecord(Population record) {
		// TODO Auto-generated method stub
		return populationDA.UpdateRecord(record);
	}

	@Override
	public Population GetPopulationRecordById(int id) {
		// TODO Auto-generated method stub
		return populationDA.GetRecordById(id);
	}
	
	@Override
	public Population GetPopulationRecordByPremiseId(String premiseId) {
		// TODO Auto-generated method stub
		return populationDA.GetRecordByPremiseId(premiseId);
	}
	
}