package com.tom.springexcel.soundsystem;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Qualifier("bkd")
@Configuration
public class BlankDisc implements CompactDisc {
    private String title;
    private String artist;
    private List<String> list;

    public BlankDisc() {

    }

    public BlankDisc(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.play();

    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void play() {
        System.out.println(title + "........" + artist + list);
    }
}
