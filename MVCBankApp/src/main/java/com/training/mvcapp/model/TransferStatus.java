package com.training.mvcapp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

public class TransferStatus {
	int customer_id;
	String bank_name;
	String sender_ifsc;
	int sender_accno;
	String receiver_ifsc;
	int receiver_accno;
	int amount;
	int transaction_id;
	int pin;
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}

	public Connection con;
	private PreparedStatement pstmt;
	private ResultSet resultSet;
	private ResultSet resultSet2;
	private ResultSet resultSet3;
	private ResultSet resultSet4;
	private ResultSet resultSet5;

	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getSender_ifsc() {
		return sender_ifsc;
	}
	public void setSender_ifsc(String sender_ifsc) {
		this.sender_ifsc = sender_ifsc;
	}

	public int getSender_accno() {
		return sender_accno;
	}
	public void setSender_accno(int sender_accno) {
		this.sender_accno = sender_accno;
	}
	public String getReceiver_ifsc() {
		return receiver_ifsc;
	}
	public void setReceiver_ifsc(String receiver_ifsc) {
		this.receiver_ifsc = receiver_ifsc;
	}
	public int getReceiver_accno() {
		return receiver_accno;
	}
	public void setReceiver_accno(int receiver_accno) {
		this.receiver_accno = receiver_accno;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public TransferStatus() {
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

	public boolean transfer() {
		try {
			pstmt = con.prepareStatement("Select * from bankapp where customer_id=? and ifsc_Code=? and acc_no=? and pin=?");

			pstmt.setInt(1, customer_id);
			pstmt.setString(2, sender_ifsc);
			pstmt.setInt(3, sender_accno);
			pstmt.setInt(4, pin);

			resultSet=pstmt.executeQuery();


			if(resultSet.next()==true) {

				pstmt = con.prepareStatement("Select * from bankapp where ifsc_Code=? and acc_no=?");

				pstmt.setString(1, receiver_ifsc);
				pstmt.setInt(2, receiver_accno);

				resultSet2=pstmt.executeQuery();

				if(resultSet2.next()==true) {
					pstmt = con.prepareStatement("Select balance from bankapp where acc_no=?");

					pstmt.setInt(1, sender_accno);


					resultSet3=pstmt.executeQuery();


					resultSet3.next();

					int bal =resultSet3.getInt(1);

					if(bal>amount) { 
						pstmt = con.prepareStatement("update bankapp set balance=balance-? where acc_no=?");
						pstmt.setInt(1, amount);
						pstmt.setInt(2, sender_accno);

						int x1=pstmt.executeUpdate();


						if(x1>0) {
							pstmt = con.prepareStatement("update bankapp set balance=balance+? where acc_no=?");

							pstmt.setInt(1, amount);
							pstmt.setInt(2, receiver_accno);

							int x2=pstmt.executeUpdate();

							if(x2>0) {

								pstmt = con.prepareStatement("Insert into transferstatus values (?,?,?,?,?,?,?,?)");

								pstmt.setInt(1, customer_id);
								pstmt.setString(2, bank_name);
								pstmt.setString(3, sender_ifsc);
								pstmt.setInt(4, sender_accno);
								pstmt.setString(5, receiver_ifsc);
								pstmt.setInt(6, receiver_accno);
								pstmt.setInt(7, amount);
								int i=new Random().nextInt(900000)+100000;
								pstmt.setInt(8, i);



								int x3=pstmt.executeUpdate();

								if(x3>0) {



									//									pstmt = con.prepareStatement("Select * from transferstatus where customer_id=?");
									//									pstmt.setInt(1, cust_id);
									//									pstmt.setInt(1, sender_accno);
									//									pstmt.setInt(2, sender_accno);
									//									
									//									resultSet4=pstmt.executeQuery();
									//									if(resultSet4.next()==true) {
									//										session.setAttribute("cust_id", resultSet4.getInt("customer_id"));
									//						            	session.setAttribute("bank_name", resultSet4.getString("bank_name"));
									//						            	session.setAttribute("ifsc_code", resultSet4.getString("sender_ifsc"));
									//						            	session.setAttribute("accountno", resultSet4.getInt("sender_accno"));
									//						            	session.setAttribute("r_ifsc_code", resultSet4.getString("receiver_ifsc"));
									//						            	session.setAttribute("r_acc_no", resultSet4.getInt("receiver_accno"));
									//						            	session.setAttribute("amount", resultSet4.getInt("amount"));
									//						            	session.setAttribute("transaction_id", resultSet4.getInt("transaction_id"));

									return true;

								}


								else {
									return false;
									//resp.sendRedirect("/BankingApplication/TransferFail.html");
								}


							}
							else {
								return false;

								//resp.sendRedirect("/BankingApplication/TransferFail.html");
							}}
						else {
							return false;
							//resp.sendRedirect("/BankingApplication/TransferFail.html");
						}}
					else {
						return false;

						//resp.sendRedirect("/BankingApplication/TransferFail.html");
					}}
				else {
					return false;

					//resp.sendRedirect("/BankingApplication/TransferFail.html");
				}}
			else {
				return false;
			}}
		//resp.sendRedirect("/BankingApplication/TransferFail.html");
		catch (Exception e) {

			e.printStackTrace();



		}
		return false;

	}



	public boolean viewtransaction(int acc_no) {
		try {

			pstmt = con.prepareStatement("Select * from transferstatus where sender_accno=?");
			pstmt.setInt(1, acc_no);
			//			pstmt.setInt(1, sender_accno);
			//			pstmt.setInt(2, sender_accno);

			resultSet5=pstmt.executeQuery();
			if(resultSet5.next()==true) {
								
				this.setCustomer_id(resultSet5.getInt("customer_id"));
				this.setBank_name(resultSet5.getString("bank_name"));
				this.setSender_ifsc(resultSet5.getString("sender_ifsc"));
				this.setReceiver_ifsc(resultSet5.getString("receiver_ifsc"));
				this.setTransaction_id(resultSet5.getInt("transaction_id"));

				this.setSender_accno(resultSet5.getInt("sender_accno"));
				this.setReceiver_accno(resultSet5.getInt("receiver_accno"));
				this.setAmount(resultSet5.getInt("amount"));
				
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
}

