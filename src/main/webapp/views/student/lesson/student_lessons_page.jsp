<%--
  Created by IntelliJ IDEA.
  User: muhammadqodir
  Date: 02/08/22
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title> Lessons </title>
    <jsp:include page="../../fragments/head.jsp"></jsp:include>

    <link rel="stylesheet" href="/resources/css/table.css">

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
                        <li class="breadcrumb-item active" aria-current="page"> Lessons</li>
                    </ol>
                </nav>
            </div>
        </div>

        <jsp:include page="../../fragments/lessons.jsp"></jsp:include>

    </div>
</section>


<jsp:include page="../../fragments/js.jsp"></jsp:include>


</body>
</html>
