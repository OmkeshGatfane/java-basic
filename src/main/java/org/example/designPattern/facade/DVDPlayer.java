package org.example.designPattern.facade;

public class DVDPlayer {
    public void on(){
        System.out.println("DVD Player is ON");
    }

    public void play(String movie){
        System.out.println("Playing movie: " + movie);
    }

    public void stop(){
        System.out.println("DVD Player is STOPPED");
    }

    public void off(){
        System.out.println("DVD Player is OFF");
    }
}

class SoundSystem{

    public void on(){
        System.out.println("Home Theater is ON");
    }
    public void off(){
        System.out.println("Home Theater is OFF");
    }
}

class Projector{
    public void on(){
        System.out.println("Projector is ON");
    }
    public void off(){
        System.out.println("Projector is OFF");
    }
}
