<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
            crossorigin="anonymous"></script>
</head>
<body>
<h2>Insert to n-n relationship</h2>
<div class="container m-auto w-75">
    <form action="employee" method="POST">
        <div class="form-row">
            <label class="col-4">
                Employee Id
            </label>
            <div class="col">
                <input class="form-control" name="empId" type="text" placeholder="Employee Id">
            </div>
        </div>
        <div class="form-row">
            <label class="col-4">
                Employee Name
            </label>
            <div class="col">
                <input class="form-control" name="empName" type="text" placeholder="Employee name">
            </div>
        </div>
        <div class="form-row">
            <label class="col-4">
                Add Employee existing in Company table
            </label>
            <div class="col">
                <input class="form-control" name="comId" type="text" placeholder="Company Id">
            </div>
        </div>
        <div class="form-row">
            <label class="col-4">
                Add Employee without in Company table
            </label>
            <div class="col">

            </div>
        </div>
        <div class="form-row">
            <label class="col-4">
                Company Id
            </label>
            <div class="col">
                <input class="form-control" name="comIdNew" type="text" placeholder="Company Id">
            </div>
        </div>
        <div class="form-row">
            <label class="col-4">
                Company Name
            </label>
            <div class="col">
                <input class="form-control" name="comNameNew" type="text" placeholder="Company name">
            </div>
        </div>
        <div class="form-row">
            <label class="col-4">
                Country Id
            </label>
            <div class="col">
                <input class="form-control" name="countryId" type="text" placeholder="Country Id">
            </div>
        </div>
        <div class="form-row">
            <label class="col-4">
                Country Name
            </label>
            <div class="col">
                <input class="form-control" name="countryName" type="text" placeholder="Country name">
            </div>
        </div>
        <p>
            <input type="reset" value="Reset">
            <input type="submit" value="ADD" name="action">
        </p>
    </form>
</div>
</body>
</html>
