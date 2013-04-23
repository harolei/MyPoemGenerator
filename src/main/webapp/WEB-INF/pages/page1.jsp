<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>

<body>
<h2>${message}</h2>


<form:form method="POST" action="/MyPoemGenerator/page1" commandName="PoemText">
<form:errors path="*" cssClass="errorblock" element="div" />
<table>
<tr>
<td><form:input path="firstSentence"/></td>
<td><form:errors path="firstSentence" cssClass="error" /></td>
</tr>

<tr>
<td><input type="submit" name="next" value="Next"/></td>
</tr>
</table>
</form:form>

</body>
</html>
