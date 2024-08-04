package juego;

import javax.swing.ImageIcon;
import java.awt.*;

public class EnemigoBasico extends Enemigo {
    public EnemigoBasico(int x, int y) {
        super(x, y);
        initEnemigo();
    }

    @Override
    protected void initEnemigo() {
        ImageIcon ii = new ImageIcon("src/recursos_gráficos/sprites/enemigo.png");
        imagen = ii.getImage();
        vidas = 1;
    }

    @Override
    public void actualizar() {

    }

    @Override
    public void dibujar(Graphics g) {
        g.drawImage(imagen, x, y, null);

    }
}
