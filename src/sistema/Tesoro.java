package sistema;

public class Tesoro {

	Celda celda; // Posición donde se encuentra alocado el Tesoro
	String equipoPerteneciente; // Equipo al que pertenece el Tesoro


	// Getters y Setters
	public Celda getCelda() {
		return celda;
	}

	public void setCelda(Celda celda) {
		this.celda = celda;
	}

	public String getEquipoPerteneciente() {
		return equipoPerteneciente;
	}

	public void setEquipoPerteneciente(String equipoPerteneciente) {
		this.equipoPerteneciente = equipoPerteneciente;
	}


	// Constructor
	public Tesoro(Celda celda, String equipoPerteneciente) {
		setCelda(celda);
		setEquipoPerteneciente(equipoPerteneciente);
	}
}