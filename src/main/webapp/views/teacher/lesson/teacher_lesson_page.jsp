
<%--
  Created by IntelliJ IDEA.
  User: muhammadqodir
  Date: 02/08/22
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title> Lesson </title>
    <jsp:include page="../../fragments/head.jsp"></jsp:include>
</head>
<body>


<jsp:include page="../../fragments/navbar.jsp"></jsp:include>
<jsp:include page="../fragments/teacher_course.jsp"></jsp:include>

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

        <div class="row">

            <c:forEach items="${answers}" var="answer">

                <ol>
                    <br>
                    <br>
                    <h3>
                        <li>

                            Answer: <a href="/download?filename=${answer.file.generatedName}" > ${answer.file.originalName} </a>
                            Student: ${answer.student.fullname.firstName}  ${answer.student.fullname.lastName}

                        </li>
                    </h3>
                </ol>


            </c:forEach>


        </div>

    </div>
</section>






<jsp:include page="../../fragments/js.jsp"></jsp:include>

</body>
</html>
