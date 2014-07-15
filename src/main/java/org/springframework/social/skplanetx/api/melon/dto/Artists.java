package org.springframework.social.skplanetx.api.melon.dto;

import java.util.List;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/14/14
 */
public class Artists {
    List<Artist> artist;

    public List<Artist> getArtist() {
        return artist;
    }

    public void setArtist(List<Artist> artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Artists{" +
                "artist=" + artist +
                '}';
    }
}
