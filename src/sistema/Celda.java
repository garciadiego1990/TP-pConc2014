package sistema;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Celda {
	Posicion pos;

	boolean hayExploradorEquipoN; // Devuelve un booleano inidicando si hay o no un Explorador del equipo Norte
	boolean hayExploradorEquipoS; // Devuelve un booleano inidicando si hay o no un Explorador del equipo Sur

	boolean hayTesoroEquipoN; // Devuelve un booleano inidicando si hay o no un Tesoro del equipo Norte
	boolean hayTesoroEquipoS;  // Devuelve un booleano inidicando si hay o no un Tesoro del equipo Sur

	// Condition variables
	private Lock lock = new ReentrantLock();
	private Condition ocupado = lock.newCondition();
	private Condition puedeMoverFrontalmente = lock.newCondition();


	// Getters y setters
	public Posicion getPos() {
		return pos;
	}

	public void setPos(Posicion pos) {
		this.pos = pos;
	}

	public boolean isHayExploradorEquipoN() {
		return hayExploradorEquipoN;
	}

	public void setHayExploradorEquipoN(boolean hayExploradorEquipoN) {
		this.hayExploradorEquipoN = hayExploradorEquipoN;
	}

	public boolean isHayExploradorEquipoS() {
		return hayExploradorEquipoS;
	}

	public void setHayExploradorEquipoS(boolean hayExploradorEquipoS) {
		this.hayExploradorEquipoS = hayExploradorEquipoS;
	}

	public boolean isHayTesoroEquipoN() {
		return hayTesoroEquipoN;
	}

	public void setHayTesoroEquipoN(boolean hayTesoroEquipoN) {
		this.hayTesoroEquipoN = hayTesoroEquipoN;
	}

	public boolean isHayTesoroEquipoS() {
		return hayTesoroEquipoS;
	}

	public void setHayTesoroEquipoS(boolean hayTesoroEquipoS) {
		this.hayTesoroEquipoS = hayTesoroEquipoS;
	}

	public Lock getLock() {
		return lock;
	}

	public void setLock(Lock lock) {
		this.lock = lock;
	}

	public Condition getOcupado() {
		return ocupado;
	}

	public void setOcupado(Condition ocupado) {
		this.ocupado = ocupado;
	}

	public Condition getPuedeMoverFrontalmente() {
		return puedeMoverFrontalmente;
	}

	public void setPuedeMoverFrontalmente(Condition puedeMoverFrontalmente) {
		this.puedeMoverFrontalmente = puedeMoverFrontalmente;
	}

	// <<< FIN DE GETTERS Y SETTERS >>>

	// Devuelve un booleano indicando si hay algun explorador en la celda
	public boolean isHayExplorador(){

		return isHayExploradorEquipoS() || isHayExploradorEquipoN();
	}

	// Devuelve un booleano indicando si la posición pasada por parámetro se encuentra en el borde del tablero
	public boolean esBorde(Tablero t, Posicion s){
		return (t.getTamanio() == s.getX() || t.getTamanio() == s.getY());

	}

	// Me devuelve la celda contigua a la izquierda de la celda actual
	public Celda celdaContiguaIzquierda(){

		Celda ret = this;

		ret.getPos().setX(ret.getPos().getX() -1);

		return ret; 
	}

	// Me devuelve la celda contigua a la derecha de la celda actual
	public Celda celdaContiguaDerecha(){

		Celda ret = this;

		ret.getPos().setX(ret.getPos().getX() + 1);

		return ret; 
	}


	public void moverCeldaIzquierda(Tablero t, Explorador exp){
		lock.lock(); // Exclusión mutua

		if(!esBorde(t, getPos())){
			if(this.celdaContiguaIzquierda().isHayExplorador()){
				try {
					this.ocupado.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}


			exp.getCelda().getPos().setX(exp.getCelda().getPos().getX()-1);
			ocupado.signal();

			// Estos if anidados verifica de que equipo es la persona que ocupa el casillero
			// y tambien se encarga de verificar si hay algun tesoro del equipo contrario para conquistar
			if(exp.getEquipo() == "Equipo Norte"){
				hayExploradorEquipoN = true;
				if(hayTesoroEquipoS){
					exp.setCantTesorosPorConquistar(exp.getCantTesorosPorConquistar() - 1); 
					hayTesoroEquipoS = false;
				}
			}

			if(exp.getEquipo() == "Equipo Sur"){
				hayExploradorEquipoS = true;
				if(hayTesoroEquipoN){
					exp.setCantTesorosPorConquistar(exp.getCantTesorosPorConquistar() - 1); 
					hayTesoroEquipoN = false;
				}
			}

		}

		lock.unlock();
	}



	public void moverCeldaDerecha(Tablero t, Explorador exp){
		lock.lock(); // Exclusión mutua

		if(!esBorde(t, getPos())){
			if(this.celdaContiguaDerecha().isHayExplorador()){
				try {
					this.ocupado.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}


			exp.getCelda().getPos().setX(exp.getCelda().getPos().getX()+1);
			ocupado.signal();

			// Estos if anidados verifica de que equipo es la persona que ocupa el casillero
			// y tambien se encarga de verificar si hay algun tesoro del equipo contrario para conquistar
			if(exp.getEquipo() == "Equipo Norte"){
				hayExploradorEquipoN = true;
				if(hayTesoroEquipoS){
					exp.setCantTesorosPorConquistar(exp.getCantTesorosPorConquistar() - 1); 
					hayTesoroEquipoS = false;
				}
			}

			if(exp.getEquipo() == "Equipo Sur"){
				hayExploradorEquipoS = true;
				if(hayTesoroEquipoN){
					exp.setCantTesorosPorConquistar(exp.getCantTesorosPorConquistar() - 1); 
					hayTesoroEquipoN = false;
				}
			}

		}

		lock.unlock();
	}

}


