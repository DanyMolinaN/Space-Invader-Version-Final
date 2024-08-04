package juego;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Defensa extends ObjetoDelJuego {
    private int vidas;

    public Defensa(int x, int y) {
        super(x, y);
        initDefensa();
    }

    private void initDefensa() {
        ImageIcon ii = new ImageIcon("src/Recursos/defensa.png");
        imagen = ii.getImage();
        vidas = 3;
    }

    @Override
    public void actualizar() {
        // La defensa no se mueve
    }

    @Override
    public void dibujar(Graphics g) {
        g.drawImage(imagen, x, y, null);
    }

    public void quitarVida() {
        vidas--;
        if (vidas <= 0) {
            //setVisible(false);
        }
    }

   /* public boolean isVisible() {
        v
    }*/
}
