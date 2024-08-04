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
