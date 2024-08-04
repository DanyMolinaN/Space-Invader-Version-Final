package juego;

import javax.swing.ImageIcon;
import java.awt.*;

public class EnemigoRapido extends Enemigo {
    public EnemigoRapido(int x, int y) {
        super(x, y);
        initEnemigo();
    }

    @Override
    protected void initEnemigo() {
        ImageIcon ii = new ImageIcon("src/recursos_gráficos/sprites/enemigo3.png");
        imagen = ii.getImage();
        vidas = 3;
    }

    @Override
    public void actualizar() {
        // Movimiento y disparo se manejan en ControladorJuego
    }

    @Override
    public void dibujar(Graphics g) {
        g.drawImage(imagen, x, y, null);

    }
}
