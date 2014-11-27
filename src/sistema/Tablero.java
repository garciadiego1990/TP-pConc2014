package sistema;

import java.util.ArrayList;


public class Tablero {

	int tamanio; // Como el tablero es cuadrado, creo que no es necesario modelar el Tablero con "Int alto" , "Int Ancho"


	ArrayList<Explorador> exploradores = new ArrayList<Explorador>(); // Lista de exploradores que hay en el Tablero

	ArrayList<Tesoro> tesorosEquipo1 = new ArrayList<Tesoro>(); // Lista de Tesoros de un equipo 
	ArrayList<Tesoro> tesorosEquipo2 = new ArrayList<Tesoro>(); // Lista de Tesoros de un otro equipo 



	// Getters y Setters
	public int getTamanio() {
		return tamanio;
	}

	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}

	public ArrayList<Explorador> getExploradores() {
		return exploradores;
	}

	public void setExploradores(ArrayList<Explorador> exploradores) {
		this.exploradores = exploradores;
	}

	public ArrayList<Tesoro> getTesorosEquipo1() {
		return tesorosEquipo1;
	}

	public void setTesorosEquipo1(ArrayList<Tesoro> tesorosEquipo1) {
		this.tesorosEquipo1 = tesorosEquipo1;
	}

	public ArrayList<Tesoro> getTesorosEquipo2() {
		return tesorosEquipo2;
	}

	public void setTesorosEquipo2(ArrayList<Tesoro> tesorosEquipo2) {
		this.tesorosEquipo2 = tesorosEquipo2;
	}

	// Constructor
	public Tablero(int tamanio) {
		setTamanio(tamanio);
	}

}