<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<xsl:for-each select="function">
			<html>
				<head>
					<title>Табличная функция Cx(delta,Mtau)</title>
				</head>
				<body bgcolor="#FFFFFF" text="#000000">
					<form name="form1" method="post" action="http:\\ya.ru">
						<p align="center">
							<input type="submit" name="save" value="Сохранить" />
							<input type="submit" name="saveAs" value="Сохранить как" />
							<input type="submit" name="addRow" value="Добавить строку" />
							<input type="submit" name="deleteRow" value="Удалить строку" />
							<input type="submit" name="addColumn" value="Добавить столбец" />
							<input type="submit" name="deleteColumn" value="Удалить столбец" />
							<input type="submit" name="close" value="Закрыть" />
						</p>
						<p align="left">
							<input type="hidden" name="type" value="tableFunction" />
							<input type="hidden" name="argumentNum" value="2" />
						</p>
						<p>Cx(delta,Mtau)
						</p>
						<p>
							<xsl:value-of select="description" />
						</p>
						<p>
							<input type="hidden" name="x1Num" value="9" />
							<input type="hidden" name="x2Num" value="10" />
						</p>
						<xsl:variable name="namet" select="name" />
						<xsl:variable name="fn1" select="nameFirstArgument" />
						<xsl:variable name="fn2" select="nameSecondArgument" />
						<table border="1" cellspacing="1" cellpadding="1">
							<xsl:for-each select="row">
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<xsl:for-each select="coll">
										<td>
											<div align="center">
												<input type="checkbox" name="checkboxX20" value="checkbox" />
											</div>
										</td>
									</xsl:for-each>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td>
										<div align="center">
											<xsl:value-of select="$fn2" />
										</div>
									</td>
									<xsl:for-each select="coll">
										<td>
											<div align="center">
												<xsl:variable name="level1Count" select="position()" />
												<xsl:value-of select="$level1Count" />
											</div>
										</td>
									</xsl:for-each>
								</tr>
								<tr>
									<td></td>
									<td>
										<div align="center">
											<xsl:value-of select="$fn1" />
										</div>
									</td>
									<td>
										<div align="center">
											<xsl:value-of select="$namet" />
										</div>
									</td>
									<xsl:for-each select="coll">
										<td width="15" bgcolor="#00FFFF" height="10">
											<div align="center">
												<xsl:variable name="TCOLL">
													<xsl:value-of select="index" />
												</xsl:variable>
												<input type="text" name="x21" size="7" value="{$TCOLL}" />
											</div>
										</td>
									</xsl:for-each>
								</tr>
								<tr>
									<td>
										<div align="center">
											<input type="checkbox" name="checkboxX20" value="checkbox" />
										</div>
									</td>
									<td>
										<div align="center">
											<xsl:variable name="level2Count" select="position()" />
											<xsl:value-of select="$level2Count" />
										</div>
									</td>
									<td width="15" bgcolor="#00FFFF" height="10">
										<div align="center">
											<xsl:variable name="TROW">
												<xsl:value-of select="index" />
											</xsl:variable>
											<input type="text" name="x21" size="7" value="{$TROW}" />
										</div>
									</td>
									<xsl:for-each select="coll">
										<td width="15" bgcolor="#FFFF66" height="10">
											<div align="center">
												<xsl:variable name="TCELL">
													<xsl:value-of select="cell/value" />
												</xsl:variable>
												<input type="text" name="y1_1" size="7" value="{$TCELL}" />
											</div>
										</td>

									</xsl:for-each>
								</tr>
							</xsl:for-each>
						</table>
						<p>
							Имя функци
							<xsl:variable name="YNAME">
								<xsl:value-of select="name" />
							</xsl:variable>
							<input type="text" name="yName" value="{$YNAME}" />
						</p>
						<p>
							Имя первого аргумента
							<xsl:variable name="X1NAME">
								<xsl:value-of select="nameFirstArgument" />
							</xsl:variable>
							<input type="text" name="x1Name" value="{$X1NAME}" />
						</p>
						<p>
							Имя второго аргумента
							<xsl:variable name="X2NAME">
								<xsl:value-of select="nameSecondArgument" />
							</xsl:variable>
							<input type="text" name="x2Name" value="{$X2NAME}" />
						</p>
						<p></p>
						<p>
							Описание
							<xsl:variable name="FUNCDESC">
								<xsl:value-of select="description" />
							</xsl:variable>
							<input type="text" name="funcDesc" value="{$FUNCDESC}" />
						</p>
					</form>

				</body>
			</html>
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>