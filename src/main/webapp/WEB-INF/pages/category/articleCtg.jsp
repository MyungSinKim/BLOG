<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/ecmascript" src="/resources/js/jquery-1.7.2.min.js"></script>
</head>
<body>
<script type="text/javascript">
    $(document).ready(function () {
        $.ajax({
            type: 'GET',
            url: "/articleCtgData",
            success: function(result) {
                console.log(result);
                for (var i = 0; i < result.length; i++) {
                    var item = result[i];
                    $("#articleCtg").append("<option value="+item.seq+">" + item.ctgName +"</option>");
                }
            },
            error:function(request, status, error){
                alert("ERROR: " + request + " " + status + " " +error);
            }
        });
    });
</script>
<select id="articleCtg"></select>
</body>
</html>
