package sistema;

public class Posicion {
	int x;
	int y;

	// Getters y Setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	// Constructor
	public Posicion(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
}