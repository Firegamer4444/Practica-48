import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "auto")
@XmlType(propOrder = {"id" , "marca" , "modelo" , "año" , "color" , "tipo_motor" , "cilindrada" , "potencia" , "transmision"})
public class Auto {
	private String id;
	private String marca;
	private String modelo;
	private String año;
	private String color;
	private String tipo_motor;
	private String cilindrada;
	private String potencia;
	private Transmision transmision;
	
	
	public Auto() {
	}

	public Auto(String id, String marca, String modelo, String año, String color, String tipo_motor, String cilindrada,
			String potencia, Transmision transmision) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.año = año;
		this.color = color;
		this.tipo_motor = tipo_motor;
		this.cilindrada = cilindrada;
		this.potencia = potencia;
		this.transmision = transmision;
	}

	/**
	 * Imprime los datos del auto
	 */
	public void imprimirDatos(){
		System.out.println("id: " + this.id);
		System.out.println("marca: " + this.marca );
		System.out.println("modelo: " + this.modelo );
		System.out.println("año: " + this.año);
		System.out.println("color: " + this.color);
		System.out.println("tipo de motor: " + this.tipo_motor);
		System.out.println("cilindrada: " + this.cilindrada);
		System.out.println("potencia: " + this.potencia);
		System.out.println("transmision:");
		System.out.println("tipo: " + this.transmision.getTipo());
		System.out.println("velocidades: " + this.transmision.getVelocidades());
	}

	@XmlAttribute(name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTipo_motor() {
		return tipo_motor;
	}

	public void setTipo_motor(String tipo_motor) {
		this.tipo_motor = tipo_motor;
	}

	public String getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(String cilindrada) {
		this.cilindrada = cilindrada;
	}

	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	public Transmision getTransmision() {
		return transmision;
	}

	public void setTransmision(Transmision transmision) {
		this.transmision = transmision;
	}
	
	
}
