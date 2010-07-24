<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@ include file="/pages/cabecera.jsp" %>
</head>
<body>
<table border="0" align="center" cellpadding="2" cellspacing="0">
  <tr>
    <td bgcolor="#262b54"><table border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
      <tr>
        <td valign="top" bgcolor="#FFFFFF"><img src="../images/spacer.gif" width="44" height="45" /></td>
        <td align="right" valign="bottom" bgcolor="#FFFFFF">&nbsp;</td>
        <td bgcolor="#FFFFFF"><img src="../images/spacer.gif" width="44" height="45" /></td>
      </tr>
      <tr>
        <td valign="top" bgcolor="#FFFFFF"><img src="../images/spacer.gif" width="44" height="45" /></td>
        <td bgcolor="#383431"><table border="0" cellspacing="1" cellpadding="0">
          <tr>
            <td bgcolor="#FFFFFF"><img src="../images/imgheader.jpg" width="676" height="76" /></td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td background="../images/bg_home.gif"><table border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="435" align="center" valign="middle">
                      <form id="FrmLogin" name="FrmLogin" method="post" action="../LoginServlet">
                          <table width="197" height="127" border="0" align="center" class="subtitulo">
                            <tr>
                              <th width="80" align="left" valign="middle" scope="row">User</th>
                              <td width="144">
                                  <label>
                                         <input name="login" type="text" class="menuhome" id="login"  />
                                 </label>
                                  
                              </td>
                            </tr>
                            <tr>
                              <th align="left" valign="middle" scope="row">Password</th>
                              <td><label>
                                <input name="password" type="password" class="menuhome" id="password" />
                              </label></td>
                            </tr>
                            <tr>
                              <th align="left" valign="middle" scope="row">Rol</th>
                              <td align="left" valign="middle"><label>
                                <select name="select" class="menuhome" id="select">
                                  <option selected="selected">Auditor</option>
                                  <option>Evaluado</option>
                                  <option>Administrador</option>
                                </select>
                              </label></td>
                            </tr>
                            <tr>
                              <th colspan="1" scope="row">
                                  <input type="submit" name="button" id="button" value="Logueo..!" />
                                </th>
                            </tr>
                              <tr>
                                   <th colspan="1" scope="row">
                                        <td width="180" align="left" valign="middle">
                                          <c:if test="${!empty requestScope.mensaje}">
                                          <label>
                                                 ${requestScope.mensaje}
                                               </label>
                                          </c:if>
                                        </td>
                                    </th>
                                  </tr>
                          </table>
                        </form>
                    </td>
                    <td width="213" align="right" valign="bottom"><table border="0" cellspacing="0" cellpadding="2">
                      <tr>
                        <td colspan=2 valign="top" class="texto" style="text-align: right">
                        </td> 
                      </tr>
                      <tr>
                        <td>&nbsp; </td>
                        <td></td>
                      </tr>
                      <tr>
                        <td>&nbsp; </td>
                        <td></td>
                      </tr>
                      <tr>
                        <td align="right" class="menuhome"><a href="../pages/intro.jsp">Introducci&oacute;n</a></td>
                        <td><img src="../images/bullet_amarillo.gif" width="9" height="7" /></td>
                      </tr>
                      <tr>
                        <td align="right" class="menuhome"><a href="../pages/pautas.jsp">Pautas</a></td>
                        <td><img src="../images/bullet_amarillo.gif" width="9" height="7" /></td>
                      </tr>
                      <tr>
                        <td align="right" class="menuhome"><a href="../pages/sistevaluacion.jsp">Sistema de Evaluaci&oacute;n</a> </td>
                        <td><img src="../images/bullet_amarillo.gif" width="9" height="7" /></td>
                      </tr>
                      <tr>
                        <td align="right" class="menuhome"><a href="../pages/revmodulos.jsp">Revisi&oacute;n de los M&oacute;dulos</a> </td>
                        <td><img src="../images/bullet_amarillo.gif" width="9" height="7" /></td>
                      </tr>
                      <tr>
                        <td colspan="2"><img src="../images/spacer.gif" width="10" height="7" /></td>
                        </tr>
                    </table></td>
                    <td width="28"><img src="../images/spacer.gif" width="28" height="167" /></td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td background="../images/bg_menuhome.gif"><table border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td><img src="../images/mnH_mod1.gif" name="mod1" width="107" height="75" border="0" id="mod1" /></td>
                    <td><img src="../images/mnH_mod1_2.gif" name="mod1_2" width="23" height="75" id="mod1_2" /></td>
                    <td><img src="../images/mnH_mod2.gif" name="mod2" width="130" height="75" border="0" id="mod2" /></td>
                    <td><img src="../images/mnH_mod2_3.gif" name="mod2_3" width="23" height="75" id="mod2_3" /></td>
                    <td><img src="../images/mnH_mod3.gif" name="mod3" width="124" height="75" border="0" id="mod3" /></td>
                    <td><img src="../images/mnH_mod3_4.gif" name="mod3_4" width="23" height="75" id="mod3_4" /></td>
                    <td><img src="../images/mnH_mod4.gif" name="mod4" width="81" height="75" border="0" id="mod4" /></td>
                    <td><img src="../images/mnH_mod4_5.gif" name="mod4_5" width="23" height="75" id="mod4_5" /></td>
                    <td><img src="../images/mnH_mod5.gif" name="mod5" width="142" height="75" border="0" id="mod5"  /></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td bgcolor="#FFFFFF"><img src="../images/spacer.gif" width="44" height="45" /></td>
      </tr>
      <tr>
        <td colspan="3" valign="top" bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td bgcolor="#FFFFFF"><img src="../images/spacer.gif" width="174" height="32" /></td>
          </tr>
          <tr>
            <td bgcolor="#9F8852"><img src="../images/spacer.gif" width="174" height="1" /></td>
          </tr>
          <tr>
            <td align="left"><img src="../images/foot_sab.gif" width="181" height="35" /></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
