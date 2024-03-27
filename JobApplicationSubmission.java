package com.task;

import java.sql.*;

public class JobApplicationSubmission {
    // JDBC URL, username, and password
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/careerhub";
    static final String USERNAME = "root";
    static final String PASSWORD = "Rishitha@14";

    public static void submitJobApplication(int applicantID, int jobID, String coverLetter) {
        String sql = "INSERT INTO Applications (ApplicantID, JobID, CoverLetter, ApplicationDate) " +
                     "VALUES (?, ?, ?, NOW())";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Set parameters
            pstmt.setInt(1, applicantID);
            pstmt.setInt(2, jobID);
            pstmt.setString(3, coverLetter);

            // Execute the insertion query
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Job application submitted successfully.");
            } else {
                System.out.println("Failed to submit the job application.");
            }
        } catch (SQLException e) {
            System.err.println("Error submitting job application: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Example usage: Submit a job application
        int applicantID = 1; // Assuming applicant ID
        int jobID = 1; // Assuming job ID
        String coverLetter = "This is my cover letter for the job application.";

        submitJobApplication(applicantID, jobID, coverLetter);
    }
}

