package com.dbmanager;

package com.dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class db_manager {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		// Step 1 : Load the mysql jdbc driver

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = null;

		// Step 2 : Getting Connection Object
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/careerhub", "root", "Rishitha@14");

		Statement stmt = null;
		// Step 3: Getting statement object
		stmt = con.createStatement();

		// Step 4 : Executing the query
		//String query = "select * from applicants";
		String query = "select * from applications";
		//String query = "select * from jobs";
		//String query = "select * from companies";
		ResultSet rs = null;


		rs = stmt.executeQuery(query);
/*
		while (rs.next()) {
			System.out.println("APPLICANTID       : " + rs.getString("applicantid"));
			System.out.println("FIRSTNAME         : " + rs.getString("firstname"));
			System.out.println("LASTNAME          : " + rs.getString("lastname"));
			System.out.println("EMAIL             : " + rs.getString("email"));
			System.out.println("PHONE             : " + rs.getString("phone"));
			System.out.println("RESUME            : " + rs.getString("resume"));
			
			System.out.println("______________________________________");
		}
*/
/*		
		while (rs.next()) {
			System.out.println("JOBID             : " + rs.getString("jobid"));
			System.out.println("COMPANYID         : " + rs.getString("companyid"));
			System.out.println("JOB TITLE         : " + rs.getString("jobtitle"));
			System.out.println("JOB DESCRIPTION   : " + rs.getString("jobdescription"));
			System.out.println("JOB LOCATION      : " + rs.getString("joblocation"));
			System.out.println("SALARY            : " + rs.getString("salary"));
			System.out.println("JOB TYPE          : " + rs.getString("jobtype"));
			System.out.println("POSTEDDATE        : " + rs.getString("posteddate"));
			
			System.out.println("______________________________________");
		}
*/
/*
		while (rs.next()) {
			System.out.println("COMPANYID         : " + rs.getString("applicantid"));
			System.out.println("COMPANY NAME      : " + rs.getString("firstname"));
			System.out.println("LOCATION          : " + rs.getString("lastname"));
			
			System.out.println("______________________________________");
		}
*/
/*
		while (rs.next()) {
			System.out.println("APPLICATIONID       : " + rs.getString("applicationid"));
			System.out.println("APPLICANTID         : " + rs.getString("applicantid"));
			System.out.println("JOB ID              : " + rs.getString("jobid"));
			System.out.println("APPLICATION DATE    : " + rs.getString("applicationdate"));
			System.out.println("COVER LETTER        : " + rs.getString("coverletter"));
			
			System.out.println("______________________________________");
		}
*/

		rs.close();
		stmt.close();
		con.close();
	}
}
