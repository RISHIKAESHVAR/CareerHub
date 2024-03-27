//Company Job Posting: Write a program that enables companies to post new job listings. Implement database connectivity to insert job listings into the "Jobs" table, including the company's ID. Handle database-related exceptions and ensure the job posting is successful.

package com.task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JobPostingProgram {
    // Database connection parameters
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/careerhub";
    static final String USERNAME = "root";
    static final String PASSWORD = "Rishitha@14";

    // Method to post a new job listing
    public static boolean postJobListing(int JobID,int companyId, String jobTitle, String jobDescription, String jobLocation,
                                          double salary, String jobType) {
        String sql = "INSERT INTO Jobs (JobID,CompanyID, JobTitle, JobDescription, JobLocation, Salary, JobType) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Set parameters
            pstmt.setInt(1,JobID);
        	pstmt.setInt(2, companyId);
            pstmt.setString(3, jobTitle);
            pstmt.setString(4, jobDescription);
            pstmt.setString(5, jobLocation);
            pstmt.setDouble(6, salary);
            pstmt.setString(7, jobType);

            // Execute the insert statement
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Return true if job posting was successful
        } catch (SQLException e) {
            System.err.println("Error posting job listing: " + e.getMessage());
            return false; // Return false if an error occurred
        }
    }

    public static void main(String[] args) {
        // Example usage: Post a job listing
        int JobID = 14;
    	int companyId = 1; // Assuming a valid company ID
        String jobTitle = "Software Engineer";
        String jobDescription = "Develop software";
        String jobLocation = "Banglore";
        double salary = 80000.00;
        String jobType = "Full-time";

        boolean success = postJobListing(JobID,companyId, jobTitle, jobDescription, jobLocation, salary, jobType);
        if (success) {
            System.out.println("Job posting successful!");
        } else {
            System.out.println("Failed to post job listing.");
        }
    }
}
