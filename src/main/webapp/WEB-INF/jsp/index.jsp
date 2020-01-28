<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
    <title>Task creator</title>
    <link rel="stylesheet" type="text/css" href="/css/css.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <spring:url value="js/ajax.js" var="ajaxJs"/>
    <script src="${ajaxJs}"></script>
    <script>
        $(document).ready(function () {
            getList();
            assignEvents();
        });
    </script>

</head>
<body>
<div class="header"></div>
<h1>MY TASKS</h1>
<button class="button actionButton"><a id="openCreateButton">CREATE NEW TASK</a></button>
</div>
<%@include file="table.jsp"%>
<%@include file="modal.jsp"%>
</body>
</html>