package guia05;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

public class Trabajo implements Contratable{
	private Instant inicioTrabajo;
	private Instant finTrabajo;
	private Trabajador trabajador;
	private Servicio servicio;
	
	
	public Trabajo(Instant inicioTrabajo, Instant finTrabajo, boolean urgente, Trabajador trabajador, Servicio servicio) {
		super();
		this.inicioTrabajo=inicioTrabajo;
		this.finTrabajo = finTrabajo;
		this.trabajador = trabajador;
		this.servicio = servicio;
	}
	
	public Instant getInicioTrabajo() {
		return inicioTrabajo;
	}
	
	public void setInicioTrabajo(Instant inicioTrabajo) {
		this.inicioTrabajo = inicioTrabajo;
	}
	
	public Instant getFinTrabajo() {
		return finTrabajo;
	}



	public void setFinTrabajo(Instant finTrabajo) {
		this.finTrabajo = finTrabajo;
	}


	public Trabajador getTrabajador() {
		return trabajador;
	}



	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}



	public Servicio getServicio() {
		return servicio;
	}



	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}



	@Override
	public double precio() {
		double valor;
		if (this.finalizado()) {
			valor=((Duration.between(inicioTrabajo, finTrabajo).toHours())*this.trabajador.getCosto_hora());
			return valor;
		}else {
		return (Duration.between(inicioTrabajo, Instant.now()).toHours())*this.trabajador.getCosto_hora();
		}
	}
	
	@Override
	public boolean finalizado() {
		if (this.finTrabajo.isAfter(Instant.now())) {
		return false;
		}else {
			return true;
		}
	}
	

}
