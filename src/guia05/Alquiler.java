package guia05;

import java.time.Duration;
import java.time.LocalDate;

public class Alquiler implements Contratable {
	private Herramienta herramienta;
	private LocalDate inicio;
	private LocalDate fin_acordado;
	private LocalDate fin_real=null;
	
	
	public Alquiler(Herramienta herramienta, LocalDate inicio, LocalDate fin_acordado) {
		super();
		this.herramienta = herramienta;
		this.inicio = inicio;
		this.fin_acordado = fin_acordado;
	}
	
	
	public boolean enMora() {
		if ( noDevuelve() || devuelveFueraDeFecha() ){
				return true;
			}else {
				return false;
			}
	}
	
	public boolean noDevuelve() {
		if ((fin_real==null) && (fin_acordado.isBefore(LocalDate.now()))) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean devuelveFueraDeFecha() {
		if (fin_real.isAfter(fin_acordado)) {
			return true;
		}else {
			return false;
		}
	}
	
	public LocalDate getFin_real() {
		return fin_real;
	}


	public void devolucion(LocalDate fin_real) {
		this.fin_real = fin_real;
	}
	
	@Override
	public double precio() {
		if(finalizado()) {
			return Duration.between(inicio.atStartOfDay(), fin_real.atStartOfDay()).toDays()*herramienta.getCosto_dia();			//Segun mi interpretacion de la consigna, el precio final del alquiler es desde el incio hasta el dia en que la herramienta fue devuelta. Sin importar que esta fecha sea despues de la acordada.
		}else {
			return Duration.between(inicio.atStartOfDay(), fin_acordado.atStartOfDay()).toDays()*herramienta.getCosto_dia();		//Como la herramienta no fue devuelta, se calcula el precio hasta el dia acordado, ya que no hay multa por devolucion tardia.
		}	
	}
	
	@Override
	public boolean finalizado() {		//Finalizado implica que la herramienta fue devuelta
		if (this.fin_real==null) {
			return false;
			}else {
				return true;
			}
	}


}
