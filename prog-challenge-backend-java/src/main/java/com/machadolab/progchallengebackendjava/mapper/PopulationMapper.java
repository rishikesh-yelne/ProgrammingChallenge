package com.machadolab.progchallengebackendjava.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.machadolab.progchallengebackendjava.models.*;

public class PopulationMapper implements RowMapper<Population> {

	@Override
	public Population mapRow(ResultSet rs, int arg1) throws SQLException {
		Population populationRow = new Population();
		populationRow.setId(rs.getInt("id"));
		populationRow.setPremiseId(rs.getString("premise_id"));
		populationRow.setTotalAnimalCount(rs.getInt("total_animal_count"));
		populationRow.setAddress(rs.getString("address"));
		populationRow.setCity(rs.getString("city"));
		populationRow.setName(rs.getString("name"));
		populationRow.setPostalCode(rs.getInt("postalcode"));
		populationRow.setState(rs.getString("state"));
		populationRow.setLatitude(rs.getFloat("lat"));
		populationRow.setLongitude(rs.getFloat("lon"));
 
        return populationRow;
	}
}