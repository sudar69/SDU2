<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<xsl:for-each select="file">
			<html>
				<head>
					<title>
						<xsl:value-of select="parameter/title" />
					</title>
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
					<form name="form1" method="get" action="/">
						<p align="center">
							<input class="btn btn-default" type="submit" name="action"
								value="save" />
							<input type="submit" name="calculate" value="Начать вычисления" />
							<a class="btn btn-default" href="/?controller=files" role="button">Закрыть
							</a>
						</p>
						<p align="center">
							<b>
								<font size="4">СДУ Аэродинамическая модель</font>
							</b>
						</p>
						<p align="center">
							<b>
								<font size="4">Исходные данные</font>
							</b>
						</p>
						<p align="center">
							<b>
								<font size="4">
									<xsl:value-of select="parameter/title" />
								</font>
							</b>
						</p>
						<p align="center">
							<b>Углы прицеливания</b>
						</p>
						<p align="center">
							<input class="btn btn-default" type="submit" name="action"
								value="addTeta0" />
							<input class="btn btn-default" type="submit" name="action"
								value="deleteTeta0" />
						</p>
						<input type="hidden" name="type" value="OSInput" />
						<input type="hidden" name="controller" value="files" />
						<xsl:variable name="PT">
							<xsl:value-of select="parameter/title" />
						</xsl:variable>
						<input type="hidden" name="fname" value="{$PT}" />

						<table width="633" border="1" cellspacing="1" cellpadding="1"
							align="center">
							<tbody>
								<tr>
									<td width="3%">
										<div align="center">
											<input type="checkbox" name="checkboxTeta0" value="checkbox" />
										</div>
									</td>
									<td width="3%">
										<div align="center">N п/п</div>
									</td>
									<td width="28%">
										<div align="center">Дт, м</div>
									</td>
									<td width="35%">
										<div align="center">teta0, градусы.мин</div>
									</td>
									<td width="31%">
										<div align="center">i пут1</div>
									</td>
									<td width="31%">
										<div align="center">i аут</div>
									</td>
									<td width="31%">
										<div align="center">i пут2</div>
									</td>
									<td width="31%">
										<div align="center">dTзр+ ТС</div>
									</td>
									<td width="31%">
										<div align="center">p+</div>
									</td>
									<td width="31%">
										<div align="center">dTзр- ТС</div>
									</td>
									<td width="31%">
										<div align="center">p-</div>
									</td>
								</tr>
								<xsl:for-each select="parameter/teta0">
									<xsl:variable name="rowP">
										<xsl:value-of select="position()" />
									</xsl:variable>
									<tr>
										<td width="3%">
											<div align="center">
												<xsl:variable name="stcheckbox" select="checkbox" />
												<xsl:choose>
													<xsl:when test="$stcheckbox = 'true'">
														<input type="checkbox" name="checkboxTeta{$rowP}"
															value="checkbox" checked="checked" />
													</xsl:when>
													<xsl:otherwise>
														<input type="checkbox" name="checkboxTeta{$rowP}"
															value="checkbox" />
													</xsl:otherwise>
												</xsl:choose>
											</div>
										</td>
										<td width="3%">
											<div align="center">
												<xsl:value-of select="id" />
											</div>
										</td>
										<td width="28%">
											<div align="center">
												<xsl:variable name="D_">
													<xsl:value-of select="d" />
												</xsl:variable>
												<input type="text" name="D{$rowP}" value="{$D_}" />
											</div>
										</td>
										<td width="35%">
											<div align="center">
												<xsl:variable name="teta0_">
													<xsl:value-of select="teta0" />
												</xsl:variable>
												<input type="text" name="teta0{$rowP}" value="{$teta0_}" />
											</div>
										</td>
										<td width="31%">
											<div align="center">
												<xsl:variable name="iput_">
													<xsl:value-of select="iput" />
												</xsl:variable>
												<input type="text" name="i{$rowP}" value="{$iput_}" />
											</div>
										</td>
										<td width="31%">
											<div align="center">
												<xsl:variable name="iaut_">
													<xsl:value-of select="iaut" />
												</xsl:variable>
												<input type="text" name="iaut{$rowP}" value="{$iaut_}" />
											</div>
										</td>
										<td width="31%">
											<div align="center">
												<xsl:variable name="iput2_">
													<xsl:value-of select="iput2" />
												</xsl:variable>
												<input type="text" name="iput2{$rowP}" value="{$iput2_}" />
											</div>
										</td>
										<td width="31%">
											<div align="center">
												<xsl:variable name="dxtzrpts_">
													<xsl:value-of select="dxtzrpts" />
												</xsl:variable>
												<input type="text" name="dxtzrpts{$rowP}" value="{$dxtzrpts_}" />
											</div>
										</td>
										<td width="31%">
											<div align="center">
												<xsl:variable name="pp_">
													<xsl:value-of select="pp" />
												</xsl:variable>
												<input type="text" name="pp{$rowP}" value="{$pp_}" />
											</div>
										</td>
										<td width="31%">
											<div align="center">
												<xsl:variable name="dxtzrmts_">
													<xsl:value-of select="dxtzrmts" />
												</xsl:variable>
												<input type="text" name="dxtzrmts{$rowP}" value="{$dxtzrmts_}" />
											</div>
										</td>
										<td width="31%">
											<div align="center">
												<xsl:variable name="pm_">
													<xsl:value-of select="pm" />
												</xsl:variable>
												<input type="text" name="pm{$rowP}" value="{$pm_}" />
											</div>
										</td>
									</tr>
								</xsl:for-each>
							</tbody>
						</table>
						<p>
							<xsl:variable name="stcheckbox" select="parameter/aerdinamik" />
							<xsl:choose>
								<xsl:when test="$stcheckbox = 'true'">
									<input type="checkbox" name="aerdinamik" value="checkbox"
										checked="checked" />
								</xsl:when>
								<xsl:otherwise>
									<input type="checkbox" name="aerdinamik" value="checkbox" />
								</xsl:otherwise>
							</xsl:choose>
							Вывести аэродинамику
						</p>
						<p></p>
						<p>
							<xsl:variable name="stcheckbox" select="parameter/findI" />
							<xsl:choose>
								<xsl:when test="$stcheckbox = 'true'">
									<input type="checkbox" name="findI" value="checkbox"
										checked="checked" />
								</xsl:when>
								<xsl:otherwise>
									<input type="checkbox" name="findI" value="checkbox" />
								</xsl:otherwise>
							</xsl:choose>
							Подбор коэффициента формы i_пут1
						</p>
						<p></p>
						<p>
							<xsl:variable name="stcheckbox" select="parameter/findIp2" />
							<xsl:choose>
								<xsl:when test="$stcheckbox = 'true'">
									<input type="checkbox" name="findIp2" value="checkbox"
										checked="checked" />
								</xsl:when>
								<xsl:otherwise>
									<input type="checkbox" name="findIp2" value="checkbox" />
								</xsl:otherwise>
							</xsl:choose>
							Подбор коэффициента формы i_пут2
						</p>
						<p></p>
						<p>
							<xsl:variable name="stcheckbox" select="parameter/findIp1p2" />
							<xsl:choose>
								<xsl:when test="$stcheckbox = 'true'">
									<input type="checkbox" name="findIp1p2" value="checkbox"
										checked="checked" />
								</xsl:when>
								<xsl:otherwise>
									<input type="checkbox" name="findIp1p2" value="checkbox" />
								</xsl:otherwise>
							</xsl:choose>
							Подбор коэффициентов формы i_пут1, i_пут2
						</p>
						<p></p>
						<p>
							<xsl:variable name="stcheckbox" select="parameter/findIaut" />
							<xsl:choose>
								<xsl:when test="$stcheckbox = 'true'">
									<input type="checkbox" name="findIaut" value="checkbox"
										checked="checked" />
								</xsl:when>
								<xsl:otherwise>
									<input type="checkbox" name="findIaut" value="checkbox" />
								</xsl:otherwise>
							</xsl:choose>
							Подбор коэффициента формы i_aут
						</p>
						<p></p>
						<p>
							<xsl:variable name="stcheckbox" select="parameter/findIvse" />
							<xsl:choose>
								<xsl:when test="$stcheckbox = 'true'">
									<input type="checkbox" name="findIvse" value="checkbox"
										checked="checked" />
								</xsl:when>
								<xsl:otherwise>
									<input type="checkbox" name="findIvse" value="checkbox" />
								</xsl:otherwise>
							</xsl:choose>
							Подбор коэффициента формы i_aут, i_пут1, i_пут2 (i_пут =
							i_аут/0.85)
						</p>
						<p></p>
						<p>
							<xsl:variable name="stcheckbox" select="parameter/findpp" />
							<xsl:choose>
								<xsl:when test="$stcheckbox = 'true'">
									<input type="checkbox" name="findpp" value="checkbox"
										checked="checked" />
								</xsl:when>
								<xsl:otherwise>
									<input type="checkbox" name="findpp" value="checkbox" />
								</xsl:otherwise>
							</xsl:choose>
							Подбор коэффициента p+
						</p>
						<p></p>
						<p>
							<xsl:variable name="stcheckbox" select="parameter/findpm" />
							<xsl:choose>
								<xsl:when test="$stcheckbox = 'true'">
									<input type="checkbox" name="findpm" value="checkbox"
										checked="checked" />
								</xsl:when>
								<xsl:otherwise>
									<input type="checkbox" name="findpm" value="checkbox" />
								</xsl:otherwise>
							</xsl:choose>
							Подбор коэффициента p-
						</p>
						<p></p>
						<p>
							<xsl:variable name="stcheckbox" select="parameter/saveCalculation" />
							<xsl:choose>
								<xsl:when test="$stcheckbox = 'true'">
									<input type="checkbox" name="saveCalculation" value="checkbox"
										checked="checked" />
								</xsl:when>
								<xsl:otherwise>
									<input type="checkbox" name="saveCalculation" value="checkbox" />
								</xsl:otherwise>
							</xsl:choose>
							Сохранять расчёты
							Имя файла
							<input type="text" name="file1Name" value="temp.txt" />
							Шаг
							<input type="text" name="step" value="1" />
						</p>
						<p align="center">
							<b>Расчитывать поправочные коэффициенты:</b>
						</p>
						<table border="1" cellspacing="1" cellpadding="1" align="center">
							<tbody>
								<tr>
									<xsl:for-each select="parameter/rpk">
										<td width="70">
											<div align="center">
												<xsl:value-of select="name" />
											</div>
										</td>
									</xsl:for-each>
								</tr>
								<tr>
									<xsl:for-each select="parameter/rpk">
										<td width="70">
											<div align="center">

												<xsl:variable name="pname_">
													<xsl:value-of select="pname" />
												</xsl:variable>
												<xsl:variable name="stcheckbox" select="check" />
												<xsl:choose>
													<xsl:when test="$stcheckbox = 'true'">
														<input type="checkbox" name="{$pname_}" value="checkbox"
															checked="checked" />
													</xsl:when>
													<xsl:otherwise>
														<input type="checkbox" name="{$pname_}" value="checkbox" />
													</xsl:otherwise>
												</xsl:choose>
											</div>
										</td>
									</xsl:for-each>
								</tr>
							</tbody>
						</table>
						<p align="center">
							<b>Расчитывать поправочные графы для расчета Вд, Вб:</b>
						</p>
						<table border="1" cellspacing="1" cellpadding="1" align="center">
							<tbody>
								<tr>
									<xsl:for-each select="parameter/rpgforv">
										<td width="70">
											<div align="center">
												<xsl:value-of select="name" />
											</div>
										</td>
									</xsl:for-each>
								</tr>
								<tr>
									<xsl:for-each select="parameter/rpgforv">
										<td width="70">
											<div align="center">

												<xsl:variable name="pname_">
													<xsl:value-of select="pname" />
												</xsl:variable>
												<xsl:variable name="stcheckbox" select="check" />
												<xsl:choose>
													<xsl:when test="$stcheckbox = 'true'">
														<input type="checkbox" name="{$pname_}" value="checkbox"
															checked="checked" />
													</xsl:when>
													<xsl:otherwise>
														<input type="checkbox" name="{$pname_}" value="checkbox" />
													</xsl:otherwise>
												</xsl:choose>
											</div>
										</td>
									</xsl:for-each>
								</tr>
							</tbody>
						</table>
						<p align="center">
							<b>Исходные данные для расчета табличной и возмущенной траектории
							</b>
						</p>
						<table width="385" border="1" cellspacing="1" cellpadding="1"
							align="center">
							<tbody>
								<xsl:for-each select="parameter/beginData">
									<tr>
										<td width="7%">
											<div align="center">
												<xsl:value-of select="position()" />
											</div>
										</td>
										<td width="45%">
											<div align="left">
												<xsl:value-of select="name" />
											</div>
										</td>
										<td width="48%">
											<div align="left">
												<xsl:variable name="pname_">
													<xsl:value-of select="pname" />
												</xsl:variable>

												<xsl:variable name="value_">
													<xsl:value-of select="value" />
												</xsl:variable>

												<xsl:variable name="value__">
													<xsl:variable name="pname__" select="pname" />
													<xsl:choose>
														<xsl:when test="$pname__ = 'psi20'">
															<xsl:value-of select="'из таблицы'" />
														</xsl:when>
														<xsl:when test="$pname__ = 'r0'">
															<xsl:value-of select="'2 M_Pi v0/(eta d) eta1'" />
														</xsl:when>
														<xsl:otherwise>
															<xsl:value-of select="$value_" />
														</xsl:otherwise>
													</xsl:choose>
												</xsl:variable>

												<xsl:variable name="stcheckbox" select="readonly" />
												<xsl:choose>
													<xsl:when test="$stcheckbox = 'true'">
														<input type="text" name="{$pname_}" value="{$value__}"
															readonly="" />
													</xsl:when>
													<xsl:otherwise>
														<input type="text" name="{$pname_}" value="{$value__}" />
													</xsl:otherwise>
												</xsl:choose>
											</div>
										</td>
									</tr>
								</xsl:for-each>
							</tbody>
						</table>
					</form>
				</body>
			</html>
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>