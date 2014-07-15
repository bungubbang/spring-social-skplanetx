package org.springframework.social.skplanetx.api.melon.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/14/14
 */
@JsonRootName("melon")
public class Melon {
    private Long menuId;
    private Long count;
    private Long page;
    private Long totalPages;
    private Long rankDay;
    private Long rankHour;
    private Songs songs;
    private Albums albums;
    private Genres genres;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public Long getRankDay() {
        return rankDay;
    }

    public void setRankDay(Long rankDay) {
        this.rankDay = rankDay;
    }

    public Long getRankHour() {
        return rankHour;
    }

    public void setRankHour(Long rankHour) {
        this.rankHour = rankHour;
    }

    public Songs getSongs() {
        return songs;
    }

    public void setSongs(Songs songs) {
        this.songs = songs;
    }

    public Genres getGenres() {
        return genres;
    }

    public void setGenres(Genres genres) {
        this.genres = genres;
    }

    public Albums getAlbums() {
        return albums;
    }

    public void setAlbums(Albums albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return "Melon{" +
                "menuId=" + menuId +
                ", count=" + count +
                ", page=" + page +
                ", totalPages=" + totalPages +
                ", rankDay=" + rankDay +
                ", rankHour=" + rankHour +
                ", songs=" + songs +
                ", albums=" + albums +
                ", genres=" + genres +
                '}';
    }
}
