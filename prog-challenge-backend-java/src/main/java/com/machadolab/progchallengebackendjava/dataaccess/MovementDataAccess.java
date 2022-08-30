package com.machadolab.progchallengebackendjava.dataaccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.machadolab.progchallengebackendjava.mapper.MovementMapper;
import com.machadolab.progchallengebackendjava.models.Movement;

@Repository
public class MovementDataAccess implements IMovementDataAccess {

	NamedParameterJdbcTemplate template;
	public MovementDataAccess(NamedParameterJdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public List<Movement> FetchAllMovementRecords() {
		// TODO Auto-generated method stub
		try {
			return template.query("SELECT * from movements ORDER BY id DESC", new MovementMapper());
		} catch (Exception ex) {
			return new ArrayList<Movement>();			
		}
	}

	@Override
	public int InsertMovementRecord(Movement movementRecord) {
		// TODO Auto-generated method stub
		try {
			String query = "INSERT INTO public.movements("
				+ "company, reason, species, moved_count, start_date, origin_premise_id, dest_premise_id) "
				+ "VALUES (:company, :reason, :species, :movedCount, :startDate, :originPremiseId, :destinationPremiseId);";
			KeyHolder holder = new GeneratedKeyHolder();
			SqlParameterSource params = new MapSqlParameterSource()
					.addValue("company", movementRecord.getCompanyName())
					.addValue("reason", movementRecord.getReason())
					.addValue("species", movementRecord.getSpecies())
					.addValue("movedCount", movementRecord.getMovedCount())
					.addValue("startDate", movementRecord.getStartDate())
					.addValue("originPremiseId", movementRecord.getOriginPremiseId())
					.addValue("destinationPremiseId", movementRecord.getDestinationPremiseId());
			int rowsAffected = template.update(query, params, holder);
			if (rowsAffected > 0) {
				Map<String, Object> keys = holder.getKeys();
				String id = keys.get("id").toString();
				return Integer.parseInt(id);
			}
			return -1;
		} catch (Exception ex) {
			return -1;			
		}
	}

}
