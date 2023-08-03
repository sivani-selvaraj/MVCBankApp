package com.training.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.mvcapp.model.BankApp;
import com.training.mvcapp.model.TransferStatus;

@WebServlet("/Transfer")
public class TransferController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=req.getSession();
		
		TransferStatus t= new TransferStatus();
		
		int cust_id= Integer.parseInt(req.getParameter("customer_id"));
		String bank_name= req.getParameter("bank_name");
		String ifsc_code= req.getParameter("sender_ifsc");
		int acc_no= Integer.parseInt(req.getParameter("sender_accno"));
		String r_ifsc_code= req.getParameter("receiver_ifsc");
		int r_acc_no= Integer.parseInt(req.getParameter("receiver_accno"));
		int amount= Integer.parseInt(req.getParameter("amount"));
		int pin= Integer.parseInt(req.getParameter("pin"));
		
		t.setCustomer_id(cust_id);
		t.setBank_name(bank_name);
		t.setSender_ifsc(ifsc_code);
		t.setReceiver_ifsc(r_ifsc_code);
		t.setReceiver_accno(r_acc_no);
		t.setSender_accno(acc_no);
		t.setAmount(amount);
		t.setPin(pin);
		
		
		boolean b=t.transfer();
		if(b==true) {
			resp.sendRedirect("/MVCBankApp/TransferSuccess.html");

		}
		else {
			resp.sendRedirect("/MVCBankApp/TransferFail.html");
		}
	}}