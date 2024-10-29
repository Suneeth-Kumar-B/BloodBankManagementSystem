<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bootstrap Form</title>
<!-- Bootstrap CSS -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <h5 class="card-header bg-primary text-white">Admin Registration</h5>
                <div class="card-body">
                    <form action="/newAdmin" method="post" onsubmit="return validateForm()">
                        <div class="form-group">
                            <label for="username">Username</label>
                            <input type="text" class="form-control" id="username" name="username" required>
                        </div>
                        <div class="form-group">
                            <label for="name">Name</label>
                            <input type="text" class="form-control" id="name" name="name" required>
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" id="password" name="password" required>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">Submit</button>
                    </form>
                    <div class="text-center mt-3">
                        <p>Already have an account? <a href="/adminLoginPage">Login here</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Bootstrap JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script>
    function validateForm() {
        var usernameInput = document.getElementById("username");
        var username = usernameInput.value;
        var passwordInput = document.getElementById("password");
        var password = passwordInput.value;

        // Username validation
        var usernameRegex = /^[a-zA-Z0-9_.]+$/;
        if (!usernameRegex.test(username)) {
            alert("Username must not contain spaces and any other special characters other than underscore and dot.");
            return false; // Prevent form submission
        }

        // Password validation
        var passwordRegex = /^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{6,}$/;
        if (!passwordRegex.test(password)) {
            alert("Password must contain at least one number, one special character, one uppercase letter, and one lowercase letter, and have a minimum length of 6 characters.");
            return false; // Prevent form submission
        }

        return true; // Allow form submission
    }
</script>

</body>
</html>
