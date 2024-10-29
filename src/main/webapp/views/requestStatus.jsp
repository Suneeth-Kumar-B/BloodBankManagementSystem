<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Blood Request Details</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Custom CSS can still be used here */
        .custom-header {
            background-color: #007bff; /* Header Color */
            color: #ffffff; /* Text color for header */
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="card">
            <div class="card-header custom-header">
                <h2 class="mb-0">Blood Request Details</h2>
            </div>
            <div class="card-body">
                <table class="table">
                    <tbody>
                        <tr>
                            <td>Request ID:</td>
                            <td>${bloodRequest.bloodRequestId}</td>
                        </tr>
                        <tr>
                            <td>Patient Name:</td>
                            <td>${bloodRequest.patientName}</td>
                        </tr>
                        <tr>
                            <td>Required Blood Group:</td>
                            <td>${bloodRequest.bloodGroup}</td>
                        </tr>
                        <tr>
                            <td>City:</td>
                            <td>${bloodRequest.city}</td>
                        </tr>
                        <tr>
                            <td>Doctor's Name:</td>
                            <td>${bloodRequest.doctorName}</td>
                        </tr>
                        <tr>
                            <td>Hospital Name and Address:</td>
                            <td>${bloodRequest.hospitalNameAddress}</td>
                        </tr>
                        <tr>
                            <td>Date Required:</td>
                            <td>${bloodRequest.date}</td>
                        </tr>
                        <tr>
                            <td>Contact Name:</td>
                            <td>${bloodRequest.contactName}</td>
                        </tr>
                        <tr>
                            <td>Contact Number:</td>
                            <td>${bloodRequest.contactNumber}</td>
                        </tr>
                        <tr>
                            <td>Contact Email:</td>
                            <td>${bloodRequest.contactEmail}</td>
                        </tr>
                        <tr>
                            <td>Message:</td>
                            <td>${bloodRequest.message}</td>
                        </tr>
                        <tr>
                            <td>Status:</td>
                            <td>${bloodRequest.status}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="card-footer d-flex justify-content-center"> 
    			<a href="/checkStatusPage" class="btn btn-primary">Check Another Request</a>
			</div>

        </div>
    </div>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
