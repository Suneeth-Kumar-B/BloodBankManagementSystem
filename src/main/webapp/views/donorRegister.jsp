<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Donor Registration</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <div class="card">
            <h5 class="card-header bg-primary text-white">Donor Registration</h5>
            <div class="card-body">
                <form action="/newDonorRegister" method="post" onsubmit="return validateForm()">
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" id="name" name="Name" required>
                    </div>
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
                    <div class="form-group">
                        <label for="phone">Phone</label>
                        <input type="text" class="form-control" id="phone" name="phone" required>
                    </div>
                    <div class="form-group">
                        <label for="city">City</label>
                        <input type="text" class="form-control" id="city" name="city" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Register</button>
                </form>
            </div>
            <div class="card-footer text-center">
                <p class="mb-0">Already a Donor? <a href="/viewDonors">Check Here.</a></p>
            </div>
        </div>
    </div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    function validateForm() {
        var name = document.getElementById("name").value;
        var phone = document.getElementById("phone").value;
        var nameRegex = /^[a-zA-Z\s]+$/;
        
        if (!nameRegex.test(name)) {
            alert("Name must contain letters only.");
            return false;
        }
        
        if (phone.length !== 10 || isNaN(phone)) {
            alert("Invalid phone number. Please enter a 10-digit phone number.");
            return false;
        }
        
        return true;
    }
</script>
</body>
</html>
