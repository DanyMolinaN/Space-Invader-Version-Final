package juego;

import javax.swing.*;

public class Juego extends JFrame {

    public Juego() {
        initUI();
    }

    private void initUI() {
        MenúPrincipal menúPrincipal = new MenúPrincipal(this);
        setContentPane(menúPrincipal.getPanel2());
        setTitle("Space Invaders");
        setSize(1080, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SplashScreen splash = new SplashScreen(5000); // Mostrar el splash por 5 segundos
        splash.showSplashAndExit();
    }
}
