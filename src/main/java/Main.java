import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
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
	 * @throws JAXBException 
	 * @throws IOException 
	 */
	public static void menu(Autos autos , ArrayList<Auto> listaAutos , Marshaller marshaller) throws JAXBException{
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
				System.out.println("Introduzca el id: ");
				String id = scanner.nextLine();
				System.out.println("Introduzca la marca: ");
				String marca = scanner.nextLine();
				System.out.println("Introduzca el modelo: ");
				String modelo = scanner.nextLine();
				System.out.println("Introduzca el año: ");
				String año = scanner.nextLine();
				System.out.println("Introduzca el color: ");
				String color = scanner.nextLine();
				System.out.println("Introduzca el tipo de motor: ");
				String tipo_motor = scanner.nextLine();
				System.out.println("Introduzca la cilindrada: ");
				String cilindrada = scanner.nextLine();
				System.out.println("Introduzca la potencia: ");
				String potencia = scanner.nextLine();
				System.out.println("Introduzca el tipo de transmision: ");
				String tipo = scanner.nextLine();
				System.out.println("Introduzca las velocidades: ");
				String velocidades = scanner.nextLine();
				Transmision nuevaTransmision = new Transmision(tipo , velocidades);
				Auto nuevoAuto = new Auto(id, marca, modelo , año, color, tipo_motor, cilindrada, potencia, nuevaTransmision);
				autos.añadirAuto(nuevoAuto);
				try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("src/main/resources/Autos.xml"), StandardCharsets.UTF_8))) {
					marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
					marshaller.marshal(autos, writer);
				}
				catch (IOException e) {
					System.out.print("Error al leer el archivo");
				}
			}
		}
		}
	
	public static void main(String[] args) throws JAXBException, IOException {
		JAXBContext contexto = JAXBContext.newInstance(Autos.class);
		Unmarshaller unmarshaller = contexto.createUnmarshaller();
		Marshaller marshaller = contexto.createMarshaller();
		Autos autos = (Autos) unmarshaller.unmarshal(new File("src/main/resources/Autos.xml"));
		ArrayList<Auto> listaAutos = autos.getlistaAutos();
		menu(autos , listaAutos , marshaller);
	}
}
 