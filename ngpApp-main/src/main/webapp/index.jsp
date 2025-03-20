<!DOCTYPE html>
<html>
<head>
    <title>Login or Register</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: linear-gradient(to right, #ff7e5f, #feb47b);
            margin: 0;
        }
        .container {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            width: 90%;
            max-width: 400px;
            text-align: center;
            animation: fadeIn 1.5s ease-in-out;
        }
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(-20px); }
            to { opacity: 1; transform: translateY(0); }
        }
        button {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            font-size: 16px;
            cursor: pointer;
            border: none;
            border-radius: 5px;
            transition: transform 0.3s, background 0.3s;
        }
        button:hover {
            transform: scale(1.05);
            background: #ff7e5f;
            color: white;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Welcome</h2>
        <form action="pages/LoginView.jsp" method="post">
            <button type="submit">Login</button>
        </form>
        <form action="pages/RegisterView.jsp" method="post">
            <button type="submit">Register</button>
        </form>
    </div>
</body>
</html>
