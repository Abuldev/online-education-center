<%--
  Created by IntelliJ IDEA.
  User: muhammadqodir
  Date: 31/07/22
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Online Courses</title>
    <jsp:include page="../fragments/head.jsp"></jsp:include>
</head>
<body>

<jsp:include page="../fragments/navbar.jsp"></jsp:include>


<div class="row">
    <c:forEach items="${courses}" var="course">

        <div class="col-2">
            <div class="card mt-5">
                <div class="card-body">
                    <p class="card-text"> Name : ${course.name}</p>
                    <p class="card-text"> Teacher : ${course.teacher.fullname.firstName}</p>
                    <p class="card-text"> Price : ${course.price} sum</p>
                    <p class="card-text"> Number of lessons : ${course.num_lessons}</p>

                    <div class="row">
                        <div class="col-10 offset-1">
                            <button type="button" class="btn btn-success" data-toggle="modal" data-target=".bd-example-modal-lg">
                                Buy Course
                            </button>

                            <div class="modal fade bd-example-modal-lg" id="exampleModal" tabindex="-1" role="dialog"
                                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel"> Buy Course </h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <form method="post" action="/buy?courseid=${course.id}" enctype="multipart/form-data">
                                            <div class="modal-body">
                                                <div class="container-fluid">
                                                    <div class="row">
                                                        <div class="col-6">

                                                            <div class="form-group">
                                                                <label for="card"> Enter card number </label>
                                                                <input type="number" name="card" class="form-control" id="card"/>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="card_phone"> Enter phone number connected with card </label>
                                                                <input type="text" name="card_phone" class="form-control" id="card_phone"/>
                                                            </div>

                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                <button type="submit" class="btn btn-primary"> Buy </button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                </div>
            </div>
        </div>
    </c:forEach>
</div>

<jsp:include page="../fragments/js.jsp"></jsp:include>
</body>
</html>
