function assignEvents() {
    $('#openCreateButton').click(function () {
        openModal();
    });
    $('#closeModalButton').click(function () {
        $('#modal').hide();
    });
}

function openModal(isUpdate = false, taskId = null) {
    $('#modal').show();
    if (isUpdate) {
        $('#submitButton').html('Update task');
        $('#submitButton').prop("onclick", null);
        $('#submitButton').click(function () {
            updateTask(taskId);
        });
    } else {
        $('#submitButton').html('Create task');
        $('#submitButton').prop("onclick", null);
        $('#submitButton').click(function () {
            createTask();
        });
    }
}

function getList() {
    $.ajax({
        url: "http://localhost:8080/rest/tasks",
        method: "GET",
        success: [
            function (data) {
                populateDataTable(data);
            }
        ]
    })
        .done(function (list) {
            console.log(list);
        })
        .fail(function () {
            alert("error");
        });
}

function initOnUpdate(taskId, updateButton) {
    updateButton.onclick = function () {
        openModal(true, taskId);
    };
};

function populateDataTable(data) {
    for (i in data) {
        var tr = document.createElement('tr');
        var element = data[i];
        console.log(element);

        var tdId = document.createElement('tdId');
        //tdId.appendChild(document.createTextNode(element.id));
        tr.appendChild(tdId);
        var taskId = element.id;

        var tdName = document.createElement('td');
        tdName.appendChild(document.createTextNode(element.taskName));
        tr.appendChild(tdName);

        var tdStartDate = document.createElement('td');
        tdStartDate.appendChild(document.createTextNode(element.startDate));
        tr.appendChild(tdStartDate);

        var tdEndDate = document.createElement('td');
        tdEndDate.appendChild(document.createTextNode(element.endDate));
        tr.appendChild(tdEndDate);

        var tdPriority = document.createElement('td');
        tdPriority.appendChild(document.createTextNode(element.priority));
        tr.appendChild(tdPriority);

        var tdNotes = document.createElement('td');
        tdNotes.appendChild(document.createTextNode(element.notes));
        tr.appendChild(tdNotes);

        var tdUpdate = document.createElement('td');
        var updateButton = document.createElement('Button');
        updateButton.appendChild(document.createTextNode('UPDATE'));
        tdUpdate.appendChild(updateButton);

        initOnUpdate(taskId, updateButton);

        tr.appendChild(tdUpdate);

        var tdDelete = document.createElement('td');
        var deleteButton = document.createElement('Button');
        deleteButton.appendChild(document.createTextNode('DELETE'));
        deleteButton.setAttribute("onclick", "deleteTask(" + taskId + ");");
        tdDelete.appendChild(deleteButton);
        tr.appendChild(tdDelete);

        $('#tasks').append(tr);
    }
}

function updateTask(id) {
    console.log('updating' + id)
    if (validateData()) {
        $.ajax({
            url: "http://localhost:8080/rest/updatetask/" + id,
            method: "PUT",
            contentType: "application/json",
            data: JSON.stringify({
                taskName: $("input[name='taskname']").val(),
                startDate: $("input[name='startdate']").val(),
                endDate: $("input[name='enddate']").val(),
                priority: $("input[name='priority']").val(),
                notes: $("input[name='notes']").val()
            }),
            success: function () {
                swal({
                    title: "Task updated!",
                    icon: "success",
                });
                getList();
                location.reload();
            },
            fail: function () {
                swal({
                    title: "There was an error while updating the task!",
                    icon: "error",
                });
            }
        })
            .done(function (response) {
                console.log(response);
            })
    } else {
        return false;
    }
}

function deleteTask(id) {
    console.log(id);
    $.ajax({
        url: "http://localhost:8080/rest/deletetask/" + id,
        method: "DELETE",
        contentType: "application/json",
        success: function () {
            swal({
                title: "Task deleted!",
                icon: "success",
            });
            getList();
            location.reload();
        },
        fail: function () {
            swal({
                title: "There was an error while deleting the task!",
                icon: "error",
            });
        }
    })
        .done(function (response) {
            console.log(response);
        })
}

function createTask() {
    if (validateData()) {
        $.ajax({
            url: "http://localhost:8080/rest/savetask",
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                taskName: $("input[name='taskname']").val(),
                startDate: $("input[name='startdate']").val(),
                endDate: $("input[name='enddate']").val(),
                priority: $("input[name='priority']").val(),
                notes: $("input[name='notes']").val()
            }),
            success: function () {
                swal({
                    title: "Task created!",
                    icon: "success",
                });
                getList();
                location.reload();
            },
            fail: function () {
                swal({
                    title: "There was an error while creating the task!",
                    icon: "error",
                });
            }
        })
            .done(function (response) {
                console.log(response);
            })
    } else {
        return false;
    }
}

function validateData() {
    console.log("VALIDATE METHOD CALLED")
    var taskName = $("input[name='taskname']").val();
    var startDate = $("input[name='startdate']").val();
    var endDate = $("input[name='enddate']").val();
    var priority = $("input[name='priority']").val();
    var notes = $("input[name='notes']").val();
    if (taskName == "" || startDate == "" || endDate == "" || priority == "" || notes == "") {
        swal({
            title: "Fields can't be empty!",
            icon: "error",
        });
        return false;
    }
    return true;
}