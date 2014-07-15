package org.springframework.social.skplanetx.api.melon.dto;

import java.util.List;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/15/14
 */
public class Albums {
    private List<Album> album;

    public List<Album> getAlbum() {
        return album;
    }

    public void setAlbum(List<Album> album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Albums{" +
                "album=" + album +
                '}';
    }
}
