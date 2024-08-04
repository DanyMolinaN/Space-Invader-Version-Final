package juego;

import java.util.ArrayList;
import java.util.List;

public class ControladorJuego {
    private static List<ObjetoDelJuego> objetos;
    private Nave nave;
    private boolean moviendoDerecha = true;
    private static int VELOCIDAD = 1;
    private static final int DESPLAZAMIENTO_VERTICAL = 10;
    private static final int LIMITE_DERECHO = 900;
    private static final int LIMITE_IZQUIERDO = 200;
    private int nivel = 1;
    private PanelJuego panel;
    private boolean juegoIniciado = false;

    public ControladorJuego() {
        objetos = new ArrayList<>();
        nave = new Nave(600, 625);
        objetos.add(nave);
        initEnemigos();
       

    }

    public void pausarJuego() {
        new Thread(() -> {
            try {
                for (int i = 5; i > 0; i--) {
                    panel.mostrarContador(i);
                    Thread.sleep(1000);
                }
                juegoIniciado = true;
                panel.ocultarContador();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void setPanel(PanelJuego panel) {
        this.panel = panel;
    }
    private void initDefensas() {
        int numDefensas = 4;
        int separacion = 200;
        int y = 500;

        for (int i = 0; i < numDefensas; i++) {
            int x = 250 + i * separacion;
            objetos.add(new Defensa(x, y));
        }
    }


    private void initEnemigos() {
        objetos.removeIf(obj -> obj instanceof Enemigo); // Limpiar enemigos de niveles anteriores

        switch (nivel) {
            case 1 -> initNivel1();
            case 2 -> initNivel2();
            case 3 -> initNivel3();
            case 4 -> initNivel4();
            case 5 -> initNivel5();
            // Agregar más niveles según sea necesario
        }
    }

    private void initNivel1() {
        int filas = 4;
        int columnas = 8;
        int anchoEnemigo = 40;
        int altoEnemigo = 40;
        for (int fila = 0; fila < filas; fila++) {
            for (int col = 0; col < columnas; col++) {
                int x = 300 + col * (anchoEnemigo + 10);
                int y = 10 + fila * (altoEnemigo + 10);
                objetos.add(new EnemigoBasico(x, y));
            }
        }
    }

    private void initNivel2() {
        int filas = 5;
        int columnas = 10;
        int anchoEnemigo = 40;
        int altoEnemigo = 40;
        for (int fila = 0; fila < filas; fila++) {
            for (int col = 0; col < columnas; col++) {
                int x = 300 + col * (anchoEnemigo + 10);
                int y = 10 + fila * (altoEnemigo + 10);
                if (fila == 0) {
                    objetos.add(new EnemigoBasico(x, y));
                } else if (fila == 1) {
                    objetos.add(new EnemigoRapido(x, y));
                } else {
                    objetos.add(new EnemigoConVida(x, y));
                }
            }
        }
    }

    private void initNivel3() {
        int filas = 6;
        int columnas = 12;
        int anchoEnemigo = 40;
        int altoEnemigo = 40;
        for (int fila = 0; fila < filas; fila++) {
            for (int col = 0; col < columnas; col++) {
                int x = 300 + col * (anchoEnemigo + 10);
                int y = 10 + fila * (altoEnemigo + 10);
                if (fila == 0) {
                    objetos.add(new EnemigoRapido(x, y));
                } else if (fila == 1) {
                    objetos.add(new EnemigoQueDispara(x, y));
                } else {
                    objetos.add(new EnemigoBasico(x, y));
                }
            }
        }
    }

    private void initNivel4() {
        int filas = 7;
        int columnas = 8;
        int anchoEnemigo = 40;
        int altoEnemigo = 40;
        for (int fila = 0; fila < filas; fila++) {
            for (int col = 0; col < columnas; col++) {
                int x = 300 + col * (anchoEnemigo + 10);
                int y = 10 + fila * (altoEnemigo + 10);
                if (fila == 0) {
                    objetos.add(new EnemigoRapido(x, y));
                } else if (fila == 1) {
                    objetos.add(new EnemigoQueDispara(x, y));
                } else {
                    objetos.add(new EnemigoBasico(x, y));
                }
            }
        }
    }

    private void initNivel5() {
        int filas = 12;
        int columnas = 6;
        int anchoEnemigo = 40;
        int altoEnemigo = 40;
        for (int fila = 0; fila < filas; fila++) {
            for (int col = 0; col < columnas; col++) {
                int x = 250 + col * (anchoEnemigo + 10);
                int y = 10 + fila * (altoEnemigo + 10);
                if (fila == 0) {
                    objetos.add(new EnemigoRapido(x, y));
                } else if (fila == 1) {
                    objetos.add(new EnemigoQueDispara(x, y));
                } else {
                    objetos.add(new EnemigoBasico(x, y));
                }
            }
        }
    }

    public void actualizar() {
        if (juegoIniciado) {
            nave.actualizar();
            moverEnemigos();
            actualizarDisparos();
            verificarColisiones();
            verificarNivelCompleto();
        }
    }

    private void moverEnemigos() {
        boolean cambiarDireccion = false;
        List<Enemigo> enemigosAMover = new ArrayList<>();

        for (ObjetoDelJuego obj : objetos) {
            if (obj instanceof Enemigo) {
                Enemigo enemigo = (Enemigo) obj;
                enemigosAMover.add(enemigo);
            }
        }

        for (Enemigo enemigo : enemigosAMover) {
            if (moviendoDerecha) {
                enemigo.mover(VELOCIDAD, 0);
                if (enemigo.getX() >= LIMITE_DERECHO) {
                    cambiarDireccion = true;
                }
            } else {
                enemigo.mover(-VELOCIDAD, 0);
                if (enemigo.getX() <= LIMITE_IZQUIERDO) {
                    cambiarDireccion = true;
                }
            }
            enemigo.actualizar(); // Para actualizar los disparos de los enemigos
        }

        if (cambiarDireccion) {
            for (Enemigo enemigo : enemigosAMover) {
                enemigo.mover(0, DESPLAZAMIENTO_VERTICAL);
            }
            moviendoDerecha = !moviendoDerecha;
        }
    }

    private void actualizarDisparos() {
        List<Misil> misiles = nave.getMisiles();
        List<Misil> misilesARemover = new ArrayList<>();

        for (Misil misil : misiles) {
            if (misil.isVisible()) {
                misil.actualizar();
            } else {
                misilesARemover.add(misil);
            }
        }

        misiles.removeAll(misilesARemover);

        // Actualizar misiles disparados por enemigos
        List<ObjetoDelJuego> misilesEnemigosARemover = new ArrayList<>();
        for (ObjetoDelJuego obj : objetos) {
            if (obj instanceof MisilEnemigo) {
                MisilEnemigo misil = (MisilEnemigo) obj;
                if (misil.isVisible()) {
                    misil.actualizar();
                } else {
                    misilesEnemigosARemover.add(misil);
                }
            }
        }

        objetos.removeAll(misilesEnemigosARemover);
    }

    private void verificarColisiones() {
        List<Misil> misiles = nave.getMisiles();
        for (Misil misil : misiles) {
            for (int i = 0; i < objetos.size(); i++) {
                ObjetoDelJuego obj = objetos.get(i);
                if (obj instanceof Enemigo) {
                    Enemigo enemigo = (Enemigo) obj;
                    if (misil.getX() < enemigo.getX() + enemigo.getImagen().getWidth(null) &&
                            misil.getX() + misil.getImagen().getWidth(null) > enemigo.getX() &&
                            misil.getY() < enemigo.getY() + enemigo.getImagen().getHeight(null) &&
                            misil.getY() + misil.getImagen().getHeight(null) > enemigo.getY()) {
                        misil.setVisible(false);
                        enemigo.quitarVida();
                        if (enemigo.getVidas() <= 0) {
                            objetos.remove(i);
                        }
                        break;
                    }
                }
            }
        }
        /*List<Misil> misiles = nave.getMisiles();
        for (Misil misil : misiles) {
            for (int i = 0; i < objetos.size(); i++) {
                ObjetoDelJuego obj = objetos.get(i);
                if (obj instanceof Enemigo) {
                    Enemigo enemigo = (Enemigo) obj;
                    if (misil.getX() < enemigo.getX() + enemigo.getImagen().getWidth(null) &&
                            misil.getX() + misil.getImagen().getWidth(null) > enemigo.getX() &&
                            misil.getY() < enemigo.getY() + enemigo.getImagen().getHeight(null) &&
                            misil.getY() + misil.getImagen().getHeight(null) > enemigo.getY()) {
                        misil.setVisible(false);
                        enemigo.quitarVida();
                        if (enemigo.getVidas() <= 0) {
                            objetos.remove(i);
                        }
                        break;
                    }
                } else if (obj instanceof Defensa) {
                    Defensa defensa = (Defensa) obj;
                    if (misil.getX() < defensa.getX() + defensa.getImagen().getWidth(null) &&
                            misil.getX() + misil.getImagen().getWidth(null) > defensa.getX() &&
                            misil.getY() < defensa.getY() + defensa.getImagen().getHeight(null) &&
                            misil.getY() + misil.getImagen().getHeight(null) > defensa.getY()) {
                        misil.setVisible(false);
                        defensa.quitarVida();
                        if (!defensa.isVisible()) {
                            objetos.remove(i);
                        }
                        break;
                    }
                }
            }
        }*/
    }

    private void verificarNivelCompleto() {
        boolean nivelCompleto = objetos.stream().noneMatch(obj -> obj instanceof Enemigo);
        if (nivelCompleto) {
            VELOCIDAD +=1;
            nivel++;
            if (panel != null) {
                panel.setNivel(nivel);
            }
            initEnemigos();
        }
    }

    public static void agregarObjeto(ObjetoDelJuego objeto) {
        objetos.add(objeto);
    }

    public List<ObjetoDelJuego> getObjetos() {
        return objetos;
    }

    public Nave getJugador() {
        return nave;
    }

}
