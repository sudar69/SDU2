<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
 xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
 <xsl:template match="/">
	<html>
	<head>
	<title>Untitled Document</title>

	</head>
	
	<body bgcolor="#FFFFFF" text="#000000">
	<table width="400" border="0" cellspacing="0" cellpadding="0" align="center">
	  <tr> 
	    <td width="227" height="252"> 
	      <p><a href="http://href?type=openInputData"><xsl:value-of select="files" /></a></p>
	      <p><a href="http://href?type=createNewInputData"><xsl:value-of select="createFile" /></a></p>
	      <p>—оздать табличную функцию:</p>
	      <ul>
	        <li><a href="http://href?type=createTableFunction1">функцию одного аргумента</a></li>
	        <li><a href="http://href?type=createTableFunction2">функцию двух аргументов</a></li>
	      </ul>
	    </td>
	  </tr>
	</table>
	</body>
	</html>

 </xsl:template>
</xsl:stylesheet>