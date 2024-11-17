<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Electricity Bill Calculator</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #fef4e1; /* Light orange background */
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: white;
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            width: 400px;
        }
        h2 {
            color: #e67e22; /* Orange text color */
            margin-bottom: 1.5rem;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        input[type="number"] {
            margin-bottom: 1rem;
            padding: 0.75rem;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 1rem;
        }
        input[type="submit"] {
            background-color: #e67e22; /* Orange button */
            color: white;
            border: none;
            padding: 0.75rem;
            border-radius: 4px;
            font-size: 1rem;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #d35400; /* Darker orange on hover */
        }
        .result {
            margin-top: 1.5rem;
            padding: 1rem;
            background-color: #ffebcc; /* Light orange result background */
            border-radius: 8px;
        }
        .result p {
            font-size: 1.1rem;
            color: #333;
        }
        a {
            color: #e67e22;
            text-decoration: none;
            margin-top: 1rem;
            display: inline-block;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Electricity Bill Calculator</h2>
        
        <%
        String unitsStr = request.getParameter("units");
        if (unitsStr != null && !unitsStr.isEmpty()) {
            int units = Integer.parseInt(unitsStr);
            double billAmount = 0.0;

            if (units <= 100) {
                billAmount = units * 1.20;
            } else if (units <= 300) {
                billAmount = 100 * 1.20 + (units - 100) * 2;
            } else {
                billAmount = 100 * 1.20 + 200 * 2 + (units - 300) * 3;
            }
        %>
            <div class="result">
                <p>Units Consumed: <strong><%= units %></strong></p>
                <p>Bill Amount: <strong>$<%= String.format("%.2f", billAmount) %></strong></p>
            </div>
            <a href="billCalculator.jsp">Calculate Another Bill</a>
        <%
        } else {
        %>
            <form action="billCalculator.jsp" method="get">
                <input type="number" name="units" placeholder="Enter units consumed" required min="0">
                <input type="submit" value="Calculate Bill">
            </form>
        <%
        }
        %>
    </div>
</body>
</html>