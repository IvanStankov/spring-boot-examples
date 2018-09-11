const aoColumns = [
        {
            "mData"     : function ( source, type, val ) {
                let columnName = "CheckBox";
                let taxonomy = getTaxonomy(source, columnName);

                if(taxonomy){
                     return taxonomy;
                } else {
                     if(source.checkBox){
                        return source.checkBox;
                     } else {
                        return "";
                     }
                }
          },

            "sClass"    : "center",
            "sWidth"    : getColumnWidthOrDefault(columnMap, "CheckBox", "2em"),
            "bSortable" :  false
        }, {
            "mData"     : function ( source, type, val ) {
                let columnName = "Actions";
                let taxonomy = getTaxonomy(source, columnName);

                if(taxonomy){
                     return taxonomy;
                } else {
                     if(source.actions){
                        return source.actions;
                     } else {
                        return "";
                     }
                }
          },
            "sClass"    : "center",
            "sWidth"    : getColumnWidthOrDefault(columnMap, "Actions", "4em"),
            "bSortable" :  false
        }, {
            "mData"     : function ( source, type, val ) {
                let columnName = "Status";
                let taxonomy = getTaxonomy(source, columnName);

                if(taxonomy){
                     return taxonomy;
                } else {
                     if(source.status){
                        return source.status;
                     } else {
                        return "";
                     }
                }
          },

            "sClass"    : "center",
            "sWidth"    : getColumnWidthOrDefault(columnMap, "Status", "10em"),
            "bSortable" :  false
        }, {
            "mData"     : function ( source, type, val ) {
                let columnName = "Title";
                let taxonomy = getTaxonomy(source, columnName);

                if(taxonomy){
                     return taxonomy;
                } else {
                     if(source.title){
                        return source.title;
                     } else {
                        return "";
                     }
                }
          },

            "sClass"    : "center",
            "sWidth"    : getColumnWidthOrDefault(columnMap, "Title", "9em"),
            "bSortable" :  true
        }, {
            "mData"     : function ( source, type, val ) {
                let columnName = "Resource ID";
                let taxonomy = getTaxonomy(source, columnName);

                if(taxonomy){
                     return taxonomy;
                } else {
                     if(source.resourceId){
                        return source.resourceId;
                     } else {
                        return "";
                     }
                }
          },

            "sClass"    : "center",
            "sWidth"    : getColumnWidthOrDefault(columnMap, "Resource ID", "7.5em"),
            "bSortable" :  true
        },
        {
            "mData"     : function ( source, type, val ) {
                let columnName = "Type";
                let taxonomy = getTaxonomy(source, columnName);

                if(taxonomy){
                     return taxonomy;
                } else {
                     if(source.resourceType){
                        return source.resourceType;
                     } else {
                        return "";
                     }
                }
          },

            "sClass"    : "center",
            "sWidth"    : getColumnWidthOrDefault(columnMap, "Type", "8em"),
            "bSortable" :  true
        }, {
            "mData"     : function ( source, type, val ) {
                let columnName = "Template";
                let taxonomy = getTaxonomy(source, columnName);

                if(taxonomy){
                     return taxonomy;
                } else {
                     if(source.productType){
                        return source.productType;
                     } else {
                        return "";
                     }
                }
          },

            "sClass"    : "center",
            "sWidth"    : getColumnWidthOrDefault(columnMap, "Template", "18em"),
            "bSortable" :  true
        }, {
            "mData"     : function ( source, type, val ) {
                let columnName = "System File Name";
                let taxonomy = getTaxonomy(source, columnName);

                if(taxonomy){
                     return taxonomy;
                } else {
                     if(source.filename){
                        return source.filename;
                     } else {
                        return "";
                     }
                }
          },

            "sClass"    : "center",
            "sWidth"    : getColumnWidthOrDefault(columnMap, "System File Name", "8em"),
            "bSortable" :  true
        }, {
            "mData"     : function ( source, type, val ) {
                let columnName = "Imported File Name";
                let taxonomy = getTaxonomy(source, columnName);

                if(taxonomy){
                     return taxonomy;
                } else {
                     if(source.importedFilename){
                        return source.importedFilename;
                     } else {
                        return "";
                     }
                }
          },

            "sClass"    : "center",
            "sWidth"    : getColumnWidthOrDefault(columnMap, "Imported File Name", "16em"),
            "bSortable" :  true
        }, {
            "mData"     : function ( source, type, val ) {
                let columnName = "Date Imported";
                let taxonomy = getTaxonomy(source, columnName);

                if(taxonomy){
                     return taxonomy;
                } else {
                     if(source.importDate){
                        return source.importDate;
                     } else {
                        return "";
                     }
                }
          },

            "sClass"    : "center",
            "sWidth"    : getColumnWidthOrDefault(columnMap, "Date Imported", "9em"),
            "bSortable" :  true
        }, {
            "mData"     : function ( source, type, val ) {
                let columnName = "Check-in Date";
                let taxonomy = getTaxonomy(source, columnName);

                if(taxonomy){
                     return taxonomy;
                } else {
                     if(source.checkinDate){
                        return source.checkinDate;
                     } else {
                        return "";
                     }
                }
          },

            "sClass"    : "center",
            "sWidth"    : getColumnWidthOrDefault(columnMap, "Check-in Date", "9em"),
            "bSortable" :  true
        }, {
            "mData"     : function ( source, type, val ) {
                let columnName = "First Publication Date";
                let taxonomy = getTaxonomy(source, columnName);

                if(taxonomy){
                     return taxonomy;
                } else {
                     if(source.initialPublishDate){
                        return source.initialPublishDate;
                     } else {
                        return "";
                     }
                }
          },

            "sClass"    : "center",
            "sWidth"    : getColumnWidthOrDefault(columnMap, "First Publication Date", "12em"),
            "bSortable" :  true
        }, {
            "mData"     : function ( source, type, val ) {
                let columnName = "Latest Publication Date";
                let taxonomy = getTaxonomy(source, columnName);

                if(taxonomy){
                     return taxonomy;
                } else {
                     if(source.publishDate){
                        return source.publishDate;
                     } else {
                        return "";
                     }
                }
          },

            "sClass"    : "center",
            "sWidth"    : getColumnWidthOrDefault(columnMap, "Latest Publication Date", "12em"),
            "bSortable" :  true
        }, {
            "mData"     : function ( source, type, val ) {
                let columnName = "Law Stated As Date";
                let taxonomy = getTaxonomy(source, columnName);

                if(taxonomy){
                     return taxonomy;
                } else {
                     if(source.lawStatedAsDate){
                        return source.lawStatedAsDate;
                     } else {
                        return "";
                     }
                }
          },

            "sClass"    : "center",
            "sWidth"    : getColumnWidthOrDefault(columnMap, "Law Stated As Date", "11em"),
            "bSortable" :  true
        }, {
            "mData"     : function ( source, type, val ) {
                let columnName = "Published On Date";
                let taxonomy = getTaxonomy(source, columnName);

                if(taxonomy){
                     return taxonomy;
                } else {
                     if(source.displayPublishedOnDate){
                        return source.displayPublishedOnDate;
                     } else {
                        return "";
                     }
                }
          },

            "sClass"    : "center",
            "sWidth"    : getColumnWidthOrDefault(columnMap, "Published On Date", "10em"),
            "bSortable" :  true
        }, {
            "mData"     : function ( source, type, val ) {
                let columnName = "Maintenance Date";
                let taxonomy = getTaxonomy(source, columnName);

                if(taxonomy){
                     return taxonomy;
                } else {
                     if(source.maintenanceDate){
                        return source.maintenanceDate;
                     } else {
                        return "";
                     }
                }
          },

            "sClass"    : "center",
            "sWidth"    : getColumnWidthOrDefault(columnMap, "Maintenance Date", "10em"),
            "bSortable" :  true
        }, {
            "mData"     : function ( source, type, val ) {
                let columnName = "Last Reviewed Date";
                let taxonomy = getTaxonomy(source, columnName);

                if(taxonomy){
                     return taxonomy;
                } else {
                     if(source.lastReviewedDate){
                        return source.lastReviewedDate;
                     } else {
                        return "";
                     }
                }
          },

            "sClass"    : "center",
            "sWidth"    : getColumnWidthOrDefault(columnMap, "Last Reviewed Date", "11em"),
            "bSortable" :  true
        }, {
            "mData"     : function ( source, type, val ) {
                let columnName = "Maintained";
                let taxonomy = getTaxonomy(source, columnName);

                if(taxonomy){
                     return taxonomy;
                } else {
                     if(source.isMaintained){
                        return source.isMaintained;
                     } else {
                        return "";
                     }
                }
          },

            "sClass"    : "center",
            "sWidth"    : getColumnWidthOrDefault(columnMap, "Maintained", "6.8em"),
            "bSortable" :  true
        }, {
            "mData"     : function ( source, type, val ) {
                let columnName = "Author";
                let taxonomy = getTaxonomy(source, columnName);

                if(taxonomy){
                     return taxonomy;
                } else {
                     if(source.author){
                        return source.author;
                     } else {
                        return "";
                     }
                }
          },

            "sClass"    : "center",
            "sWidth"    : getColumnWidthOrDefault(columnMap, "Author", "13em"),
            "bSortable" :  true
        }, {
            "mData"     : function ( source, type, val ) {
                let columnName = "Primary Editor";
                let taxonomy = getTaxonomy(source, columnName);

                if(taxonomy){
                     return taxonomy;
                } else {
                     if(source.internalAuthor){
                        return source.internalAuthor;
                     } else {
                        return "";
                     }
                }
          },

            "sClass"    : "center",
            "sWidth"    : getColumnWidthOrDefault(columnMap, "Primary Editor", "14em"),
            "bSortable" :  true
        }, {
            "mData"     : function ( source, type, val ) {
                let columnName = "Maintenance Editor";
                let taxonomy = getTaxonomy(source, columnName);

                if(taxonomy){
                     return taxonomy;
                } else {
                     if(source.maintEditor){
                        return source.maintEditor;
                     } else {
                        return "";
                     }
                }
          },

            "sClass"    : "center",
            "sWidth"    : getColumnWidthOrDefault(columnMap, "Maintenance Editor", "12em"),
            "bSortable" :  true
        }, {
            "mData"     : function ( source, type, val ) {
                let columnName = "Subscription Required";
                let taxonomy = getTaxonomy(source, columnName);

                if(taxonomy){
                     return taxonomy;
                } else {
                     if(source.subscriptionRequired){
                        return source.subscriptionRequired;
                     } else {
                        return "";
                     }
                }
          },

            "sClass"    : "center",
            "sWidth"    : getColumnWidthOrDefault(columnMap, "Subscription Required", "12em"),
            "bSortable" :  true
        }, {
            "mData"     : function ( source, type, val ) {
                let columnName = "Tags";
                let taxonomy = getTaxonomy(source, columnName);

                if(taxonomy){
                     return taxonomy;
                } else {
                     if(source.tags){
                        return source.tags;
                     } else {
                        return "";
                     }
                }
          },

            "sClass"    : "center",
            "sWidth"    : getColumnWidthOrDefault(columnMap, "Tags", "20em"),
            "bSortable" :  false
        }, {
            "mData"     : function ( source, type, val ) {
                let columnName = "Imported By";
                let taxonomy = getTaxonomy(source, columnName);

                if(taxonomy){
                     return taxonomy;
                } else {
                     if(source.importedBy){
                        return source.importedBy;
                     } else {
                        return "";
                     }
                }
          },

            "sClass"    : "center",
            "sWidth"    : getColumnWidthOrDefault(columnMap, "Imported By", "8em"),
            "bSortable" :  true
        }, {
            "mData"     : function ( source, type, val ) {
                let columnName = "UUID";
                let taxonomy = getTaxonomy(source, columnName);

                if(taxonomy){
                     return taxonomy;
                } else {
                     if(source.uuid){
                        return source.uuid;
                     } else {
                        return "";
                     }
                }
          },

            "sClass"    : "center",
            "sWidth"    : getColumnWidthOrDefault(columnMap, "UUID", "16em"),
            "bSortable" :  true
        }, {
            "mData"     : function ( source, type, val ) {
                let columnName = "ACR Id";
                let taxonomy = getTaxonomy(source, columnName);

                if(taxonomy){
                     return taxonomy;
                } else {
                     if(source.acrId){
                        return source.acrId;
                     } else {
                        return "";
                     }
                }
          },

            "sClass"    : "center",
            "sWidth"    : getColumnWidthOrDefault(columnMap, "ACR Id", "5em"),
            "bSortable" :  true
        }, {
            "mData"     : function ( source, type, val ) {
                let columnName = "Filesize (KB)";
                let taxonomy = getTaxonomy(source, columnName);

                if(taxonomy){
                     return taxonomy;
                } else {
                     if(source.filesize){
                        return source.filesize;
                     } else {
                        return "";
                     }
                }
          },

            "sClass"    : "center",
            "sWidth"    : getColumnWidthOrDefault(columnMap, "Filesize (KB)", "8em"),
            "bSortable" :  true
        }, {
            "mData"     : function ( source, type, val ) {
                let columnName = "Word Doc Page Count";
                let taxonomy = getTaxonomy(source, columnName);

                if(taxonomy){
                     return taxonomy;
                } else {
                     if(source.wordPageCount){
                        return source.wordPageCount;
                     } else {
                        return "";
                     }
                }
          },

            "sClass"    : "center",
            "sWidth"    : getColumnWidthOrDefault(columnMap, "Word Doc Page Count", "12em"),
            "bSortable" :  true
        }];

const aaSorting = []
const checkInColIndex = aoColumns.findIndex(x => x.mData === 'importDate')
if(checkInColIndex&&checkInColIndex!= -1) {
  aaSorting.push([checkInColIndex, 'desc']);
}

$(function() {

    var dt = $("#dt").DataTable( {
        "pageLength": 25,
        "lengthChange": true,
        "dom": '<"dataTables_length"ip>rt',
        "language": {
            "paginate": {
                "previous": " ",
                "first": " ",
                "next": " ",
                "last": " "
            },
            "processing": "<div class='processSpinner' id='processingImg' title='Reloading Documents Table...'></div>",
            "infoFiltered": "",
            "infoEmpty": "0 results found",
            "loadingRecords": "Please wait - loading data...",
            "info": "Showing _START_ to _END_ of _TOTAL_ results"
        },
        "bProcessing": true,
        "bDestroy":true,
        "bServerSide": true,
        "bStateSave": true,
//        "fnStateLoadCallback": function(oSettings) { return load_dt_view(oSettings); },
//        "fnStateSaveCallback": function(oSettings, oData) { save_dt_view(oSettings, oData); },
        "sScrollX": "100%",
        "sScrollY": "100%",
        "pagingType": "input",
        "scrollXInner": "150%",
        "scrollCollapse": false,
        "sAjaxSource": "http://localhost:8070/datatables/documents",
        "autoWidth": true,
//        "aaSorting": aaSorting,
//        "aoColumns": aoColumns,
        fixedColumns: {
            "leftColumns": 3
        },
        "columnDefs": [ {
            "render": function() {
                return "<input type='checkbox' class='chk'>"
            },
            "targets": [0]
        } ]
        "defaultVisibilities": [
                    true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                    true, true, true, true, true, true, true, true, true, true ] //24
    });

//    new $.fn.dataTable.FixedColumns(dt, {
//    });

    setInterval(function() {
        console.log('Interval');
        dt.draw(false);
    }, 2 * 1000);

    window.dt = dt;
})