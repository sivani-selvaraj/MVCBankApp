package com.training.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.mvcapp.model.BankApp;
@WebServlet("/Login")

public class LoginController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stu
		 HttpSession session=req.getSession(true);
		BankApp bp= new BankApp();
		bp.setCustomer_id(Integer.parseInt(req.getParameter("customer_id")));
		bp.setPin(Integer.parseInt(req.getParameter("pin")));

		boolean b=bp.login();

		if(b==true) {
			session.setAttribute("Bankname",bp.getBank_name());

            session.setAttribute("cust_name",bp.getCustomer_name());
            
            session.setAttribute("balance",bp.getBalance());
            session.setAttribute("accountno",bp.getAcc_no());
            
            

            resp.sendRedirect("/MVCBankApp/HomePage.jsp");

            
		}
		else {
			resp.sendRedirect("/MVCBankApp/LoginFail.html");
		}




	}
}