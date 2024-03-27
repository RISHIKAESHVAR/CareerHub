package com.dbmanager;

import java.sql.*;
import com.careerhub.Applicant;
import com.careerhub.Company;
import com.careerhub.JobApplication;
import com.careerhub.JobListing;

public class DatabaseManager {
    private Connection connection;

    public DatabaseManager() {
        // Initialize the database connection
        try {
            // Replace "jdbc:mysql://localhost:3306/your_database" with your actual database URL
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/careerhub_coding_challenge", "root", "Rishitha@14");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        // Close the database connection
        try {
            if (this.connection != null) {
                this.connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void InitializeDatabase() {
        // Code to initialize the database schema and tables
        System.out.println("Database schema and tables initialized.");
    }

    public void InsertJobListing(JobListing job, PreparedStatement preparedstatement) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Jobs (JobID, CompanyID, JobTitle, JobDescription, JobLocation, Salary, JobType, PostedDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, job.getJobID());
            preparedStatement.setInt(2, job.getCompanyID());
            preparedStatement.setString(3, job.getJobTitle());
            preparedStatement.setString(4, job.getJobDescription());
            preparedStatement.setString(5, job.getJobLocation());
            preparedStatement.setDouble(6, job.getSalary());
            preparedStatement.setString(7, job.getJobType());
            preparedstatement.setTimestamp(8, job.getPostedDate());
            preparedStatement.executeUpdate();
            System.out.println("Job listing inserted into the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void InsertCompany(Company company) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Companies (CompanyID, CompanyName, Location) VALUES (?, ?, ?)");
            preparedStatement.setInt(1, company.getCompanyID());
            preparedStatement.setString(2, company.getCompanyName());
            preparedStatement.setString(3, company.getLocation());
            preparedStatement.executeUpdate();
            System.out.println("Company inserted into the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void InsertApplicant(Applicant applicant) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Applicants (ApplicantID, FirstName, LastName, Email, Phone, Resume) VALUES (?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, applicant.getApplicantID());
            preparedStatement.setString(2, applicant.getfirstName());
            preparedStatement.setString(3, applicant.getlastName());
            preparedStatement.setString(4, applicant.getEmail());
            preparedStatement.setLong(5, applicant.getPhone());
            preparedStatement.setString(6, applicant.getResume());
            preparedStatement.executeUpdate();
            System.out.println("Applicant inserted into the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void InsertJobApplication(JobApplication application) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Applications (ApplicationID, JobID, ApplicantID, ApplicationDate, CoverLetter) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, application.getApplicationID());
            preparedStatement.setInt(2, application.getJobID());
            preparedStatement.setInt(3, application.getApplicantID());
            preparedStatement.setTime(4,application.getApplicationDate());
            preparedStatement.setString(5, application.getCoverLetter());
            preparedStatement.executeUpdate();
            System.out.println("Job application inserted into the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
