package com.dbmanager;

import java.sql.SQLException;
import java.sql.Time;

import com.careerhub.JobApplication;

public class Applicant_main {
    public static void main(String[] args) throws SQLException {
        // Create a new JobApplication object
        JobApplication application = new JobApplication();
        
        // Set attributes of the JobApplication object
        application.setApplicationID(1); // Set the application ID (if applicable)
        application.setJobID(123); // Set the job ID
        application.setApplicantID(456); // Set the applicant ID
        application.setApplicationDate(new Time(0)); // Set the application date
        application.setCoverLetter("This is a cover letter for the job application."); // Set the cover letter
        
        // Create a new DatabaseManager object
        DatabaseManager databaseManager = new DatabaseManager();
        
        // Insert the JobApplication object into the database
		databaseManager.InsertJobApplication(application);
		
		System.out.println("Job application inserted successfully.");
    }
}