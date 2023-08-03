
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to the Bank</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	background-image: url("https://example.com/background-image.jpg");
	/* Replace with your background image URL */
	background-size: cover;
	background-position: center;
}

.container {
	max-width: 400px;
	padding: 30px;
	background-color: rgba(255, 255, 255, 0.9);
	border-radius: 10px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
	text-align: center;
}

h1 {
	color: #3366cc;
	margin-bottom: 20px;
}

p {
	margin-bottom: 20px;
}

a {
	display: inline-block;
	padding: 10px 20px;
	background-color: #3366cc;
	color: #fff;
	text-decoration: none;
	border-radius: 5px;
	font-weight: bold;
	transition: background-color 0.3s ease;
}

a:hover {
	background-color: #005580;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Welcome to the Bank</h1>
		<p>
			<% 
      session=request.getSession();
      String s1=(String)session.getAttribute("cust_name");
      out.print(s1 + ", welcome to your account. Please select an operation to perform:");
      %>
		</p>
		<a href="CheckBalance">1. Check Balance</a> <br>
		<br> <a href="ChangePassword.html">2. Change Password</a> <br>
		<br> <a href="Loan.jsp">3. Apply Loan </a> <br>
		<br> <a href="Transfer.html">4. Transfer Amount </a> <br>
		<br> <a href="ViewTransaction"> 5. View Transaction
			Details </a> <br>
		<br> <a href="Logout">4. Logout </a> <br>
		<br>




	</div>
</body>
</html>