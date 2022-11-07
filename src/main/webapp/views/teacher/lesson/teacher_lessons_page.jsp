<%--
  Created by IntelliJ IDEA.
  User: muhammadqodir
  Date: 02/08/22
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title> Lessons </title>
    <jsp:include page="../../fragments/head.jsp"></jsp:include>

    <link rel="stylesheet" href="/resources/css/table.css">

</head>
<body>
<jsp:include page="../../fragments/navbar.jsp"></jsp:include>
<jsp:include page="../../fragments/teacher_cabinet_navbar.jsp"></jsp:include>


<section style="background-color: #eee;">
    <div class="container py-5">
        <div class="row">
            <div class="col">
                <nav aria-label="breadcrumb" class="bg-light rounded-3 p-3 mb-4">
                    <ol class="breadcrumb mb-0">
                        <li class="breadcrumb-item"><a href="/">Home</a></li>
                        <li class="breadcrumb-item"><a href="/profile/my_courses"> My courses </a></li>
                        <li class="breadcrumb-item"><a href="/enter/course?courseid=${course.id}"> Course </a></li>
                        <li class="breadcrumb-item active" aria-current="page"> Lessons</li>
                    </ol>
                </nav>
            </div>
        </div>

        <jsp:include page="../../fragments/lessons.jsp"></jsp:include>





        <div class="row">
            <div class="col-10 offset-1">
                <button type="button" class="btn btn-success" data-toggle="modal" data-target=".bd-example-modal-lg">
                    Add Lesson
                </button>

                <div class="modal fade bd-example-modal-lg" id="exampleModal" tabindex="-1" role="dialog"
                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Add Lesson</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <form method="post" action="/lessons/add?courseid=${course.id}" enctype="multipart/form-data">
                                <div class="modal-body">
                                    <div class="container-fluid">
                                        <div class="row">
                                            <div class="col-6">

                                                <div class="form-group">
                                                    <label for="name">Lesson Name</label>
                                                    <input type="text" name="name" class="form-control" id="name"/>
                                                </div>
                                                <div class="form-group">
                                                    <label for="info">Lesson info</label>
                                                    <input type="text" name="info" class="form-control" id="info"/>
                                                </div>

                                                <div class="form-group">
                                                    <label for="video"> Video YouTube path </label>
                                                    <input type="text" name="video" class="form-control" id="video"/>
                                                </div>

                                                <div class="form-group">
                                                    <label for="task"> Upload task </label>
                                                    <input type="file" name="task" class="form-control" id="task"/>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-primary">Save</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>








    </div>
</section>


<jsp:include page="../../fragments/js.jsp"></jsp:include>


</body>
</html>
