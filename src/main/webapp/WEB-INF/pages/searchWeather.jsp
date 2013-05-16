<html>
<head>
<script type="text/javascript">
var xmlHttp;
function createXMLRequest(){
   if(window.ActiveXObject){
      xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
   }
   else if(window.XMLHttpRequest){
      xmlHttp = new XMLHttpRequest();
   }
}

function startRequest(){
   createXMLHttpRequest();
   xmlHttp.onreadystatechange = handleStateChange;
   xmlHttp.open("POST","http://www.webxml.com.cn/WebServices/WeatherWebService.asmx/getWeatherbyCityName");
   xmlHttp.send(null);
}

function handleStateChange(){
   if(xmlHttp.readyState == 4){
      if(xmlHttp.status == 200){
         document.getElementById("results").innerHTML = xmlHttp.responseText;
      }
}
</script>
</head>
<body>
<form target="_blank" action="http://www.webxml.com.cn/WebServices/WeatherWebService.asmx/getWeatherbyCityName" method="POST">

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
            <td align="right"> <input type="button" value="调用" onclick="startRequest();"></td>
        </tr>
        </tbody></table>

        <div id="results"></div>


</form>
</body>
</html>