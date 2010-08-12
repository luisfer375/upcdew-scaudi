SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `DBSGA` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `DBSGA`;

-- -----------------------------------------------------
-- Table `DBSGA`.`Region`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBSGA`.`Region` (
  `idRegion` INTEGER NOT NULL ,
  `descripcionRegion` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idRegion`) )
ENGINE = InnoDB
COMMENT = 'Todas las regiones';


-- -----------------------------------------------------
-- Table `DBSGA`.`CD`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBSGA`.`CD` (
  `idCD` INTEGER NOT NULL ,
  `idRegion` INTEGER NOT NULL ,
  `descripcionCD` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idCD`) ,
  INDEX `fk_CD_Region` (`idRegion` ASC) ,
  CONSTRAINT `fk_CD_Region`
    FOREIGN KEY (`idRegion` )
    REFERENCES `DBSGA`.`Region` (`idRegion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'En esta tabla se encuentran los centros de Distribucin';


-- -----------------------------------------------------
-- Table `DBSGA`.`Estandar`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBSGA`.`Estandar` (
  `idModulo` INTEGER NOT NULL ,
  `nombreModulo` VARCHAR(45) NOT NULL ,
  `idMeta` INTEGER NOT NULL ,
  `nombreMeta` VARCHAR(45) NOT NULL ,
  `idEstandar` INTEGER NOT NULL ,
  `nombreEstandar` VARCHAR(45) NOT NULL ,
  `comentario` VARCHAR(8000) NULL ,
  `esPobre` VARCHAR(8000) NULL ,
  `esDebajoEstandar` VARCHAR(8000) NULL ,
  `esEstandar` VARCHAR(8000) NULL ,
  `esExcepcional` VARCHAR(8000) NULL ,
  `peso` INT NOT NULL ,
  PRIMARY KEY (`idEstandar`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBSGA`.`Usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBSGA`.`Usuario` (
  `idUsuario` INTEGER NOT NULL ,
  `nombre` VARCHAR(50) NOT NULL,
  `login` VARCHAR(20) NOT NULL ,
  `password` VARCHAR(45) NOT NULL ,
  `tipo` INT NOT NULL COMMENT 'Tipo: 1 Auditor\n2: Director' ,
  PRIMARY KEY (`idUsuario`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBSGA`.`Evaluacion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBSGA`.`Evaluacion` (
  `idCD` INTEGER NOT NULL  ,
  `periodo` INTEGER NOT NULL AUTO_INCREMENT,
  `idUsuario` INTEGER NOT NULL ,
  `PosiblePuntaje` INT NOT NULL ,
  INDEX `fk_Evaluacion_CD` (`idCD` ASC) ,
  INDEX `fk_Evaluacion_Usuario` (`idUsuario` ASC) ,
  PRIMARY KEY (`periodo`, `idCD`) ,
  CONSTRAINT `fk_Evaluacion_CD`
    FOREIGN KEY (`idCD` )
    REFERENCES `DBSGA`.`CD` (`idCD` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Evaluacion_Usuario`
    FOREIGN KEY (`idUsuario` )
    REFERENCES `DBSGA`.`Usuario` (`idUsuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBSGA`.`DetalleEvaluacion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `DBSGA`.`DetalleEvaluacion` (
  `idEstandar` INTEGER NOT NULL ,
  `periodo` INTEGER NULL ,
  `idCD` INTEGER NULL ,
  `puntaje` INT NOT NULL ,
  `observaciones` VARCHAR(300) NULL ,
  `oportunidades` VARCHAR(300) NULL ,
  INDEX `fk_DetalleEvaluacion_Estandar` (`idEstandar` ASC) ,
  PRIMARY KEY (`idEstandar`, `periodo`) ,
  INDEX `fk_DetalleEvaluacion_Evaluacion` (`periodo` ASC, `idCD` ASC) ,
  CONSTRAINT `fk_DetalleEvaluacion_Estandar`
    FOREIGN KEY (`idEstandar` )
    REFERENCES `DBSGA`.`Estandar` (`idEstandar` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DetalleEvaluacion_Evaluacion`
    FOREIGN KEY (`periodo` , `idCD` )
    REFERENCES `DBSGA`.`Evaluacion` (`periodo` , `idCD` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `DBSGA`;

-- -----------------------------------------------------
-- Data for table `DBSGA`.`CD`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
INSERT INTO `CD` (`idCD`, `idRegion`, `descripcionCD`) VALUES (1, 2, 'CD Ate');
INSERT INTO `CD` (`idCD`, `idRegion`, `descripcionCD`) VALUES (2, 1, 'CD Comas');
INSERT INTO `CD` (`idCD`, `idRegion`, `descripcionCD`) VALUES (3, 3, 'CD Pucallpa');
INSERT INTO `CD` (`idCD`, `idRegion`, `descripcionCD`) VALUES (4, 1, 'CD Cono Sur');
INSERT INTO `CD` (`idCD`, `idRegion`, `descripcionCD`) VALUES (5, 4, 'CD Cusco');
INSERT INTO `CD` (`idCD`, `idRegion`, `descripcionCD`) VALUES (6, 5, 'CD Piura');
INSERT INTO `CD` (`idCD`, `idRegion`, `descripcionCD`) VALUES (7, 5, 'CD Motupe');
INSERT INTO `CD` (`idCD`, `idRegion`, `descripcionCD`) VALUES (8, 4, 'CD Arequipa');
INSERT INTO `CD` (`idCD`, `idRegion`, `descripcionCD`) VALUES (9, 2, 'CD Jauja');
INSERT INTO `CD` (`idCD`, `idRegion`, `descripcionCD`) VALUES (10, 2, 'CD Huancayo');

COMMIT;

-- -----------------------------------------------------
-- Data for table `DBSGA`.`Region`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
INSERT INTO `Region` (`idRegion`, `descripcionRegion`) VALUES (1, 'Lima');
INSERT INTO `Region` (`idRegion`, `descripcionRegion`) VALUES (2, 'Ate Centro');
INSERT INTO `Region` (`idRegion`, `descripcionRegion`) VALUES (3, 'Oriente');
INSERT INTO `Region` (`idRegion`, `descripcionRegion`) VALUES (4, 'Sur');
INSERT INTO `Region` (`idRegion`, `descripcionRegion`) VALUES (5, 'Norte');

COMMIT;

-- -----------------------------------------------------
-- Data for table `DBSGA`.`Estandar`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
INSERT INTO `Estandar` (`idModulo`, `nombreModulo`, `idMeta`, `nombreMeta`, `idEstandar`, `nombreEstandar`, `Comentario`, `esPobre`, `esDebajoEstandar`, `esEstandar`, `esExcepcional`, `peso`) VALUES (1, 'Reparto', 1, 'Gestión de Clientes y Reparto ', 1, 'Gestion de Reclamos ', '<div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; color: black\"><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; color: black\">El objetivo de este est&aacute;ndar es dar soluci&oacute;n oportuna y efectiva a los reclamos de nuestros clientes, identificando acciones preventivas y correctivas, que nos permitan mejorar nuestra gesti&oacute;n.</span></div><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; color: black\">El cliente debe ser informado acerca del n&uacute;mero telef&oacute;nico de la Central de Atenci&oacute;n de Servicio al Cliente (0-800-1-9999) ya sea a trav&eacute;s de stickers, circulares a los clientes detallistas, d&iacute;pticos o a trav&eacute;s de la comunicaci&oacute;n directa del personal de reparto, incentivando permanentemente el uso de este canal de comunicaci&oacute;n.</span></div></span></div>', '<ol><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line\">El indicador acumulado % de Efectividad de Soluci&oacute;n se encuentra en promedio en: X&nbsp;&lt;= 90%</span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line\">El indicador acumulado % de Soluci&oacute;n en 48 hrs. se encuentra en promedio en: X&nbsp;&lt;= 90%</span></div></li><li><span style=\"font-size: 8pt; color: black\">Dos o m&aacute;s veces en el que el Supervisor de Distribuci&oacute;n no reenv&iacute;o a la Central de Servicio al Cliente el formato consolidado de reclamos.</span></li></ol>', '<ol><li><span style=\"font-size: 8pt; layout-grid-mode: line\">El indicador acumulado % de Efectividad de Soluci&oacute;n se encuentra en promedio entre: 90%&nbsp;&lt; X&nbsp;&lt;= 95%</span></li><li><span style=\"font-size: 8pt; layout-grid-mode: line\">El indicador acumulado % de Soluci&oacute;n en 48 hrs. se encuentra en promedio entre: 90%&nbsp;&lt; X&nbsp;&lt;= 95%</span></li><li><span style=\"font-size: 8pt; color: black\">Al menos una vez en el que el Supervisor de Distribuci&oacute;n no reenv&iacute;o a la Central de Servicio al Cliente el formato consolidado de reclamos.</span></li><li><span style=\"font-size: 8pt; color: black\">Los reclamos recurrentes no son analizados y/o enviados al Gerente mensualmente por: clientes, tipificaci&oacute;n de llamadas y unidades de reparto (placas) y/o no se evidencian acciones de mejora: an&aacute;lisis de situaci&oacute;n inicial, acciones/estrategias e impacto.</span></li></ol>', '<ol><li><span style=\"font-size: 8pt; layout-grid-mode: line\">El indicador acumulado % de Efectividad de Soluci&oacute;n se encuentra en promedio entre: 95%&nbsp;&lt; X&nbsp;&lt;= 99%</span></li><li><span style=\"font-size: 8pt; layout-grid-mode: line\">El indicador acumulado % de Soluci&oacute;n en 48 hrs. se encuentra en promedio entre: 95%&nbsp;&lt; X&nbsp;&lt;= 99%</span></li><li><span style=\"font-size: 8pt; color: black\">El Supervisor de Distribuci&oacute;n reenv&iacute;a a la Central de Servicio al Cliente todos los martes el formato consolidado con los reclamos recibidos durante la semana.</span></li><li><span style=\"font-size: 8pt; color: black\">L</span><span style=\"font-size: 8pt; color: black\">os reclamos recurrentes son analizados y enviados mensualmente al Gerente por: clientes, tipificaci&oacute;n de llamadas y unidades de reparto (placas) y se evidencian acciones de mejora: an&aacute;lisis de situaci&oacute;n inicial, acciones/estrategias e impacto.</span></li><li><span style=\"font-size: 8pt; color: black\">Se evidencia gesti&oacute;n para fomentar el uso del sistema de reclamos por los clientes.</span></li></ol>', '<ol><li><div><span style=\"font-size: 8pt; layout-grid-mode: line\">El indicador acumulado % de Efectividad de Soluci&oacute;n se encuentra en promedio en: X &gt; 99%</span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line\">El indicador acumulado % de Soluci&oacute;n en 48 hrs. se encuentra en promedio en: X &gt; 99%</span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; color: black\">Se evidencian acciones espec&iacute;ficas (impacto) orientadas a disminuir/eliminar los reclamos por tipificaci&oacute;n de llamada: Actitud descort&eacute;s hacia el cliente.</span></div></li><li><div><span style=\"font-size: 8pt; layout-grid-mode: line; color: black\">Todo el personal conoce y entiende los aspectos del sistema de reclamos y su impacto en el negocio.</span></div></li></ol>', 1);
INSERT INTO `Estandar` (`idModulo`, `nombreModulo`, `idMeta`, `nombreMeta`, `idEstandar`, `nombreEstandar`, `Comentario`, `esPobre`, `esDebajoEstandar`, `esEstandar`, `esExcepcional`, `peso`) VALUES (1, 'Reparto', 1, 'Gestión de Clientes y Reparto ', 2, 'Efectividad de Reparto ', '<div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; color: black\"><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; color: black\">El retorno de producto terminado es costoso y perjudica el servicio. A menudo es ocasionado por errores en pedidos, errores en la carga de productos o por problemas relacionados con la calidad de producto. </span></div><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; color: black\">Se debe de minimizar los clientes no atendidos (los que no recibieron producto) en la operaci&oacute;n de reparto. </span></div><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; color: black\">Todos los esfuerzos deben estar orientados a lograr altos niveles de efectividad de reparto (correcto SKU, correcta cantidad y correcta calidad).</span></div><span style=\"font-size: 8pt; color: black\">Por otro lado demasiados envases en el mercado causan congesti&oacute;n, agotan el capital activo en el mercado, y dan como resultado paradas en la l&iacute;nea de envasado, generando mayor inversi&oacute;n en botellas. El recojo r&aacute;pido de envases reduce la demanda de botellas y mejoran el Nivel de Servicio al cliente.&nbsp;&nbsp;&nbsp; </span></span></div>', '<ol><li><span style=\"font-size: 8pt; color: black\">Se evidencian dos o mas casos en los que no se monitore&oacute; y/o envi&oacute; al Supervisor de Ventas los indicadores Efectividad de Reparto (Cjs. F&iacute;sicas) y/o Recojo de Envases (Cjs. F&iacute;sicas) as&iacute; como los motivos de no entrega y/o no recojo.</span></li><li><span style=\"font-size: 8pt; color: black\">El indicador Efectividad de Reparto (Cjs. F&iacute;sicas) se encuentra en promedio en: X &lt;= 92%</span></li><li><span style=\"font-size: 8pt; color: black\">El indicador Efectividad de Recojo de Envases (Cjs. F&iacute;sicas) se encuentra en promedio en: X &lt;= 92%</span></li></ol>', '<ol><li><span style=\"font-size: 8pt; color: black\">Se evidencia un caso en el que no se monitore&oacute; y/o envi&oacute; al Supervisor de Ventas los indicadores Efectividad de Reparto (Cjs. F&iacute;sicas) y/o Recojo de Envases (Cjs. F&iacute;sicas) as&iacute; como los motivos de no entrega y/o no recojo.</span></li><li><span style=\"font-size: 8pt; color: black\">El indicador Efectividad de Reparto (Cjs. F&iacute;sicas) se encuentra en promedio entre: 92% &lt; X &lt;= 95%</span></li><li><span style=\"font-size: 8pt; color: black\">El indicador Efectividad de Recojo de Envases (Cjs. F&iacute;sicas) se encuentra en promedio entre: 92% &lt; X &lt;= 95%</span></li></ol>', '<ol><li><span style=\"font-size: 8pt; color: black\">Diariamente se monitorea y env&iacute;a al Supervisor de Ventas los indicadores Efectividad de Reparto (Cjs. F&iacute;sicas) y Recojo de Envases (Cjs. F&iacute;sicas) as&iacute; como los motivos de no entrega y no recojo.</span></li><li><span style=\"font-size: 8pt; color: black\">El indicador Efectividad de Reparto (Cjs. F&iacute;sicas) se encuentra en promedio entre: 95% &lt; X &lt;= 97%</span></li><li><span style=\"font-size: 8pt; color: black\">El indicador Efectividad de Recojo de Envases (Cjs. F&iacute;sicas) se encuentra en promedio entre: 95% &lt; X &lt;= 97%</span></li></ol>', '<ol><li><span style=\"font-size: 8pt; color: black\">El Indicador Efectividad de Reparto (Cjs. F&iacute;sicas) se encuentra en promedio en: X&nbsp;&gt;&nbsp;97%</span></li><li><span style=\"font-size: 8pt; color: black\">El Indicador Efectividad de Recojo de Envases (Cjs. F&iacute;sicas) se encuentra en promedio en: X&nbsp;&gt;&nbsp;97%</span></li><li><span style=\"font-size: 8pt; color: black\">Se evidencia 3 acciones (por cada uno de los 2 indicadores) acordadas y realizadas con ventas que redujeron efectivamente la cantidad de rechazos y mejoran la efectividad de recojo de envases.</span></li><li><span style=\"font-size: 8pt; layout-grid-mode: line\"><span style=\"color: black\">El Supervisor y Asistente de Distribuci&oacute;n conocen y entienden el Est&aacute;ndar y saben cual es su impacto en el negocio.</span></span></li></ol>', 1);
INSERT INTO `Estandar` (`idModulo`, `nombreModulo`, `idMeta`, `nombreMeta`, `idEstandar`, `nombreEstandar`, `Comentario`, `esPobre`, `esDebajoEstandar`, `esEstandar`, `esExcepcional`, `peso`) VALUES (1, 'Reparto', 1, 'Gestión de Clientes y Reparto ', 3, 'Gestin del Stock Out en el Punto de Venta ', '<div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt\">Stock Out es la falta de alguna de las marcas de nuestro portafolio en cualquier punto de venta del pa&iacute;s.</span></div><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt\">Un adecuado manejo de stocks en el Punto de Venta garantiza: </span><span style=\"font-size: 8pt\">Una mejor satisfacci&oacute;n de nuestros clientes, un mayor volumen de ventas para nuestros clientes, reducci&oacute;n en la prueba de productos de la competencia y mayor participaci&oacute;n de mercado.</span></div>', '<ol><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line\">Dos o m&aacute;s d&iacute;as en el que no se midi&oacute; el Stock Out en el Punto de Venta (OOS &ndash; POS) con respecto a las tres principales marcas y/o los reportes consolidados no fueron enviados de forma diaria o semanal a las Gerencias de Ventas o Distribuci&oacute;n (Solo de forma semanal a Supply Chain).</span></div></li></ol>', '<ol><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line\">Al menos un dia en el que no se mide el Stock Out en el Punto de Venta (OOS &ndash; POS) con respecto a las tres principales marcas y/o los reportes consolidados no fueron enviados de forma diaria o semanal a las Gerencias de Ventas o Distribuci&oacute;n (Solo de forma semanal a Supply Chain).</span></div></li><li><span style=\"font-size: 8pt; layout-grid-mode: line\">No se evidencian reuniones semanales, an&aacute;lisis y/o acciones de mejora coordinadas con Ventas en base a los resultados obtenidos de las encuestas de Stock Out del reparto o de CCR (donde aplique) </span></li></ol>', '<ol><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line\">Se mide el Stock Out en el Punto de Venta (OOS &ndash; POS) de forma diaria con respecto a las tres principales marcas y los reportes consolidados son enviados de forma diaria y semanal a las Gerencias de Ventas y Distribuci&oacute;n (Solo de forma semanal a Supply Chain).</span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line\">Se evidencian reuniones semanales, an&aacute;lisis y acciones de mejora coordinadas con Ventas en base a los resultados obtenidos de las encuestas de Stock Out del reparto o de CCR (donde aplique) </span></div></li><li><span style=\"font-size: 8pt; layout-grid-mode: line\">Se evidencia tendencia a la mejora en el indicador Stock Out en el Punto de Venta (OOS &ndash; POS), tanto para la encuesta del reparto como la de CCR (donde aplique).</span></li></ol>', '<ol><li><div><span style=\"font-size: 8pt; layout-grid-mode: line\">Se detecta a los clientes recurrentes con Stock Out,&nbsp;los mismos que son ubicados en el plano (mapinfo) y se evidencia haber implementado soluciones en estos clientes en coordinaci&oacute;n con Ventas. (Se evidencia mails mensuales enviados a Ventas con el mapa y las acciones definidas).</span></div></li><li><div><span style=\"font-size: 8pt; layout-grid-mode: line\">Sen analizan los clientes recurrentes con Stock Out en el POS mes a mes.</span></div></li><li><div><span style=\"font-size: 8pt; layout-grid-mode: line; color: black\">Todo el personal conoce y entiende la importancia de reducir el Stock Out en los Puntos de Venta.</span></div></li></ol><div>&nbsp;</div>', 1);
INSERT INTO `Estandar` (`idModulo`, `nombreModulo`, `idMeta`, `nombreMeta`, `idEstandar`, `nombreEstandar`, `Comentario`, `esPobre`, `esDebajoEstandar`, `esEstandar`, `esExcepcional`, `peso`) VALUES (1, 'Reparto', 1, 'Gestión de Clientes y Reparto ', 4, 'Desarrollo de Empresarios de Reparto ', '<div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line; color: black\">El Informe Semestral de an&aacute;lisis de costos y comisiones de repartos, nos permite revisar la estructura de costos y gastos reales y la compara con la comisi&oacute;n vigente y el volumen de cajas de reparto, de acuerdo al &aacute;rea geogr&aacute;fica en que opera, a fin de verificar si la comisi&oacute;n vigente cubre o no los gastos del Reparto. Con esto aseguramos siempre velar por que ellos no se vean afectados.</span></div><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line; color: black\">As&iacute; mismo debemos garantizar la asignaci&oacute;n equitativa de la carga diaria de las unidades de reparto.</span></div>', '<ol><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line; color: black\">Dos o m&aacute;s modificaciones a las comisiones de reparto no cuentan con la aprobaci&oacute;n (firma) del Gerente o Director Regional.</span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line; color: black\">Se dispone de personal de reparto temporal (empleo estacional o peri&oacute;dico) y este es: X&nbsp;&gt; 15% del personal permanente. </span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line; color: black\">Dos o m&aacute;s personas de reparto que no han recibido la inducci&oacute;n dentro de los primeros 15 d&iacute;as despu&eacute;s de su ingreso.</span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line; color: black\">No se evidencia el conocimiento y uso del portal de personal desvinculado o se evidencia que se han registrado ingresos de personal que se encuentra en la base de datos</span></div></li></ol>', '<ol><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line; color: black\">Una modificaci&oacute;n a las comisiones de reparto no cuenta con la aprobaci&oacute;n (firma) del Gerente o Director Regional.</span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line; color: black\">Se evidencia que las comisiones de reparto facturadas en el mes no coinciden con el reporte de pago de comisiones del Business, con las comisiones aprobadas o con los contratos entre el CD y empresarios.</span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line; color: black\">Se dispone de personal temporal (empleo estacional o peri&oacute;dico) y este se encuentra: 10% &lt; X &lt;= 15% del personal permanente. </span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line; color: black\">Al menos una persona de reparto que no ha recibido la inducci&oacute;n dentro de los primeros 15 d&iacute;as despu&eacute;s de su ingreso.</span></div></li></ol>', '<p><span style=\"font-size: 8pt; layout-grid-mode: line; color: black\"><ol><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line; color: black\">Toda modificaci&oacute;n a las comisiones de reparto cuentan con la aprobaci&oacute;n (firma) del Gerente y Director Regional. </span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line; color: black\">Las comisiones de reparto facturadas en el mes coinciden con el reporte de pago de comisiones del Business, con las comisiones aprobadas y con los contratos entre el CD y empresarios.</span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line; color: black\">Se revisa semanal y mensualmente&nbsp;la asignaci&oacute;n de carga e ingreso por las empresas de reparto&nbsp;y estas son aprobadas por el Gerente de Distribuci&oacute;n.</span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line; color: black\">Todo el personal de las empresas de reparto se encuentra en planilla (a excepci&oacute;n de los temporales). Se cuenta con la siguiente informaci&oacute;n: pagos de&nbsp;planillas electr&oacute;nicas mensuales, certificados de antecedentes policiales (en el caso del personal temporal el documento es obligatorio).</span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line; color: black\">Se dispone de personal temporal (empleo estacional o peri&oacute;dico) y este se encuentra: 5% &lt; X &lt;= 10% del personal permanente. </span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line; color: black\">Se evidencia inducci&oacute;n a todo el personal de reparto dentro de los primeros 15 d&iacute;as despu&eacute;s de su ingreso (temas sugeridos: &ldquo;Servicio al Cliente&rdquo;, &ldquo;Portafolio de Marcas&rdquo;, &ldquo;Clasificaci&oacute;n adecuada de envases&rdquo;, &ldquo;Aseguramiento de la limpieza de unidades de reparto&rdquo; y &ldquo;Rotaci&oacute;n de producto&rdquo;).</span></div></li></ol></span></p>', '<ol><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line; color: black\">Se evidencian tres acciones desde la &uacute;ltima Red orientadas al desarrollo de los empresarios de reparto a fin de optimizar los costos de las comisiones de reparto (reducci&oacute;n de consumo de combustible, mayor rendimiento de combustible, reducci&oacute;n de mermas, compras a escala, control de gastos varios, etc.)</span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line; color: black\">Se dispone de personal temporal (empleo estacional o peri&oacute;dico) y este es: X &lt;= 5% del personal permanente. </span></div></li><li><span style=\"font-size: 8pt; layout-grid-mode: line; color: black\">El Supervisor y Asistente de Distribuci&oacute;n conocen y entienden el Est&aacute;ndar y saben cual es su impacto en el negocio.</span></li></ol>', 1);
INSERT INTO `Estandar` (`idModulo`, `nombreModulo`, `idMeta`, `nombreMeta`, `idEstandar`, `nombreEstandar`, `Comentario`, `esPobre`, `esDebajoEstandar`, `esEstandar`, `esExcepcional`, `peso`) VALUES (1, 'Reparto', 1, 'Gestión de Clientes y Reparto ', 5, 'Desempeo del Reparto ', '<div style=\"margin: 1pt 0cm 0pt 1.7pt\"><span style=\"font-size: 8pt; color: black\"><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; color: black\"><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; color: black\">El personal de reparto (propio o tercero) debe de estar informado sobre la contribuci&oacute;n e importancia que desempe&ntilde;an en la calidad de servicio que brindan a nuestros clientes en el POS. Por otro lado, con la finalidad de mantener un desempe&ntilde;o sostenido de clase mundial es necesario definir las metas a corto plazo y tener el feedback de nuestros clientes es de suma importancia.</span></div><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; color: black\">La Gerencia debe validar las metas del indicador de efectividad de reparto, de recojo de envases y tiempo de recarga, seg&uacute;n la realidad de cada Centro de Distribuci&oacute;n.</span></div><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; color: black\">As&iacute; mismo cabe resaltar que la imagen de la empresa se soporta en la adecuada presentaci&oacute;n del personal de reparto y en la limpieza de nuestra flota, por lo que es importante garantizar el cumplimiento de las directivas definidas por la organizaci&oacute;n en este aspecto.</span></div></span></div></span></div>', '<ol><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; color: black\">Dos o mas personas de reparto no conocen o entienden los indicadores claves definidos por el CD de acuerdo a su realidad/prioridad (como m&iacute;nimo 3 indicadores)</span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; color: black\">Dos o m&aacute;s responsables de reparto no conocen las metas, el desempe&ntilde;o (de su unidad), y/o no realizan an&aacute;lisis de causas y/o acciones de mejora.</span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; color: black\">Solo se evidencia una capacitaci&oacute;n por trimestre del a&ntilde;o fiscal al personal de reparto en los temas: &ldquo;Servicio al Cliente&rdquo; &ldquo;Portafolio de Marcas&rdquo;, &ldquo;Clasificaci&oacute;n adecuada de envases&rdquo; y &ldquo;Aseguramiento de la limpieza de unidades de reparto&rdquo;.</span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line\">Dos o m&aacute;s personas de reparto que no conocen los procedimientos y/o el uso del Hand Held (HH).</span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; color: black\">Dos o m&aacute;s personas de reparto no utilizan uniformes y/o botines/zapatos (no zapatillas) y/o estos no se encuentran en buenas condiciones.</span></div></li></ol>', '<ol><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; color: black\">Al menos una persona de reparto que no conoce o entiende los indicadores claves definidos por el CD de acuerdo a su realidad/prioridad (como m&iacute;nimo 3 indicadores)</span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; color: black\">Al menos un responsable de unidad (el reparto) no conoce las metas, el desempe&ntilde;o (de su unidad) y/o no realizan an&aacute;lisis de causas y/o acciones de mejora.</span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; color: black\">Se evidencian dos capacitaciones por trimestre del a&ntilde;o fiscal al personal de reparto en los temas: &ldquo;Servicio al Cliente&rdquo; &ldquo;Portafolio de Marcas&rdquo;, &ldquo;Clasificaci&oacute;n adecuada de envases&rdquo; y &ldquo;Aseguramiento de la limpieza de unidades de reparto&rdquo;.</span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line\">No se evidencia la difusi&oacute;n permanente del desempe&ntilde;o de los indicadores y reuniones peri&oacute;dicas (diarias, semanales, mensuales) con el personal de reparto/empresarios para analizar la situaci&oacute;n y definir acciones de mejora en los procesos de Distribuci&oacute;n.</span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line\">Al menos una persona de reparto no conoce los procedimientos y/o el uso del Hand Held (HH).</span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; color: black\">Al menos una persona de reparto no utiliza uniformes y/o botines/zapatos (no zapatillas) y/o estos no se encuentran en buenas condiciones.</span></div></li></ol>', '<ol><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; color: black\">Se evidencia que la tripulaci&oacute;n de reparto conoce y entiende los indicadores claves definidos por el CD de acuerdo a su realidad/prioridad (como m&iacute;nimo 3 indicadores)</span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; color: black\">Se evidencia que el responsable de la unidad (el reparto), conoce las metas, el desempe&ntilde;o (de su unidad), el an&aacute;lisis de causas y las acciones de mejora que se han tomado para mejorar el desempe&ntilde;o.</span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; color: black\">Se evidencian como m&iacute;nimo tres capacitaciones por trimestre del a&ntilde;o fiscal al personal de reparto en los temas: &ldquo;Servicio al Cliente&rdquo; &ldquo;Portafolio de Marcas&rdquo;, &ldquo;Clasificaci&oacute;n adecuada de envases&rdquo; y &ldquo;Aseguramiento de la limpieza de unidades de reparto&rdquo;, &ldquo;Rotaci&oacute;n de producto&rdquo;.</span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; color: black\">4. </span><span style=\"font-size: 8pt; layout-grid-mode: line\">Se evidencia la difusi&oacute;n permanente del desempe&ntilde;o de los indicadores y reuniones peri&oacute;dicas (diarias, semanales, mensuales) con el personal de reparto/empresarios para analizar la situaci&oacute;n y definir acciones de mejora en los procesos de Distribuci&oacute;n.</span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; layout-grid-mode: line\">5. Se evidencia que todo el personal de reparto conoce los procedimientos y el uso del Hand Held (HH).</span></div></li><li><span style=\"font-size: 8pt; layout-grid-mode: line\">6.</span><span style=\"font-size: 8pt; color: black\"> Todo el personal de reparto (tripulaci&oacute;n) utiliza uniformes y botines/zapatos (no zapatillas) y estos se encuentran en buenas condiciones.</span></li></ol>', '<ol><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; color: black\">Se evidencia que producto del an&aacute;lisis y reuniones entre el Supervisor de Distribuci&oacute;n y el personal de reparto se ha logrado mejorar el desempe&ntilde;o del CD.</span></div></li><li><div style=\"margin: 1pt 0cm 0pt\"><span style=\"font-size: 8pt; color: black\">Se evidencian cuatro o mas capacitaciones por trimestre del a&ntilde;o fiscal al personal de reparto en los temas: &ldquo;Servicio al Cliente&rdquo; &ldquo;Portafolio de Marcas&rdquo;, &ldquo;Clasificaci&oacute;n adecuada de envases&rdquo; y &ldquo;Aseguramiento de la limpieza de unidades de reparto&rdquo;.</span></div></li><li><span style=\"font-size: 8pt; color: black\">El Uniforme del personal de reparto permite identificar a la persona y a la empresa en que trabaja (para que en caso de reclamos el cliente pueda identificar a la persona f&aacute;cilmente).</span></li></ol>', 1);

COMMIT;

-- -----------------------------------------------------
-- Data for table `DBSGA`.`Evaluacion`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
INSERT INTO `Evaluacion` (`idCD`, `periodo`, `idUsuario`, `PosiblePuntaje`) VALUES (1, 2, 1, 2);
INSERT INTO `Evaluacion` (`idCD`, `periodo`, `idUsuario`, `PosiblePuntaje`) VALUES (2, 2, 2, 3);

COMMIT;

-- -----------------------------------------------------
-- Data for table `DBSGA`.`DetalleEvaluacion`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
INSERT INTO `DetalleEvaluacion` (`idEstandar`, `periodo`, `idCD`, `puntaje`, `observaciones`, `oportunidades`) VALUES (1, 1, 1, 1, '', '');
INSERT INTO `DetalleEvaluacion` (`idEstandar`, `periodo`, `idCD`, `puntaje`, `observaciones`, `oportunidades`) VALUES (1, 2, 1, 0, '', '');
INSERT INTO `DetalleEvaluacion` (`idEstandar`, `periodo`, `idCD`, `puntaje`, `observaciones`, `oportunidades`) VALUES (2, 1, 1, 1, '', '');
INSERT INTO `DetalleEvaluacion` (`idEstandar`, `periodo`, `idCD`, `puntaje`, `observaciones`, `oportunidades`) VALUES (2, 2, 1, 1, '', '');
INSERT INTO `DetalleEvaluacion` (`idEstandar`, `periodo`, `idCD`, `puntaje`, `observaciones`, `oportunidades`) VALUES (3, 1, 1, 1, '', '');
INSERT INTO `DetalleEvaluacion` (`idEstandar`, `periodo`, `idCD`, `puntaje`, `observaciones`, `oportunidades`) VALUES (3, 2, 1, 0, '', '');
INSERT INTO `DetalleEvaluacion` (`idEstandar`, `periodo`, `idCD`, `puntaje`, `observaciones`, `oportunidades`) VALUES (4, 1, 1, 0, '', '');
INSERT INTO `DetalleEvaluacion` (`idEstandar`, `periodo`, `idCD`, `puntaje`, `observaciones`, `oportunidades`) VALUES (4, 2, 1, 1, '', '');
INSERT INTO `DetalleEvaluacion` (`idEstandar`, `periodo`, `idCD`, `puntaje`, `observaciones`, `oportunidades`) VALUES (5, 1, 1, 0, '', '');
INSERT INTO `DetalleEvaluacion` (`idEstandar`, `periodo`, `idCD`, `puntaje`, `observaciones`, `oportunidades`) VALUES (5, 2, 1, 1, '', '');

COMMIT;

-- -----------------------------------------------------
-- Data for table `DBSGA`.`Usuario`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
INSERT INTO `Usuario` (`idUsuario`, `nombre`,  `login`, `password`, `tipo`) VALUES (1, 'Erick Tapia', 'etapia', '123456', 1);
INSERT INTO `Usuario` (`idUsuario`, `nombre`, `login`, `password`, `tipo`) VALUES (2, 'Jossymar Cabanillas', 'jcabanillas', '123456', 1);
INSERT INTO `Usuario` (`idUsuario`, `nombre`, `login`, `password`, `tipo`) VALUES (3, 'Jorge Cortez', 'jcortez', '123456', 2);

COMMIT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;