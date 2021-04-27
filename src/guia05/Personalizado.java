package guia05;

public class Personalizado extends Servicio {
	private double presupuesto;
	private double costo_materiales;
	private double costo_transporte;
	
	
	public Personalizado(double presupuesto, double costo_materiales, double costo_transporte,  boolean urgente, Oficio oficio, Trabajo trabajo) {
		super();
		this.presupuesto = presupuesto;
		this.costo_materiales = costo_materiales;
		this.costo_transporte = costo_transporte;
		this.trabajo=trabajo;
		this.urgente=urgente;
		this.oficio=oficio;
	}
	

	public Personalizado(double presupuesto, double costo_materiales, double costo_transporte,  boolean urgente, Oficio oficio) {
		super();
		this.presupuesto = presupuesto;
		this.costo_materiales = costo_materiales;
		this.costo_transporte = costo_transporte;
		this.urgente=urgente;
		this.oficio=oficio;
	}
	
	public void setTrabajo (Trabajo trabajo) {
		this.trabajo=trabajo;
	}
	
	@Override
	public double precio() {
		if (urgente) {
		return (presupuesto+costo_materiales+costo_transporte)*1.5;		//El presupuesto incluye el precio del trabajo final, por eso no se multiplica por hs trabajadas.
		}
		return presupuesto+costo_materiales+costo_transporte;
	}
		
		
	@Override
	public boolean finalizado() {
		return trabajo.finalizado();
	}

}
