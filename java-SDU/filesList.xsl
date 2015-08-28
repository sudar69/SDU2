<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<head>
				<title>Files</title>
				<style>
					* {
					-webkit-box-sizing: border-box;
					-moz-box-sizing:
					border-box;
					box-sizing: border-box;
					}
					.btn {
					display: inline-block;
					padding: 6px 12px;
					margin-bottom: 0;
					font-size: 14px;
					font-weight:
					400;
					line-height: 1.42857143;
					text-align: center;
					white-space:
					nowrap;
					vertical-align: middle;
					-ms-touch-action: manipulation;
					touch-action: manipulation;
					cursor: pointer;
					-webkit-user-select:
					none;
					-moz-user-select: none;
					-ms-user-select: none;
					user-select:
					none;
					background-image: none;
					border: 1px solid transparent;
					border-radius: 4px;
					}
					.btn-default {
					color: #333;
					background-color:
					#fff;
					border-color: #ccc;
					text-decoration: none;
					}
					.btn:hover {
					background-color: #f9f2f4;
					}
					input[type=button], input[type=reset],
					input[type=submit] {
					-webkit-appearance: button;
					cursor: pointer;
					}
				</style>
			</head>
			<body bgcolor="#FFFFFF" text="#000000">
				<p align="center">
					<b>
						<font size="4">Исходные данные</font>
					</b>
				</p>
				<form name="form1" method="get" action="/">
					<p align="center">
						<input class="btn btn-default" type="submit" name="action"
							value="add" />
						<a class="btn btn-default" href="/" role="button">Закрыть</a>
						<input type="hidden" name="controller" value="files" />
					</p>
				</form>
				<table width="700" border="1" cellspacing="1" cellpadding="1"
					align="center">
					<tr>
						<th>Имя</th>
					</tr>
					<xsl:for-each select="filesList/file">
						<tr>
							<td>
								<xsl:variable name="NAME">
									<xsl:value-of select="parameter/title" />
								</xsl:variable>
								<p>
									<a href="?controller=files&amp;fname={$NAME}">
										<xsl:value-of select="parameter/title" />
									</a>
								</p>
							</td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>

	</xsl:template>
</xsl:stylesheet>