$(document).ready(function () {

    hideFormEdit();
    hideFormSubmit();
    loadData();
    loadFormListeners();

});

function hideFormSubmit() {
    document.getElementById('formSub').style.display = 'none';
}

function hideFormEdit() {
    document.getElementById('formEdit').style.display = 'none';
}

function showFormEdit() {
    document.getElementById('formEdit').style.display = 'block';
}

function showFormSubmit() {
    document.getElementById('formSub').style.display = 'block';
}

function loadFormListeners() {

    document.getElementById('addProject').addEventListener('click', showFormSubmit);
}


function projectDelete(object) {
    document.getElementById('row' + object.id).style.display = 'none';
    $.ajax({
        url: 'http://localhost:8080/project/delete/' + object.id,
        method: "DELETE",
        success: [
            function () {
                alert("Project " + object.id + " successfully deleted ");
            }
        ]
    })
        .fail(function () {
            alert("error");
        });

}
//TODO, show single project screen, for more in-depth analysis
function loadSingleProject(ID) {
    $.ajax({
        url: 'http://localhost:8080/project/' + ID,
        method: "GET",
        contentType: "application/json",
        success: [
            function (data) {
            alert("Project " + ID + " successfully loaded ");
            }
        ]
    })
        .fail(function () {
            alert("error");
        });


}
//TODO. update, this is duplicate code. used it for sake of management, change both!!!!
function formatDateForUpdate(date) {
    var day= date.toString().substring(8, 10);
    var month= date.toString().substring(5, 7);
    var year= date.toString().substring(0, 4);
    var formattedDate= year + "-" +month+ "-" +day;
    return formattedDate;
}

//TODO, implement the autoload of checkbox
//TODO, also, refactor the date formatting
function showProjectUpdateWindow(object) {
    if(object.critical==true){
        document.getElementById('criticalEdit').checked =true;
    }else{
        document.getElementById('criticalEdit').checked =false;
    }
    document.getElementById('projectIdEdit').value =object.id;
    document.getElementById('projectNameEdit').value =object.title;
    document.getElementById('textEdit').value =object.body;
    document.getElementById('startDateEdit').value =formatDateForUpdate(object.dateCreated);
    document.getElementById('endDateEdit').value =formatDateForUpdate(object.timeRemaining);
    showFormEdit();
}


function projectHide(object) {
    document.getElementById('row' + object.id).style.display = 'none';
}
//Placeholder for better implementation, right now, it just load's all objects again
function unhideAllRows() {
loadData();

}
function getFilledData(suffix) {
    try{
        var projectID = document.getElementById('projectId'+suffix).value;
    }catch (e) {
        projectID=null;
    }
    var projectName = document.getElementById('projectName'+suffix).value;
    var projectDesc = document.getElementById('text'+suffix).value;
    var projectStart = document.getElementById('startDate'+suffix).value;
    var projectEnd = document.getElementById('endDate'+suffix).value;
    var projectCritical = $('#critical'+suffix).prop('checked');
    prepareJSON(projectName, projectDesc, projectStart, projectEnd, projectCritical, projectID);
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

//TODO, can be refactored
//if value exists, project is being edited, if not, new project.
function prepareJSON(projectName, projectDesc, projectStart, projectEnd, projectCritical, ID) {
    if (!ID) {
        var data = '{"title": "' + projectName + '","body":"' + projectDesc + '","dateCreated":"' + projectStart + '","critical":' + projectCritical + ',"timeRemaining":"' + projectEnd + '"}';
        var obj = JSON.stringify(eval("(" + data + ")"));
        hideFormSubmit();
        submitProject(obj);

    } else {
        var data = '{"id": "' + ID + '","title": "' + projectName + '","body":"' + projectDesc + '","dateCreated":"' + projectStart + '","critical":' + projectCritical + ',"timeRemaining":"' + projectEnd + '"}';
        var obj = JSON.stringify(eval("(" + data + ")"));
        hideFormEdit();
        updateProject(obj, ID)
    }


}

function validateFormInputs(suffix) {
    var errorMessage="Invalid values, please make sure to fill out the form properly. ";
    var isTheInputValid=true;
    var endDate =document.getElementById("endDate"+suffix).value;
    var startDate =document.getElementById("startDate"+suffix).value;
    var projectName =document.getElementById("projectName"+suffix).value;
    var projectDescription=document.getElementById("text"+suffix).value;

    if (!projectName) {
        isTheInputValid=false;
        errorMessage=errorMessage.concat("Project Title can't be empty. ");
    }
    if (!projectDescription){
        isTheInputValid=false;
        errorMessage=errorMessage.concat("Project Description can't be empty. ");
    }
    if (!startDate){
        isTheInputValid=false;
        errorMessage=errorMessage.concat("Project Start Date can't be empty. ");
    }
    if (!endDate){
        isTheInputValid=false;
        errorMessage=errorMessage.concat("Project End Date can't be empty. ");
    }
    if (Date.parse(startDate)>Date.parse(endDate)){
        isTheInputValid=false;
        errorMessage=errorMessage.concat("Please recheck the project schedule, it ends before it starts. ");
    }
    if (isTheInputValid==false){
        alert(errorMessage);
    }else{
        getFilledData(suffix)
    }
}

function addRow(object) {
    $('#tbody').append
    ('<tr class="projectrow" id="row' + object.id + '">' +
        '<td>' + object.id + '</td>' +
        '<td>' + object.title + '</td>' +
        '<td class="descriptionBody">' + object.body + '</td>' +
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
    addRow(object);
}


function loadListener(object) {
    document.getElementById('edit' + object.id).addEventListener('click', function () {
        showProjectUpdateWindow(object);
    });
    document.getElementById('delete' + object.id).addEventListener('click', function () {
        projectDelete(object);
    });

    document.getElementById('hide' + object.id).addEventListener('click', function () {
        projectHide(object);
    });

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
        ('<tr class="projectrow" id="row' + object.id + '">' +
            '<td>' + object.id + '</td>' +
            '<td>' + object.title + '</td>' +
            '<td class="descriptionBody">' + object.body + '</td>' +
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
