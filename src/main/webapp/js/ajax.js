$(document).ready(function () {

    hideFormEdit();
    hideFormSubmit();

    loadData();

    loadFormListeners();
    var caller = null;

});

function hideFormSubmit() {
    document.getElementById('formSub').style.display = 'none';
}

function hideFormEdit() {
    document.getElementById('formEdit').style.display = 'none';
}

function showFormEdit(id) {
    var x = document.getElementById('projectIdEdit');
    x.getAttributeNode("value").value = id;

    document.getElementById('formEdit').style.display = 'block';
}

function showFormSubmit() {
    document.getElementById('formSub').style.display = 'block';
}

function loadFormListeners() {

    document.getElementById('addProject').addEventListener('click', projectSubmit);
}


function editProject() {
    hideFormEdit();
}

function projectSubmit() {
    showFormSubmit();
}

function projectDelete() {
    var str = this.id;
    var len = str.length;
    var res = str.substring(6, len);
    document.getElementById('row' + res).style.display = 'none';
    $.ajax({
        url: 'http://localhost:8080/project/delete/' + res,
        method: "DELETE",
        success: [
            function () {
                alert("Project " + res + "successfully deleted ");
            }
        ]
    })
        .fail(function () {
            alert("error");
        });

}

//TODO, make it so that project ID gets autoloaded.
function projectUpdate() {
    var str = this.id;
    var len = str.length;
    var res = str.substring(4, len);
    showFormEdit(res);

}

function projectHide() {
    var str = this.id;
    var len = str.length;
    var res = str.substring(4, len);
    document.getElementById('row' + res).style.display = 'none';
}

function unhideAllRows() {
loadData();

    // $('.projectRow').style.display='block';
    /*var res = document.getElementsByClassName('projectRow');
    var count = 0;
    for (i in res) {
        var theId=res.item(i).id;
        if (res.length > count) {
            count++;
            document.getElementsByClassName('projectRow').style.display = 'table-row';
        }

    }
     */
}

function getEditData(res) {
    var projectID = document.getElementById('projectIdEdit').value;
    var projectName = document.getElementById('projectNameEdit').value;
    var projectDesc = document.getElementById('textEdit').value;
    var projectStart = document.getElementById('startDateEdit').value;
    var projectEnd = document.getElementById('endDateEdit').value;
    var projectCritical = $('#criticalEdit').prop('checked');
    hideFormEdit();
    prepareJSON(projectName, projectDesc, projectStart, projectEnd, projectCritical, projectID);

}

//TODO Update so that ID gets loaded dynamically.
function getSubmitData() {
    // $('#formEditIdGetter').append(
    //     'Project ID '+this.id+':<br><input id="projectNameEdit" type="text"><br>'
    // );
    var projectName = document.getElementById('projectNameSubm').value;
    var projectDesc = document.getElementById('textSubm').value;
    var projectStart = document.getElementById('startDateSubm').value;
    var projectEnd = document.getElementById('endDateSubm').value;
    var projectCritical = $('#criticalSubm').prop('checked');
    hideFormSubmit();
    prepareJSON(projectName, projectDesc, projectStart, projectEnd, projectCritical);
}

function updateProject(object, ID) {
    $.ajax({
        url: 'http://localhost:8080/project/update/' + ID,
        method: "PATCH",
        contentType: "application/json",
        data: object,
        success: [
            function (data) {
                updateRow(data, ID);
                alert("Project successfully updated");
                console.log(data);
            }
        ]
    })
        .fail(function () {
            alert("error");
        });
}

function submitProject(object) {
    $.ajax({
        url: 'http://localhost:8080/projectSubmit',
        method: "POST",
        contentType: "application/json",
        data: object,
        success: [
            function (data) {
                addRow(data);
                alert("Project successfully scheduled");
                console.log(data);
            }
        ]
    })
        .fail(function () {
            alert("error");
        });
}

function prepareJSON(projectName, projectDesc, projectStart, projectEnd, projectCritical, ID) {
    if (!ID) {
        var data = '{"title": "' + projectName + '","body":"' + projectDesc + '","dateCreated":"' + projectStart + '","critical":' + projectCritical + ',"timeRemaining":"' + projectEnd + '"}';
        var obj = JSON.stringify(eval("(" + data + ")"));
        submitProject(obj);

    } else {
        var data = '{"id": "' + ID + '","title": "' + projectName + '","body":"' + projectDesc + '","dateCreated":"' + projectStart + '","critical":' + projectCritical + ',"timeRemaining":"' + projectEnd + '"}';
        var obj = JSON.stringify(eval("(" + data + ")"));
        updateProject(obj, ID)
    }


}

function addRow(object) {
    $('#tbody').append
    ('<tr class="projectRow" id="row' + object.id + '">' +
        '<td>' + object.id + '</td>' +
        '<td>' + object.title + '</td>' +
        '<td>' + object.body + '</td>' +
        '<td>' + formatDate(object.dateCreated) + '</td>' +
        '<td>' + formatDate(object.timeRemaining) + '</td>' +
        '<td>' + criticalToString(object.critical) + '</td>' +
        '<td id="edit' + object.id + '"><button>Edit</button></td>' +
        '<td id="delete' + object.id + '"><button>Delete</button></td>' +
        '<td id="hide' + object.id + '"><button>Hide</button></td>' +
        '</tr>');
    loadListener(object);
}

function updateRow(object, ID) {
    $('#row' + ID).remove();
    if (ID == 1) {
        addRow(object);
    } else {
        ID--;
        $('#tbody').append
        ('<tr class="projectRow" id="row' + object.id + '">' +
            '<td>' + object.id + '</td>' +
            '<td>' + object.title + '</td>' +
            '<td>' + object.body + '</td>' +
            '<td>' + formatDate(object.dateCreated) + '</td>' +
            '<td>' + formatDate(object.timeRemaining) + '</td>' +
            '<td>' + criticalToString(object.critical) + '</td>' +
            '<td id="edit' + object.id + '"><button>Edit</button></td>' +
            '<td id="delete' + object.id + '"><button>Delete</button></td>' +
            '<td id="hide' + object.id + '"><button>Hide</button></td>' +
            '</tr>');
        loadListener(object, ID);
    }

}


function loadListener(object, ID) {
    if (!object.id) {
        document.getElementById('edit' + ID).addEventListener('click', projectUpdate);
        document.getElementById('delete' + ID).addEventListener('click', projectDelete);
        document.getElementById('hide' + ID).addEventListener('click', projectHide);

    } else {

        document.getElementById('edit' + object.id).addEventListener('click', projectUpdate);
        document.getElementById('delete' + object.id).addEventListener('click', projectDelete);
        document.getElementById('hide' + object.id).addEventListener('click', projectHide);
    }
}
function monthNumberToString(month) {
    switch(month) {
        case "01":
            text = "January";
            break;

        case "02":
            text = "February";
            break;

        case "03":
            text = "March";
            break;

        case "04":
            text = "April";
            break;

        case "05":
            text = "May";
            break;

        case "06":
            text = "June";
            break;

        case "07":
            text = "July";
            break;

        case "08":
            text = "August";
            break;

        case "09":
            text = "September";
            break;

        case "10":
            text = "October";
            break;

        case "11":
            text = "November";
            break;

        case "12":
            text = "December";
            break;

    }
return text;
}

function formatDate(date) {
    var day= date.toString().substring(8, 10);
    var month= date.toString().substring(5, 7);
    var year= date.toString().substring(0, 4);
    month = monthNumberToString(month);
    var formattedDate= year + "-" +month+ "-" +day;
    return formattedDate;
}

function criticalToString(boolean) {
    if (boolean == true) {
        var status = "Yes, it is urgent"
    } else {
        var status = "No"
    }
    return status;
}

function loadData() {
    $.ajax({
        url: "http://localhost:8080/projects",
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
    


    function populateTable(object) {
        $('#tbody').append
        ('<tr class="projectRow" id="row' + object.id + '">' +
            '<td>' + object.id + '</td>' +
            '<td>' + object.title + '</td>' +
            '<td>' + object.body + '</td>' +
            '<td>' + formatDate(object.dateCreated) + '</td>' +
            '<td>' + formatDate(object.timeRemaining) + '</td>' +
            '<td>' + criticalToString(object.critical) + '</td>' +
            '<td id="edit' + object.id + '"><button>Edit</button></td>' +
            '<td id="delete' + object.id + '"><button>Delete</button></td>' +
            '<td id="hide' + object.id + '"><button>Hide</button></td>' +
            '</tr>');
    }

    function populateDataTable(data) {
        $("tr:has(td)").remove();

        for (var i in data) {
            var object = data[i];
            populateTable(object);
            loadListener(object)

        }
    }

    //other way of populating, keeping in case of need.
    function makeButton(info, tableRow, ButtonTitle) {
        var tableCell = document.createElement("button");
        tableCell.appendChild(document.createElement("HardCoded"));
        tableRow.appendChild(tableCell);

    }

    //other way of populating, keeping in case of need.
    function makeElement(info, tableRow) {
        var tableCell = document.createElement('td');
        tableCell.appendChild(document.createTextNode(info));
        tableRow.appendChild(tableCell);

    }


}
