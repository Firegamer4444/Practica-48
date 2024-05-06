import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Main {
	
	
	public static void mostrarElemento(ArrayList<Auto> listaAutos) {
		for (Auto auto: listaAutos) {
			System.out.println("--------------------------");
			System.out.println("id: " + auto.getId());
			System.out.println("marca: " + auto.getMarca());
			System.out.println("año: " + auto.getAño());
			System.out.println("color: " + auto.getColor());
			System.out.println("tipo de motor: " + auto.getTipo_motor());
			System.out.println("cilindrada: " + auto.getCilindrada());
			System.out.println("potencia: " + auto.getPotencia());
			System.out.println("transmision:");
			System.out.println("tipo: " + auto.getTransmision().getTipo());
			System.out.println("velocidades: " + auto.getTransmision().getVelocidades());
		}
	}
	
	public static void main(String[] args) throws JAXBException {
		JAXBContext contexto = JAXBContext.newInstance(Garaje.class);
		Unmarshaller unmarshaller = contexto.createUnmarshaller();
		Garaje autos = (Garaje) unmarshaller.unmarshal(new File("src/main/resources/Autos.xml"));
		ArrayList<Auto> listaAutos = autos.getlistaAutos();
		mostrarElemento(listaAutos);
	}
}
 