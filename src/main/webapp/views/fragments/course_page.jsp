<div class="row">
  <div class="col-lg-4">
    <div class="card mb-4">
      <div class="card-body text-center">
        <h1 class="my-3">  ${course.name} </h1>
      </div>
    </div>

  </div>
  <div class="col-lg-8">
    <div class="card mb-4">
      <div class="card-body">
        <div class="row">

          <div class="col-sm-3">
            <p class="mb-0">Name</p>
          </div>
          <div class="col-sm-9">
            <p class="text-muted mb-0">
              ${course.name}
            </p>
          </div>
        </div>
        <hr>
        <div class="row">

          <div class="col-sm-3">
            <p class="mb-0"> Teacher </p>
          </div>
          <div class="col-sm-9">
            <p class="text-muted mb-0">
              ${course.teacher.fullname.firstName}  ${course.teacher.fullname.lastName}
            </p>
          </div>
        </div>
        <hr>
        <div class="row">
          <div class="col-sm-3">
            <p class="mb-0"> Price </p>
          </div>
          <div class="col-sm-9">
            <p class="text-muted mb-0">
              ${course.price} sum
            </p>
          </div>
        </div>
        <hr>
        <div class="row">
          <div class="col-sm-3">
            <p class="mb-0"> Discount </p>
          </div>
          <div class="col-sm-9">
            <p class="text-muted mb-0">
              ${course.discount} sum
            </p>
          </div>
        </div>
        <hr>
        <div class="row">
          <div class="col-sm-3">
            <p class="mb-0">Number of lessons</p>
          </div>
          <div class="col-sm-9">
            <p class="text-muted mb-0">
              ${num_of_lessons}
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>