<%@ page contentType="text/html;charset=utf-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

</head>
<body>
<form:form method="POST" action="/MyPoemGenerator/weather">

    <table cellspacing="0" cellpadding="4" frame="box" bordercolor="#dcdcdc" rules="none" style="border-collapse: collapse;">
        <tbody>
        <tr>
            <td class="frmHeader" background="./WeatherWebService Web 服务_files/WeatherWebService.asmx" style="border-right: 2px solid white;">参数</td>
            <td class="frmHeader" background="./WeatherWebService Web 服务_files/WeatherWebService.asmx">值</td>
        </tr>


        <tr>
            <td class="frmText" style="color: #000000; font-weight: normal;">theCityName:</td>
            <td><input class="frmInput" type="text" size="50" name="theCityName"></td>
        </tr>

        <tr>
            <td></td>
            <td align="right"> <input type="submit" id="btnCallService" value="调用"></td>
        </tr>
        </tbody></table>

        <div id="backData"></div>


</form:form>

<h2>${message}</h2>

</body>
</html>