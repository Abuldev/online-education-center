<%--
  Created by IntelliJ IDEA.
  User: muhammadqodir
  Date: 30/07/22
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <jsp:include page="../fragments/head.jsp"></jsp:include>
</head>
<body>


<div class="row">

    <div class="col-xl-6 d-none d-xl-block">
        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img4.webp"
             alt="Sample photo" class="img-fluid"
             style="border-top-left-radius: .15rem; border-bottom-left-radius: .15rem;" />
    </div>
    <div class="col-xl-6">
        <form method="post" action="/auth/login">
            <br>
            <br>
            <div class="form-group">
                <h3> Student Login  </h3>
            </div>

            <div class="form-group">
                <label for="l_phone"> Phone Number</label>
                <input type="text" class="form-control" id="l_phone" name="l_phone" placeholder="Phone number">
            </div>

            <div class="form-group">
                <label for="l_password">password</label>
                <input type="password" class="form-control" id="l_password" name="l_password" placeholder="John Doe">
            </div>

            <button type="submit" class="btn btn-success">Login</button>
            <a href="/auth/register" class="btn btn-primary">Register</a>
        </form>
    </div>
</div>


<jsp:include page="../fragments/js.jsp"></jsp:include>
</body>
</html>
