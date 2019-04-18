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
                <th>Project start date</th>
                <th>Project end date</th>
                <th>Is it Urgent</th>
                <th>Edit</th>
                <th>Delete</th>
                <th>Hide</th>
        </thead>
        <tbody id="tbody">
<%--        <tr id="rows">--%>
<%--            <td id="taskId" type="text"></td>--%>
<%--            <td id="taskTitle" type="text"></td>--%>
<%--            <td id="taskDescription" type="text"></td>--%>
<%--            <td id="taskCreated" type="date"></td>--%>
<%--            <td id="taskTimeRemaining" type="date"></td>--%>
<%--            <td id="isCritical" type="boolean"></td>--%>
<%--            <td><button id="editBtn">Edit</button></td>--%>
<%--            <td><button id="deleteBtn">Delete</button></td>--%>
<%--            <td><a href="link.html"><button id="doneBtn">Hide</button></a></td>--%>

<%--            <td><a class="btn btn-warning" href="/Task-edit">Edit</a></td>--%>
<%--            <td><a class="btn btn-warning" href="/Task-delete">Delete</a></td>--%>
<%--            <td><a class="btn btn-warning" href="/Task-Done">Done</a></td>--%>

<%--        </tr>--%>

        </tbody>
    </table>
    <div>
        <button id="addProject">Add Project</button>
        <button id="unhideProjects" onClick="unhideAllRows()">Unhide All</button>
    </div>
    <div id="formSub">
        <form>
            Title of the project:<br>
            <input id="projectNameSubm" type="text"><br>
            Project Description<br>
            <textarea type="text" id="textSubm"></textarea><br>
            Project start date:<br>
            <input id="startDateSubm" type="date"><br>
            Project end date:<br>
            <input id="endDateSubm" type="date"><br>
            Is the project Urgent:<br>
            <input id="criticalSubm" type="checkbox">
            <input id="submitSubm" class="button" type="button" value="Submit" onClick="getSubmitData()">
            <input id="submitSubmHide" class="button" type="button" value="Close" onClick="hideFormSubmit()">

        </form>
    </div>
    <div id="formEdit">
        <form id="formEditIdGetter">
            ID of the Project:<br>
            <input id="projectIdEdit" type="number" value="1" readonly="readonly"><br>
            Title of the project:<br>
            <input id="projectNameEdit" type="text"><br>
            Project Description<br>
            <textarea type="text" id="textEdit"></textarea><br>
            Project start date:<br>
            <input id="startDateEdit" type="date"><br>
            Project end date:<br>
            <input id="endDateEdit" type="date"><br>
            Is the project Urgent:<br>
            <input id="criticalEdit" type="checkbox">
            <input id="submitEdit" class="button" type="button" value="Submit" onClick="getEditData()">
            <input id="submitEditHide" class="button" type="button" value="Close" onClick="hideFormEdit()">

        </form>
    </div>

</div>
</body>
</html>