package com.training.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.mvcapp.model.BankApp;

@WebServlet("/ChangePassword")
public class ChangePasswordController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		BankApp bp= new BankApp();
		int acc_no=(int) session.getAttribute("accountno");
		int pin=Integer.parseInt(req.getParameter("pin"));
		int new_pin=Integer.parseInt(req.getParameter("pin1"));
		int confirm_pin=Integer.parseInt(req.getParameter("pin2"));

		
		bp.setPin(pin);
		bp.setNew_pin(new_pin);
		bp.setConfirm_pin(confirm_pin);
		
		boolean b=bp.changepassword(acc_no);
		
		if(b==true) {
			resp.sendRedirect("/MVCBankApp/PasswordChangeSuccess.html");

		}
		else {
			resp.sendRedirect("/MVCBankApp/PasswordChangeFailed.html");
		}
	}}