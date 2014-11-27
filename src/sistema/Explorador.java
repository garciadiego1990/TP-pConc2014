package sistema;

public class Explorador extends Thread {

	Tablero tablero;
	Celda celda; // Celda en la que se encuentra el Explorador actualmente
	String equipo; // Nombre del Equipo al que pertenece 
	int cantTesorosPorConquistar; // Cantidad de tesoros que faltan encontrar para ganar el Juego


	// Getters y Setters

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public Celda getCelda() {
		return celda;
	}

	public void setCelda(Celda celda) {
		this.celda = celda;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public int getCantTesorosPorConquistar() {
		return cantTesorosPorConquistar;
	}

	public void setCantTesorosPorConquistar(int cantTesorosPorConquistar) {
		this.cantTesorosPorConquistar = cantTesorosPorConquistar;
	}

	// <<< FIN DE GETTERS Y SETTERS >>>


	public void moverAIzquierda(){
		getCelda().moverCeldaIzquierda(tablero, this);
	}

	public void moverADerecha(){
		getCelda().moverCeldaDerecha(tablero, this);
	}

}