<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="modal" class="modal">
    <button type="button" class="button" id="closeModalButton">X</button>
    <div>
        <div class="formelement">Task name: <input name="taskname"/></div>
        <div class="formelement">Start date: <input type="date" name="startdate"/></div>
        <div class="formelement">End date: <input type="date" name="enddate"></div>
        <div class="formelement">Priority: <input name="priority"></div>
        <div class="formelement">Notes: <input name="notes"></div>
        <button class = button type="submit" id="submitButton" onclick="createTask()"> CREATE TASK </button>
    </div>
</div>