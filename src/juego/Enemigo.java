package juego;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public abstract class Enemigo extends ObjetoDelJuego {
    protected int vidas;

    public Enemigo(int x, int y) {
        super(x, y);
        initEnemigo();
    }

    protected void initEnemigo() {
        ImageIcon ii = new ImageIcon("src/recursos_gráficos/sprites/enemigo.png");
        imagen = ii.getImage();
        vidas = 1;
    }

    @Override
    public void actualizar() {
        // Implementar lógica de movimiento común a todos los enemigos
    }

    @Override
    public void dibujar(Graphics g) {
        g.drawImage(imagen, x, y, null);
    }

    public void mover(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void quitarVida() {
        vidas--;
    }

    public int getVidas() {
        return vidas;
    }
}
