<%--
  Created by IntelliJ IDEA.
  User: Zhaiyunpeng
  Date: 2019/4/23
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>File Upload</title>
</head>
<body>
    <form  action="${pageContext.request.contextPath}/fileUpload" method="post" enctype="multipart/form-data">
        <fieldset style="width: 80%;align-self: center">
            <legend>文件上传</legend>
            <table border="2"  >
                <tr>
                    <td colspan="2">
                        <strong>文件上传</strong>
                    </td>
                </tr>
                <tr>
                    <td style="text-align: right;padding-right: 5px;">
                        选择上传文件:
                    </td>
                    <td>
                        <input name="file" type="file">
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center">
                        <input type="submit" value="确定"/>
                    </td>
                </tr>
            </table>
        </fieldset>

    </form>
</body>
</html>
