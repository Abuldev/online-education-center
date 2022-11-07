<%--
  Created by IntelliJ IDEA.
  User: muhammadqodir
  Date: 03/08/22
  Time: 09:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Lesson </title>
    <jsp:include page="../../fragments/head.jsp"></jsp:include>
</head>
<body>


<jsp:include page="../../fragments/navbar.jsp"></jsp:include>
<jsp:include page="../../fragments/student_cabinet_navbar.jsp"></jsp:include>

<section style="background-color: #eee;">
    <div class="container py-5">
        <div class="row">
            <div class="col">
                <nav aria-label="breadcrumb" class="bg-light rounded-3 p-3 mb-4">
                    <ol class="breadcrumb mb-0">
                        <li class="breadcrumb-item"><a href="/">Home</a></li>
                        <li class="breadcrumb-item"><a href="/profile/my_courses"> My courses </a></li>
                        <li class="breadcrumb-item"><a href="/enter/course?courseid=${course.id}"> Course </a></li>
                        <li class="breadcrumb-item"><a href="/course/lessons?courseid=${course.id}"> Lessons </a></li>
                        <li class="breadcrumb-item active" aria-current="page"> Lesson</li>
                    </ol>
                </nav>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="card mb-6">
                    <div class="card-body text-center">
                        <h1 class="my-6">Course: ${course.name} </h1>
                        <h3 class="my-6">Lesson: ${lesson.name}  </h3>
                    </div>
                </div>

            </div>
            <div class="list-group list-group-light">

                <br>
                <br>
                <h1 class="my-6" style="text-align: center"> Lesson video </h1>
                <iframe width="560" align="center" style="text-align: center" height="315" src="${lesson.video}"
                        title="YouTube video player" frameborder="0"
                        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                        allowfullscreen></iframe>
                <br>
                <br>
                <h2 class="my-6" style="text-align: right"> Task: <a href="/download?filename=${lesson.task.file.generatedName}"> ${lesson.task.name}  </a> </h2>
            </div>

        </div>








<%--        <div class="form-group">--%>
<%--            <label for="answer"> Upload answer </label>--%>
<%--            <input type="file" name="answer" class="form-control" id="answer"/>--%>
<%--            <a href="answer/add?taskid=${lesson.task.id}"> Upload </a>--%>
<%--        </div>--%>

    </div>
</section>

<div class="row">
    <div class="col-10 offset-1">
        <button type="button" class="btn btn-success" data-toggle="modal" data-target=".bd-example-modal-lg">
            Add Answer
        </button>

        <div class="modal fade bd-example-modal-lg" id="exampleModal" tabindex="-1" role="dialog"
             aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Add Answer</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form method="post" action="/answer/add?taskid=${lesson.task.id}" enctype="multipart/form-data">
                        <div class="modal-body">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-6">

                                        <div class="form-group">
                                            <label for="answer"> Upload answer </label>
                                            <input type="file" name="answer" class="form-control" id="answer"/>
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







<jsp:include page="../../fragments/js.jsp"></jsp:include>

</body>
</html>
