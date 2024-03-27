//Salary Range Query: Create a program that allows users to search for job listings within a specified salary range. Implement database connectivity to retrieve job listings that match the user's criteria, including job titles, company names, and salaries. Ensure the program handles database connectivity and query exceptions.


package com.task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaryRangeQueryProgram {
    // Database connection parameters
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/careerhub";
    static final String USERNAME = "root";
    static final String PASSWORD = "Rishitha@14";

    // Method to retrieve job listings within a specified salary range
    public static List<JobListing> getJobListingsBySalaryRange(double minSalary, double maxSalary) {
        List<JobListing> jobListings = new ArrayList<>();
        String sql = "SELECT j.JobTitle, c.CompanyName, j.Salary " +
                     "FROM Jobs j INNER JOIN Companies c ON j.CompanyID = c.CompanyID " +
                     "WHERE j.Salary BETWEEN ? AND ?";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Set parameters
            pstmt.setDouble(1, minSalary);
            pstmt.setDouble(2, maxSalary);

            // Execute the query
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String jobTitle = rs.getString("JobTitle");
                String companyName = rs.getString("CompanyName");
                double salary = rs.getDouble("Salary");
                jobListings.add(new JobListing(jobTitle, companyName, salary));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving job listings: " + e.getMessage());
        }
        return jobListings;
    }

    public static void main(String[] args) {
        // Example usage: Retrieve job listings within a salary range
        double minSalary = 80000.0;
        double maxSalary = 100000.0;

        List<JobListing> jobListings = getJobListingsBySalaryRange(minSalary, maxSalary);
        if (!jobListings.isEmpty()) {
            System.out.println("Job listings within salary range:");
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            
            for (JobListing job : jobListings) {
                System.out.println(job);
                System.out.println("______________________________________________________________________");
            }
        } else {
            System.out.println("No job listings found within the specified salary range.");
        }
    }

    // JobListing class representing a job listing
    static class JobListing {
        private String jobTitle;
        private String companyName;
        private double salary;

        public JobListing(String jobTitle, String companyName, double salary) {
            this.jobTitle = jobTitle;
            this.companyName = companyName;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Job Title: " + jobTitle + ", Company Name: " + companyName + ", Salary: " + salary;
        }
    }
}

