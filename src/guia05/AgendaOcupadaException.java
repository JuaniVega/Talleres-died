package guia05;

public class AgendaOcupadaException extends Exception {

	public AgendaOcupadaException() {
		super("La tarea no puede ser agregada porque la fecha no esta disponible.");
	}

	
}
