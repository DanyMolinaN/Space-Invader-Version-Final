<<<<<<< HEAD
package juego;

import javax.swing.ImageIcon;
import java.awt.*;

public class EnemigoBasico extends Enemigo {
    public EnemigoBasico(int x, int y) {
        super(x, y);
        initEnemigo();
        this.imagenDerecha = new ImageIcon("src/recursos_gráficos/sprites/NaveEnemigaDER1.gif").getImage();
        this.imagenIzquierda = new ImageIcon("src/recursos_gráficos/sprites/NaveEnemigaIzq1.gif").getImage();
    }

    @Override
    protected Image initEnemigo() {
        ImageIcon ii = new ImageIcon("src/recursos_gráficos/sprites/enemigo.png");
        imagen = ii.getImage();
        vidas = 1;
        return null;
    }

    @Override
    public void actualizar() {

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
>>>>>>> 5863d0f3b383dc29fa2d8e59ad4f6f9432bce66c
