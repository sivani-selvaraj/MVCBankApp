<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Viewing Details Successful</title>
 

<style>
  .container {
    max-width: 400px;
    padding: 30px;
    background-color: rgba(255, 255, 255, 0.9);
    border-radius: 10px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
    text-align: center;
</style>
</head>


<body>
<div class="container">

<h3 align="center">LOAN DETAILS</h3>
	<%
	session = request.getSession();
	out.println("Loan ID: " + session.getAttribute("Loan_id"));
	out.println("<pre> </pre>");
	out.println("Loan Type: " + session.getAttribute("Loan_type"));
	out.println("<pre> </pre>");
	out.println("Tenure: " + session.getAttribute("Tenure"));
	out.println("<pre> </pre>");
	out.println("Rate of Interest: " + session.getAttribute("Rate_of_Interest"));
	out.println("<pre> </pre>");
	out.println("Description: " + session.getAttribute("Description"));
	out.println("<pre> </pre>");
	%>

	<br>
	<br>
	<a href="HomePage.jsp">Click here to Redirect </a>
</div>

</body>
</html>