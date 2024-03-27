package com.careerhub;

import java.sql.Timestamp;
import java.util.List;

public class JobListing {
    private int jobID;
    private int companyID;
    private String jobTitle;
    private String jobDescription;
    private String jobLocation;
    private double salary;
    private String jobType;
    private Timestamp postedDate;
    private List<Applicant> applicants;

    // Getters and Setters 
    
    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public Timestamp getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Timestamp postedDate) {
        this.postedDate = postedDate;
    }

    public List<Applicant> getApplicants1() {
        return applicants;
    }
    
    public void apply(int applicantID, String resume) {
        // Create a new Applicant object
        Applicant applicant = new Applicant();
        applicant.setApplicantID(applicantID);
        applicant.setResume(resume);
        
        // Add the applicant to the list of applicants
        applicants.add(applicant);
        
        // Print confirmation message
        System.out.println("Applicant with ID " + applicantID + " applied for the job successfully");
    }

    // Method to retrieve list of applicants
    public List<Applicant> getApplicants() {
        // Return the list of applicants
        return applicants;
    }
}

