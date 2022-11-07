<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: muhammadqodir
  Date: 30/07/22
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Register </title>
    <jsp:include page="../fragments/head.jsp"/>

</head>
<body>

<%--<jsp:include page="../fragments/navbar.jsp"/>--%>


<div class="row">

    <div class="col-xl-6 d-none d-xl-block">
        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img4.webp"
             alt="Sample photo" class="img-fluid"
             style="border-top-left-radius: .15rem; border-bottom-left-radius: .15rem;" />
    </div>
    <div class="col-xl-6">
        <form method="post" action="/auth/register">
            <br>
            <br>
            <div class="form-group">
                <h3> Student Registration Form </h3>
            </div>

            <div class="form-group">
                <label for="first_name">First name</label>
                <input type="text" class="form-control" id="first_name" name="first_name" placeholder="John Doe">
            </div>

            <div class="form-group">
                <label for="last_name">Last name</label>
                <input type="text" class="form-control" id="last_name" name="last_name" placeholder="John Doe">
            </div>

            <div class="form-group">
                <label for="phone">Phone Number </label>
                <input type="text" class="form-control" id="phone" name="phone" placeholder=" phone ">
            </div>

            <div class="form-group">
                <label for="birthday">Birthday </label>
                <input type="date" class="form-control" id="birthday" name="birthday">
            </div>

            <div class="form-group">
                <label for="password"> Password </label>
                <input type="password" class="form-control" id="password" name="password" placeholder=" password ">
            </div>

            <div class="form-group">
                <label for="confirm"> Confirm Password </label>
                <input type="password" class="form-control" id="confirm" name="confirm" placeholder=" confirm password ">
            </div>


            <div class="form-group">
                <label for="region">Region</label>
                <select class="form-control" id="region" name="region">
                    <c:forEach items="${regions}" var="region">
                        <option value="region"> ${region} </option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="city"> City </label>
                <select class="form-control" id="city" name="city">
                   <c:forEach items="${cities}" var="city">
                       <option value="city"> ${city} </option>
                   </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="email"> Email </label>
                <input type="email" class="form-control" id="email" name="email" placeholder=" email ">
            </div>

            <div class="form-group">
                <input type="radio" class="btn-check" name="gender" id="male" autocomplete="off" checked />
                <label class="btn btn-secondary" for="male"> Male </label>

                <input type="radio" class="btn-check" name="gender" id="female" autocomplete="off" />
                <label class="btn btn-secondary" for="female"> Female </label>

                <input type="radio" class="btn-check" name="gender" id="other" autocomplete="off" />
                <label class="btn btn-secondary" for="other"> Other </label>
            </div>

            <button type="submit" class="btn btn-success">Register</button>
            <a href="/auth/login" class="btn btn-primary">Login</a>
        </form>
    </div>
</div>







<jsp:include page="../fragments/js.jsp"/>

</body>
</html>
<%--

<link rel="stylesheet" type="text/css" href="register_style.css">

<





section class="h-100 bg-dark">
<form method="post" action="/auth/register" enctype="multipart/form-data">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col">
                <div class="card card-registration my-4">
                    <div class="row g-0">


                        <div class="col-xl-6 d-none d-xl-block">
                            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img4.webp"
                                 alt="Sample photo" class="img-fluid"
                                 style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;" />
                        </div>

                        <div class="col-xl-6">
                            <div class="card-body p-md-5 text-black">
                                <h3 class="mb-5 text-uppercase"> Student registration form </h3>

                                <div class="row">
                                    <div class="col-md-6 mb-4">
                                        <div class="form-group">
                                            <input type="text" id="first_name" name="first_name" class="form-control form-control-lg" />
                                            <label for="first_name">First name</label>
                                        </div>
                                    </div>
                                    <div class="col-md-6 mb-4">
                                        <div class="form-group">
                                            <input type="text" id="last_name" name="last_name" class="form-control form-control-lg" />
                                            <label for="last_name"> Last name </label>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-md-12 mb-6">
                                    <div class="form-group">
                                        <input type="text" id="phone" name="phone" class="form-control form-control-lg" placeholder="+998 ## ### ## ##" />
                                        <label for="phone"> Phone Number </label>
                                    </div>
                                </div>

                                <div class="col-md-12 mb-6">
                                    <div class="form-group">
                                        <input type="password" id="password" name="password" class="form-control form-control-lg" />
                                        <label for="password"> Password </label>
                                    </div>
                                </div>

                                <div class="col-md-12 mb-6">
                                    <div class="form-group">
                                        <input type="password" id="confirm" name="confirm" class="form-control form-control-lg"/>
                                        <label for="confirm"> Confirm Password </label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="region">Region</label>
                                    <select class="form-control" id="region" name="region">
                                        <option value="UZ">Uz</option>
                                        <option value="RU">Ru</option>
                                        <option value="EN">En</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="city"> City </label>
                                    <select class="form-control" id="city" name="city">
                                        <option value="UZ">Uz</option>
                                        <option value="RU">Ru</option>
                                        <option value="EN">En</option>
                                    </select>
                                </div>

                            </div>

                            <div class="d-md-flex justify-content-start align-items-center mb-4 py-2">

                                <h6 class="mb-0 me-4"> Gender: </h6>

                                <div class="form-check form-check-inline mb-0 me-4" >
                                    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="femaleGender"
                                           value="female" />
                                    <label class="form-check-label" for="femaleGender"> Female </label>
                                </div>

                                <div class="form-check form-check-inline mb-0 me-4">
                                    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="maleGender"
                                           value="option2" />
                                    <label class="form-check-label" for="maleGender">Male</label>
                                </div>
                            </div>
                            <div class="form-group mb-4">
                                <input type="email" id="email" name="email" placeholder="email address" class="form-control form-control-lg" />
                                <label for="email">Email</label>
                            </div>

                            <div class="d-flex justify-content-end pt-3">
                                <button type="button" class="btn btn-light btn-lg">Reset all</button>
                                <button type="submit" class="btn btn-warning btn-lg ms-2"> Register </button>
                            </div>

                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</form>
</section>




--%>