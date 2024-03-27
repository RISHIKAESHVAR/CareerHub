//Job Listing Retrieval: Write a program that connects to the database and retrieves all job listings from the "Jobs" table. Implement database connectivity using Entity Framework and display the job titles, company names, and salaries.

package com.task;

import java.sql.*;

public class JobListingRetrieval {
    // JDBC URL, username, and password
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/careerhub";
    static final String USERNAME = "root";
    static final String PASSWORD = "Rishitha@14";

    public static void main(String[] args) {
        try {
            // Establishing connection
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Creating SQL statement
            Statement statement = connection.createStatement();

            // SQL query to retrieve job listings
            String sqlQuery = "SELECT JobID, CompanyID, JobTitle, JobDescription, JobLocation, Salary, JobType, PostedDate FROM Jobs";

            // Executing the query
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            // Processing the results
            while (resultSet.next()) {
                int jobID = resultSet.getInt("JobID");
                int companyID = resultSet.getInt("CompanyID");
                String jobTitle = resultSet.getString("JobTitle");
                String jobDescription = resultSet.getString("JobDescription");
                String jobLocation = resultSet.getString("JobLocation");
                double salary = resultSet.getDouble("Salary");
                String jobType = resultSet.getString("JobType");
                Date postedDate = resultSet.getDate("PostedDate");

                // Displaying job listings
                System.out.println("Job ID           : " + jobID);
                System.out.println("Company ID       : " + companyID);
                System.out.println("Job Title        : " + jobTitle);
                System.out.println("Job Description  : " + jobDescription);
                System.out.println("Job Location     : " + jobLocation);
                System.out.println("Salary           : " + salary);
                System.out.println("Job Type         : " + jobType);
                System.out.println("Posted Date      : " + postedDate);
                System.out.println("-----------------------------------------");
            }

            // Closing resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
