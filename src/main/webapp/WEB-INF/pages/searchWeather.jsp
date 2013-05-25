<%@ page contentType="text/html;charset=utf-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script  language="javascript" type="text/javascript">
$(document).ready(function(){

  $("#selectProv").change(function(){
     var provName = $(this).children('option:selected').val();
     $("#selectCity option").remove();
     $.ajax({
        url:"/MyPoemGenerator/weather",
        type:"GET",
        data:"prov="+provName,
        dataType:"json",
        success:function(result){
           var obj = result;
           $(obj).each(function(index){
              var _city = obj[index];
              var _cityName = _city.cityName;
              $("#selectCity").append("<option>"+ _cityName +"</option>");
           });
        }
     });
  });
  $("#selectCity").change(function(){
     var cityName = $(this).children('option:selected').val();
     $("#weatherTable tbody").remove();
     $.ajax({
       url:"/MyPoemGenerator/weather",
       type:"GET",
       data:"city="+cityName,
       dataType:"json",
       success:function(result){
          var obj = result;
          var table = document.getElementById("weatherTable");
          $(obj).each(function(index){
             var weatherStr = obj[index].weather;
             $("#weatherTable").append("<tr><td>"+weatherStr+"</td></tr>");
          });
       }
     });
  });
});
</script>
</head>

<body>
<table cellspacing="0" cellpadding="4" frame="box" bordercolor="#dcdcdc" rules="none" style="border-collapse: collapse;">
        <tbody>
        <tr>
          <td>请选择查询的城市：</td>
        </tr>
        <tr>
         <td>
            <select id="selectProv">
            <c:forEach items="${provs}" var="prov">
              <option>
              <c:out value="${prov.proName}"/>
              </option>
            </c:forEach>
            </select>
          </td>
          <td>
            <select id="selectCity">
            </select>
          </td>
        </tr>

        <tr>
            <td></td>
            <td></td>
        </tr>
        </tbody>
    </table>

    <div id="backData"></div>
    <table width="100%" border="1" cellspacing="1" id="weatherTable"><tbody></tbody></table>

</body>
</html>