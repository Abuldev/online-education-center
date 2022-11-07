<%--
  Created by IntelliJ IDEA.
  User: jlkesh
  Date: 26/07/22
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bad request</title>
    <style>
        body{
            margin: 0;
            background: #a29e9e;
            color: black;
            font-weight: bold;
        }
        h1{
            margin-top: 30vh;
            text-align: center;
            font-size: 70px;
        }
        h3{
            text-align: center;
        }
    </style>
</head>
<body>
<div class="err">
    <h1>400</h1>
    <h3>${message}</h3>
</div>

</body>
</html>
