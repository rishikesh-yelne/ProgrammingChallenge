package com.machadolab.progchallengebackendjava.dataaccess;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.machadolab.progchallengebackendjava.mapper.PopulationMapper;
import com.machadolab.progchallengebackendjava.models.Population;

@Repository
public class PopulationDataAccess implements IPopulationDataAccess {
	
	NamedParameterJdbcTemplate template;
	public PopulationDataAccess(NamedParameterJdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public List<Population> FetchAllRecords() {
		// TODO Auto-generated method stub
		try {
			return template.query("SELECT * FROM population ORDER BY id", new PopulationMapper());			
		} catch (Exception ex) {
			return new ArrayList<>();
		}
	}
	
	@Override
	public boolean UpdateRecord(Population populationRecord) {
		// TODO Auto-generated method stub
		try {
			String query = "UPDATE population SET total_animal_count=:totalAnimalCount WHERE premise_id=:premiseId;";
			KeyHolder holder = new GeneratedKeyHolder();
			SqlParameterSource params = new MapSqlParameterSource()
					.addValue("premiseId", populationRecord.getPremiseId())
					.addValue("totalAnimalCount", populationRecord.getTotalAnimalCount());
			return template.update(query, params, holder) > 0;
		} catch (Exception ex) {
			return false;			
		}
	}

	@Override
	public Population GetRecordById(int id) {
		// TODO Auto-generated method stub
		try {
			String query = "SELECT * FROM population WHERE id=:id";
			SqlParameterSource params = new MapSqlParameterSource().addValue("id", id);
			List<Population> records = template.query(query, params, new PopulationMapper());
			if (records.size() > 0) return records.get(0);
			return new Population();
		} catch (Exception ex) {
			return new Population();
		}
	}

	@Override
	public Population GetRecordByPremiseId(String premiseId) {
		// TODO Auto-generated method stub
		try {
			String query = "SELECT * FROM population WHERE premise_id=:premiseId";
			SqlParameterSource params = new MapSqlParameterSource().addValue("premiseId", premiseId);
			List<Population> records = template.query(query, params, new PopulationMapper());
			if (records.size() > 0) return records.get(0);
			return new Population();
		} catch (Exception ex) {
			return new Population();
		}
	}
}