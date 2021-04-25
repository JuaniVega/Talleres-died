package guia05;

public class Estandar extends Servicio {
	private double montoFijo;
	
	
	public Estandar (double montoFijo) {
		this.montoFijo=montoFijo;
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
