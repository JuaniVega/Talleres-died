package guia05;

public class Herramienta {
	private String nombre;
	private double costo_dia;


	public Herramienta(String nombre, double costo_dia) {
		super();
		this.nombre = nombre;
		this.costo_dia = costo_dia;
	}
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getCosto_dia() {
		return costo_dia;
	}


	public void setCosto_dia(double costo_dia) {
		this.costo_dia = costo_dia;
	}
	

}
