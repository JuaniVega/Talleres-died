package guia05;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App {

	public static void main(String[] args) {
		
		//Creamos un oficio
		Oficio oficio=new Oficio("Carpintero");
		Oficio oficio1=new Oficio("Zapatero");
		
		//Creamos un trabajador
		Trabajador trabajador= new Trabajador("Juan",oficio,"prueba@prueba", 250);
		
		//Creamos un servicio
		Estandar servEst= new Estandar(100, false, oficio);
		Personalizado servPers= new Personalizado(1000, 800, 500, false, oficio1);
		
		//Creamos un trabajo con servicio estandar
		LocalDateTime fechaInicio=LocalDateTime.of(2021, 4, 26, 10, 00);
		LocalDateTime fechaFin=LocalDateTime.of(2021, 4, 26, 22, 00); 
		Trabajo trabajo= new Trabajo(fechaInicio,trabajador,servEst);
		trabajo.definirFinTrabajo(fechaFin);
		
		//Creamos un trabajo con servicio personalizado
		LocalDateTime fechaInicio1=LocalDateTime.of(2021, 4, 26, 10, 00);
		LocalDateTime fechaFin1=LocalDateTime.of(2021, 4, 26, 22, 00); 
		Trabajo trabajo1= new Trabajo(fechaInicio1,trabajador,servPers);
		trabajo1.definirFinTrabajo(fechaFin1);
		
		//Ahora que tenemos un trabajo creado lo agregamos a un servicio
		servEst.setTrabajo(trabajo);
		servPers.setTrabajo(trabajo1);
		
		//Creamos un usuario
		Usuario usuario= new Usuario("Carlos123");
		
		//Creamos una herramienta
		Herramienta herramienta=new Herramienta("Martillo", 50);
		
		//Creamos un alquiler
		LocalDate fechaInicioAlquiler=LocalDate.of(2021, 4, 15);
		LocalDate fechaFinAlquiler=LocalDate.of(2021, 4, 20);
		Alquiler alquiler = new Alquiler(herramienta, fechaInicioAlquiler, fechaFinAlquiler);
	
	//EVALUAMOS METODOS
		
		//Precio de trabajo
		System.out.println("El precio del trabajo es: "+trabajo.precio());
		
		//Calculamos precio de servicio
		System.out.println("El precio del servicio estandar es: "+servEst.precio());
		System.out.println("El precio del servicio personalizado es: "+servPers.precio());
		
		//Calculamos el costo del alquiler sin devolucion de herramienta (como no se sabe cuando
		// la va a devolver el usuario, calculamos el precio hasta la fecha acordada)
		System.out.println("El precio del alquiler (sin devolucion de herramienta aun) es: "+alquiler.precio());
		
		//Es moroso antes de definir fecha de devolucion?
		System.out.println("El usuario es moroso? "+alquiler.enMora());
		
		//Seteamos fecha (tardia) de entraga de la herramienta
		LocalDate fechaFinRealAlquiler=LocalDate.of(2021, 4, 25);
		alquiler.devolucion(fechaFinRealAlquiler);
		System.out.println("El precio del alquiler con una entraga tardia es: "+alquiler.precio());
		
		//Es moroso luego de definir fecha de devolucion tardia?
		System.out.println("El usuario es moroso? "+alquiler.enMora());
		
		//Seteamos fecha de devolucion antes de la acordada.
		LocalDate fechaFinRealAlquiler2=LocalDate.of(2021, 4, 19);
		alquiler.devolucion(fechaFinRealAlquiler2);
		System.out.println("El precio del alquiler con una entraga antes de la fecha acordada es: "+alquiler.precio());
		
		//Es moroso luego de definir fecha de devolucion dentro de lo previsto?
		System.out.println("El usuario es moroso? "+alquiler.enMora());
		
		//Trabajo finalizado?
		System.out.println("El trabajo del servicio estandar esta finalizado? "+servEst.finalizado());
		System.out.println("El trabajo del servicio personalizado esta finalizado? "+servPers.finalizado());
		
		//Alquiler finalizado? (se debe tener en cuenta que ya se definio una fecha de devolucion)
		System.out.println("El alquiler esta finalizado? "+alquiler.finalizado());
		
		//Agregamos trabajo a un trabajador 
		try {
			trabajador.agregarTareas(trabajo);
		} catch (AgendaOcupadaException | OficioNoCoincideException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Agregamos nuevamente el trabajo para comprobar la excepcion de fecha
		try {
			trabajador.agregarTareas(trabajo);
		} catch (AgendaOcupadaException | OficioNoCoincideException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Agregamos trabajo a un trabajador con oficio diferente
		try {
			trabajador.agregarTareas(trabajo1);
		} catch (AgendaOcupadaException | OficioNoCoincideException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Agregamos un contratable a la lista de contratables de usuario
		try {
			usuario.contratar(alquiler);
		} catch (AlquilerNoEntregadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Creamos 3 nuevos alquileres sin devolver para comprobar la excepcion del metodo contratar en la clase usuario
		LocalDate fechaInicioAlquiler2=LocalDate.of(2021, 4, 15);
		LocalDate fechaFinAlquiler2=LocalDate.of(2021, 4, 20);
		LocalDate fechaFinReaAlquiler2=LocalDate.of(2021, 4, 25);
		Alquiler alquiler2 = new Alquiler(herramienta, fechaInicioAlquiler2, fechaFinAlquiler2);
		alquiler.devolucion(fechaFinReaAlquiler2);
		
		LocalDate fechaInicioAlquiler3=LocalDate.of(2021, 4, 15);
		LocalDate fechaFinAlquiler3=LocalDate.of(2021, 4, 20);
		LocalDate fechaFinRealAlquiler3=LocalDate.of(2021, 4, 25);
		Alquiler alquiler3 = new Alquiler(herramienta, fechaInicioAlquiler3, fechaFinAlquiler3);
		alquiler.devolucion(fechaFinRealAlquiler3);
		
		LocalDate fechaInicioAlquiler4=LocalDate.of(2021, 4, 15);
		LocalDate fechaFinAlquiler4=LocalDate.of(2021, 4, 20);
		LocalDate fechaFinRealAlquiler4=LocalDate.of(2021, 4, 25);
		Alquiler alquiler4 = new Alquiler(herramienta, fechaInicioAlquiler4, fechaFinAlquiler4);
		alquiler.devolucion(fechaFinRealAlquiler4);
		
		try {
			usuario.contratar(alquiler2);
			usuario.contratar(alquiler3);
			usuario.contratar(alquiler4);
		} catch (AlquilerNoEntregadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
