<<<<<<< HEAD
package juego;

import javax.swing.ImageIcon;

public class MisilEnemigo extends Misil {

    public MisilEnemigo(int x, int y) {
        super(x, y);
        initMisil();
    }


    protected void initMisil() {
        ImageIcon ii = new ImageIcon("src/recursos_gráficos/sprites/disparo.png");
        ii.setImage(ii.getImage());
    }

    @Override
    public void actualizar() {
        y += 2; // Velocidad del misil enemigo
        if (y > 720) {
            setVisible(false);
        }
    }


}
=======
package juego;

import javax.swing.ImageIcon;

public class MisilEnemigo extends Misil {

    public MisilEnemigo(int x, int y) {
        super(x, y);
        initMisil();
    }


    protected void initMisil() {
        ImageIcon ii = new ImageIcon("src/recursos_gráficos/sprites/misil_enemigo.png");
        ii.setImage(ii.getImage());
    }

    @Override
    public void actualizar() {
        y += 2; // Velocidad del misil enemigo
        if (y > 720) {
            setVisible(false);
        }
    }
}
>>>>>>> 5863d0f3b383dc29fa2d8e59ad4f6f9432bce66c
