DROP DATABASE DBSGA;

CREATE DATABASE DBSGA;

USE DBSGA;

CREATE TABLE T_USUARIO (
  IN_IDUSUARIO INTEGER UNSIGNED  NOT NULL  ,
  VC_NOMBRE VARCHAR(30)  NULL  ,
  VC_LOGIN VARCHAR(30)  NULL  ,
  VC_PASSWORD VARCHAR(30)  NULL  ,
  IN_TIPO INTEGER UNSIGNED  NULL  ,
  IN_ESTADO INTEGER UNSIGNED  NULL    ,
PRIMARY KEY(IN_IDUSUARIO));



CREATE TABLE T_REGION (
  IN_IDREGION INTEGER  NOT NULL  ,
  VC_DESCRIPCION VARCHAR(50)  NULL    ,
PRIMARY KEY(IN_IDREGION));



CREATE TABLE T_MODULO (
  IN_IDMODULO INTEGER UNSIGNED  NOT NULL  ,
  VC_DESCRIPCION VARCHAR(50)  NULL    ,
PRIMARY KEY(IN_IDMODULO));



CREATE TABLE T_COMENTARIO (
  IN_IDCOMENTARIO INTEGER  NOT NULL  ,
  VC_DESCRIPCION VARCHAR(30)  NULL    ,
PRIMARY KEY(IN_IDCOMENTARIO));



CREATE TABLE T_AREA (
  IN_IDAREA INTEGER UNSIGNED  NOT NULL  ,
  IN_IDMODULO INTEGER UNSIGNED  NOT NULL  ,
  VC_DESCRIPCION VARCHAR(50) BINARY  NULL  ,
  IN_PESO INTEGER  NULL    ,
PRIMARY KEY(IN_IDAREA)  ,
INDEX T_AREA_FKIndex1(IN_IDMODULO),
  FOREIGN KEY(IN_IDMODULO)
    REFERENCES T_MODULO(IN_IDMODULO)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);



CREATE TABLE T_ESTANDAR (
  IN_IDESTANDAR INTEGER UNSIGNED  NOT NULL  ,
  IN_IDAREA INTEGER UNSIGNED  NULL  ,
  VC_DESCRIPCION VARCHAR(100)  NULL  ,
  IN_PESO INTEGER UNSIGNED  NULL    ,
PRIMARY KEY(IN_IDESTANDAR)  ,
INDEX T_ESTANDAR_FKIndex1(IN_IDAREA),
  FOREIGN KEY(IN_IDAREA)
    REFERENCES T_AREA(IN_IDAREA)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);



CREATE TABLE T_CENTRODIST (
  IN_IDCENTRODIST INTEGER UNSIGNED  NOT NULL  ,
  IN_IDREGION INTEGER  NULL  ,
  VC_DESCRIPCION VARCHAR(50)  NULL    ,
PRIMARY KEY(IN_IDCENTRODIST)  ,
INDEX T_CENTRODIST_FKIndex1(IN_IDREGION),
  FOREIGN KEY(IN_IDREGION)
    REFERENCES T_REGION(IN_IDREGION)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);



CREATE TABLE T_ESTANDARCOM (
  IN_IDCOMENTARIO INTEGER  NOT NULL  ,
  IN_IDESTANDAR INTEGER UNSIGNED  NOT NULL  ,
  VC_COMENTARIO VARCHAR(1000)  NULL    ,
PRIMARY KEY(IN_IDCOMENTARIO, IN_IDESTANDAR)  ,
INDEX T_ESTANDAR_has_T_COMENTARIO_FKIndex1(IN_IDESTANDAR)  ,
INDEX T_ESTANDAR_has_T_COMENTARIO_FKIndex2(IN_IDCOMENTARIO),
  FOREIGN KEY(IN_IDESTANDAR)
    REFERENCES T_ESTANDAR(IN_IDESTANDAR)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(IN_IDCOMENTARIO)
    REFERENCES T_COMENTARIO(IN_IDCOMENTARIO)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);



CREATE TABLE T_ENCUESTA (
  IN_IDENCUESTA INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  IN_IDMODULO INTEGER UNSIGNED  NOT NULL  ,
  IN_IDCENTRODIST INTEGER UNSIGNED  NOT NULL  ,
  IN_IDUSUARIO INTEGER UNSIGNED  NOT NULL  ,
  DT_FECHA DATE  NULL  ,
  IN_ESTADO INTEGER UNSIGNED  NULL    ,
PRIMARY KEY(IN_IDENCUESTA)  ,
INDEX T_ENCUESTA_FKIndex1(IN_IDUSUARIO)  ,
INDEX T_ENCUESTA_FKIndex2(IN_IDCENTRODIST)  ,
INDEX T_ENCUESTA_FKIndex3(IN_IDMODULO),
  FOREIGN KEY(IN_IDUSUARIO)
    REFERENCES T_USUARIO(IN_IDUSUARIO)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(IN_IDCENTRODIST)
    REFERENCES T_CENTRODIST(IN_IDCENTRODIST)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(IN_IDMODULO)
    REFERENCES T_MODULO(IN_IDMODULO)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);



CREATE TABLE T_ENCUESTADT (
  IN_IDESTANDAR INTEGER UNSIGNED  NOT NULL  ,
  IN_IDENCUESTA INTEGER UNSIGNED  NOT NULL  ,
  IN_CALIFICACION INTEGER UNSIGNED  NULL  ,
  VC_OBSERVACION VARCHAR(300)  NULL  ,
  VC_RECOMENDACION VARCHAR(300)  NULL    ,
PRIMARY KEY(IN_IDESTANDAR, IN_IDENCUESTA)  ,
INDEX T_ENCUESTA_has_T_ESTANDAR_FKIndex1(IN_IDENCUESTA)  ,
INDEX T_ENCUESTA_has_T_ESTANDAR_FKIndex2(IN_IDESTANDAR),
  FOREIGN KEY(IN_IDENCUESTA)
    REFERENCES T_ENCUESTA(IN_IDENCUESTA)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(IN_IDESTANDAR)
    REFERENCES T_ESTANDAR(IN_IDESTANDAR)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);


insert into t_region (in_idregion, vc_descripcion) values (1, 'Centro');
insert into t_region (in_idregion, vc_descripcion) values (2, 'Lima');
insert into t_region (in_idregion, vc_descripcion) values (3, 'Norte');
insert into t_region (in_idregion, vc_descripcion) values (4, 'Oriente');
insert into t_region (in_idregion, vc_descripcion) values (5, 'Sur');

insert into t_centrodist (in_idcentrodist, in_idregion, vc_descripcion) values (1, 1, 'CD Satipo');
insert into t_centrodist (in_idcentrodist, in_idregion, vc_descripcion) values (2, 1, 'CD Chanchamayo');
insert into t_centrodist (in_idcentrodist, in_idregion, vc_descripcion) values (3, 1, 'CD Tarma');
insert into t_centrodist (in_idcentrodist, in_idregion, vc_descripcion) values (4, 2, 'CD Callao');
insert into t_centrodist (in_idcentrodist, in_idregion, vc_descripcion) values (5, 2, 'CD Rimac');
insert into t_centrodist (in_idcentrodist, in_idregion, vc_descripcion) values (6, 2, 'CD Cono Sur');
insert into t_centrodist (in_idcentrodist, in_idregion, vc_descripcion) values (7, 3, 'CD Huaraz');
insert into t_centrodist (in_idcentrodist, in_idregion, vc_descripcion) values (8, 3, 'CD Trujillo');
insert into t_centrodist (in_idcentrodist, in_idregion, vc_descripcion) values (9, 3, 'CD Talara');
insert into t_centrodist (in_idcentrodist, in_idregion, vc_descripcion) values (10, 4, 'CD Pucallpa');
insert into t_centrodist (in_idcentrodist, in_idregion, vc_descripcion) values (11, 4, 'CD Iquitos');
insert into t_centrodist (in_idcentrodist, in_idregion, vc_descripcion) values (12, 4, 'CD Yurimaguas');
insert into t_centrodist (in_idcentrodist, in_idregion, vc_descripcion) values (13, 5, 'CD Tacna');
insert into t_centrodist (in_idcentrodist, in_idregion, vc_descripcion) values (14, 5, 'CD Ica');
insert into t_centrodist (in_idcentrodist, in_idregion, vc_descripcion) values (15, 5, 'CD Cuzco');

insert into t_modulo (in_idmodulo, vc_descripcion) values (1, 'Reparto');
insert into t_modulo (in_idmodulo, vc_descripcion) values (2, 'Reposicion y Almacenamiento');
insert into t_modulo (in_idmodulo, vc_descripcion) values (3, 'Mantenimiento de Flota');
insert into t_modulo (in_idmodulo, vc_descripcion) values (4, 'Gesgion de Centro de Distribucion');
insert into t_modulo (in_idmodulo, vc_descripcion) values (5, 'Evaluacion en el Mercado');

insert into t_area (in_idarea, in_idmodulo, vc_descripcion, in_peso) values (11, 1, 'Planificaci�n de la carga', 75);
insert into t_area (in_idarea, in_idmodulo, vc_descripcion, in_peso) values (21, 2, 'Administraci�n del stock', 93);
insert into t_area (in_idarea, in_idmodulo, vc_descripcion, in_peso) values (31, 3, 'Planificaci�n del  mantenimiento', 47);
insert into t_area (in_idarea, in_idmodulo, vc_descripcion, in_peso) values (41, 4, 'Desempe�o, desarrollo y satisfacci�n del personal', 60);
insert into t_area (in_idarea, in_idmodulo, vc_descripcion, in_peso) values (51, 5, 'Evaluaci�n del mercado', 100);

insert into t_estandar (in_idestandar, in_idarea, vc_descripcion, in_peso) values (1, 11, 'Informaci�n de Clientes y condiciones operativas', 14);
insert into t_estandar (in_idestandar, in_idarea, vc_descripcion, in_peso) values (2, 11, 'Optimizaci�n del Ruteo', 16);
insert into t_estandar (in_idestandar, in_idarea, vc_descripcion, in_peso) values (3, 11, 'Requisitos para la planificaci�n y control de la ejecuci�n del transporte secundario con Roadshow', 19);
insert into t_estandar (in_idestandar, in_idarea, vc_descripcion, in_peso) values (4, 11, 'Antig�edad del producto en el reparto', 13);
insert into t_estandar (in_idestandar, in_idarea, vc_descripcion, in_peso) values (5, 11, 'Calidad de Producto en el Reparto y el cliente', 13);

insert into t_estandar (in_idestandar, in_idarea, vc_descripcion, in_peso) values (20, 21, 'Registros y Controles de inventarios de Productos, Envases y Cajas Pl�sticas', 20);
insert into t_estandar (in_idestandar, in_idarea, vc_descripcion, in_peso) values (21, 21, 'Revisi�n y an�lisis de los Movimientos realizados semanalmente en el SAP', 20);
insert into t_estandar (in_idestandar, in_idarea, vc_descripcion, in_peso) values (22, 21, 'Registro y an�lisis de las Roturas y Faltantes de productos y envases originados en el almac�n', 21);
insert into t_estandar (in_idestandar, in_idarea, vc_descripcion, in_peso) values (23, 21, 'Envases adecuadamente clasificados', 18);
insert into t_estandar (in_idestandar, in_idarea, vc_descripcion, in_peso) values (24, 21, 'Calidad asegurada de los productos,  envases, cajas pl�sticas, empaques y parihuelas', 14);

insert into t_estandar (in_idestandar, in_idarea, vc_descripcion, in_peso) values (34, 31, 'Difusi�n y conocimiento del manual de flota', 8);
insert into t_estandar (in_idestandar, in_idarea, vc_descripcion, in_peso) values (35, 31, 'Cumplimiento del programa de mantenimiento', 9);
insert into t_estandar (in_idestandar, in_idarea, vc_descripcion, in_peso) values (36, 31, 'Inspecci�n diaria', 9);
insert into t_estandar (in_idestandar, in_idarea, vc_descripcion, in_peso) values (37, 31, 'Condici�n externa, interna y Logotipo de flota', 8);
insert into t_estandar (in_idestandar, in_idarea, vc_descripcion, in_peso) values (38, 31, 'Neum�ticos dados de baja prematuramente', 13);

insert into t_estandar (in_idestandar, in_idarea, vc_descripcion, in_peso) values (40, 41, 'Performance Management', 10);
insert into t_estandar (in_idestandar, in_idarea, vc_descripcion, in_peso) values (41, 41, 'Inducci�n,  Descripci�n de Funciones y Capacitaci�n', 10);
insert into t_estandar (in_idestandar, in_idarea, vc_descripcion, in_peso) values (42, 41, 'Satisfacci�n Organizacional', 16);
insert into t_estandar (in_idestandar, in_idarea, vc_descripcion, in_peso) values (43, 41, 'Gesti�n del programa de seguridad y salud en el trabajo', 15);
insert into t_estandar (in_idestandar, in_idarea, vc_descripcion, in_peso) values (44, 41, 'Plan de Contingencias y Registro de Accidentes e Incidentes', 9);

insert into t_estandar (in_idestandar, in_idarea, vc_descripcion, in_peso) values (53, 51, 'El personal de reparto entrega la cantidad exacta de productos pedidos en la preventa o televenta', 20);
insert into t_estandar (in_idestandar, in_idarea, vc_descripcion, in_peso) values (54, 51, 'El personal de reparto recoge los envases seg�n lo programado con el preventa o televenta', 20);
insert into t_estandar (in_idestandar, in_idarea, vc_descripcion, in_peso) values (55, 51, 'El personal de reparto es cort�s, amable, honrado, respetuoso y colaborador', 20);
insert into t_estandar (in_idestandar, in_idarea, vc_descripcion, in_peso) values (56, 51, 'El personal de reparto est� adecuadamente presentado e identificado', 20);
insert into t_estandar (in_idestandar, in_idarea, vc_descripcion, in_peso) values (57, 51, 'El personal de reparto verifica y entrega los documentos necesarios al cliente', 20);
