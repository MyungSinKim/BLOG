<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/ecmascript" src="/resources/js/jquery-1.7.2.min.js"></script>
    <title>CATEGORY</title>
</head>
<body>
<script type="application/javascript">
    $(document).ready(function () {
        $.ajax({
            type: 'GET',
            url: "/articleCtgData",
            success: function(result) {

                $("#divCtg").append("<a href='/'>HOME</a><br/>");
                for (var i = 0; i < result.length; i++) {
                    var item = result[i];
                    $("#divCtg").append("<a href=/category/"+ item.ctgName + " >"  + item.ctgName +"</a><br/>");
                }
            },
            error:function(request, status, error){
                alert("ERROR: " + request + " " + status + " " +error);
            }
        });
    });
</script>
<div id="divCtg"></div>
</body>
</html>
