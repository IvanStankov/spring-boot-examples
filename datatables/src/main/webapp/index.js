$(function() {

    var dt = $("#dt").DataTable( {
        "processing": true,
        "serverSide": true,
        "scrollX": "100%",
        "scrollXInner": "150%",
        "scrollCollapse": false,
        fixedColumns: {
            "leftColumns": 3
        },
        "columnDefs": [ {
            "render": function() {
                return "<input type='checkbox' class='chk'>"
            },
            "targets": [0]
        } ],
        "ajaxSource": "http://localhost:8070/datatables/documents"
    });

//    new $.fn.dataTable.FixedColumns(dt, {
//    });

    setInterval(function() {
        console.log('Interval');
        dt.draw(false);
    }, 2 * 1000);

    window.dt = dt;
})