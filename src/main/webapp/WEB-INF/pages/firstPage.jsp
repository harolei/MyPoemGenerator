<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>

<form method="post" action="/MyPoemGenerator/poemText.htm">
<input type="text" name="sentenceText"/>
<input type="submit" value="Next Sentence"/>

<form:form method="POST" commandName="poemText">
<table>
<tr>
<td><form:input path="sentenceText"/></td>
<td><form:error path="sentenceText" cssClass="error"/></td>
</tr>

<tr>
<td><input type="submit" name="nextAction" value="secondSentence"/></td>
</table>

</form:form>

</form>
</body>
</html>
