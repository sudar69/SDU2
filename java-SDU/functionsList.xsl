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
	  <xsl:for-each select="functionsList/function">
	  <tr> 
	    <td> 
	      <p><xsl:value-of select="name" /></p>
	    </td>
	    <td> 
	      <p><xsl:value-of select="type" /></p>
	    </td>
	    <td> 
	      <p><xsl:value-of select="description" /></p>
	    </td>
	    <td> 
	      <p><xsl:value-of select="nameFirstArgument" /></p>
	    </td>
	    <td> 
	      <p><xsl:value-of select="nameSecondArgument" /></p>
	    </td>
	  </tr>
	  </xsl:for-each>
	</table>
	</body>
	</html>

 </xsl:template>
</xsl:stylesheet>