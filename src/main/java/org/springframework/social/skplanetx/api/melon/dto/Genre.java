package org.springframework.social.skplanetx.api.melon.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/15/14
 */
@JsonRootName("genre")
public class Genre {
    private String genreName;
    private String genreId;

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getGenreId() {
        return genreId;
    }

    public void setGenreId(String genreId) {
        this.genreId = genreId;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreName='" + genreName + '\'' +
                ", genreId='" + genreId + '\'' +
                '}';
    }
}
