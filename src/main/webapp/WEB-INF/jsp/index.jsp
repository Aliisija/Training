<%@  taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page language="java"%>
<html>
<head>
    <spring:url value="js/ajax.js" var="ajaxJs"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
    <script src="${ajaxJs}"></script>
    <title>Task Tool v.9001</title>
    <link href="css/custom.css"
          rel="stylesheet">
</head>
<body>

<div id="divTask" class="container">
    <table id="table" class="table table-striped">
        <caption>Your Tasks</caption>
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Date created</th>
                <th>Time Remaining</th>
                <th>Is it Critical</th>
                <th>Edit</th>
                <th>Delete</th>
                <th>Done</th>
        </thead>
        <tbody id="tbody1">
<%--        <tr id="rows">--%>
<%--            <td id="taskId" type="text"></td>--%>
<%--            <td id="taskTitle" type="text"></td>--%>
<%--            <td id="taskDescription" type="text"></td>--%>
<%--            <td id="taskCreated" type="date"></td>--%>
<%--            <td id="taskTimeRemaining" type="date"></td>--%>
<%--            <td id="isCritical" type="boolean"></td>--%>
<%--            <td><a class="btn btn-warning" href="/Task-edit">Edit Task</a></td>--%>
<%--            <td><a class="btn btn-warning" href="/Task-delete">Delete Task</a></td>--%>
<%--            <td><a class="btn btn-warning" href="/Task-Done">Task is Done</a></td>--%>

<%--        </tr>--%>

        </tbody>
    </table>
    <div>
        <a class="btn btn-default" href="/Task-add">Add a Task</a>

    </div>

</div>
</body>
</html>