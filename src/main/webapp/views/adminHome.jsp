<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Admin Home</title>
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
        .list-group-item a {
            color: #007bff; /* Link color */
        }
        .list-group-item a:hover {
            color: #0056b3; /* Hover color for links */
            text-decoration: none; /* Remove underline on hover */
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="card">
            <h3 class="card-header bg-primary text-white">Blood Bank Management System</h3>
            <ul class="list-group list-group-flush">
                <li class="list-group-item"><a href="/showBloodRequests">Approve Requests</a></li>
                <li class="list-group-item"><a href="/showDonors">Edit Donors</a></li>
            </ul>
            <div class="card-footer">
                <!-- Replaced button with an anchor tag -->
                <a href="/logout" class="btn btn-danger">Logout</a>
            </div>
        </div>
    </div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
