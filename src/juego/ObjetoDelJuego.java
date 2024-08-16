<<<<<<< HEAD
package juego;

import java.awt.Image;
import java.awt.Graphics;

public abstract class ObjetoDelJuego {
    protected int x, y;
    protected Image imagen;

    public ObjetoDelJuego(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void actualizar();
    public abstract void dibujar(Graphics g);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImagen() {
        return imagen;
    }
}
=======
package juego;

import java.awt.Image;
import java.awt.Graphics;

public abstract class ObjetoDelJuego {
    protected int x, y;
    protected Image imagen;

    public ObjetoDelJuego(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void actualizar();
    public abstract void dibujar(Graphics g);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImagen() {
        return imagen;
    }
}
>>>>>>> 5863d0f3b383dc29fa2d8e59ad4f6f9432bce66c
