package com.careerhub;

public class Applicant {
    private int applicantID;
    private String firstName;
    private String lastName;
    private String email;
    private int phone;
    private String resume;
    
    public int getApplicantID() {
		return applicantID;
	}

	public void setApplicantID(int applicantID) {
		this.applicantID = applicantID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}
	
	public String getfirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getlastName() {
		return lastName;
	}
	
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

    // Method to create applicant profile
    public void createProfile(String email, String firstName, String lastName, int phone) {
        this.setEmail(email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.setPhone(phone);
    }

    // Method to apply for job
    public void applyForJob(int jobID, String coverLetter) {
        // Logic to apply for job goes here
        System.out.println("Applicant " + firstName + " " + lastName + " applied for job with ID " + jobID);
    }
}
