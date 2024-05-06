import java.util.ArrayList;
import javax.xml.bind.annotation.*;


@XmlRootElement(name = "garaje")
@XmlType(propOrder = {"listaAutos"})

public class Garaje {
	
	private ArrayList<Auto> listaAutos = new ArrayList<Auto>();
	
	public Garaje() {
	}

	@XmlElementWrapper(name = "autos")
	@XmlElement(name = "auto")
	public ArrayList<Auto> getlistaAutos() {
		return listaAutos;
	}

	public void setlistaAutos(ArrayList<Auto> listaAutos) {
		this.listaAutos = listaAutos;
	}
	
}
