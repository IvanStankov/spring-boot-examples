$(function() {

    var COLUMN_SETTINGS_STORAGE_KEY = "_DOCS_COLUMN_SETTINGS";

    function getColumnWidthOrDefault(columnMap, nameOfColumn, defaultWidth) {
        if (!columnMap) {
            return defaultWidth
        }

        if (columnMap[nameOfColumn]) {
            return columnMap[nameOfColumn][COLUMN_SETTINGS_WIDTH_KEY];
        }

        return defaultWidth;
    }

    function getTaxonomy() {
        return null;
    }

    function getColumnsWidth(productFamily) {
        if (!localStorage) {
            console.log("can't save column width on Local Storage");
        }

        var storageSettings = localStorage.getItem(productFamily + COLUMN_SETTINGS_STORAGE_KEY);
        if (storageSettings) {
            return JSON.parse(storageSettings);
        } else {
            return {}
        }
    }

    var $refreshButton = $('#refreshTableLink');

    const columnMap = getColumnsWidth("PLC");
    const aoColumns = [
    {
            "mData": function (source, type, val) {
                let columnName = "CheckBox";
                let taxonomy = getTaxonomy(source, columnName);

                if (taxonomy) {
                    return taxonomy;
                } else {
                    if (source.checkBox) {
                        return source.checkBox;
                    } else {
                        return "";
                    }
                }
            },

            "sClass": "center",
            "sWidth": getColumnWidthOrDefault(columnMap, "CheckBox", "2em"),
            "bSortable": false
        }, {
            "mData": function (source, type, val) {
                let columnName = "Actions";
                let taxonomy = getTaxonomy(source, columnName);

                if (taxonomy) {
                    return taxonomy;
                } else {
                    if (source.actions) {
                        return source.actions;
                    } else {
                        return "";
                    }
                }
            },
            "sClass": "center",
            "sWidth": getColumnWidthOrDefault(columnMap, "Actions", "4em"),
            "bSortable": false
        }, {
            "mData": function (source, type, val) {
                let columnName = "Status";
                let taxonomy = getTaxonomy(source, columnName);

                if (taxonomy) {
                    return taxonomy;
                } else {
                    if (source.status) {
                        return source.status;
                    } else {
                        return "";
                    }
                }
            },

            "sClass": "center",
            "sWidth": getColumnWidthOrDefault(columnMap, "Status", "10em"),
            "bSortable": false
        }, {
            "mData": function (source, type, val) {
                let columnName = "Title";
                let taxonomy = getTaxonomy(source, columnName);

                if (taxonomy) {
                    return taxonomy;
                } else {
                    if (source.title) {
                        return source.title;
                    } else {
                        return "";
                    }
                }
            },

            "sClass": "center",
            "sWidth": getColumnWidthOrDefault(columnMap, "Title", "9em"),
            "bSortable": true
        }, {
            "mData": function (source, type, val) {
                let columnName = "Resource ID";
                let taxonomy = getTaxonomy(source, columnName);

                if (taxonomy) {
                    return taxonomy;
                } else {
                    if (source.resourceId) {
                        return source.resourceId;
                    } else {
                        return "";
                    }
                }
            },

            "sClass": "center",
            "sWidth": getColumnWidthOrDefault(columnMap, "Resource ID", "7.5em"),
            "bSortable": true
        }, {
            "mData": function (source, type, val) {
                let columnName = "Type";
                let taxonomy = getTaxonomy(source, columnName);

                if (taxonomy) {
                    return taxonomy;
                } else {
                    if (source.resourceType) {
                        return source.resourceType;
                    } else {
                        return "";
                    }
                }
            },

            "sClass": "center",
            "sWidth": getColumnWidthOrDefault(columnMap, "Type", "8em"),
            "bSortable": true
        }, {
            "mData": function (source, type, val) {
                let columnName = "Template";
                let taxonomy = getTaxonomy(source, columnName);

                if (taxonomy) {
                    return taxonomy;
                } else {
                    if (source.productType) {
                        return source.productType;
                    } else {
                        return "";
                    }
                }
            },

            "sClass": "center",
            "sWidth": getColumnWidthOrDefault(columnMap, "Template", "18em"),
            "bSortable": true
        }, {
            "mData": function (source, type, val) {
                let columnName = "System File Name";
                let taxonomy = getTaxonomy(source, columnName);

                if (taxonomy) {
                    return taxonomy;
                } else {
                    if (source.filename) {
                        return source.filename;
                    } else {
                        return "";
                    }
                }
            },

            "sClass": "center",
            "sWidth": getColumnWidthOrDefault(columnMap, "System File Name", "8em"),
            "bSortable": true
        }, {
            "mData": function (source, type, val) {
                let columnName = "Imported File Name";
                let taxonomy = getTaxonomy(source, columnName);

                if (taxonomy) {
                    return taxonomy;
                } else {
                    if (source.importedFilename) {
                        return source.importedFilename;
                    } else {
                        return "";
                    }
                }
            },

            "sClass": "center",
            "sWidth": getColumnWidthOrDefault(columnMap, "Imported File Name", "16em"),
            "bSortable": true
        }, {
            "mData": function (source, type, val) {
                let columnName = "Date Imported";
                let taxonomy = getTaxonomy(source, columnName);

                if (taxonomy) {
                    return taxonomy;
                } else {
                    if (source.importDate) {
                        return source.importDate;
                    } else {
                        return "";
                    }
                }
            },

            "sClass": "center",
            "sWidth": getColumnWidthOrDefault(columnMap, "Date Imported", "9em"),
            "bSortable": true
        }, {
            "mData": function (source, type, val) {
                let columnName = "Check-in Date";
                let taxonomy = getTaxonomy(source, columnName);

                if (taxonomy) {
                    return taxonomy;
                } else {
                    if (source.checkinDate) {
                        return source.checkinDate;
                    } else {
                        return "";
                    }
                }
            },

            "sClass": "center",
            "sWidth": getColumnWidthOrDefault(columnMap, "Check-in Date", "9em"),
            "bSortable": true
        }, {
            "mData": function (source, type, val) {
                let columnName = "First Publication Date";
                let taxonomy = getTaxonomy(source, columnName);

                if (taxonomy) {
                    return taxonomy;
                } else {
                    if (source.initialPublishDate) {
                        return source.initialPublishDate;
                    } else {
                        return "";
                    }
                }
            },

            "sClass": "center",
            "sWidth": getColumnWidthOrDefault(columnMap, "First Publication Date", "12em"),
            "bSortable": true
        }, {
            "mData": function (source, type, val) {
                let columnName = "Latest Publication Date";
                let taxonomy = getTaxonomy(source, columnName);

                if (taxonomy) {
                    return taxonomy;
                } else {
                    if (source.publishDate) {
                        return source.publishDate;
                    } else {
                        return "";
                    }
                }
            },

            "sClass": "center",
            "sWidth": getColumnWidthOrDefault(columnMap, "Latest Publication Date", "12em"),
            "bSortable": true
        }, {
            "mData": function (source, type, val) {
                let columnName = "Law Stated As Date";
                let taxonomy = getTaxonomy(source, columnName);

                if (taxonomy) {
                    return taxonomy;
                } else {
                    if (source.lawStatedAsDate) {
                        return source.lawStatedAsDate;
                    } else {
                        return "";
                    }
                }
            },

            "sClass": "center",
            "sWidth": getColumnWidthOrDefault(columnMap, "Law Stated As Date", "11em"),
            "bSortable": true
        }, {
            "mData": function (source, type, val) {
                let columnName = "Published On Date";
                let taxonomy = getTaxonomy(source, columnName);

                if (taxonomy) {
                    return taxonomy;
                } else {
                    if (source.displayPublishedOnDate) {
                        return source.displayPublishedOnDate;
                    } else {
                        return "";
                    }
                }
            },

            "sClass": "center",
            "sWidth": getColumnWidthOrDefault(columnMap, "Published On Date", "10em"),
            "bSortable": true
        }, {
            "mData": function (source, type, val) {
                let columnName = "Maintenance Date";
                let taxonomy = getTaxonomy(source, columnName);

                if (taxonomy) {
                    return taxonomy;
                } else {
                    if (source.maintenanceDate) {
                        return source.maintenanceDate;
                    } else {
                        return "";
                    }
                }
            },

            "sClass": "center",
            "sWidth": getColumnWidthOrDefault(columnMap, "Maintenance Date", "10em"),
            "bSortable": true
        }, {
            "mData": function (source, type, val) {
                let columnName = "Last Reviewed Date";
                let taxonomy = getTaxonomy(source, columnName);

                if (taxonomy) {
                    return taxonomy;
                } else {
                    if (source.lastReviewedDate) {
                        return source.lastReviewedDate;
                    } else {
                        return "";
                    }
                }
            },

            "sClass": "center",
            "sWidth": getColumnWidthOrDefault(columnMap, "Last Reviewed Date", "11em"),
            "bSortable": true
        }, {
            "mData": function (source, type, val) {
                let columnName = "Maintained";
                let taxonomy = getTaxonomy(source, columnName);

                if (taxonomy) {
                    return taxonomy;
                } else {
                    if (source.isMaintained) {
                        return source.isMaintained;
                    } else {
                        return "";
                    }
                }
            },

            "sClass": "center",
            "sWidth": getColumnWidthOrDefault(columnMap, "Maintained", "6.8em"),
            "bSortable": true
        }, {
            "mData": function (source, type, val) {
                let columnName = "Author";
                let taxonomy = getTaxonomy(source, columnName);

                if (taxonomy) {
                    return taxonomy;
                } else {
                    if (source.author) {
                        return source.author;
                    } else {
                        return "";
                    }
                }
            },

            "sClass": "center",
            "sWidth": getColumnWidthOrDefault(columnMap, "Author", "13em"),
            "bSortable": true
        }, {
            "mData": function (source, type, val) {
                let columnName = "Primary Editor";
                let taxonomy = getTaxonomy(source, columnName);

                if (taxonomy) {
                    return taxonomy;
                } else {
                    if (source.internalAuthor) {
                        return source.internalAuthor;
                    } else {
                        return "";
                    }
                }
            },

            "sClass": "center",
            "sWidth": getColumnWidthOrDefault(columnMap, "Primary Editor", "14em"),
            "bSortable": true
        }, {
            "mData": function (source, type, val) {
                let columnName = "Maintenance Editor";
                let taxonomy = getTaxonomy(source, columnName);

                if (taxonomy) {
                    return taxonomy;
                } else {
                    if (source.maintEditor) {
                        return source.maintEditor;
                    } else {
                        return "";
                    }
                }
            },

            "sClass": "center",
            "sWidth": getColumnWidthOrDefault(columnMap, "Maintenance Editor", "12em"),
            "bSortable": true
        }, {
            "mData": function (source, type, val) {
                let columnName = "Subscription Required";
                let taxonomy = getTaxonomy(source, columnName);

                if (taxonomy) {
                    return taxonomy;
                } else {
                    if (source.subscriptionRequired) {
                        return source.subscriptionRequired;
                    } else {
                        return "";
                    }
                }
            },

            "sClass": "center",
            "sWidth": getColumnWidthOrDefault(columnMap, "Subscription Required", "12em"),
            "bSortable": true
        }, {
            "mData": function (source, type, val) {
                let columnName = "Tags";
                let taxonomy = getTaxonomy(source, columnName);

                if (taxonomy) {
                    return taxonomy;
                } else {
                    if (source.tags) {
                        return source.tags;
                    } else {
                        return "";
                    }
                }
            },

            "sClass": "center",
            "sWidth": getColumnWidthOrDefault(columnMap, "Tags", "20em"),
            "bSortable": false
        }, {
            "mData": function (source, type, val) {
                let columnName = "Imported By";
                let taxonomy = getTaxonomy(source, columnName);

                if (taxonomy) {
                    return taxonomy;
                } else {
                    if (source.importedBy) {
                        return source.importedBy;
                    } else {
                        return "";
                    }
                }
            },

            "sClass": "center",
            "sWidth": getColumnWidthOrDefault(columnMap, "Imported By", "8em"),
            "bSortable": true
        }, {
            "mData": function (source, type, val) {
                let columnName = "UUID";
                let taxonomy = getTaxonomy(source, columnName);

                if (taxonomy) {
                    return taxonomy;
                } else {
                    if (source.uuid) {
                        return source.uuid;
                    } else {
                        return "";
                    }
                }
            },

            "sClass": "center",
            "sWidth": getColumnWidthOrDefault(columnMap, "UUID", "16em"),
            "bSortable": true
        }, {
            "mData": function (source, type, val) {
                let columnName = "ACR Id";
                let taxonomy = getTaxonomy(source, columnName);

                if (taxonomy) {
                    return taxonomy;
                } else {
                    if (source.acrId) {
                        return source.acrId;
                    } else {
                        return "";
                    }
                }
            },

            "sClass": "center",
            "sWidth": getColumnWidthOrDefault(columnMap, "ACR Id", "5em"),
            "bSortable": true
        }, {
            "mData": function (source, type, val) {
                let columnName = "Filesize (KB)";
                let taxonomy = getTaxonomy(source, columnName);

                if (taxonomy) {
                    return taxonomy;
                } else {
                    if (source.filesize) {
                        return source.filesize;
                    } else {
                        return "";
                    }
                }
            },

            "sClass": "center",
            "sWidth": getColumnWidthOrDefault(columnMap, "Filesize (KB)", "8em"),
            "bSortable": true
        }, {
            "mData": function (source, type, val) {
                let columnName = "Word Doc Page Count";
                let taxonomy = getTaxonomy(source, columnName);

                if (taxonomy) {
                    return taxonomy;
                } else {
                    if (source.wordPageCount) {
                        return source.wordPageCount;
                    } else {
                        return "";
                    }
                }
            },

            "sClass": "center",
            "sWidth": getColumnWidthOrDefault(columnMap, "Word Doc Page Count", "12em"),
            "bSortable": true
        }
    ];

    const aaSorting = []
    const checkInColIndex = aoColumns.findIndex(x => x.mData === 'importDate')
    if(checkInColIndex&&checkInColIndex!= -1) {
      aaSorting.push([checkInColIndex, 'desc']);
    }

    var dataTable = $("#dt").DataTable( {
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
        "fnStateLoadCallback": function(oSettings) {
            return load_dt_view(oSettings);
        },
        "fnStateSaveCallback": function(oSettings, oData) {
            save_dt_view(oSettings, oData);
        },
        "sScrollY": "100%",
        "sScrollX": "100%",
//        "pagingType": "input",
        "sAjaxSource": "http://localhost:8070/datatables/documents",
        "autoWidth": true,
        "aaSorting": aaSorting,
        "scrollXInner": "150%",
        "scrollCollapse": false,
        "aaSorting": aaSorting,
        "aoColumns": aoColumns,
        "defaultVisibilities": [true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                    true, true, true, true, true, true, true, true, true, true ], //24
        "initComplete": function() {
            var vis = this.fnSettings().oInit.defaultVisibilities;
            for (var i = 0; i < vis.length; i++) {
                this.fnSetColumnVis(i+3+1, vis[i]);
            }
        },
        "preDrawCallback": function (settings) {
            currentTableScrollPosition = $(".dataTables_scrollBody").scrollTop();
        },
        "drawCallback":function (settings) {

            // No tooltip plugin
//            $(".dataTables_scroll").tooltip({
//                "delay": 150,
//                "fade": 250
//            });

            $('.ui-tooltip').remove();

            setupColumnResizing(true, 'documents-tabDatatable_wrapper');
            setupColumnResizing(false, 'documents-tabDatatable_wrapper');
            // adjustToolbarCellWidth();
            recalculateHeight();

            $("#doclist .dataTables_scrollBody").scrollTop(currentTableScrollPosition);
        },
        "fnServerData": function ( sSource, aoData, fnCallback ) {
            var settings = this.fnSettings();

            // skip server requests until FixedColumns is initialized
            // is dataTable plugin updated, revise the approach
            if (!settings.fixedColumnsInitialized) {

                var json = {};
                json.aaData = {sEcho: 0};
                fnCallback(json);

                if (aoData[0].value * 1 >= settings.iDraw) {
                      settings.oApi._fnProcessingDisplay( settings, false);
                }
                return;
            }

            settings.bDataRequesting = true;

            // retrieve data if it's not an update
            if (!settings.bLongPolling) {
                // clearing refresh status, should be in success,
                // but was put there since we don't have loading indicator
                $refreshButton.data('new-docs-count', 0);
                $refreshButton.data('deleted-docs-count', 0);
                $refreshButton.removeClass('refresh-needed');
                // data request
                $('#documents-tabDatatable_info').text("Loading documents...");
                $.ajax( {
                    "dataType": 'json',
                    "type": "POST",
                    "url": sSource,
                    "data": aoData,
                    "success": function(result) {
                        if (result.iTotalDisplayRecords == 0) {
                          if ( !$( "#no-results-found" ).length ) {
                              $("#documents-tabDatatable").after("<div id='no-results-found' style='text-align: center; font-size: 14px;'>0 results found</div>");
                          }
                        }

                        totalDocumentCount = result.iTotalDisplayRecords;

                        currentTableScrollPosition = $("#doclist .dataTables_scrollBody").scrollTop();
                        settings.productFamilyName = result.productFamilyName;
                        if (result.errorDetails) { // if the response contains errorDetails, try to handle it
                            handleErrorByCode(result.errorDetails);
                        }
                        fnCallback(result);
                    },
                    "complete": function() {
                        settings.bDataRequesting = false;
                    },
                    "error": handleAjaxError // call the error handling function below
                });
                return;
            }
            // clear update flag ASAP
            settings.bLongPolling = false;

            // partial update
            var ids = [];
            $.each(dataTable.rows().data(), function(i, doc) {
                ids.push(doc.id);
            });
            aoData.push({name: 'docIds', value: ids.join(',')});
            aoData.push({name: 'productFamilyName', value: settings.productFamilyName});
            $.ajax({
                type: 'POST',
                dataType: 'json',
                url: '/documents/getUpdates',
                data: aoData,
                complete: function() {
                    settings.bDataRequesting = false;
                },
                success: function(result) {
                    currentTableScrollPosition = $("#doclist .dataTables_scrollBody").scrollTop();

                    var $refreshButton = $('#refreshTableLink');
                    // ignore if session staled
                    if (result.sessionStaled) {
                        settings.sessionStaled = true;
                        $refreshButton.addClass('refresh-needed');
                        //$($refreshButton).effect('highlight');
                        let json= {};
                        json.aaData = {sEcho: 0};
                        fnCallback(json);
                        if (aoData[0].value * 1 >= settings.iDraw) {
                           settings.oApi._fnProcessingDisplay( settings, false);
                        }
                        return;
                    }

                    var doc, docs = result.docs;
                    var data = dataTable.rows().data();
                    var updatedDocs = [];

                    // update row's data
                    $.each(data, function(i, row) {
                        doc = docs[row.id];

                        //Some product families wrap the doc.title in DOM elements
                        let docTitle;
                        if(doc && doc.title !== null){
                            if(row.title != doc.title && doc.title.indexOf('title') > -1){
                                const docWrapper = document.createElement('div');
                                docWrapper.innerHTML = doc.title.toString();
                                docTitle = docWrapper.firstChild.getAttribute('title');
                            } else{
                                docTitle = doc.title
                            }
                        }

                        //Some product families wrap the row.title in DOM elements
                        let rowTitle;
                        if(row && row.title !== null){
                          if(row.title != docTitle && row.title.indexOf("title=") > -1){
                              const rowWrapper = document.createElement('div');
                              rowWrapper.innerHTML = row.title.toString();
                              rowTitle = rowWrapper.firstChild.getAttribute('title')
                          } else {
                              rowTitle = row.title;
                          }
                        }

                        const docResourceType = (doc && (doc.resourceType != null)) ? doc.resourceType : "";
                        const docResourceId = (doc && (doc.resourceId != null)) ? doc.resourceId : "";

                        const rowResourceType = (row && (row.resourceType != null)) ? row.resourceType : "";
                        const rowResourceId = (row && (row.resourceId != null)) ? row.resourceId : "";

                        const docCitation = (doc && doc.citation) ? doc.citation : '';
                        const rowCitation = (row && row.citation) ? row.citation : '';

                        // (cja) if any changes are detected, push the row to the UI
                        if (doc && (row.status != doc.status ||
                                        row.actions != doc.actions ||
                                        rowTitle != docTitle ||
                                        rowResourceType != docResourceType ||
                                        rowResourceId != docResourceId ||
                                        rowCitation != docCitation)) {
                            $.extend(row, doc);
                            updatedDocs.push(row.id);
                        }
                    });

                    var sEcho = aoData[0].value;
                    let json = {
                        // zero sEcho will instruct table to ignore this update
                        sEcho: updatedDocs.length ? sEcho : 0,
                        aaData: data,
                        iTotalRecords: settings._iRecordsTotal,
                        iTotalDisplayRecords: settings._iRecordsDisplay
                    };

                    // update columns width using actual client width of TH
                    updateSettingColumnsWidthByClientWidth(settings);
                    // restore selection after table redraw
                    var selectedIds = getBulkSelectedDocsIds();
                    fnCallback(json);

                    function highlightLeftSide(id){
                          var index = $('#rowid_' + id ).index() +1 ;
                          $("#doclist .DTFC_LeftBodyWrapper table tr:eq(" + index + ")  td").effect("highlight", 4000);
                    }

                    // hide the processing indicator if it was the last ajax call
                    if (json.sEcho == 0 && sEcho * 1 >= settings.iDraw) {
                        settings.oApi._fnProcessingDisplay( settings, false);
                    } else {
                        $.each(updatedDocs, function(i, id) {
                            highlightLeftSide(id);
                            $('#rowid_' + id + ' td').effect("highlight", 4000);
                        });
                    }

                    setBulkSelectedDocs(selectedIds);

                    // new docs indication
                    if (result.newDocsCount || result.deletedDocsCount) {
                        if (!$refreshButton.hasClass('refresh-needed')) {
                            $refreshButton.addClass('refresh-needed');
                            //$($refreshButton).effect('highlight');
                        }
                    } else {
                        $refreshButton.removeClass('refresh-needed');
                    }

                    $refreshButton.data('new-docs-count', result.newDocsCount);
                    $refreshButton.data('deleted-docs-count', result.deletedDocsCount);
                }
            });
        }
    });

    var fixed = new $.fn.DataTable.FixedColumns( dataTable, {
        "drawCallback": function () {
            $(".dataTables_wrapper .DTFC_LeftBodyWrapper").scrollTop(currentTableScrollPosition);
            $(".dataTables_scrollBody").scrollTop(currentTableScrollPosition);
        },
        "heightMatch": 'auto',
        "leftColumns": 4,
        "leftWidth": 512 // MODIFY ME WHEN YOU CHANGE THE FIXED COLUMN WIDTHS
    } );

    // it is done to fix a trouble with jumping to the top of the table
    $(fixed.dom.grid.left.liner).off( 'scroll.DTFC');

    dataTable.settings()[0].fixedColumnsInitialized = true;
    dataTable.draw(false);


    ///// START AND STOP INTERVAL BUTTONS
    var closure = {};
    $("#startInterval").click(function() {
        closure.intervalId = setInterval(function() {
            console.log('Interval');

            var settings = dataTable.settings()[0];
            // prevent partial update during full data update (as it will increment sEcho and invalidate previous requests)
            if (settings.bDataRequesting || settings.sessionStaled) {
                return;
            }
            // instructs fnServerData to use update request
            settings.bLongPolling = true;
            dataTable.draw(false);
        }, 2 * 1000);
    });
    $("#stopInterval").click(function() {
        clearInterval(closure.intervalId);
    });

    /////////// OTHER METHODS

    // method to save/load/clear the datatables local storage
    function save_dt_view (oSettings, oData) {
        localStorage.setItem( 'ACT_DataTables_PLC_documents-tab'+window.location.pathname, JSON.stringify(oData) );
    }

    function load_dt_view (oSettings) {
        return JSON.parse( localStorage.getItem('ACT_DataTables_PLC_documents-tab'+window.location.pathname) );
    }

    function setupColumnResizing(disableFlag, identity, disabledColumnList) {

        var disabledColumnList = Array.isArray(disabledColumnList) ? disabledColumnList : [0, 1, 2, 3];

        // now sync up the widths of columns in the header table to the widths of the data table
        var activeMenu = $("#act-menu li a.active");
        if (activeMenu.length > 0) {
            var dataTableHeaders = $('#' + activeMenu.attr("id").toLowerCase() + 'Datatable th.head');

            var headerTableHeaders = find('.dataTables_scrollHeadInner>table th.head', identity);

            // grab the table that now contains the static headers

            var headerTable = find('.dataTables_scrollHeadInner>table', identity);

            headerTable.colResizable({
                disable: disableFlag,
                liveDrag: true,
                gripInnerHtml: "<div class='grip'></div>",
                // minWidth:60,
                draggingClass: "dragging",
                disabledColumns: disabledColumnList,

                onDrag: function (event) {
                    // when a column is dragged, make sure the widths sync up
                    // set the corresponding width on the header table
                    for (var i = 0; i < dataTableHeaders.length; i++) {
                        var dataTableWidth = $(dataTableHeaders[i]).width();
                        var headerTableWidth = $(headerTableHeaders[i]).width();
                        if (parseInt(dataTableWidth) !== parseInt(headerTableWidth)) {
                            $(dataTableHeaders[i]).width($(headerTableHeaders[i]).width());
                        }
                    }
                }
            });
        } else {
            // console.warn("setupColumnResizing hit before we had a active menu??? Should look into this");
        }
    }

    function recalculateHeight() {
        var menuheight = $('#menutable').height();
        var toolbarheight = $('#doclist .dataTables_length').height();
        var dataTablesScrollHeadHeight = $('#doclist .dataTables_scrollHead').height();
        var messageHeight = $("div .act-messages").height();
        var toolbarPadding = 2 * 6;
        var tablePadding = 15;
        var padding = toolbarPadding + tablePadding;
        var clientHeight = document.documentElement.clientHeight;
        var horizontalScrollbarHeight = 17;

        var tableheight = clientHeight - menuheight - toolbarheight - dataTablesScrollHeadHeight - padding - messageHeight - horizontalScrollbarHeight;

        if (tableheight < 400) {
            tableheight = 400;
        }

        var filterHeight = $('#filterPaneContainer').height();

        if (filterHeight > tableheight) {
            $('#filterPaneContainer').height(tableheight);
        }

        $('#doclist div.dataTables_scrollBody').height(tableheight);

    }

    function handleAjaxError( xhr, textStatus, error ) {
        console.debug( 'Server has returned the error. Text status: ' + textStatus + ", error: " + error);
        showProcessingIndicator(false);
        if (xhr.responseText !== undefined) {

            var responseJSON = null;

            try {
                 responseJSON = $.parseJSON(xhr.responseText);
            } finally {
             //Do Nothing
            }
            if (responseJSON !== undefined && responseJSON !== null) {
                console.debug("Error details: " + responseJSON.errorDetails.desc);
                $('div#documents-tabDatatable_length')
                  .after('<div id="documents-tab_error" class="errorMessage" style="color:white;"><span>'
                          + responseJSON.errorDetails.desc + '</span></div>');
            } else {
               console.debug(xhr.responseText);
                $('div#documents-tabDatatable_length')
                  .after('<div id="documents-tabDatatable_error" class="errorMessage" style="color:white;"><span>Sorry, an error occured. Please contact the development team</span></div>');
            }
        }
    }

    // hide/show 'Processing' message
    function showProcessingIndicator(bShow) {
        if ( typeof( bShow ) == 'undefined' ) {
            bShow = true;
        }
        var settings = dataTable.settings()[0];
        settings.oApi._fnProcessingDisplay(settings, bShow);
    }
})