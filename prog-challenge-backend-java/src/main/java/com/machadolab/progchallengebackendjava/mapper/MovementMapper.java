package com.machadolab.progchallengebackendjava.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.machadolab.progchallengebackendjava.models.*;

public class MovementMapper implements RowMapper<Movement> {

	@Override
	public Movement mapRow(ResultSet rs, int arg1) throws SQLException {
		Movement movementRow = new Movement();
		movementRow.setId(rs.getInt("id"));
		movementRow.setCompanyName(rs.getString("company"));
		movementRow.setReason(rs.getString("reason"));
		movementRow.setSpecies(rs.getString("species"));
		movementRow.setMovedCount(rs.getInt("moved_count"));
		movementRow.setStartDate(rs.getDate("start_date"));
		movementRow.setOriginPremiseId(rs.getString("origin_premise_id"));
		movementRow.setDestinationPremiseId(rs.getString("dest_premise_id"));
 
        return movementRow;
	}
}