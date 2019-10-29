package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Candy;
import com.revature.util.ConnectionUtil;

public class CandyDao {

	public Candy save(Candy candy) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO CANDY (name, cost, quantity, "
					+ " flavor) VALUES (?, ?, ?, ?) RETURNING id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, candy.getName());
			ps.setDouble(2, candy.getCost());
			ps.setInt(3, candy.getQuantity());
			ps.setString(4, candy.getFlavor());
			
			ResultSet results = ps.executeQuery();
			
			if (results.next()) {
				candy.setId(results.getInt("id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return candy;
	}

}
