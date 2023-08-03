package com.training.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.mvcapp.model.BankApp;

@WebServlet("/CheckBalance")
public class BalanceController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession session=req.getSession();
			BankApp bp= new BankApp();
			int acc_no=(int) session.getAttribute("accountno");

			boolean b=bp.balance(acc_no);
		//	System.out.println(acc_no);

			if(b==true) {
				
	            
				 session.setAttribute("balance",bp.getBalance());        
	            

	            resp.sendRedirect("/MVCBankApp/Balance.jsp");

	            
			}
			else {
				resp.sendRedirect("/MVCBankApp/BalanceFail.jsp");
			}




		}
	}