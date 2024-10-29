<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="com.hcl.app.entity.BloodRequests"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Blood Requests</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Custom CSS can still be used here */
        .custom-header {
            background-color: #007bff; /* Blood Request Page Header Color */
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

        /* Adjust table layout */
        .table-responsive {
            overflow-x: auto;
        }

        /* Set fixed width for columns */
        th, td {
            max-width: 200px;
            word-wrap: break-word;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="card">
            <div class="card-header custom-header">
                <h2 class="mb-0">Blood Requests</h2>
            </div>
            <div class="card-body table-responsive">
                <table class="table">
                    <thead class="thead">
                        <tr>
                            <th>Request ID</th>
                            <th>Patient Name</th>
                            <th>Required Blood Group</th>
                            <th>City</th>
                            <th>Doctor's Name</th>
                            <th>Hospital Name and Address</th>
                            <th>Date Required</th>
                            <th>Contact Name</th>
                            <th>Contact Number</th>
                            <th>Contact Email</th>
                            <th>Message</th>
                            <th>Status</th>
                            <th>Action</th> <!-- Add a new header for actions -->
                        </tr>
                    </thead>
                    <tbody>
                        <% List<BloodRequests> requests = (List<BloodRequests>) request.getAttribute("data");
                        if (requests != null) {
                            for (BloodRequests r : requests) { %>
                            <tr>
                                <td><%= r.getBloodRequestId()%></td>
                                <td><%= r.getPatientName()%></td>
                                <td><%= r.getBloodGroup()%></td>
                                <td><%= r.getCity()%></td>
                                <td><%= r.getDoctorName()%></td>
                                <td><%= r.getHospitalNameAddress()%></td>
                                <td><%= r.getDate()%></td>
                                <td><%= r.getContactName()%></td>
                                <td><%= r.getContactNumber()%></td>
                                <td><%= r.getContactEmail()%></td>
                                <td><%= r.getMessage()%></td>
                                <td>
                                    <select name="status" onchange="updateStatus(<%= r.getBloodRequestId() %>, this.value)">
                                        <option value="pending" >select</option>
                                        <option value="approved" <%= r.getStatus().equals("approved") ? "selected" : "" %>>Approved</option>
                                        <option value="rejected" <%= r.getStatus().equals("rejected") ? "selected" : "" %>>Rejected</option>
                                    </select>
                                </td>
                                <td>
                                    <button class="btn btn-danger" onclick="deleteEntry(<%= r.getBloodRequestId() %>)">Delete</button>
                                </td>
                            </tr>
                        <% } } %>
                    </tbody>
                </table>
            </div>
            <div class="card-footer">
                <a href="/" class="btn btn-primary">Go to Home</a>
            </div>
        </div>
    </div>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        function updateStatus(requestId, newStatus) {
            var confirmationMessage = '';
            if (newStatus === 'approved') {
                confirmationMessage = 'Are you sure you want to approve this request?';
            } else if (newStatus === 'rejected') {
                confirmationMessage = 'Are you sure you want to reject this request?';
            }
            
            if (confirmationMessage && confirm(confirmationMessage)) {
                // Send AJAX request to update status
                var xhr = new XMLHttpRequest();
                xhr.open("POST", "/updateStatus?requestId=" + requestId + "&newStatus=" + newStatus, true);
                xhr.setRequestHeader('Content-Type', 'application/json');
                xhr.onreadystatechange = function() {
                    if (xhr.readyState == XMLHttpRequest.DONE) {
                        // Handle response if needed
                        console.log(xhr.responseText);
                    }
                };
                xhr.send();
            }
        }

        function deleteEntry(requestId) {
            if (confirm("Are you sure you want to delete this entry?")) {
                // Send AJAX request to delete entry
                var xhr = new XMLHttpRequest();
                xhr.open("POST", "/deleteEntry?requestId=" + requestId, true);
                xhr.setRequestHeader('Content-Type', 'application/json');
                xhr.onreadystatechange = function() {
                    if (xhr.readyState == XMLHttpRequest.DONE) {
                        // Handle response if needed
                        console.log(xhr.responseText);
                        // Reload the page after deletion
                        location.reload();
                    }
                };
                xhr.send();
            }
        }
    </script>            
    
</body>
</html>
