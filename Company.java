package com.careerhub;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private int companyID;
    private String companyName;
    private String location;
    private List<JobListing> jobListings;

    // Default Constructor
    public Company() {
        jobListings = new ArrayList<>();
    }

    // Parameterized Constructor
    public Company(int companyID, String companyName, String location) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.location = location;
        jobListings = new ArrayList<>();
    }

    // Getters and Setters
    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public void postJob(String jobTitle, String jobDescription, String jobLocation, double salary, String jobType) {
        JobListing newJob = new JobListing();
        jobListings.add(newJob);
    }

    // Method to retrieve list of job listings posted by the company
    public List<JobListing> getJobs() {
        return jobListings;
    }
}

