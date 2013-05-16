<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
<h2>${message}</h2>

<form:form method="GET" action="/MyPoemGenerator/page1" commandName="PoemText">
<table>
<tr>
<td><input type="submit" name="next" value="Start Edit"/></td>
</tr>
</table>
</form:form>

<form:form method="GET" action="/MyPoemGenerator/weather">
<table>
<tr>
<td><input type="submit" name="weather" value="Search Weather"/></td>
</tr>
</table>
</form:form>

</body>
</html>
