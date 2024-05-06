import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "transmision")
@XmlType(propOrder = {"tipo" , "velocidades"})
public class Transmision {
	private String tipo;
	private String velocidades;
	
	public Transmision() {
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getVelocidades() {
		return velocidades;
	}

	public void setVelocidades(String velocidades) {
		this.velocidades = velocidades;
	}
	
}
