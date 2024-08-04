package juego;

import javax.swing.ImageIcon;
import java.awt.*;

public class EnemigoConVida extends Enemigo {
    public EnemigoConVida(int x, int y) {
        super(x, y);
        initEnemigo();
    }

    @Override
    protected void initEnemigo() {
        ImageIcon ii = new ImageIcon("src/recursos_gráficos/sprites/enemigo4.png");
        imagen = ii.getImage();
        vidas = 3;
    }

    @Override
    public void actualizar() {
        // Movimiento básico se controla en ControladorJuego
    }

    @Override
    public void dibujar(Graphics g) {
        g.drawImage(imagen, x, y, null);
    }
}
