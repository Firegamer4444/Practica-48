import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Main {
	
	/**
	 * Muestra todos los elementos del fichero xml
	 * @param listaAutos lista de autos
	 */
	public static void mostrarElemento(ArrayList<Auto> listaAutos) {
		for (Auto auto: listaAutos) {
			System.out.println("--------------------------");
			auto.imprimirDatos();
		}
	}

	/**
	 * Retorna el auto con el id pasado por parametro
	 * @param id id del auto que quieres buscar
	 * @param listaAutos lista de autos
	 * @return
	 */
	public static Auto busqueda(String id , ArrayList<Auto> listaAutos){
		for (Auto auto: listaAutos) {
			if (auto.getId().equals(id)){
				return auto;
			}
		}
		return null;
	}

	/**
	 * menu del programa
	 * @param listaAutos
	 */
	public static void menu(ArrayList<Auto> listaAutos){
		while (true){
			Scanner scanner = new Scanner(System.in);
			System.out.println("\n--- Opciones: ---");
			System.out.println("1. mostrar elementos");
			System.out.println("2. buscar elemento");
			System.out.println("3. escribir datos");
			String opcion = scanner.nextLine();
			if (opcion.equals("1")){
				mostrarElemento(listaAutos);
			}
			if (opcion.equals("2")){
				System.out.println("Introduzca el id: ");
				String idBusqueda = scanner.nextLine();
				Auto autoBuscado = busqueda(idBusqueda, listaAutos);
				if (autoBuscado == null){
					System.out.println("No existe el id introducido");
				}
				else{
					System.out.println("");
					autoBuscado.imprimirDatos();
				}
			}
			if (opcion.equals("3")){

			}
		}
	}
	
	public static void main(String[] args) throws JAXBException {
		JAXBContext contexto = JAXBContext.newInstance(Autos.class);
		Unmarshaller unmarshaller = contexto.createUnmarshaller();
		Autos autos = (Autos) unmarshaller.unmarshal(new File("src/main/resources/Autos.xml"));
		ArrayList<Auto> listaAutos = autos.getlistaAutos();
		menu(listaAutos);
	}
}
 