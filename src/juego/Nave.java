package juego;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class Nave extends ObjetoDelJuego {
    private static final long TIEMPO_DE_DISPARO = 100;
    private int dx, dy;
    private List<Misil> misiles;
    private long ultimoDisparo;

    public Nave(int x, int y) {
        super(x, y);
        initJugador();
    }

    private void initJugador() {
        ImageIcon spriteJugador = new ImageIcon("src/recursos_gráficos/sprites/jugador.png");
        imagen = spriteJugador.getImage();
        misiles = new ArrayList<>();
    }

    @Override
    public void actualizar() {
        x += dx;
        y += dy;
        limitarMovimiento();
        actualizarMisiles();
    }

    private void limitarMovimiento() {
        if (x < 250) x = 250;
        if (x > 926 - imagen.getWidth(null)) x = 926 - imagen.getWidth(null);
        if (y < 550) y = 550;
        if (y > 650 - imagen.getHeight(null)) y = 650 - imagen.getHeight(null);
    }

    @Override
    public void dibujar(Graphics g) {
        g.drawImage(imagen, x, y, null);
        for (Misil misil : misiles) {
            misil.dibujar(g);
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT -> dx = -2;
            case KeyEvent.VK_RIGHT -> dx = 2;
            case KeyEvent.VK_UP -> dy = -2;
            case KeyEvent.VK_DOWN -> dy = 2;
            case KeyEvent.VK_Z -> disparar();
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT -> dx = 0;
            case KeyEvent.VK_UP, KeyEvent.VK_DOWN -> dy = 0;
        }
    }

    public void disparar() {
        long time = System.currentTimeMillis();
        if (time - ultimoDisparo >= TIEMPO_DE_DISPARO) {
            misiles.add(new Misil(x + imagen.getWidth(null) / 2 - 2, y));
            ultimoDisparo = time;
        }
    }

    private void actualizarMisiles() {
        List<Misil> misilesRemover = new ArrayList<>();
        for (Misil misil : misiles) {
            misil.actualizar();
            if (!misil.isVisible()) {
                misilesRemover.add(misil);
            }
        }
        misiles.removeAll(misilesRemover);
    }

    public List<Misil> getMisiles() {
        return misiles;
    }
}
