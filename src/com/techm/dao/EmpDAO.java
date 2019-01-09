package com.techm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.techm.model.Referral;
import com.techm.util.DbFactory;

public class EmpDAO {
							Connection con;
							PreparedStatement ps;
			public int referABuddy(Referral ref){
				int x = 0;
				try {
					con = DbFactory.getConnection();
					ps = con.prepareStatement("insert into referral_details values(?,?,?,?,?,?,?,?,?)");
					ps.setString(1, ref.getReferralId());
					ps.setString(2, ref.getBuddyName());
					System.out.println("DAO---->"+ref.getJobcode());
					ps.setString(3, ref.getJobcode());
					ps.setString(4, ref.getSkill());
					ps.setString(5, "In Progress");
					ps.setString(6, ref.getUsername());
					ps.setString(7, ref.getExperience());
					ps.setInt(8, 0);
					ps.setString(9, ref.getBuddyMobNo());

					x = ps.executeUpdate();
					if (x == 1) {
						x = 1;
					} else {
						x = 0;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return x;
			}
			
		public ArrayList<Referral> checkReferralStatus(String username){
			con = DbFactory.getConnection();
			ArrayList<Referral> al = new ArrayList<Referral>();
			try {
				ps = con.prepareStatement("select * from referral_details where username=?");
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {

					Referral ref= new Referral();
					ref.setBuddyMobNo(rs.getString("buddymobno"));
					ref.setBuddyName(rs.getString("buddyname"));
					ref.setJobcode(rs.getString("jobcode"));
					ref.setExperience(rs.getString("expr"));
					ref.setReferralId(rs.getString("referralid"));
					ref.setUsername(rs.getString("username"));
					ref.setSkill(rs.getString("skill"));
					

					al.add(ref);

				}
			} catch (Exception e) {
				System.out.println(e);
			}
			return al;
		}
}
