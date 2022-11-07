
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book List</title>
    <jsp:include page="../fragments/head.jsp"></jsp:include>

</head>

<body>

<jsp:include page="../fragments/navbar.jsp"/>



<div class="row">
    <div class="col-10 offset-1">

        <div class="row">
<%--            <c:forEach items="${courses}" var="course">--%>

<%--                <div class="col-2">--%>
<%--                    <div class="card mt-5">--%>
<%--                        <img class="card-img-top" src="/download?filename=${book.cover.generatedName}"--%>
<%--                             alt="Card image cap">--%>
<%--                        <div class="card-body">--%>

<%--                            <p class="card-text">Name : ${course.name}</p>--%>
<%--                            <p class="card-text">Author : ${course.fullname.firstName}</p>--%>
<%--                            <p class="card-text">Price : ${course.price}</p>--%>
<%--                            <p class="card-text">Discount : ${course.discount}</p>--%>
<%--                            <p class="card-text">Created : ${course.createdAt}</p>--%>
<%--                            <a href="/buy?coursename=${course.id}" class="btn btn-outline-primary"> Buy this course </a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </c:forEach>--%>
        </div>


    </div>
</div>

<jsp:include page="../fragments/js.jsp"></jsp:include>

</body>
</html>