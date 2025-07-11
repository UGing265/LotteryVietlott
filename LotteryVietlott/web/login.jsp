<%-- 
    Document   : login
    Created on : 16-Jun-2025, 13:17:05
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
    
    <!-- Tailwind CDN -->
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 flex items-center justify-center min-h-screen">

    <form action="MainController" method="POST" class="bg-white p-8 rounded shadow-md w-full max-w-sm space-y-4">
        <h2 class="text-2xl font-bold text-center text-gray-700">Login</h2>

        <div>
            <label class="block text-sm font-medium text-gray-600">Username</label>
            <input type="text" name="username" placeholder="Username"
                   class="mt-1 w-full border border-gray-300 p-2 rounded focus:outline-none focus:ring focus:border-blue-300"/>
        </div>

        <div>
            <label class="block text-sm font-medium text-gray-600">Password</label>
            <input type="password" name="password" placeholder="Password"
                   class="mt-1 w-full border border-gray-300 p-2 rounded focus:outline-none focus:ring focus:border-blue-300"/>
        </div>

        <div>
            <input type="submit" name="action" value="Login"
                   class="w-full bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded cursor-pointer"/>
        </div>

        <div class="text-center">
            <a href="MainController?action=Register" class="text-sm text-blue-500 hover:underline">
                Create a Lottery Account?
            </a>
        </div>
    </form>

</body>
</html>

