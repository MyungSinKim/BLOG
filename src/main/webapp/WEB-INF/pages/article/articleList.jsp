<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <!-- The jQuery library is a prerequisite for all jqSuite products -->
    <script type="text/ecmascript" src="/resources/js/jquery-1.7.2.min.js"></script>
    <!-- This is the Javascript file of jqGrid -->
    <script type="text/ecmascript" src="/resources/js/jquery.jqGrid.min.js"></script>
    <!-- This is the localization file of the grid controlling messages, labels, etc.
    <!-- We support more than 40 localizations -->
    <script type="text/ecmascript" src="/resources/js/i18n/grid.locale-en.js"></script>
    <!-- A link to a jQuery UI ThemeRoller theme, more than 22 built-in and many more custom -->
    <link rel="stylesheet" type="text/css" media="screen" href="/resources/css/jquery-ui.css" />
    <!-- The link to the CSS that the grid needs -->
    <link rel="stylesheet" type="text/css" media="screen" href="/resources/css/ui.jqgrid.css" />
    <title>Article List</title>
</head>
<body>

<table id="jqGrid"></table>
<div id="jqGridPager"></div>

<script type="text/javascript">
    var lastSel;

    $(document).ready(function () {
        $("#jqGrid").jqGrid({
            colModel: [
                { label: 'articleNo', name: 'articleNo', width: 35, sorttype:'integer', formatter: 'integer', align: 'right' },
                { label: 'title', name: 'title', width: 150 },
                { label: 'contents', name: 'contents', width: 150, formatter: formatContents }
            ],

            viewrecords: true, // show the current page, data rang and total records on the toolbar
            width: 780,
            height: 200,
            rowNum: 5,
            datatype: 'local',
//            datatype: 'json',

//            jsonReader : {
//                root: "rows",
//                page: "page",
//                total: "total",
//                records: "records",
//                repeatitems: false
//            },
//            url: "/articleListData",
            pager: "#jqGridPager",
            caption: "Article List",

            //event handling
            onSelectRow: function(id){
                var articleNo = $(this).jqGrid ('getCell', id, 'articleNo');

                location.href = "/articles/"+ articleNo;
            },

            gridComplete: function(){
            }

        });

        fetchGridData();

        function fetchGridData() {

            var gridArrayData = [];
            $.ajax({
                url: "/articleListData",
                success: function (result) {
                    /*
                    for (var i = 0; i < result.rows.length; i++) {

                        var item = result.rows[i];
                        gridArrayData.push({
                            articleNo: item.articleNo,
                            title: item.title,
                            contents: item.contents
                        });

                        alert(gridArrayData[i]);
                    }
                    $("#jqGrid").jqGrid('setGridParam', { data: gridArrayData});
                    */

                    // set the new data
                    $("#jqGrid").jqGrid('setGridParam', { data: result.rows});
                    // refresh the grid
                    $("#jqGrid").trigger('reloadGrid');
                }
            });
        }

        function formatContents(cellValue, options, rowObject) {
            return cellValue.substring(0, 50) + "...";
        };


        function formatButtons(cellvalue, options, rowObject){

            return "<button type=button>"+"MOD"+ rowObject.articleNo  +"</button>";
        };
        function formatLink(cellValue, options, rowObject) {
            return "<a href='" + cellValue + "'>" + cellValue.substring(0, 25) + "..." + "</a>";
        };
    });

</script>
</body>
</html>
