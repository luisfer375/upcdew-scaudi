package pe.com.backus.scaudi.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import pe.com.backus.scaudi.comun.Constantes;


/**
 * @author Juan Pablo Uribe
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Log {
	static String FQCN = Log.class.getName();
	public static Logger logger = Logger.getLogger(Log.class);
	static String debug = "N";
	static String info = "N";
	static String warn = "N";
	static String error = "N";
	
	static
	{
		try{				    
		    debug= Constantes.SI ;
		    info= Constantes.SI ;
		    warn= Constantes.NO ;
		    error= Constantes.SI ;
		}
		catch(Exception e){
			System.out.println("Error al cargar par�metros para el log");
		}

		
	}
	
	

	/**
	 * <b>Debug:</b>
	 * <br>
	 * El nivel DEBUG se utiliza para escribir mensajes de depuraci�n.
	 * @param message Mensaje a ser escrito en el log.
	 */
	public static void debug (Object message){
		if (debug.equals(Constantes.SI)) {
			logger.log(FQCN, Level.DEBUG, message, null);
		}
	}

	/**
 	 * <b>Debug:</b>
	 * <br>
	 * El nivel DEBUG se utiliza para escribir mensajes de depuraci�n.
	 * @param message Mensaje a ser escrito en el log.
	 * @param exception Excepcion a ser escrita en el log.
	 */
	public static void debug (Object message, Throwable exception){
		if (debug.equals(Constantes.SI)) {
			logger.log(FQCN, Level.DEBUG, message, exception);
		}
	}

	/**
	 * <b>Info:</b>
	 * <br>
	 * El nivel INFO est� asociado con eventos significativos en el ciclo de vida normal de la aplicaci�n
	 * @param message Mensaje a ser escrito en el log.
	 */
	public static void info(Object message){
		if (info.equals(Constantes.SI)) {
			logger.log(FQCN, Level.INFO, message, null);
		}
	}

	/**
	 * <b>Info:</b>
	 * <br>
	 * El nivel INFO est� asociado con eventos significativos en el ciclo de vida normal de la aplicaci�n
	 * @param message Mensaje a ser escrito en el log.
	 * @param exception Excepcion a ser escrita en el log.
	 */
	public static void info(Object message, Throwable exception){
		if (info.equals(Constantes.SI)) {
			logger.log(FQCN, Level.INFO, message, exception);
		}
	}

	/**
	 * <b>Warn:</b>
	 * <br>
	 * El nivel WARN se utiliza para mensajes de alerta sobre eventos que se desea mantener constancia,
	 * pero que no afectan el funcionamiento del programa.
	 * @param message Mensaje a ser escrito en el log.
	 */
	public static void warn(Object message){
		if (warn.equals(Constantes.SI)) {
			logger.log(FQCN, Level.WARN, message, null);
		}
	}

	/**
	 * <b>Warn:</b>
	 * <br>
	 * El nivel WARN se utiliza para mensajes de alerta sobre eventos que se desea mantener constancia,
	 * pero que no afectan el funcionamiento del programa.
	 * @param message Mensaje a ser escrito en el log.
	 * @param exception Excepcion a ser escrita en el log.
	 */
	public static void warn (Object message, Throwable exception){
		if (warn.equals(Constantes.SI)) {
			logger.log(FQCN, Level.INFO, message, exception);
		}
	}

	/**
	 * <b>Error:</b>
	 * <br>
	 * El nivel ERROR se utiliza generalmente para las excepciones.
	 * Las condiciones de error no necesariamente causan que la aplicaci�n deje de funcionar.
	 * @param message Mensaje a ser escrito en el log.
	 */
	public static void error (Object message){
		if (error.equals(Constantes.SI)) {
			logger.log(FQCN, Level.ERROR, message, null);
		}
	}

	/**
	 * <b>Error:</b>
	 * <br>
	 * El nivel ERROR se utiliza generalmente para las excepciones.
	 * Las condiciones de error no necesariamente causan que la aplicaci�n deje de funcionar.
	 * @param message Mensaje a ser escrito en el log.
	 * @param exception Excepcion a ser escrita en el log.
	 */
	public static void error (Object message, Throwable exception){
		if (error.equals(Constantes.SI)) {
			logger.log(FQCN, Level.ERROR, message, exception);
		}
	}

	/**
	 * <b>Fatal:</b>
	 * <br>
	 * El nivel FINAL se utiliza para mensajes cr�ticos del sistema, generalmente
	 * luego de guardar el mensaje el programa abortar�.
	 * @param message Mensaje a ser escrito en el log.
	 * @param exception Excepcion a ser escrita en el log.
	 */
	public static void fatal (Object message){
		logger.log(FQCN, Level.FATAL, message, null);
	}

	/**
	 * <b>Fatal:</b>
	 * <br>
	 * El nivel FINAL se utiliza para mensajes cr�ticos del sistema, generalmente
	 * luego de guardar el mensaje el programa abortar�.
	 * @param message Mensaje a ser escrito en el log.
	 * @param exception Excepcion a ser escrita en el log.
	 */
	public static void fatal (Object message, Throwable exception){
		logger.log(FQCN, Level.INFO, message, exception);
	}
}
