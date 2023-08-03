package com.training.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.mvcapp.model.BankApp;
@WebServlet("/Register")
public class RegisterController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
			int bank_id = Integer.parseInt(req.getParameter("bank_id"));

	        String bank_name = req.getParameter("bank_name");

	        String ifsc_code = req.getParameter("ifsc_Code");

	        int accno = Integer.parseInt(req.getParameter("acc_no"));

	        int pin = Integer.parseInt(req.getParameter("pin"));

	        int cust_id = Integer.parseInt(req.getParameter("customer_id"));

	        String cust_name = req.getParameter("customer_name");

	        int balance = Integer.parseInt(req.getParameter("balance"));

	        String email = req.getParameter("email_id");

	      //  long phone = Long.parseLong(req.getParameter("phone"));

	 BankApp ba= new BankApp();
	 ba.setAcc_no(accno);
	 ba.setBalance(balance);
	 ba.setBank_id(bank_id);
	 ba.setBank_name(bank_name);

	 ba.setEmail_id(email);
	 ba.setIfsc_Code(ifsc_code);
	 ba.setPin(pin);
	 ba.setCustomer_id(cust_id);
	 ba.setCustomer_name(cust_name);
	 ba.setPhone(Long.parseLong(req.getParameter("phone")));
	 
	 boolean b=ba.register();
	 
	 if(b==true) {
		 resp.sendRedirect("/MVCBankApp/RegisterSuccess.html");
	 }
	 else {
		 resp.sendRedirect("/MVCBankApp/RegisterFail.html");

	 }
	 
	 

	 
	}

}
