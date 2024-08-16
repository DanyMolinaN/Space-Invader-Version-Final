package juego;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class GestorSonidos {
    private Clip shootClip;
    private Clip backgroundMusicClip;

    public GestorSonidos() {
       /* try {
            // Cargar el sonido del disparo
            shootClip = AudioSystem.getClip();
            AudioInputStream shootSound = AudioSystem.getAudioInputStream(new File("sounds/shoot.wav"));
            shootClip.open(shootSound);

            // Cargar la música de fondo
            backgroundMusicClip = AudioSystem.getClip();
            AudioInputStream backgroundMusic = AudioSystem.getAudioInputStream(new File("src/recursos_sonidos/Bgm2.wav"));
            backgroundMusicClip.open(backgroundMusic);
            backgroundMusicClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }*/
    }

    public void playShootSound() {
        if (shootClip.isRunning()) {
            shootClip.stop(); // detener el sonido si ya se está reproduciendo
        }
        shootClip.setFramePosition(0); // rebobinar el sonido
        shootClip.start();
    }

    public void playBackgroundMusic() {
        backgroundMusicClip.start();
    }

    public void stopBackgroundMusic() {
        backgroundMusicClip.stop();
    }

    public void reproducirBGM(String bgm) {
        try {
            // Cargar el sonido del disparo
            shootClip = AudioSystem.getClip();
            AudioInputStream shootSound = AudioSystem.getAudioInputStream(new File(bgm));
            shootClip.open(shootSound);

            // Cargar la música de fondo
            backgroundMusicClip = AudioSystem.getClip();
            AudioInputStream backgroundMusic = AudioSystem.getAudioInputStream(new File(bgm));
            backgroundMusicClip.open(backgroundMusic);
            backgroundMusicClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }
}
