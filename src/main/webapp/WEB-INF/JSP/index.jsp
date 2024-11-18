<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Customer Signup/Signin</title>
    <link rel="stylesheet" href="static/css/signup.css">
    <script>
        function toggleForm(action) {
            if (action === 'signup') {
                document.getElementById('signup-form').style.display = 'block';
                document.getElementById('signin-form').style.display = 'none';
            } else {
                document.getElementById('signup-form').style.display = 'none';
                document.getElementById('signin-form').style.display = 'block';
            }
        }
    </script>
</head>
<body>
<%
    String messageout = (String) request.getAttribute("res");
    if (messageout != null) {
%>
    <div class="notification">
        <p><%= messageout %></p>
    </div>
<%
        // Remove the message after displaying it once
        request.removeAttribute("res");
    }
%>
<%
    String message = (String) session.getAttribute("res");
    if (message != null) {
%>
    <div class="notification">
        <p><%= message %></p>
    </div>
<%
        // Remove the message after displaying it once
        session.removeAttribute("res");
    }
%>
    <h1>Welcome to farm market</h1>
    <img src="static/images/cow.jpg" alt="" id="cow">
    <img src="static/images/buffalo.jpg" alt="" id="buuffalo">
    <img src="static/images/pets1.jpg" alt="" id="pets1">
    <img src="static/images/sheep.jpg" alt="" id="sheep">
    <!-- Signup Form -->
    <div id="signup-form" style="display: none;">
        <div class="card">
            <div class="card2">
                <form class="form" action="signup" method="post">
                    <p id="heading">Sign Up</p>
                    <div class="field">
                
                        <input type="text" class="input-field" id="fullName" name="fullName" placeholder="Full Name"
                               required>
                    </div>

                    <div class="field">
                        <input type="text" class="input-field" id="address" name="address" placeholder="Address" required>
                    </div>

                    <div class="field">
                        <input type="text" class="input-field" id="phoneNumber" name="phoneNumber" placeholder="Phone Number" required>
                    </div>

                    <div class="field">
                        <input type="email" class="input-field" id="email" name="email" placeholder="Email" required>
                    </div>

                    <div class="field">
                        <input type="password" class="input-field" id="password" name="password" placeholder="Password" required>
                    </div>

                    <div class="btn">
                        <button class="button1" type="submit">Sign Up</button>
                        <p>if not singup ? click on</p><button class="button2" onclick="toggleForm('signin')">Sign In</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Signin Form -->
    <div id="signin-form" style="display: block;">
        <div class="card">
            <div class="card2">
                <form class="form" action="signin" method="post">
                    <p id="heading">Sign In</p>
                    <div class="field">
                        <input type="email" class="input-field" id="email" name="email" placeholder="Email" required>
                    </div>

                    <div class="field">
                        <input type="password" class="input-field" id="password" name="password" placeholder="Password" required>
                    </div>

                    <div class="btn">
                        <button class="button1" type="submit">Sign In</button>
                        <p>if not singup ? click on</p><button class="button1" onclick="toggleForm('signup')">Sign Up</button>
                       
                    </div>
                    
                </form>
            </div>
        </div>
    </div>
</body>
</html>
