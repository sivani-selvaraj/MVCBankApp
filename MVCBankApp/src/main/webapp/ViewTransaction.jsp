<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h4>
			<%
			session = request.getSession();
			out.println("transaction_id: " + session.getAttribute("transaction_id"));
			out.println("<pre> </pre>");
			
			out.println("cust_id: " + session.getAttribute("cust_id"));
			out.println("<pre> </pre>");

			out.println("bank_name : " + session.getAttribute("bank_name"));
			out.println("<pre> </pre>");

			out.println("ifsc_code: " + session.getAttribute("ifsc_code"));
			out.println("<pre> </pre>");

			out.println("accountno: " + session.getAttribute("accountno"));
			out.println("<pre> </pre>");

			out.println("r_ifsc_code: " + session.getAttribute("r_ifsc"));
			out.println("<pre> </pre>");

			out.println("r_acc_no: " + session.getAttribute("r_acc_no"));
			out.println("<pre> </pre>");

			out.println("amount: " + session.getAttribute("amount"));
			out.println("<pre> </pre>");
			%>

			</h3>
			<a href="HomePage.jsp">Click here to Redirect </a>
	</div>

</body>
</html>