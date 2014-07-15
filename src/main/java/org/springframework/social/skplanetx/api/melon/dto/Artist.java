package org.springframework.social.skplanetx.api.melon.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/14/14
 */
@JsonRootName("artist")
public class Artist {
    private Long artistId;
    private String artistName;

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistId=" + artistId +
                ", artistName='" + artistName + '\'' +
                '}';
    }
}
