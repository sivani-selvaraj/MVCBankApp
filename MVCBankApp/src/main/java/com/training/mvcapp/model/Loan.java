package com.training.mvcapp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Loan {
	int Loan_id;
	String Loan_type;
	int Tenure;
	int Rate_of_Interest;
	String Description;
	int choice;
	public Connection con;
	private PreparedStatement pstmt;
	private ResultSet resultSet;
	
	public Loan() {

		String url = "jdbc:mysql://localhost:3306/project1";

		String user = "root";

		String pwd = "Shivani@1235";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pwd);

		}
		catch(Exception e) {
			e.printStackTrace();

		}
	}
	
	public int getChoice() {
		return choice;
	}
	public void setChoice(int choice) {
		this.choice = choice;
	}

	

	public void setLoan_id(int loan_id) {
		this.Loan_id = loan_id;
	}
	public String getLoan_type() {
		return Loan_type;
	}
	public void setLoan_type(String loan_type) {
		Loan_type = loan_type;
	}
	public int getTenure() {
		return Tenure;
	}
	public void setTenure(int tenure) {
		this.Tenure = tenure;
	}
	public int getRate_of_Interest() {
		return Rate_of_Interest;
	}
	public void setRate_of_Interest(int rate_of_Interest) {
		this.Rate_of_Interest = rate_of_Interest;
	}
	public int getLoan_id() {
		return Loan_id;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}

	
public boolean ApplyLoan() {
	try {


		pstmt = con.prepareStatement("Select * from loan where Loan_id=?");

		pstmt.setInt(1, choice);
		resultSet=pstmt.executeQuery();


		if(resultSet.next()) {
				this.setLoan_id(resultSet.getInt("Loan_id"));
				this.setLoan_type(resultSet.getString("Loan_type"));
				this.setTenure(resultSet.getInt("Tenure"));
				this.setRate_of_Interest(resultSet.getInt("Rate_of_Interest"));
				this.setDescription(resultSet.getString("Description"));
				
				return true;
				
		}

		else {

			return false;

		}
		
		


	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return false;
}
}




