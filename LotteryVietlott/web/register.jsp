<%-- 
    Document   : login
    Created on : 16-Jun-2025, 13:17:05
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>

    <!-- ✅ Tailwind CDN -->
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 flex items-center justify-center min-h-screen">

    <form action="MainController" method="POST" class="bg-white p-8 rounded-lg shadow-lg w-full max-w-sm space-y-5">
        <h2 class="text-2xl font-bold text-center text-gray-700">Create Account</h2>

        <!-- Username -->
        <div>
            <label class="block text-sm font-medium text-gray-600 mb-1">Username</label>
            <input type="text" name="username" placeholder="Username"
                   class="w-full border border-gray-300 p-2 rounded focus:outline-none focus:ring focus:border-blue-400" />
        </div>

        <!-- Password -->
        <div>
            <label class="block text-sm font-medium text-gray-600 mb-1">Password</label>
            <input type="password" name="password" placeholder="Password"
                   class="w-full border border-gray-300 p-2 rounded focus:outline-none focus:ring focus:border-blue-400" />
        </div>

        <!-- Submit Button -->
        <div>
            <input type="submit" name="action" value="Register"
                   class="w-full bg-green-500 hover:bg-green-600 text-white font-semibold py-2 px-4 rounded cursor-pointer transition"/>
        </div>

        <!-- Link to Login -->
        <div class="text-center">
            <a href="MainController?action=Login" class="text-sm text-blue-500 hover:underline">
                Already have a Lottery Account? Sign in
            </a>
        </div>
    </form>

</body>
</html>

