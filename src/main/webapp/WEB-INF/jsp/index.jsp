<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
    <title>Task creator</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
    <link rel="stylesheet" type="text/css" href="/css/css.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
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
<h1>WELCOME</h1>
<%@include file="table.jsp"%>
<div id="modal" class="modal">
    <button id="closeModalButton">X</button>
    <div>
        Task name: <input type="text" name="taskname"/><br>
        Start date: <input type="date" name="startdate"/><br>
        End date: <input type="date" name="enddate"><br>
        Priority: <input type="text" name="priority"><br>
        Notes: <input type="text" name="notes"><br>
        <button type="submit" id="submitButton" onclick="createTask()"> Create Task </button>
    </div>
</div>
<button type="button" class="btn btn-primary"><a id="openCreateButton">CREATE NEW TASK</a></button>
</body>
</html>