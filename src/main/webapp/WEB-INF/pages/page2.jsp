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


<form:form method="POST" action="/MyPoemGenerator/page2" commandName="PoemSentence">
<form:errors path="*" cssClass="errorblock" element="div" />
<table>
<tr>
<td><form:input path="sentence" /></td>
<td><form:errors path="sentence" cssClass="error" /></td>
</tr>

<tr>

<td><input type="submit" name="next" value="Next"/></td>
</tr>
</table>
</form:form>

<form:form method="GET" action="/MyPoemGenerator/page1" commandName="PoemSentence">
<input type="submit" name="previous" value="Previous"/>
</form:form>

</body>
</html>
