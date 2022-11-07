<%--
  Created by IntelliJ IDEA.
  User: muhammadqodir
  Date: 02/08/22
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title> My Courses</title>
    <jsp:include page="../../fragments/head.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../../fragments/navbar.jsp"></jsp:include>
<jsp:include page="../../fragments/teacher_cabinet_navbar.jsp"></jsp:include>

<div class="row">
    <c:forEach items="${courses}" var="course">

        <div class="col-2">
            <div class="card mt-5">
                <div class="card-body">
                    <p class="card-text"> Name : ${course.name}</p>
                    <p class="card-text"> Teacher : ${course.teacher.fullname.firstName}</p>
                    <p class="card-text"> Price : ${course.price} sum</p>
                    <p class="card-text"> Number of lessons : ${course.num_lessons}</p>
                    <a href="/enter/course?courseid=${course.id}" class="btn btn-outline-primary"> Enter this course </a>

                </div>
            </div>
        </div>
    </c:forEach>
</div>

<jsp:include page="../../fragments/js.jsp"></jsp:include>
</body>
</html>
