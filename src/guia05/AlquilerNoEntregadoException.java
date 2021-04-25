package guia05;

public class AlquilerNoEntregadoException extends Exception {

	public AlquilerNoEntregadoException() {
		super("Tiene 2 alquileres sin devolver. Devuelvalos y vuelva a intentar.");
	}
	
	

}
