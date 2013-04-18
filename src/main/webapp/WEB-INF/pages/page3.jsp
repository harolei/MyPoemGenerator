<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
<h2>${message}</h2>


<form:form method="POST" action="/MyPoemGenerator/page4.htm" commandName="PoemText">
<table>
<tr>
<td><form:input path="thirdSentence"/></td>
</tr>

<tr>
<td><input type="submit" name="next" value="Next"/></td>
</tr>
</table>
</form:form>


<form:form method="GET" action="/MyPoemGenerator/page2.htm" commandName="PoemText">
<input type="submit" name="previous" value="Previous"/>
</form:form>

</body>
</html>
