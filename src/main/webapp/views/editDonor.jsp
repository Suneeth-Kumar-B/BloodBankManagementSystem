<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Donor Update</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <div class="card">
            <h5 class="card-header bg-primary text-white">Donor Registration</h5>
            <div class="card-body">
                <form id="updateForm" action="/updateDonor" method="post">
                    <div class="form-group">
                        <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" id="name" name="name" value="<%= request.getParameter("name") %>" required>
                    </div>
                    <div class="form-group">
                        <label for="bloodGroup">Blood Group</label>
                        <select class="form-control" id="bloodGroup" name="bloodGroup" required>
                            <option value="">Select</option>
                            <option value="A+" <%= "A+".equals(request.getParameter("bloodGroup")) ? "selected" : "" %>>A+</option>
                            <option value="A-" <%= "A-".equals(request.getParameter("bloodGroup")) ? "selected" : "" %>>A-</option>
                            <option value="B+" <%= "B+".equals(request.getParameter("bloodGroup")) ? "selected" : "" %>>B+</option>
                            <option value="B-" <%= "B-".equals(request.getParameter("bloodGroup")) ? "selected" : "" %>>B-</option>
                            <option value="AB+" <%= "AB+".equals(request.getParameter("bloodGroup")) ? "selected" : "" %>>AB+</option>
                            <option value="AB-" <%= "AB-".equals(request.getParameter("bloodGroup")) ? "selected" : "" %>>AB-</option>
                            <option value="O+" <%= "O+".equals(request.getParameter("bloodGroup")) ? "selected" : "" %>>O+</option>
                            <option value="O-" <%= "O-".equals(request.getParameter("bloodGroup")) ? "selected" : "" %>>O-</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone</label>
                        <input type="text" class="form-control" id="phone" name="phone" value="<%= request.getParameter("phone") %>" required>
                    </div>
                    <div class="form-group">
                        <label for="city">City</label>
                        <input type="text" class="form-control" id="city" name="city" value="<%= request.getParameter("city") %>" required>
                    </div>
                    <button type="button" class="btn btn-primary" onclick="confirmUpdate()">Update</button>
                </form>
            </div>
        </div>
    </div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    function confirmUpdate() {
        if (confirm("Are you sure you want to update?")) {
            document.getElementById("updateForm").submit();
        }
    }
</script>
</body>
</html>
