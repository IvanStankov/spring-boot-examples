$(function() {

    var dt = $("#dt").dataTable( {
        "bProcessing": true,
        "bServerSide": true,
        "sScrollX": "100%",
        "sScrollXInner": "150%",
        "bScrollCollapse": true,
        "aoColumnDefs": [ {
            "mRender": function() {
                return "<input type='checkbox' class='chk'>"
            },
            "aTargets": [0]
        } ],
        "sAjaxSource": "http://localhost:8070/datatables/documents"
    });

    new $.fn.dataTable.FixedColumns(dt, {
        "iLeftColumns": 3,
        "iLeftWidth": 350
    });

    setInterval(function() {
        console.log('Interval');
        dt.fnDraw(false);
    }, 10 * 1000);

    window.dt = dt;
})