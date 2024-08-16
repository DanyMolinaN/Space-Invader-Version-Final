<<<<<<< HEAD
package juego;

import javax.swing.ImageIcon;
import java.awt.*;

public class EnemigoRapido extends Enemigo {
    public EnemigoRapido(int x, int y) {
        super(x, y);
        initEnemigo();
        this.imagenDerecha = new ImageIcon("src/recursos_gráficos/sprites/NaveEnemigaDER3.gif").getImage();
        this.imagenIzquierda = new ImageIcon("src/recursos_gráficos/sprites/NaveEnemigaIZQ3.gif").getImage();

    }

    @Override
    protected Image initEnemigo() {
        ImageIcon ii = new ImageIcon("src/recursos_gráficos/sprites/enemigo3.png");
        imagen = ii.getImage();
        vidas = 3;
        return null;
    }

    @Override
    public void actualizar() {
        // Movimiento y disparo se manejan en ControladorJuego
    }

    @Override
    public void dibujar(Graphics g) {
        if (moviendoDerecha) {
            g.drawImage(imagenDerecha, x, y, null);
        } else {
            g.drawImage(imagenIzquierda, x, y, null);
        }
    }
}
=======
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
>>>>>>> 5863d0f3b383dc29fa2d8e59ad4f6f9432bce66c
