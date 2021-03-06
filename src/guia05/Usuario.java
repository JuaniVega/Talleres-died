package guia05;

import java.util.ArrayList;

public class Usuario {
	private String id;
	ArrayList<Contratable> serviciosContratados;		//La lista de contratables puede contener Alquileres o Servicios.
	
	public Usuario(String id) {
		super();
		this.id = id;
		this.serviciosContratados=new ArrayList();
	}
	
	public void contratar(Contratable contratable) throws AlquilerNoEntregadoException {
		int sum=0;
		
		for(int i=0; i<this.serviciosContratados.size();i++) {
			if (serviciosContratados.get(i).getClass().equals(Alquiler.class)) {
				if (serviciosContratados.get(i).finalizado()==false) {
					sum=sum+1;
				}
			}	
		}
		
		if (sum>=2) {
			throw new AlquilerNoEntregadoException();
		}else {
			serviciosContratados.add(contratable);
		}
	}
	
	

}
