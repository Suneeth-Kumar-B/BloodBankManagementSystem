<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Redirecting...</title>
</head>
<body>
    <script>
        window.onload = function() {
        	var errorMessage = "<%= request.getAttribute("errorMessage") %>";
            alert(errorMessage);
            setTimeout(function() {
                window.location.href = "/";
            }, 300); 
        };
    </script>
</body>
    <p>${errorMessage}</p>
</body>
</html>
