package org.springframework.social.skplanetx.api.melon.dto;

import java.util.List;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/14/14
 */
public class Songs {
    private List<Song> song;

    public List<Song> getSong() {
        return song;
    }

    public void setSong(List<Song> song) {
        this.song = song;
    }

    @Override
    public String toString() {
        return "Songs{" +
                "song=" + song +
                '}';
    }
}
