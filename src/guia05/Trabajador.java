package guia05;

import java.time.Instant;
import java.util.ArrayList;

public class Trabajador {
	ArrayList<Trabajo> trabajosAsignados;
	private String nombre;
	private Oficio oficio;
	private String correo;
	private int costo_hora;
	
	
	public int getCosto_hora() {
		return costo_hora;
	}


	public void setCosto_hora(int costo_hora) {
		this.costo_hora = costo_hora;
	}


	public Trabajador(String nombre, Oficio oficio, String correo, int costo_hora, int comision) {
		super();
		this.nombre = nombre;
		this.oficio = oficio;
		this.correo = correo;
		this.costo_hora = costo_hora;
		this.trabajosAsignados=new ArrayList();
	}
	
	
	public void agregarTareas(Trabajo trabajo) throws AgendaOcupadaException, OficioNoCoincideException {
		if(oficiosIguales(this.oficio, trabajo.getServicio().oficio)) {
			if(agendaLibre(trabajo.getInicioTrabajo(), trabajosAsignados)) {
				this.trabajosAsignados.add(trabajo);
			}else {
				throw new AgendaOcupadaException();
			}
		}else {
			throw new OficioNoCoincideException();
		}
		
		
	}
	
	public boolean oficiosIguales(Oficio oficioTrabajador, Oficio oficioTrabajo) {
		if(oficioTrabajador==oficioTrabajo) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean agendaLibre(Instant fechaInicio, ArrayList<Trabajo> listaTrabajos) {
		for(int i=0; i<listaTrabajos.size(); i++) {
			if(fechaInicio==listaTrabajos.get(i).getInicioTrabajo()) {
				return false;
			}
		}
		return true;
		
	}
		

	

}
