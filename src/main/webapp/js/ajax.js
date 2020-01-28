function assignEvents() {
    $('#openCreateButton').click(function () {
        openModal();
    });
    $('#closeModalButton').click(function () {
        $('#modal').hide();
    });
}

function openModal(isUpdate,task) {
    console.log('openModal');
    $("input[name='taskname']").val("");
    $("input[name='startdate']").val("");
    $("input[name='enddate']").val("");
    $("input[name='priority']").val("");
    $("input[name='notes']").val("");
    if (isUpdate) {
        console.log(task);
        $("input[name='taskname']").val(task.taskName);
        var date1 = new Date(task.startDate);
        $("input[name='startdate']").val(date1.toISOString().substring(0,10));
        var date2 = new Date(task.endDate);
        $("input[name='enddate']").val(date2.toISOString().substring(0,10));
        $("input[name='priority']").val(task.priority);
        $("input[name='notes']").val(task.notes);
        $('#submitButton').text('UPDATE TASK');
        $('#submitButton').prop("onclick", null).off("click");
        $('#submitButton').click(function () {
            updateTask(task);
        });
    } else {
        $('#submitButton').text('CREATE TASK');
        $('#submitButton').prop("onclick", null).off("click");
        $('#submitButton').click(function () {
            createTask();
        });
    }
    $('#modal').show();
}

function getList() {
    $.ajax({
        url: "http://localhost:8085/rest/tasks",
        method: "GET",
        success:
            function (data) {
                populateDataTable(data);
            }
    })
        .fail(function () {
            alert("error");
        });
}

function initOnUpdate(task, updateButton) {
    console.log('initOnUpdate');
    $(updateButton).prop("onclick", null).off("click");
    updateButton.onclick = function () {
        console.log('update clicked');
        openModal(true, task);
    };
};

function populateDataTable(data){
    for (i in data) {
        // data.forEach(function(data) {
        var tr = document.createElement('tr');
        var element = data[i];
        console.log(element);

        var taskId = element.id;

        tr.appendChild(createTD(element.id));
        tr.appendChild(createTD(element.taskName));
        var date1 = new Date(element.startDate);
        tr.appendChild(createTD(date1.toISOString().slice(0, 10)));
        var date2 = new Date(element.endDate);
        tr.appendChild(createTD(date2.toISOString().slice(0, 10)));
        tr.appendChild(createTD(element.priority));
        tr.appendChild(createTD(element.notes));

        var tdUpdate = document.createElement('td');
        var updateButton = document.createElement('Button');
        updateButton.innerText = "UPDATE";
        updateButton.className = "button";
        tdUpdate.appendChild(updateButton);

        initOnUpdate(element, updateButton);

        tr.appendChild(tdUpdate);

        var tdDelete = document.createElement('td');
        var deleteButton = document.createElement('Button');
        deleteButton.innerText = "DELETE";
        deleteButton.setAttribute("onclick", "deleteTask(" + taskId + ");");
        deleteButton.className = "button";
        tdDelete.appendChild(deleteButton);
        tr.appendChild(tdDelete);

        $('#tasks').append(tr);
    }
}

function createTD(innerText){
    var el = document.createElement('td');
    el.appendChild(document.createTextNode(innerText));
    return el;
}

function updateTask(task) {
    console.log('updating' + task.id)
    if (validateData()) {
        $.ajax({
            url: "http://localhost:8085/rest/tasks/" + task.id,
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
    }
}

function deleteTask(id) {
    console.log(id);
    $.ajax({
        url: "http://localhost:8085/rest/tasks/" + id,
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
}

function createTask() {
    if (validateData()) {
        $.ajax({
            url: "http://localhost:8085/rest/tasks",
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