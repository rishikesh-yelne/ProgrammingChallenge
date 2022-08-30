package com.machadolab.progchallengebackendjava.service;

import java.util.List;

import com.machadolab.progchallengebackendjava.models.Population;

public interface IPopulationService {
	List<Population> GetAllRecords();
	boolean UpdateRecord(Population record);
	Population GetPopulationRecordById(int id);
	Population GetPopulationRecordByPremiseId(String premiseId);
}