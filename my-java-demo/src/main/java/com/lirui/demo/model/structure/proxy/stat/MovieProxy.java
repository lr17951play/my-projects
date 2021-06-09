package com.lirui.demo.model.structure.proxy.stat;

import com.lirui.demo.model.structure.proxy.Imovie;
import com.lirui.demo.model.structure.proxy.Movie;

public class MovieProxy implements Imovie {

    private final String BEFORE = "1";
    private final String AFTER = "2";

    private Movie movie;

    public MovieProxy(Movie movie){
        this.movie = movie;
    }
    @Override
    public void play() {
        advertise(BEFORE);
        movie.play();
        advertise(AFTER);
    }

    private void advertise(String when) {
        if (BEFORE.equals(when)) {
            System.out.println("开场广告走一波");
        } else {
            System.out.println("散场广告再走一波");
        }
    }
}
