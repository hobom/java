<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--文件上传必须为多部份表单形式--%>
<form action="${pageContext.request.contextPath}/user/quick23" method="post" enctype="multipart/form-data">
    名称<input type="text" name="username"><br/>
    文件<input type="file" name="uploadFile"><br/>
    文件<input type="file" name="uploadFile"><br/>
    <input type="submit" value="提交">
</form>

<%--文件上传必须为多部份表单形式--%>
<form action="${pageContext.request.contextPath}/user/quick22" method="post" enctype="multipart/form-data">
    名称<input type="text" name="username"><br/>
    文件<input type="file" name="uploadFile"><br/>
    文件2<input type="file" name="uploadFile2"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
