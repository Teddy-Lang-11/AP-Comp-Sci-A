package finalsemestertwogameproject;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * SoundPlayer - loads .wav files from inside the project (src folder).
 * Files must be in: src/finalsemestertwogameproject/sounds/
 * NetBeans copies them into the build automatically on Clean and Build.
 */
public class Soundplayer {

    /**
     * Plays a .wav file and waits for it to finish.
     * Use for win and lose sounds.
     */
    public static void play(String soundFile) {
        Clip clip = loadClip(soundFile);
        if (clip == null) return;

        try {
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 1000);
            clip.close();
        } catch (InterruptedException e) {
            clip.close();
        }
    }

    /**
     * Plays a .wav file on loop in the background (non-blocking).
     * Use for spin sound. Call stopClip() when done.
     */
    public static Clip playAsync(String soundFile) {
        Clip clip = loadClip(soundFile);
        if (clip == null) return null;

        clip.loop(Clip.LOOP_CONTINUOUSLY);
        clip.start();
        return clip;
    }

    /**
     * Stops and closes a clip returned by playAsync().
     */
    public static void stopClip(Clip clip) {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }

    /**
     * Internal helper - tries TWO locations to find the sound file:
     *   1. Inside the compiled jar/build (from src folder) - works after Clean & Build
     *   2. Directly next to the project files - works as a fallback
     */
    private static Clip loadClip(String soundFile) {
        // Try 1: load from inside the build (src/finalsemestertwogameproject/sounds/)
        try {
            InputStream stream = Soundplayer.class.getResourceAsStream(
                    "/finalsemestertwogameproject/sounds/" + soundFile);

            if (stream != null) {
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(stream);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                return clip;
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            // fall through to try #2
        }

        // Try 2: load directly from the filesystem (project root folder)
        try {
            File file = new File(soundFile);
            if (file.exists()) {
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                return clip;
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            // fall through to error
        }

        // Neither location worked - print the paths we tried
        System.out.println("[Sound] Could not find: " + soundFile);
        System.out.println("[Sound] Tried: src/finalsemestertwogameproject/sounds/" + soundFile);
        System.out.println("[Sound] Tried: " + new File(soundFile).getAbsolutePath());
        return null;
    }
}