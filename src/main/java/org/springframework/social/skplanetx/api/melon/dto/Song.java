package org.springframework.social.skplanetx.api.melon.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/14/14
 */
@JsonRootName("song")
public class Song {
    private Long songId;
    private String songName;
    private Artists artists;
    private Long albumId;
    private String albumName;
    private Long currentRank;
    private Long pastRank;
    private Long rankDay;
    private Long playTime;
    private String issueDate;
    private String isTitleSong;
    private String isHitSong;
    private String isAdult;
    private String isFree;

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Artists getArtists() {
        return artists;
    }

    public void setArtists(Artists artists) {
        this.artists = artists;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Long getCurrentRank() {
        return currentRank;
    }

    public void setCurrentRank(Long currentRank) {
        this.currentRank = currentRank;
    }

    public Long getPastRank() {
        return pastRank;
    }

    public void setPastRank(Long pastRank) {
        this.pastRank = pastRank;
    }

    public Long getRankDay() {
        return rankDay;
    }

    public void setRankDay(Long rankDay) {
        this.rankDay = rankDay;
    }

    public Long getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Long playTime) {
        this.playTime = playTime;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getIsTitleSong() {
        return isTitleSong;
    }

    public void setIsTitleSong(String isTitleSong) {
        this.isTitleSong = isTitleSong;
    }

    public String getIsHitSong() {
        return isHitSong;
    }

    public void setIsHitSong(String isHitSong) {
        this.isHitSong = isHitSong;
    }

    public String getIsAdult() {
        return isAdult;
    }

    public void setIsAdult(String isAdult) {
        this.isAdult = isAdult;
    }

    public String getIsFree() {
        return isFree;
    }

    public void setIsFree(String isFree) {
        this.isFree = isFree;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songId=" + songId +
                ", songName='" + songName + '\'' +
                ", artists=" + artists +
                ", albumId=" + albumId +
                ", albumName='" + albumName + '\'' +
                ", currentRank=" + currentRank +
                ", pastRank=" + pastRank +
                ", rankDay=" + rankDay +
                ", playTime=" + playTime +
                ", issueDate='" + issueDate + '\'' +
                ", isTitleSong=" + isTitleSong +
                ", isHitSong=" + isHitSong +
                ", isAudult=" + isAdult +
                ", isFree=" + isFree +
                '}';
    }
}
