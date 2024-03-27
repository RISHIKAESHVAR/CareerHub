package com.careerhub;

import java.sql.Time;

public class JobApplication {
    private int applicationID;
    private int jobID;
    private int applicantID;
    private Time applicationDate;
    private String coverLetter;

    // Getters and Setters
    public int getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(int applicationID) {
        this.applicationID = applicationID;
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public int getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(int applicantID) {
        this.applicantID = applicantID;
    }

    public Time getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Time applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }
}

