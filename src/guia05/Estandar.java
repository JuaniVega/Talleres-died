package guia05;

public class Estandar extends Servicio {
	private double montoFijo;
	
	
	public Estandar (double montoFijo, boolean urgente, Oficio oficio, Trabajo trabajo) {
		this.montoFijo=montoFijo;
		this.oficio=oficio;
		this.trabajo=trabajo;
		this.urgente=urgente;
	}
	
	public Estandar (double montoFijo, boolean urgente, Oficio oficio) {
		this.montoFijo=montoFijo;
		this.oficio=oficio;
		this.urgente=urgente;
	}

	public void setTrabajo (Trabajo trabajo) {
		this.trabajo=trabajo;
	}
	
	@Override
	public double precio() {
		if(urgente) {
		return (montoFijo+trabajo.precio())*1.5;
		}else {
			return montoFijo+trabajo.precio();
		}
	}

	@Override
	public boolean finalizado() {
		return trabajo.finalizado();
	}

}
