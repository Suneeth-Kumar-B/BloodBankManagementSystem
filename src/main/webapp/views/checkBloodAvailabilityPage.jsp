<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Check Blood Availability</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Custom CSS can still be used here */
        .custom-header {
            background-color: #007bff; /* Header Color */
            color: #ffffff; /* Text color for header */
        }
        .custom-primary {
            background-color: #dc3545; /* Primary button color */
            border-color: #dc3545; /* Border color for primary button */
        }
        .custom-primary:hover {
            background-color: #bd2130; /* Hover color for primary button */
            border-color: #bd2130; /* Hover border color for primary button */
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="card">
            <div class="card-header custom-header">
                <h2 class="mb-0">Check Blood Availability</h2>
            </div>
            <div class="card-body">
                <form action="/checkAvailability" method="post">
                    <div class="form-group">
                        <label for="bloodGroup">Blood Group</label>
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
                    <button type="submit" class="btn btn-primary">Check Status</button>
                </form>
            </div>
            <div class="card-footer">
                <a href="/checkStatusPage" class="btn btn-primary">Check Request Status</a>
            </div>
        </div>
    </div>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
