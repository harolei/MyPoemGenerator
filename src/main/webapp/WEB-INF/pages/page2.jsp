<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
<h2>${message}</h2>


<form:form method="POST" action="/MyPoemGenerator/page3.htm" commandName="PoemText">
<table>
<tr>
<td><form:input path="secondSentence"/></td>
</tr>

<tr>

<td><input type="submit" name="next" value="Next"/></td>
</tr>
</table>
</form:form>

<form:form method="GET" action="/MyPoemGenerator/page1.htm" commandName="PoemText">
<input type="submit" name="previous" value="Previous"/>
</form:form>

</body>
</html>
