package com.techm.model;

public class Referral {
	private String referralId;
	private String jobcode;
	private String buddyName;
	private String buddyMobNo;
	private String skill;
	private String experience;
	private String username;
	private String referralStatus;

	
	public String getReferralStatus() {
		return referralStatus;
	}

	public void setReferralStatus(String referralStatus) {
		this.referralStatus = referralStatus;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getReferralId() {
		return referralId;
	}

	public void setReferralId(String referralId) {
		this.referralId = referralId;
	}

	public String getJobcode() {
		return jobcode;
	}

	public void setJobcode(String jobcode) {
		this.jobcode = jobcode;
	}

	public String getBuddyName() {
		return buddyName;
	}

	public void setBuddyName(String buddyName) {
		this.buddyName = buddyName;
	}

	public String getBuddyMobNo() {
		return buddyMobNo;
	}

	public void setBuddyMobNo(String buddyMobNo) {
		this.buddyMobNo = buddyMobNo;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

}
