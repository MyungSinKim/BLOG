<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <!-- The jQuery library is a prerequisite for all jqSuite products -->
    <script type="text/ecmascript" src="/resources/js/jquery-1.7.2.min.js"></script>
    <!-- A link to a jQuery UI ThemeRoller theme, more than 22 built-in and many more custom -->
    <link rel="stylesheet" type="text/css" media="screen" href="/resources/css/jquery-ui.css" />
    <!-- The link to the CSS that the grid needs -->
    <title>Article</title>
</head>

<script type="application/javascript">
    $(document).ready(function () {
        //get category
        fnGetArticleCtgData();

        //button setting
        fnVisibleButton("${article.articleNo}");

        $('#btnPost').click(function() {
            console.log($("#article").serialize());
            if(confirm("등록 하시겠습니까?")) {

                var jsonData = {
                    "articleNo": "",
                    "title":     $('#title').val(),
                    "contents":  $('#contents').val(),
                    "ctgSeq": $('#articleCtg option:selected').val()
                };

                $.ajax({
                    type: 'POST',
                    url: "/article",
                    contentType: 'application/json; charset=utf-8',
                    data : JSON.stringify(jsonData),
                    dataType: 'json',
                    async: true,
                    success: function(result) {
                        console.log(result);
                        alert("등록 되었습니다.");
                        location.href= "/articles";
                    },
                    error:function(request, status, error){
                        alert("ERROR: " + request + " " + status + " " +error);
                    }
                });
            }
        });

        $('#btnMod').click(function() {
            console.log($("#article").serialize());
            if(confirm("수정 하시겠습니까?")) {

                var jsonData = {
                    "articleNo": $('#articleNo').val(),
                    "title":     $('#title').val(),
                    "contents":  $('#contents').val(),
                    "ctgSeq": $('#articleCtg option:selected').val()
                };

                $.ajax({
                    type: 'PUT',
                    url: "/articles/${article.articleNo}",
                    contentType: 'application/json; charset=utf-8',
//                    data: $("#article").serialize(),
//                    data : JSON.stringify($("#article").serialize()),
//                    data : '{"articleNo":"11","title":"ajax","contents":"ajax"}',
                      data : JSON.stringify(jsonData),
                    dataType: 'json',
                    async: true,
                    success: function(result) {
                        console.log(result);
                        alert("수정 되었습니다.");
                        location.href= "/articles";
                    },
                    error:function(request, status, error){
                        alert("ERROR: " + request + " " + status + " " +error);
                    }
                });
            }
        });

        $('#btnDel').click(function() {
            if(confirm("삭제 하시겠습니까?")){
                $.ajax({
                    type: 'DELETE',
                    url: "/articles/${article.articleNo}",
                    success: function (result) {
                        console.log(result);
                        alert("삭제 되었습니다.");
                        location.href=result;
                    },
                    error:function(request, status, error){
                        alert("ERROR: " + request + " " + status + " " +error);
                    }
                });
            }
        });
    });


    function fnGetArticleCtgData(){
        $.ajax({
            type: 'GET',
            url: "/articleCtgData",
            success: function(result) {
                console.log(result);
                for (var i = 0; i < result.length; i++) {
                    var item = result[i];
                    $("#articleCtg").append("<option value="+item.seq+">" + item.ctgName +"</option>");
                }
                if("${article.ctgSeq}".length > 0){
                    $("#articleCtg").val("${article.ctgSeq}");
                }
            },
            error:function(request, status, error){
                alert("ERROR: " + request + " " + status + " " +error);
            }
        });
    }

    function fnVisibleButton(articleNo){
        if(articleNo.length > 0){
            $('#btnPost').hide();
            $('#btnMod').show();
            $('#btnDel').show();

        }else{
            $('#btnPost').show();
            $('#btnMod').hide();
            $('#btnDel').hide();
        }
    }

</script>


<body>


<div id="content">


    <select id="articleCtg"></select>
        <table>
            <tr>
                <td colspan="2">
                    <button id="btnPost">post</button>
                    <button id="btnMod">put</button>
                    <button id="btnDel">del</button>
                </td>
            </tr>
            <tr>
                <td>
                    Article No.
                </td>
                <td>
                    <input id="articleNo" name="articleNo" type="text" value="${article.articleNo}" readonly="true">
                </td>
            </tr>
            <tr>
                <td>
                    Title
                </td>
                <td>
                    <input id="title" name="title" type="text" value="${article.title}" >
                </td>
            </tr>
            <tr>
                <td>
                    Contents
                </td>
                <td>
                    <textarea id="contents" name="contents" >${article.contents}</textarea>
                </td>
            </tr>
        </table>
</div>






</body>
</html>
