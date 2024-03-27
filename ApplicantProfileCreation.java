//Applicant Profile Creation: Create a program that allows applicants to create a profile by entering their information. Implement database connectivity to insert the applicant's data into the "Applicants" table. Handle potential database-related exceptions.

package com.task;

import java.sql.*;

public class ApplicantProfileCreation {
    // JDBC URL, username, and password
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/careerhub";
    static final String USERNAME = "root";
    static final String PASSWORD = "Rishitha@14";

    public static void main(String[] args) {
        try {
            // Establishing connection
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Prompting user to enter applicant information
            // You can use Scanner class to get user input
            // For simplicity, I'll just hardcode the values here
            int applicantID = 125; // Unique identifier for each applicant
            String firstName = "Rishi";
            String lastName = "Maran";
            String email = "rishi.maran@example.com";
            String phone = "9345818942";
            String resume = "resume";

            // Creating SQL statement to insert applicant data
            String sqlQuery = "INSERT INTO Applicants (ApplicantID, FirstName, LastName, Email, Phone, Resume) " +
                              "VALUES (?, ?, ?, ?, ?, ?)";

            // Preparing the SQL statement
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            // Setting parameters for the prepared statement
            preparedStatement.setInt(1, applicantID);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, phone);
            preparedStatement.setString(6, resume);

            // Executing the SQL statement to insert applicant data
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Applicant profile created successfully!");
            } else {
                System.out.println("Failed to create applicant profile.");
            }

            // Closing resources
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

