package com.tom.springexcel.concert;

import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
@Configuration
public class BlankDisc implements CompactDisc{
    private List<String> Artist;
    private List<String> Song;
    private List<Integer> track;

    public BlankDisc() {
        this.Artist = new ArrayList<String>();
        Artist.add("a");
        Artist.add("b");
        this.Song = new ArrayList<String>();
        Song.add("aa");
        Song.add("bb");
        this.track = new ArrayList<Integer>();
        track.add(1);
        track.add(2);
    }
    public void setArtist(List<String> artist) {
        Artist = artist;
    }

    public void setSong(List<String> song) {
        Song = song;
    }

    public void setTrack(List<Integer> track) {
        this.track = track;
    }

    public void playTrack(int number) {
        System.out.println(Artist.get(number) + "   " + Song.get(number) + "     " + track.get(number));
    }
}
