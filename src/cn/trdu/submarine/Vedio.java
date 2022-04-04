package cn.trdu.submarine;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;
public class Vedio extends Thread{
    //音效类

        Player player;
        String music;
        public Vedio(String file) {
            this.music = file;
        }
        public void run() {
            try {
                play();
            } catch (FileNotFoundException | JavaLayerException e) {
                e.printStackTrace();
            }
        }
        public void play() throws FileNotFoundException, JavaLayerException {
            BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(music));
            player = new Player(buffer);
            player.play();
        }



}
