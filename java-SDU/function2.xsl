<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<xsl:for-each select="function">
			<html>
				<head>
					<title>Табличная функция Cx(delta,Mtau)</title>
					<style>
						* {
						-webkit-box-sizing: border-box;
						-moz-box-sizing: border-box;
						box-sizing: border-box;
						}
						.btn {
						display: inline-block;
						padding: 6px 12px;
						margin-bottom: 0;
						font-size: 14px;
						font-weight: 400;
						line-height: 1.42857143;
						text-align: center;
						white-space: nowrap;
						vertical-align: middle;
						-ms-touch-action: manipulation;
						touch-action: manipulation;
						cursor: pointer;
						-webkit-user-select: none;
						-moz-user-select: none;
						-ms-user-select: none;
						user-select: none;
						background-image: none;
						border: 1px solid transparent;
						border-radius: 4px;
						}
						.btn-default {
						color: #333;
						background-color: #fff;
						border-color: #ccc;
						text-decoration: none;
						}
						.btn:hover {
						background-color: #f9f2f4;
						}
						input[type=button], input[type=reset], input[type=submit] {
						-webkit-appearance: button;
						cursor: pointer;
						}
					</style>
				</head>
				<body bgcolor="#FFFFFF" text="#000000">
					<form name="form1" method="get" action="/">
						<p align="center">
							<input class="btn btn-default" type="submit" name="action"
								value="save" />
							<input class="btn btn-default" type="submit" name="action"
								value="addrow" />
							<input type="submit" name="deleteRow" value="Удалить строку" />
							<input type="submit" name="addColumn" value="Добавить столбец" />
							<input type="submit" name="deleteColumn" value="Удалить столбец" />
							<a class="btn btn-default" href="/?controller=func" role="button">Закрыть
							</a>
						</p>
						<xsl:variable name="namet" select="name" />
						<xsl:variable name="fn1" select="nameFirstArgument" />
						<xsl:variable name="fn2" select="nameSecondArgument" />
						<xsl:variable name="descr" select="description" />
						<p align="left">
							<input type="hidden" name="controller" value="func" />
							<input type="hidden" name="view" value="f2" />
							<xsl:variable name="DESCRIP">
								<xsl:value-of select="description" />
							</xsl:variable>
							<input type="hidden" name="fname" value="{$DESCRIP}" />
							<input type="hidden" name="type" value="tableFunction" />
							<input type="hidden" name="argumentNum" value="2" />
						</p>
						<p>Cx(delta,Mtau)
						</p>
						<p>
							<xsl:value-of select="$descr" />
						</p>
						<p>
							<input type="hidden" name="x1Num" value="9" />
							<input type="hidden" name="x2Num" value="10" />
						</p>
						<table border="1" cellspacing="1" cellpadding="1">
							<xsl:for-each select="row">
								<xsl:variable name="rowP">
									<xsl:value-of select="position()" />
								</xsl:variable>
								<xsl:variable name="rowCount" select="position()" />
								<xsl:choose>
									<xsl:when test="$rowCount = '1'">
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<xsl:for-each select="coll">
												<xsl:variable name="collP">
													<xsl:value-of select="position()" />
												</xsl:variable>
												<td>
													<div align="center">
														<input type="checkbox" name="checkboxX2{$collP}"
															value="checkbox" />
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
												<xsl:variable name="collP">
													<xsl:value-of select="position()" />
												</xsl:variable>
												<td width="15" bgcolor="#00FFFF" height="10">
													<div align="center">
														<xsl:variable name="TCOLL">
															<xsl:value-of select="index" />
														</xsl:variable>
														<input type="text" name="x2{$collP}" size="7" value="{$TCOLL}" />
													</div>
												</td>
											</xsl:for-each>
										</tr>
									</xsl:when>
								</xsl:choose>

								<tr>
									<td>
										<div align="center">

											<input type="checkbox" name="checkboxX1{$rowP}" value="checkbox" />
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
											<input type="text" name="x1{$rowP}" size="7" value="{$TROW}" />
										</div>
									</td>
									<xsl:for-each select="coll">
										<xsl:variable name="collP">
											<xsl:value-of select="position()" />
										</xsl:variable>
										<td width="15" bgcolor="#FFFF66" height="10">
											<div align="center">
												<xsl:variable name="TCELL">
													<xsl:value-of select="cell/value" />
												</xsl:variable>
												<input type="text" name="y{$rowP}_{$collP}" size="7"
													value="{$TCELL}" />
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