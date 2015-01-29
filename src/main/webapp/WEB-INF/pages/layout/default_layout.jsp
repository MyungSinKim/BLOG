<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
    <tiles:insertAttribute name="header" />
</head>
<body>

<table border=1>
    <tr>
        <td><tiles:insertAttribute name="menu" /></td>
        <td><tiles:insertAttribute name="body" /></td>
    </tr>
    <tr>
        <td colspan="2"><tiles:insertAttribute name="footer" /></td>
    </tr>
</table>

</body>
</html>