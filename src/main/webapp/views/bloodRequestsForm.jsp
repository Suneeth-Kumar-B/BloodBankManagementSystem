<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Blood Donation Request Form</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="card">
            <h5 class="card-header bg-primary text-white">Blood Donation Request Form</h5>
            <div class="card-body">
                <form action="/saveRequest" method="post">
                    <div class="form-group">
                        <label for="patientName">Patient Name:</label>
                        <input type="text" class="form-control" id="patientName" name="patientName" required>
                    </div>
                    <div class="form-group">
                        <label for="bloodGroup">Required Blood Group:</label>
                        <select class="form-control" id="bloodGroup" name="bloodGroup" required>
                            <option value="">Select</option>
                            <option value="A+">A+</option>
                            <option value="A-">A-</option>
                            <option value="B+">B+</option>
                            <option value="B-">B-</option>
                            <option value="AB+">AB+</option>
                            <option value="AB-">AB-</option>
                            <option value="O+">O+</option>
                            <option value="O-">O-</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="city">City:</label>
                        <input type="text" class="form-control" id="city" name="city" required>
                    </div>
                    <div class="form-group">
                        <label for="doctorName">Doctor's Name:</label>
                        <input type="text" class="form-control" id="doctorName" name="doctorName" required>
                    </div>
                    <div class="form-group">
                        <label for="hospitalNameAddress">Hospital Name and Address:</label>
                        <input type="text" class="form-control" id="hospitalNameAddress" name="hospitalNameAddress" required>
                    </div>
                    <div class="form-group">
    					<label for="dateRequired">Date Required:</label>
    					<input type="date" class="form-control" id="dateRequired" name="date" required>
					</div>
                    <div class="form-group">
                        <label for="contactName">Contact Name:</label>
                        <input type="text" class="form-control" id="contactName" name="contactName" required>
                    </div>
                    <div class="form-group">
                        <label for="contactNumber">Contact Number:</label>
                        <input type="text" class="form-control" id="contactNumber" name="contactNumber" required>
                    </div>
                    <div class="form-group">
                        <label for="contactEmail">Contact Email Id:</label>
                        <input type="email" class="form-control" id="contactEmail" name="contactEmail" required>
                    </div>
                    <div class="form-group">
                        <label for="message">Message:</label>
                        <textarea class="form-control" id="message" name="message"></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit Request</button>
                </form>
            </div>
        </div>
    </div>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
