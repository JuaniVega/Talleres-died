package guia05;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

public class Alquiler implements Contratable {
	private Herramienta herramienta;
	private Instant inicio;
	private Instant fin_acordado;
	private Instant fin_real=null;

	
	public Alquiler(Herramienta herramienta, Instant inicio, Instant fin_acordado) {
		super();
		this.herramienta = herramienta;
		this.inicio = inicio;
		this.fin_acordado = fin_acordado;
	}
	
	
	public boolean enMora() {
		if(fin_real.isAfter(fin_acordado) || (fin_acordado.isBefore(Instant.now()))) {
			return true;
		}else {
			return false;
		}
	}
	
	public Instant getFin_real() {
		return fin_real;
	}


	public void Devolucion(Instant fin_real) {
		this.fin_real = fin_real;
	}
	
	@Override
	public double precio() {
		if(finalizado()) {
			return Duration.between(inicio, fin_real).toDays()*herramienta.getCosto_dia();
		}else {
			return Duration.between(inicio, fin_acordado).toDays()*herramienta.getCosto_dia();
		}	
	}
	
	@Override
	public boolean finalizado() {
		if (this.fin_real==null) {
			return false;
			}else {
				return true;
			}
	}


}
