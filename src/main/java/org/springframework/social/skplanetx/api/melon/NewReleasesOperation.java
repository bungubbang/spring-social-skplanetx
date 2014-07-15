package org.springframework.social.skplanetx.api.melon;

import org.springframework.social.skplanetx.api.melon.dto.Melon;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/15/14
 */
public interface NewReleasesOperation {
    Melon getAlbums(int page, int count);
    Melon getAlbums(int page, int count, String genreId);
    Melon getSongs(int page, int count);
    Melon getSongs(int page, int count, String genreId);
}
