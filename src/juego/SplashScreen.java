package juego;

import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JWindow {

    private final int duration;

    public SplashScreen(int duration) {
        this.duration = duration;
    }

    public void showSplash() {
        JPanel content = (JPanel) getContentPane();
        content.setBackground(Color.white);

        // Establecer el tamaño del Splash Screen
        int width = 800;
        int height = 600;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);

        // Añadir una imagen al Splash Screen
        JLabel label = new JLabel(new ImageIcon("src/recursos_gráficos/logos/SplashScreen.png"));
        content.add(label, BorderLayout.CENTER);

        // Añadir un mensaje de copyright en la parte inferior
        JLabel copyrt = new JLabel("Copyright 2024", JLabel.CENTER);
        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 24));
        content.add(copyrt, BorderLayout.SOUTH);

        // Mostrar el Splash Screen
        setVisible(true);

        // Esperar la duración especificada
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        setVisible(false);
    }

    public void showSplashAndExit() {
        showSplash();
        // Después de que el splash screen desaparezca, mostrar el menú principal
        Juego juego = new Juego();
        juego.setVisible(true);

    }


}
