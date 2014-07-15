package org.springframework.social.skplanetx.api.melon.dto;

import java.util.List;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/15/14
 */
public class Genres {
    private List<Genre> genre;

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Genres{" +
                "genre=" + genre +
                '}';
    }
}
