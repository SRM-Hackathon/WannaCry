<?php
// Initialize the session
session_start();
 
// Check if the user is logged in, if not then redirect him to login page
if(!isset($_SESSION["loggedin"]) || $_SESSION["loggedin"] !== true){
    header("location: login.php");
    exit;
}
?>
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
    <style type="text/css">
        body{ font: 14px sans-serif; text-align: center; }
    </style>
</head>
<body>
    <div class="page-header">
        <h1>Hi, <b id="username"><?php echo htmlspecialchars($_SESSION["username"]); ?></b>. Welcome to our portal.</h1>
    </div>
    <div class="mainDiv" align="left">
        <h1>Your Details</h1>
        <table border="1">
            <thead>
                <tr>
                    <td>Name</td>
                    <td>Email</td>
                    <td>Pnr No</td>
                    <td>Action</td>
                </tr>
            </thead>
            <tbody id="table_body">
        
            </tbody>
        </table>
    </div>
    <p>
        <a href="reset-password.php" class="btn btn-warning">Reset Your Password</a>
        <a href="logout.php" class="btn btn-danger">Sign Out of Your Account</a>
    </p>

    <script src="https://www.gstatic.com/firebasejs/7.2.0/firebase-app.js"></script>
    <script type="text/javascript" src="https://www.gstatic.com/firebasejs/live/3.1/firebase.js"></script>
    <script type="text/javascript">
        var firebaseConfig = {
            apiKey: "AIzaSyAkL0SmgCgZHhUJhhErD8HmgSn_Ru1OsLw",
            authDomain: "webapp-dce5b.firebaseapp.com",
            databaseURL: "https://webapp-dce5b.firebaseio.com",
            projectId: "webapp-dce5b",
            storageBucket: "webapp-dce5b.appspot.com",
            messagingSenderId: "88104536922",
            appId: "1:88104536922:web:6115ad7decaf2bd9c1c163",
            measurementId: "G-C24QGPZDB3"
        };
  
        // Initialize Firebase
        firebase.initializeApp(firebaseConfig);
    </script>

    <script type="text/javascript" src="https://code.jquery.com/jquery-3.1.0.js"></script>
    <script type="text/javascript" src="retrieve.js"></script>
</body>
</html>