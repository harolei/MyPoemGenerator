<html>
<body>

<%
String firstSentence = (String)session.getAttribute("firstSentence");
String secondSentence = (String)session.getAttribute("secondSentence");
String thirdSentence = (String)session.getAttribute("thirdSentence");
String forthSentence = (String)session.getAttribute("forthSentence");
%>

<h2>The Poem You Generate is as following:</h2>
<p><h4><%=firstSentence%></h4> </p>
<p><h4><%=secondSentence%></h4> </p>
<p><h4><%=thirdSentence%></h4> </p>
<p><h4><%=forthSentence%></h4> </p>

</body>
</html>
