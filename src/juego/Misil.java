package juego;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Misil extends ObjetoDelJuego {
    private boolean visible;

    public Misil(int x, int y) {
        super(x, y);
        initMisil();
    }

    private void initMisil() {
        ImageIcon ii = new ImageIcon("src/recursos_gráficos/sprites/disparo.png");
        imagen = ii.getImage();
        visible = true;
    }

    @Override
    public void actualizar() {
        y -= 5;
        if (y < 0) visible = false;
    }

    @Override
    public void dibujar(Graphics g) {
        if (visible) {
            g.drawImage(imagen, x, y, null);
        }
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
