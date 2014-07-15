package org.springframework.social.skplanetx.api.melon.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/15/14
 */
@JsonRootName("album")
public class Album {
    private Long albumId;
    private String albumName;
    private Artists artists;
    private Long repSongId;
    private String repSongName;
    private Artists repArtists;
    private Long currentRank;
    private Long pastRank;
    private Long repSongCurrentRank;
    private Long repSongPastRank;
    private String issueDate;
    private String albumType;
    private Long totalSongCount;
    private String averageScore;

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

    public Artists getArtists() {
        return artists;
    }

    public void setArtists(Artists artists) {
        this.artists = artists;
    }

    public Long getRepSongId() {
        return repSongId;
    }

    public void setRepSongId(Long repSongId) {
        this.repSongId = repSongId;
    }

    public String getRepSongName() {
        return repSongName;
    }

    public void setRepSongName(String repSongName) {
        this.repSongName = repSongName;
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

    public Long getRepSongCurrentRank() {
        return repSongCurrentRank;
    }

    public void setRepSongCurrentRank(Long repSongCurrentRank) {
        this.repSongCurrentRank = repSongCurrentRank;
    }

    public Long getRepSongPastRank() {
        return repSongPastRank;
    }

    public void setRepSongPastRank(Long repSongPastRank) {
        this.repSongPastRank = repSongPastRank;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getAlbumType() {
        return albumType;
    }

    public void setAlbumType(String albumType) {
        this.albumType = albumType;
    }

    public Artists getRepArtists() {
        return repArtists;
    }

    public void setRepArtists(Artists repArtists) {
        this.repArtists = repArtists;
    }

    public Long getTotalSongCount() {
        return totalSongCount;
    }

    public void setTotalSongCount(Long totalSongCount) {
        this.totalSongCount = totalSongCount;
    }

    public String getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(String averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumId=" + albumId +
                ", albumName='" + albumName + '\'' +
                ", artists=" + artists +
                ", repSongId=" + repSongId +
                ", repSongName='" + repSongName + '\'' +
                ", repArtists=" + repArtists +
                ", currentRank=" + currentRank +
                ", pastRank=" + pastRank +
                ", repSongCurrentRank=" + repSongCurrentRank +
                ", repSongPastRank=" + repSongPastRank +
                ", issueDate='" + issueDate + '\'' +
                ", albumType='" + albumType + '\'' +
                ", totalSongCount=" + totalSongCount +
                ", averageScore='" + averageScore + '\'' +
                '}';
    }
}
