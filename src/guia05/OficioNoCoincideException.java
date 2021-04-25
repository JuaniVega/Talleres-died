package guia05;

public class OficioNoCoincideException extends Exception {

	public OficioNoCoincideException() {
		super("La tarea no se puede agregar porque el oficio no coincide.");
	}
	
	

}
