package Assets;

import Assets.Logo;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class DolbySystem {

    public void backgroundMusicCinematic() throws LineUnavailableException, UnsupportedAudioFileException, IOException, InterruptedException {

        Clip clip = AudioSystem.getClip();
        File file = new File("/Users/mindera/Documents/batalha-naval/Naval-Battle/src/Sound/music.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip.open(audioInputStream);
        clip.start();
        Logo.logoCinematic();
        clip.stop();
    }
    public void player1Sound() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        Clip clip = AudioSystem.getClip();
        File file = new File("/Users/mindera/Documents/School/NavalBattle/src/Sound/player1Wins.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip.open(audioInputStream);
        clip.start();
    }
    public void player2Sound() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        Clip clip = AudioSystem.getClip();
        File file = new File("/Users/mindera/Documents/School/NavalBattle/src/Sound/player2Wins.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip.open(audioInputStream);
        clip.start();
    }


    public void backgroundMusic() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        Clip clip = AudioSystem.getClip();
        File file = new File("/Users/mindera/Documents/batalha-naval/Naval-Battle/src/Sound/music.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip.open(audioInputStream);
        clip.loop(10);
        clip.start();
    }

    public void chooseOption() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        Clip clip = AudioSystem.getClip();
        File file = new File("/Users/mindera/Documents/batalha-naval/Naval-Battle/src/Sound/chooseOption.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip.open(audioInputStream);
        clip.start();
    }

    public void bombSound() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        Clip clip = AudioSystem.getClip();
        File file = new File("/Users/mindera/Documents/batalha-naval/Naval-Battle/src/Sound/bomb.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip.open(audioInputStream);
        clip.start();
    }

    public void splashSound() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        Clip clip = AudioSystem.getClip();
        File file = new File("/Users/mindera/Documents/batalha-naval/Naval-Battle/src/Sound/splash.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip.open(audioInputStream);
        clip.start();
    }

    public void fatalitySound() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        Clip clip = AudioSystem.getClip();
        File file = new File("/Users/mindera/Documents/batalha-naval/Naval-Battle/src/Sound/fatality.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip.open(audioInputStream);
        clip.start();
    }

    public void cheatSound() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        Clip clip = AudioSystem.getClip();
        File file = new File("/Users/mindera/Documents/batalha-naval/Naval-Battle/src/Sound/aii.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip.open(audioInputStream);
        clip.start();
    }

    public void youLose() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        Clip clip = AudioSystem.getClip();
        File file = new File("/Users/mindera/Documents/batalha-naval/Naval-Battle/src/Sound/youLose.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip.open(audioInputStream);
        clip.start();
    }

    public void youWin() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        Clip clip = AudioSystem.getClip();
        File file = new File("/Users/mindera/Documents/batalha-naval/Naval-Battle/src/Sound/youWin.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip.open(audioInputStream);
        clip.start();
    }
}