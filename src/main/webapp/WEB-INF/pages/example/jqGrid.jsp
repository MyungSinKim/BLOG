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
    <title>jqGrid List</title>
</head>
<body>

<table id="jqGrid"></table>
<div id="jqGridPager"></div>

<script type="text/javascript">

    $(document).ready(function () {
        $("#jqGrid").jqGrid({
            colModel: [
                {
                    label: 'Title',
                    name: 'Title',
                    width: 150,
                    formatter: formatTitle
                },
                {
                    label: 'Link',
                    name: 'Link',
                    width: 80,
                    formatter: formatLink
                },
                {
                    label: 'View Count',
                    name: 'ViewCount',
                    width: 35,
                    sorttype:'integer',
                    formatter: 'number',
                    align: 'right'
                },
                {
                    label: 'Answer Count',
                    name: 'AnswerCount',
                    width: 25
                }
            ],

            viewrecords: true, // show the current page, data rang and total records on the toolbar
            width: 780,
            height: 200,
            rowNum: 15,
            datatype: 'local',
            pager: "#jqGridPager",
            caption: "Load live data from stackoverflow"
        });

        fetchGridData();

        function fetchGridData() {

            var gridArrayData = [];
            // show loading message
            //$("#jqGrid")[0].grid.beginReq();
            $.ajax({
                url: "http://api.stackexchange.com/2.2/questions?order=desc&sort=activity&tagged=jqgrid&site=stackoverflow",
                success: function (result) {
                    alert("result: " + result)
                    for (var i = 0; i < result.items.length; i++) {
                        var item = result.items[i];

                        if(i == 0){
                            alert(item.title);
                        }

                        gridArrayData.push({
                            Title: item.title,
                            Link: item.link,
                            CreationDate: item.creation_date,
                            ViewCount: item.view_count,
                            AnswerCount: item.answer_count
                        });
                    }
                    // set the new data
                    $("#jqGrid").jqGrid('setGridParam', { data: gridArrayData});
                    // hide the show message
                    // $("#jqGrid")[0].grid.endReq();
                    // refresh the grid
                    $("#jqGrid").trigger('reloadGrid');
                }

            });
        }

        function formatTitle(cellValue, options, rowObject) {
            return cellValue.substring(0, 50) + "...";
        };

        function formatLink(cellValue, options, rowObject) {
            return "<a href='" + cellValue + "'>" + cellValue.substring(0, 25) + "..." + "</a>";
        };



    });

</script>


</body>
</html>
