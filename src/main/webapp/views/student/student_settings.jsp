<%--
  Created by IntelliJ IDEA.
  User: muhammadqodir
  Date: 01/08/22
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Student Settings </title>
    <jsp:include page="../fragments/head.jsp"></jsp:include>
</head>
<body>

<jsp:include page="../fragments/navbar.jsp"></jsp:include>
<jsp:include page="../fragments/student_cabinet_navbar.jsp"></jsp:include>


<section style="background-color: #eee;">
    <div class="container py-5">
        <div class="row">
            <div class="col">
                <nav aria-label="breadcrumb" class="bg-light rounded-3 p-3 mb-4">
                    <ol class="breadcrumb mb-0">
                        <li class="breadcrumb-item"><a href="/">Home</a></li>
                        <li class="breadcrumb-item active" aria-current="page">User Profile</li>
                    </ol>
                </nav>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-4">
                <div class="card mb-4">
                    <div class="card-body text-center">
                        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp"
                             alt="avatar"
                             class="rounded-circle img-fluid" style="width: 150px;">

                        <p class="text-muted mb-0">
                            <input name="photo" autocomplete="off"
                                   placeholder="Your first name" required="" id="photo"
                                   type="file"
                                   class="is-untouched is-pristine av-valid form-control">
                        </p>

                        <h5 class="my-3">  ${user.fullname.firstName} ${user.fullname.lastName} </h5>
                        <p class="text-muted mb-4">${user.address.region}, ${user.address.city} </p>
                        <div class="d-flex justify-content-center mb-2">
                            <button type="button" class="btn btn-primary">Follow</button>
                            <button type="button" class="btn btn-outline-primary ms-1">Message</button>
                        </div>
                    </div>
                </div>

            </div>
            <div class="col-lg-8">
                <div class="card mb-4">
                    <div class="card-body">
                        <div class="row">

                            <div class="col-sm-3">
                                <p class="mb-0">First Name</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">
                                    <input name="firstName" autocomplete="off"
                                           placeholder="Your first name" required="" id="firstName"
                                           type="text"
                                           class="is-untouched is-pristine av-valid form-control"
                                           value=${user.fullname.firstName}>
                                </p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">

                            <div class="col-sm-3">
                                <p class="mb-0">Last Name</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">
                                    <input name="lastName" autocomplete="off"
                                           placeholder="Your last name" required="" id="lastName"
                                           type="text"
                                           class="is-untouched is-pristine av-valid form-control"
                                           value=${user.fullname.lastName}>
                                </p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Email</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">
                                    <input name="email" autocomplete="off"
                                           placeholder="Email" required="" id="email"
                                           type="email"
                                           class="is-untouched is-pristine av-valid form-control"
                                           value=${user.email}>
                                </p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Phone number</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">
                                    <input name="phone" autocomplete="off"
                                           placeholder="Phone" required="" id="phone"
                                           type="text"
                                           class="is-untouched is-pristine av-valid form-control"
                                           value=${user.login.phone_number}>
                                </p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0"> Birthday </p>
                            </div>
                            <div class="col-sm-9">
                                <input name="birthday" autocomplete="off"
                                       required="" id="birthday"
                                       type="date"
                                       class="is-untouched is-pristine av-valid form-control"
                                       value=${user.birthday}>
                            </div>

                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Address</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">
                                    ${user.address.region}, ${user.address.city}
                                </p>
                            </div>

                            <a href="/profile/settings" class="btn btn-primary"> Save </a>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<jsp:include page="../fragments/js.jsp"></jsp:include>
</body>
</html>
