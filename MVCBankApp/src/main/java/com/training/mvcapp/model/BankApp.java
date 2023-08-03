package com.training.mvcapp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.http.HttpSession;

public class BankApp {
	int bank_id;
	String bank_name;
	String ifsc_Code;
	int acc_no;
	int pin;
	int customer_id;
	String customer_name;
	int balance;
	String email_id;
	long phone;
	int new_pin;
	public int getNew_pin() {
		return new_pin;
	}
	public void setNew_pin(int new_pin) {
		this.new_pin = new_pin;
	}
	public int getConfirm_pin() {
		return confirm_pin;
	}
	public void setConfirm_pin(int confirm_pin) {
		this.confirm_pin = confirm_pin;
	}

	int confirm_pin;
	public Connection con;
	private PreparedStatement pstmt;
	private ResultSet resultSet;


	public BankApp() {
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
	public int getBank_id() {
		return bank_id;
	}
	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getIfsc_Code() {
		return ifsc_Code;
	}
	public void setIfsc_Code(String ifsc_Code) {
		this.ifsc_Code = ifsc_Code;
	}
	public int getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}

	public boolean register() {
		try {

			pstmt = con.prepareStatement("insert into bankapp values(?,?,?,?,?,?,?,?,?,?)");

			pstmt.setInt(1, bank_id);

			pstmt.setString(2, bank_name);

			pstmt.setString(3, ifsc_Code);

			pstmt.setInt(4, acc_no);

			pstmt.setInt(5, pin);

			pstmt.setInt(6, customer_id);

			pstmt.setString(7, customer_name);

			pstmt.setInt(8, balance);

			pstmt.setString(9, email_id);

			pstmt.setLong(10, phone);



			int x = pstmt.executeUpdate();

			if(x>0) {

				return true;

			}

			else {

				return false;
			}



		}

		catch (Exception e) {

			e.printStackTrace();

		}
		return false;

	}
	public boolean login() {
		try {
			pstmt = con.prepareStatement("Select * from bankapp where customer_id=? and pin=?");

			pstmt.setInt(1, customer_id);
			pstmt.setInt(2, pin);
			resultSet=pstmt.executeQuery();



			if(resultSet.next()) {

				if(resultSet.getInt("pin")==this.pin) {



					this.setAcc_no(resultSet.getInt("acc_no"));

					this.setCustomer_name(resultSet.getString("customer_name"));

					this.setBalance(resultSet.getInt("balance"));

					return true;

				}

				else {

					return false;

				}

			}

			else {

				return false;

			}
		}
		catch (Exception e) {

			e.printStackTrace();

		}
		return false;
	}

	public boolean balance(int acc_no) {

		try {

			pstmt = con.prepareStatement("Select balance from bankapp where acc_no=?");
			pstmt.setInt(1, acc_no);	
			resultSet=pstmt.executeQuery();

			if(resultSet.next()==true) {
				this.setBalance(resultSet.getInt("balance"));
				return true;


			}
			else {
				return false;
			}


		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean changepassword(int acc_no) {
		if(new_pin==confirm_pin) {

			try
			{
				pstmt = con.prepareStatement("update bankapp set pin=? where acc_no=? and pin=? ");
				pstmt.setInt(1, new_pin);
				pstmt.setInt(2, acc_no);
				pstmt.setInt(3, pin);


				int resultSet=pstmt.executeUpdate();
				if(resultSet>0) {
					
					return true;

				}
				else {
					return false;
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;

		}
		else {
			return false;
		}
	}
	
}