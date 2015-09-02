<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<head>
				<title>Theard</title>
			</head>
			<body bgcolor="#FFFFFF" text="#000000">
				<table width="400" border="0" cellspacing="0" cellpadding="0"
					align="center">
					<xsl:for-each select="menu/items">
						<tr>
							<td>
								<xsl:variable name="NAME">
									<xsl:value-of select="url" />
								</xsl:variable>
								<p>
									<a href="{$NAME}">
										<xsl:value-of select="title" />
									</a>
								</p>
							</td>
						</tr>
					</xsl:for-each>
				</table>
				<p><xsl:value-of select="menu/countFiles" /></p>
				<table width="400" border="1" cellspacing="0" cellpadding="0"
					align="center">
					<xsl:for-each select="menu/file">
						<tr>
							<td>
								<xsl:variable name="title_">
									<xsl:value-of select="parameter/title" />
								</xsl:variable>
								<p>
									<xsl:value-of select="parameter/title" />
								</p>
							</td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>

	</xsl:template>
</xsl:stylesheet>