<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <%@ include file="/pages/cabecera.jsp" %>
</head>
<body >
    <script>
var ajax;
var accion;

function funcionCallback()
{
	// Comprobamos si la peticion se ha completado (estado 4)
	if( ajax.readyState == 4 )
	{
		// Comprobamos si la respuesta ha sido correcta (resultado HTTP 200)

		if( ajax.status == 200 )
		{
			// Escribimos el resultado en la pagina HTML mediante DHTML
                        if(accion == 1){
                            document.getElementById('cd').innerHTML = "<b>"+ajax.responseText+"</b>";
                        }else{
                            document.getElementById('mensaje').innerHTML = "<b>"+ajax.responseText+"</b>";
                        }
			
		}
	}
}

function cargarCD(idRegion)
{
        accion = 1;
	// Creamos el control XMLHttpRequest segun el navegador en el que estemos
	if( window.XMLHttpRequest )
		ajax = new XMLHttpRequest(); // No Internet Explorer
	else
		ajax = new ActiveXObject("Microsoft.XMLHTTP"); // Internet Explorer

	// Almacenamos en el control al funcion que se invocara cuando la peticion
	// cambie de estado
	ajax.onreadystatechange = funcionCallback;

	// Enviamos la peticion
	ajax.open( "GET", "<%=request.getContextPath()%>/AjaxServlet?idRegion="+idRegion+"&accion="+accion, true );
	ajax.send( "" );
}

function registrarCD()
{
        accion = 2;
	// Creamos el control XMLHttpRequest segun el navegador en el que estemos
	if( window.XMLHttpRequest )
		ajax = new XMLHttpRequest(); // No Internet Explorer
	else
		ajax = new ActiveXObject("Microsoft.XMLHTTP"); // Internet Explorer

	// Almacenamos en el control al funcion que se invocara cuando la peticion
	// cambie de estado
	ajax.onreadystatechange = funcionCallback;
        var idCD = document.getElementById("cd").value;
	// Enviamos la peticion
	ajax.open( "GET", "<%=request.getContextPath()%>/AjaxServlet?idCD="+idCD+"&accion="+accion, true );
	ajax.send( "" );
}
</script>



<table border="0" align="center" cellpadding="2" cellspacing="0">
  <tr>
    <td bgcolor="#262b54"><table border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
      <tr>
        <td valign="top" bgcolor="#FFFFFF"><img src="<%=request.getContextPath()%>/images/spacer.gif" width="44" height="45" /></td>
        <td align="right" valign="bottom" bgcolor="#FFFFFF">&nbsp;</td>
        <td bgcolor="#FFFFFF"><img src="<%=request.getContextPath()%>/images/spacer.gif" width="44" height="45" /></td>
      </tr>
      <tr>
        <td valign="top" bgcolor="#FFFFFF"><img src="<%=request.getContextPath()%>/images/spacer.gif" width="44" height="45" /></td>
        <td bgcolor="#383431"><table border="0" cellspacing="1" cellpadding="0">
          
          <tr>
            <td bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td colspan="2"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td background="<%=request.getContextPath()%>/images/bg_topinterna.gif"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td><img src="<%=request.getContextPath()%>/images/logo1_interna.gif" width="354" height="76" /></td>
                          <td><img src="<%=request.getContextPath()%>/images/spacer.gif" width="20" height="76" /></td>
                          <td align="right" valign="middle"><img src="<%=request.getContextPath()%>/images/logoBackusInterna.gif" alt="Backus" width="86" height="26" hspace="22" /></td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td background="<%=request.getContextPath()%>/images/bg_menutopinterna.gif"><table border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td><img src="<%=request.getContextPath()%>/images/logo2_internas.gif" width="118" height="64" /></td>
                          <td><a href="<%=request.getContextPath()%>/pages/est1.jsp"><img src="<%=request.getContextPath()%>/images/mnI_mod1.gif" name="mod1" width="92" height="64" border="0" id="mod1" /></a></td>
                          <td><img src="<%=request.getContextPath()%>/images/mnI_mod1_2.gif" name="mod1_2" width="19" height="64" id="mod1_2" /></td>
                          <td><a href="<%=request.getContextPath()%>/pages/est1.jsp"><img src="<%=request.getContextPath()%>/images/mnI_mod2.gif" name="mod2" width="106" height="64" border="0" id="mod2"/></a></td>
                          <td><img src="<%=request.getContextPath()%>/images/mnI_mod2_3.gif" name="mod2_3" width="19" height="64" id="mod2_3" /></td>
                          <td><a href="<%=request.getContextPath()%>/pages/est1.jsp"><img src="<%=request.getContextPath()%>/images/mnI_mod3.gif" name="mod3" width="102" height="64" border="0" id="mod3"/></a></td>
                          <td><img src="<%=request.getContextPath()%>/images/mnI_mod3_4.gif" name="mod3_4" width="20" height="64" id="mod3_4" /></td>
                          <td><a href="<%=request.getContextPath()%>/pages/est1.jsp"><img src="<%=request.getContextPath()%>/images/mnI_mod4.gif" name="mod4" width="71" height="64" border="0" id="mod4" /></a></td>
                          <td><img src="<%=request.getContextPath()%>/images/mnI_mod4_5.gif" name="mod4_5" width="19" height="64" id="mod4_5" /></td>
                          <td><a href="<%=request.getContextPath()%>/pages/est1.jsp"><img src="<%=request.getContextPath()%>/images/mnI_mod5.gif" name="mod5" width="109" height="64" border="0" id="mod5"/></a></td>
                        </tr>
                    </table></td>
                  </tr>
                </table></td>
                </tr>
              <tr>
                <td><img src="<%=request.getContextPath()%>/images/spacer.gif" width="165" height="4" /></td>
                <td><img src="<%=request.getContextPath()%>/images/spacer.gif" width="500" height="4" /></td>
              </tr>
              <tr>
                <td valign="top" class="menuizq"><br />
                  <ul>
                                <li class="menuizq"><a href="<%=request.getContextPath()%>/pages/login.jsp">Inicio</a></li>
                    <li class="menuizq"><a href="<%=request.getContextPath()%>/pages/intro.jsp">Introducci&oacute;n</a></li>
                    <li class="menuizq"><a href="<%=request.getContextPath()%>/pages/pautas.jsp">Pautas</a></li>
                    <li class="menuizq"><a href="<%=request.getContextPath()%>/pages/sistevaluacion.jsp">Sistema de Evaluaci&oacute;n</a></li>
                    <li class="menuizq"><a href="<%=request.getContextPath()%>/pages/revmodulos.jsp">Revisi&oacute;n de los M&oacute;dulos</a></li>
                    <li class="menuizq"><a href="<%=request.getContextPath()%>/pages/summary.jsp">Reportes </a></li>
                  </ul>
                  <br />
                  <br />                  <br />
                </td>
                <td valign="top"><table border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td><img src="<%=request.getContextPath()%>/images/spacer.gif" width="24" height="31" /></td>
                    <td><img src="<%=request.getContextPath()%>/images/spacer.gif" width="460" height="31" /></td>
                    <td><img src="<%=request.getContextPath()%>/images/spacer.gif" width="24" height="31" /></td>
                  </tr>
                  
                  <tr>
                      <form id="FrmBienvenida" name="FrmBienvenida" action=""  onsubmit="javascript:registrarCD(); return false;">
                    <td>&nbsp;</td>
                    <td valign="top"><table width="460" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td class="titulo">Bienvenido: ${usuario.nombre}</td>
                      </tr>
                      <tr>
                          <td class="texto">
                              <label>
                                  A continuación debe asignar el Centro de Distribución auditado.
                              </label>

                          </td>

                      </tr>
                      <tr>
                        <td bgcolor="#535891"><img src="<%=request.getContextPath()%>/images/spacer.gif" width="150" height="1" /></td>
                      </tr>
                      <tr>
                        <td class="texto"><img src="<%=request.getContextPath()%>/images/spacer.gif" width="71" height="10" /></td>
                      </tr>
                      <tr>
                          <td>
                              <table>
                                  <tr>
                                  <th align="left" valign="middle" scope="row">Region</th>
                                  <td align="left" valign="middle">
                                    <label>
                                        <select name="select" class="menuhome" id="region" onchange="cargarCD(this.value);">
                                        <option value="0" selected="selected">Seleccione</option>
                                        <c:if test="${listaRegiones != null}">
                                            <c:forEach var="region" items="${listaRegiones}">
                                                <option value="${region.idRegion}">${region.descripcion}</option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                  </label>
                                  </td>
                                  </tr>
                          </table></td>
                       </tr>
                        <tr>
                          <td>
                              <table>
                                  <tr>
                                  <th align="left" valign="middle" scope="row">Centro Distribucion</th>
                                  <td align="left" valign="middle">
                                    <label>
                                    <select name="select" class="menuhome" id="cd">
                                        <option value="0" selected="selected">Seleccione</option>
                                    </select>
                                  </label>
                                  </td>
                                  </tr>
                          </table></td>
                       </tr>
                      <tr>
                       <th colspan="1" scope="row">
                           <input type="Submit" name="button" id="button" value="Asignar Modulo!"
                                  />
                             </th>
                       </tr>
                      <tr>
                         <td class="texto">
                             <div id="mensaje">

                             </div>
                         </td>
                       </tr>
                        </table>                          
                          <p>&nbsp;</p>
                          </td>
                      </form>

                      </tr>
                    </table></td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td><img src="<%=request.getContextPath()%>/images/spacer.gif" width="24" height="25" /></td>
                    <td><h1>&nbsp;</h1></td>
                    <td><img src="<%=request.getContextPath()%>/images/spacer.gif" width="24" height="25" /></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td bgcolor="#FFFFFF"><img src="<%=request.getContextPath()%>/images/spacer.gif" width="44" height="45" /></td>
      </tr>
      <tr>
        <td colspan="3" valign="top" bgcolor="#FFFFFF"><img src="<%=request.getContextPath()%>/images/spacer.gif" width="174" height="32" /></td>
      </tr>
    </table>
</td>
  </tr>
</table>
</body>
</html>
