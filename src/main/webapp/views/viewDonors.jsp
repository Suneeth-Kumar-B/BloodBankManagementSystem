<%@page import="com.hcl.app.entity.Donor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Data</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Custom CSS can still be used here */
        .custom-header {
            background-color: #007bff; /* Donor Register and Admin Register Page Header Color */
            color: #ffffff; /* Text color for header */
        }
        .custom-primary {
            background-color: #007bff; /* Primary button color */
            border-color: #007bff; /* Border color for primary button */
        }
        .custom-primary:hover {
            background-color: #0056b3; /* Hover color for primary button */
            border-color: #0056b3; /* Hover border color for primary button */
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="card">
            <div class="card-header custom-header">
                <h2 class="mb-0">Donors</h2>
            </div>
            <div class="card-body">
                <table class="table">
                    <thead class="thead">
    				<tr>
        				<th>ID</th>
        				<th>Name</th>
        				<th>Blood Group</th>
        				<th>Phone</th>
        				<th>City</th>
    				</tr>
				</thead>
					<tbody>
    				<%
    				List<Donor> users = (List<Donor>) request.getAttribute("data");
    				if (users != null) {
        			for (Donor user : users) {
    					%>
    					<tr>
        					<td><%= user.getUserID() %></td>
        					<td><%= user.getName() %></td>
        					<td><%= user.getBloodGroup() %></td>
        					<td><%= user.getPhone() %></td>
        					<td><%= user.getCity() %></td>
    					</tr>
    					<% 
        						}
    						}
    					%>
					</tbody>

                </table>
            </div>
            <div class="card-footer">
                <a href="/" class="btn btn-primary">Go to Home</a>
            </div>
        </div>
    </div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
