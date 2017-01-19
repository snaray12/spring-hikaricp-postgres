package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
        user.setUserId(rs.getInt("id"));
        user.setUserName(rs.getString("name"));
        user.setUserEmail(rs.getString("email"));
        user.setAddress(rs.getString("address"));
        return user;
	}

}
