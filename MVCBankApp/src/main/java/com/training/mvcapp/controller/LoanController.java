package com.training.mvcapp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.mvcapp.model.Loan;

@WebServlet("/Loan")
public class LoanController extends HttpServlet{

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet resultSet;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session =req.getSession();
		//int acc_no=(int) session.getAttribute("accountno");

		Loan l= new Loan();

		l.setChoice(Integer.parseInt(req.getParameter("choice")));

		boolean b=l.ApplyLoan();

		if(b==true) {


			session.setAttribute("Loan_id", l.getLoan_id());
			session.setAttribute("Loan_type", l.getLoan_type());
			session.setAttribute("Tenure", l.getTenure());
			session.setAttribute("Rate_of_Interest", l.getRate_of_Interest());
			session.setAttribute("Description", l.getDescription());


			resp.sendRedirect("/MVCBankApp/LoanDetails.jsp");

		}

		else {

			resp.sendRedirect("/MVCBankApp/LoanDetailsFail.html");

		}



	}

}