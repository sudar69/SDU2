<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<head>
				<title>Functions</title>
			</head>
			<body bgcolor="#FFFFFF" text="#000000">
				<p align="center">
					<b>
						<font size="4">Табличные функции</font>
					</b>
				</p>
				<table width="700" border="1" cellspacing="1" cellpadding="1"
					align="center">
					<tr>
						<th>Описание</th>
						<th>Имя функци</th>
						<th>Тип</th>
						<th>Имя первого аргумента</th>
						<th>Имя второго аргумента</th>
					</tr>
					<xsl:for-each select="functionsList/function">
						<tr>
							<td>
								<xsl:variable name="NAME">
									<xsl:value-of select="description" />
								</xsl:variable>
								<p>
									<a href="?controller=func&amp;view=f2&amp;fname={$NAME}" >
										<xsl:value-of select="description" />
									</a>
								</p>
							</td>
							<td>
								<p>
									<xsl:value-of select="name" />
								</p>
							</td>
							<td>
								<p>
									<xsl:value-of select="type" />
								</p>
							</td>
							<td>
								<p>
									<xsl:value-of select="nameFirstArgument" />
								</p>
							</td>
							<td>
								<p>
									<xsl:value-of select="nameSecondArgument" />
								</p>
							</td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>

	</xsl:template>
</xsl:stylesheet>