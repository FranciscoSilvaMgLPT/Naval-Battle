import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class DolbySystem {

    public void backgroundMusic() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        Clip clip = AudioSystem.getClip();
        File file = new File("/Users/mindera/Documents/School/NavalBattle/src/Sound/music.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip.open(audioInputStream);
        clip.loop(10);
        clip.start();
    }

    public void bombSound() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        Clip clip = AudioSystem.getClip();
        File file = new File("/Users/mindera/Documents/School/NavalBattle/src/Sound/explosion.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip.open(audioInputStream);
        clip.start();
    }

    public void splashSound() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        Clip clip = AudioSystem.getClip();
        File file = new File("/Users/mindera/Documents/School/NavalBattle/src/Sound/splash.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip.open(audioInputStream);
        clip.start();
    }

    public void fatalitySound() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        Clip clip = AudioSystem.getClip();
        File file = new File("/Users/mindera/Documents/School/NavalBattle/src/Sound/fatality.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip.open(audioInputStream);
        clip.start();
    }

    public void cheatSound() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        Clip clip = AudioSystem.getClip();
        File file = new File("/Users/mindera/Documents/School/NavalBattle/src/Sound/aii.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip.open(audioInputStream);
        clip.start();
    }
}
