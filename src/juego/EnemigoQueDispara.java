<<<<<<< HEAD
package juego;

import javax.swing.ImageIcon;
import java.awt.*;
import java.util.Random;

public class EnemigoQueDispara extends Enemigo {

    private static final int PROBABILIDAD_DISPARO = 1;
    private Random random = new Random();

    public EnemigoQueDispara(int x, int y) {
        super(x, y);
        initEnemigo();
        this.imagenDerecha = new ImageIcon("src/recursos_gráficos/sprites/NaveEnemigaDER4.gif").getImage();
        this.imagenIzquierda = new ImageIcon("src/recursos_gráficos/sprites/NaveEnemigaIZQ4.gif").getImage();

    }

    @Override
    protected Image initEnemigo() {
        ImageIcon ii = new ImageIcon("src/recursos_gráficos/sprites/enemigo2.png");
        imagen = ii.getImage();
        vidas = 3;
        return null;
    }

    @Override
    public void actualizar() {
        if (random.nextInt(1000) < PROBABILIDAD_DISPARO) {
            disparar();
        }
    }

    @Override
    public void dibujar(Graphics g) {
        if (moviendoDerecha) {
            g.drawImage(imagenDerecha, x, y, null);
        } else {
            g.drawImage(imagenIzquierda, x, y, null);
        }
    }

    private void disparar() {
        MisilEnemigo misil = new MisilEnemigo(x + imagen.getWidth(null) / 2 - 2, y + imagen.getHeight(null));
        ControladorJuego.agregarObjeto(misil);
    }
}
=======
package juego;

import javax.swing.ImageIcon;
import java.awt.*;
import java.util.Random;

public class EnemigoQueDispara extends Enemigo {
    private static final int PROBABILIDAD_DISPARO = 1;
    private Random random = new Random();

    public EnemigoQueDispara(int x, int y) {
        super(x, y);
        initEnemigo();
    }

    @Override
    protected void initEnemigo() {
        ImageIcon ii = new ImageIcon("src/recursos_gráficos/sprites/enemigo2.png");
        imagen = ii.getImage();
        vidas = 3;
    }

    @Override
    public void actualizar() {
        if (random.nextInt(1000) < PROBABILIDAD_DISPARO) {
            disparar();
        }
    }

    @Override
    public void dibujar(Graphics g) {
        g.drawImage(imagen, x, y, null);
    }

    private void disparar() {
        MisilEnemigo misil = new MisilEnemigo(x + imagen.getWidth(null) / 2 - 2, y + imagen.getHeight(null));
        ControladorJuego.agregarObjeto(misil);
    }
}
>>>>>>> 5863d0f3b383dc29fa2d8e59ad4f6f9432bce66c
