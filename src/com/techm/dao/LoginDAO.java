package com.techm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.techm.model.Login;
import com.techm.util.DbFactory;

public class LoginDAO {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public String loginValidation(Login login) {
		String role = "";
		try {

			con = DbFactory.getConnection();
			ps = con.prepareStatement("select * from Login_Details where username=? and password=?");
			ps.setString(1, login.getUsername());
			ps.setString(2, login.getPassword());
			rs = ps.executeQuery();
			if (rs.next()) {
					role = rs.getString("role");
					login.setFirstName(rs.getString("fname"));
					login.setLastName(rs.getString("lname"));
				}else{
					role="invalid";
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return role;

	}
}
