import java.util.ArrayList;
import javax.xml.bind.annotation.*;


@XmlRootElement(name = "autos")
public class Autos {
	
	private ArrayList<Auto> listaAutos = new ArrayList<Auto>();
	
	public Autos() {
	}

	public Autos(ArrayList<Auto> listaAutos) {
		this.listaAutos = listaAutos;
	}

	@XmlElement(name = "auto")
	public ArrayList<Auto> getlistaAutos() {
		return listaAutos;
	}

	public void setlistaAutos(ArrayList<Auto> listaAutos) {
		this.listaAutos = listaAutos;
	}
	
}
