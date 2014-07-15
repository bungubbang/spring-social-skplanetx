package org.springframework.social.skplanetx.api.melon;

import org.springframework.social.skplanetx.api.melon.dto.Melon;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/15/14
 */
public interface SearchOperation {
    Melon searchAlbums(int page, int count, String keyword);
    Melon searchArtists(int page, int count, String keyword);
    Melon searchSongs(int page, int count, String keyword);
}
