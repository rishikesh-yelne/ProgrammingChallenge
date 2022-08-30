package com.machadolab.progchallengebackendjava.dataaccess;

import java.util.List;
import com.machadolab.progchallengebackendjava.models.Population;

public interface IPopulationDataAccess {
	public List<Population> FetchAllRecords();
	public boolean UpdateRecord(Population populationRecord);
	public Population GetRecordById(int id);
	public Population GetRecordByPremiseId(String premiseId);
}