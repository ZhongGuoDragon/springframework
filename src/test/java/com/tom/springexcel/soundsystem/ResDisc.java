package com.tom.springexcel.soundsystem;

import java.util.List;

public class ResDisc {
    public String title;
    public String artist;
    public List<Integer> tracks;

    public void setTitle(String title) {
        this.title=title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List list) {
        this.tracks = list;
    }

    public void run() {
        System.out.println(title + "...." + artist + "....." + tracks.toString());
    }


}
