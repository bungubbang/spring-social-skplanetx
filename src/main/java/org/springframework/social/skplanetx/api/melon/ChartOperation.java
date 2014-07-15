package org.springframework.social.skplanetx.api.melon;

import org.springframework.social.skplanetx.api.melon.dto.Melon;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/15/14
 */
public interface ChartOperation {
    Melon getRealTime(int page, int count);
    Melon getTodayTopSongs(int page, int count);
    Melon getTopAlbums(int page, int count);
    Melon getTopGenres(int page, int count);
    Melon getTopGenres(int page, int count, String genreId);
    Melon getGenres();
}
