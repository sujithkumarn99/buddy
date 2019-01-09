package com.techm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.techm.model.Job;
import com.techm.model.Referral;
import com.techm.util.DbFactory;

public class SpocDAO {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public int addNewJob(Job job) {
		int x = 0;
		try {
			con = DbFactory.getConnection();
			ps = con.prepareStatement("insert into jobs values(?,?,?,?,?,?)");
			ps.setString(1, job.getJobcode());
			ps.setString(2, job.getSkill());
			ps.setString(3, job.getExp());
			ps.setString(4, job.getLocation());
			ps.setString(5, job.getSpocName());
			ps.setString(6, job.getMailId());

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

	public ArrayList<Job> viewExistingJobs() {
		con = DbFactory.getConnection();
		ArrayList<Job> al = new ArrayList<Job>();
		try {
			ps = con.prepareStatement("select * from jobs");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Job job = new Job();
				job.setJobcode(rs.getString("jobcode"));
				job.setSkill(rs.getString("skill"));
				job.setExp(rs.getString("experience"));
				job.setLocation(rs.getString("location"));
				job.setSpocName(rs.getString("sname"));
				job.setMailId(rs.getString("smailid"));

				al.add(job);

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return al;
	}

	public ArrayList<Job> viewJobDetails(String jobCode) {
		con = DbFactory.getConnection();
		ArrayList<Job> al = new ArrayList<Job>();
		try {
			ps = con.prepareStatement("select * from jobs where jobcode=?");
			ps.setString(1, jobCode);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Job job = new Job();
				job.setJobcode(rs.getString("jobcode"));
				job.setSkill(rs.getString("skill"));
				job.setExp(rs.getString("experience"));
				job.setLocation(rs.getString("location"));
				job.setSpocName(rs.getString("sname"));
				job.setMailId(rs.getString("smailid"));

				al.add(job);

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return al;
	}

	public int updateJobDetails(Job job) {
		int x = 0;
		try {
			con = DbFactory.getConnection();
			ps = con.prepareStatement("update jobs set skill =?, experience=?, location=? where jobcode=?");
			System.out.println("jobcode"+job.getJobcode());
			ps.setString(1, job.getSkill());
			ps.setString(2, job.getExp());
			ps.setString(3, job.getLocation());
			ps.setString(4, job.getJobcode());
			x = ps.executeUpdate();
			System.out.println("update"+x);
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

	public int deleteJobs(String jobCode) {
		int x = 0;
		try {
			con = DbFactory.getConnection();
			ps = con.prepareStatement("delete from jobs where jobcode=?");
			ps.setString(1, jobCode);
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
	
	public ArrayList<Referral> viewBuddyRequest(){
		con = DbFactory.getConnection();
		ArrayList<Referral> al = new ArrayList<Referral>();
		try {
			ps = con.prepareStatement("select * from referral_details where referralstatus='In Progress'");
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
