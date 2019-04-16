$(document).ready(function () {
    var sad = $('#rows').find('*').length;
    loadData();
    // alert(fun);
});


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

    // $("tr:has(td)").remove();
    // for (i in data){
    //
    //     makeElement(i);
    function makeElement(info, tr) {
        var tableCell = document.createElement('td'); //izveido table cell
        tableCell.appendChild(document.createTextNode(info)); //ieliek current element taskName veertiibu ieksh cell
        tr.appendChild(tableCell); //tablerow.pievieno(tablecell)

    }

    function populateDataTable(data) {
        for (var i in data) {
            const ele = data[i]
            //makeElement(i);
            var tr = document.createElement('tr'); //izveido table row
            makeElement(ele.id, tr);
            makeElement(ele.title, tr);
            makeElement(ele.body, tr);
            makeElement(ele.dateCreated, tr);
            makeElement(ele.timeRemaing, tr);
            makeElement(ele.critical, tr);
            $("#tbody1").append(tr);

        }
    }

    // function makeElement(element) {
    //     var newRow = document.createElement('tr');
    //     var newEntry = document.createElement('td');
    //     newEntry.appendChild(document.createTextNode(element.id));
    //
    //     newRow.appendChild(newEntry);
    //
    // }
    // }
    // $("tr:has(td)").remove();
    // for (i in data){
    //
    //     makeElement(i);
    //
    //
    //
    //     var td_id=$("<td/>");
    //         var span = $("<span/>");
    //         span.text(data.id);
    //         td_id.append(span);
    //
    //      var td_title=$("<td/>");
    //         var span = $("<span/>");
    //         span.text(data.title);
    //         td_title.append(span);
    //
    //     var td_body=$("<td/>");
    //         var span = $("<span/>");
    //         span.text(data.body);
    //         td_body.append(span);
    //
    //
    //     var td_dateCreated=$("<td/>");
    //         span.text(data.dateCreated);
    //         td_dateCreated.append(span);
    //
    //     var td_timeRemaining=$("<td/>");
    //         var span = $("<span/>");
    //         span.text(data.timeRemaining);
    //         td_timeRemaining.append(span);
    //
    //     var td_critical=$("<td/>");
    //         var span = $("<span/>");
    //         span.text(data.critical);
    //         td_critical.append(span);
    //
    //     $('#tbody1').append($('<tr/>')
    //.append($('<td/>').html("<a href='"+article.url+"'>"+article.title+"</a>"))
    // .append(td_id)
    // .append(td_title)
    // .append(td_body)
    // .append(td_dateCreated)
    // .append(td_timeRemaining)
    // .append(td_critical)
    // );
    //
    //
    //
    // $('#divTask tbody1').append(
    //     '<tr><td>'+item.id+
    //     '</td><td>'+item.title+
    //     '</td><td>'+item.body+
    //     '</td><td>'+item.dateCreated+
    //     '</td><td>'+item.timeRemaining+
    //     '</td><td>'+item.critical+
    // '</td></tr>'


    // var fun =$.ajax({
    //     type: 'GET',
    //     url: 'localhost:8080/projects' ,
    //     contentType: "application/json"
    //     data: JSON.stringify({
    //
    //     })
    // });
    // var loadJson = JSON.stringify(fun);

    // var id = $('#taskId');
    // var title=$('#taskTitle');
    // var description=$('#taskDescription');
    // var created=$('#taskCreated');
    // var remaining=$('#taskTimeRemaining');
    // var table=$('#mainTable');
    //  var requestAllValues= $.ajax({
    //      url:"localhost:8080/projects",
    //      method: 'GET',
    //      data:
    //         {id: id,
    //         title:title,
    //         body:body,
    //         dateCreated:dateCreated,
    //         timeRemaining:timeRemaining,
    //         critical:critical},
    //      dataType:'json'
    //  });
    // $.ajax({
    //     type: 'GET',
    //     url: "localhost:8080/projects" ,
    //     dataType: 'json',
    //     success: function (response) {
    //         var trHTML = '';
    //         for(var f=0;f<response.length;f++) {
    //             trHTML += '<tr><td><strong>' + response[f]['app_action_name']+'</strong></td><td><span class="label label-success">'+response[f]['action_type'] +'</span></td><td>'+response[f]['points']+'</td></tr>';
    //         }
    //         $('#result').html(trHTML);
    //         $( ".spin-grid" ).removeClass( "fa-spin" );
    //     }
    // });
    // if (id.toString()==""||title.toString()==" "||!description||!created||!remaining) {
    //    return count =0;
    // }else{
    //    return count =id.toString()+title.toString()+description.toString()+created.toString()+remaining.toString();
    // }


}
