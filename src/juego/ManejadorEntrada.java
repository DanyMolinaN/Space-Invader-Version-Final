<<<<<<< HEAD
package juego;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ManejadorEntrada extends KeyAdapter {
    private Nave nave;

    public ManejadorEntrada(Nave nave) {
        this.nave = nave;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        nave.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        nave.keyReleased(e);
    }
}
=======
package juego;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ManejadorEntrada extends KeyAdapter {
    private Nave nave;

    public ManejadorEntrada(Nave nave) {
        this.nave = nave;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        nave.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        nave.keyReleased(e);
    }
}
>>>>>>> 5863d0f3b383dc29fa2d8e59ad4f6f9432bce66c
