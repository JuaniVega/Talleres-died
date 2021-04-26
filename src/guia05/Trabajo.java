package guia05;

import java.time.Duration;
import java.time.Instant;

public class Trabajo implements Contratable{
	private Instant inicioTrabajo;
	private Instant finTrabajo;
	private Trabajador trabajador;
	private Servicio servicio;
	
	
	public Trabajo(Instant inicioTrabajo, boolean urgente, Trabajador trabajador, Servicio servicio) {
		super();
		this.inicioTrabajo=inicioTrabajo;
		this.finTrabajo = null;					//Al crear un trabajo, este no tiene fecha de finalizacion.
		this.trabajador = trabajador;
		this.servicio = servicio;
	}
	
	public Instant getInicioTrabajo() {
		return inicioTrabajo;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public Servicio getServicio() {
		return servicio;
	}
	
	public void definirFinTrabajo(Instant finTrabajo) {
		this.finTrabajo = finTrabajo;
	}

	//Segun mi interpretacion del enunciado, el trabajo comienza y termina en el mismo dia,
	//por lo tanto el calculo del costo se realiza calculando las horas trabajadas.
	
	@Override
	public double precio() {
		double valor;
		if (this.finalizado()) {
			valor=((Duration.between(inicioTrabajo, finTrabajo).toHours())*this.trabajador.getCosto_hora());		//Calcula el costo desde el inicio hasta el fin del trabajo.
			return valor;
		}else {
		return (Duration.between(inicioTrabajo, Instant.now()).toHours())*this.trabajador.getCosto_hora();			//El trabajo no esta finalizado, entonces se calcula el costo al momento.
		}
	}
	
	@Override
	public boolean finalizado() {
		if ((finTrabajo!=null) && (finTrabajo.isBefore(Instant.now()))) {
		return true;
		}else {
			return false;
		}
	}
	

}
