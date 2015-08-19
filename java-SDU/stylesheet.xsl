<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
 xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
 <xsl:template match="/">
  <html>
   <body>
    <h2>My Library</h2>
    <table>
     <tr>
      <th>Title</th>
     </tr>
     <xsl:for-each select="menu/items">
      <tr>
       <td>
        <xsl:value-of select="title" />
       </td>
      </tr>
     </xsl:for-each>
    </table>
   </body>
  </html>
 </xsl:template>
</xsl:stylesheet>