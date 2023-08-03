package com.training.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.mvcapp.model.TransferStatus;

@WebServlet("/ViewTransaction")
public class ViewTransaction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session =req.getSession();
		TransferStatus t=new TransferStatus();
		
		int acc_no=(int) session.getAttribute("accountno");
		/*t.setCustomer_id(Integer.parseInt(req.getParameter("customer_id")));
		t.setBank_name(req.getParameter("bank_name"));
		t.setSender_ifsc(req.getParameter("sender_ifsc"));
		t.setReceiver_ifsc(req.getParameter("recevier_ifsc"));
		t.setTransaction_id(Integer.parseInt(req.getParameter("transaction_id")));
		t.setPin(Integer.parseInt(req.getParameter("pin")));
		t.setSender_accno(Integer.parseInt(req.getParameter("sender_accno")));
		t.setReceiver_accno(Integer.parseInt(req.getParameter("receiver_accno")));
		
		
		t.setAmount(Integer.parseInt(req.getParameter("amount")));*/
		boolean b= t.viewtransaction(acc_no);
	
		if(b==true) {   
			
//			int k= t.getCustomer_id();
//			System.out.println(k);
			
			session.setAttribute("cust_id", t.getCustomer_id());
			session.setAttribute("bank_name", t.getBank_name());
			session.setAttribute("ifsc_code", t.getSender_ifsc());
			session.setAttribute("accountno", t.getSender_accno());
			session.setAttribute("r_ifsc", t.getReceiver_ifsc());
			
			session.setAttribute("r_acc_no", t.getReceiver_accno());
			session.setAttribute("amount", t.getAmount());
			session.setAttribute("transaction_id", t.getTransaction_id());
			
			
			

            resp.sendRedirect("/MVCBankApp/ViewTransaction.jsp");

            
		}
		else {
			resp.sendRedirect("/MVCBankApp/ViewTransactionFail.html");
		}




	}
}
	

	