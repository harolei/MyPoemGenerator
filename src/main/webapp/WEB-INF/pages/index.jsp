<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
<h2>${message}</h2>
<form method="GET" action="/MyPoemGenerator/page1.htm">
<input type="submit" value="Start Edit"/>
</form>

<form:form method="POST" commandName="poemText">
<table>
<tr>
<td><input type="submit" name="nextAction" value="firstSentence"/></td>
</table>

</body>
</html>
