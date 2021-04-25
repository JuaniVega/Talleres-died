package guia05;

public class Personalizado extends Servicio {
	private double presupuesto;
	private double costo_materiales;
	private double costo_transporte;
	
	
	public Personalizado(double presupuesto, double costo_materiales, double costo_transporte) {
		super();
		this.presupuesto = presupuesto;
		this.costo_materiales = costo_materiales;
		this.costo_transporte = costo_transporte;
	}
	
	@Override
	public double precio() {
		if (urgente) {
		return (presupuesto+costo_materiales+costo_transporte)*1.5;
		}
		return presupuesto+costo_materiales+costo_transporte;
	}
		
		
	@Override
	public boolean finalizado() {
		return trabajo.finalizado();
	}

}
