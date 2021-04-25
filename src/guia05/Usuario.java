package guia05;

import java.util.ArrayList;

public class Usuario {
	private String id;
	ArrayList<Contratable> serviciosContratados;
	
	public Usuario(String id) {
		super();
		this.id = id;
		this.serviciosContratados=new ArrayList();
	}
	
	public void contratar(Contratable contratable) throws AlquilerNoEntregadoException {
	/*	int sum=0;
		
		for(int i=0; i<this.serviciosContratados.size();i++) {
				if (serviciosContratados.get(i).finalizado()==false) {
					sum=sum+1;
			}
		}
		
		if (sum>=2) {
			throw new AlquilerNoEntregadoException();
		}else {
			
		}
	*/}
	
	

}
