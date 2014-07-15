package org.springframework.social.skplanetx.api.melon;

import org.springframework.social.skplanetx.api.impl.AbstractSkplanetxOperations;
import org.springframework.social.skplanetx.api.melon.dto.Melon;
import org.springframework.web.client.RestTemplate;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/15/14
 */
public class SearchTemplate extends AbstractSkplanetxOperations implements SearchOperation {

    private RestTemplate restTemplate;
    private Integer version;

    public SearchTemplate(RestTemplate restTemplate, boolean isAuthorized, Integer version) {
        super(isAuthorized);
        this.restTemplate = restTemplate;
        this.version = version;
    }

    @Override
    public Melon searchAlbums(int page, int count, String keyword) {
        return restTemplate.getForObject("http://apis.skplanetx.com/melon/charts/realtime?version={version}&page={page}&count={count}", Melon.class, version, page, count);
    }

    @Override
    public Melon searchArtists(int page, int count, String keyword) {
        return null;
    }

    @Override
    public Melon searchSongs(int page, int count, String keyword) {
        return null;
    }
}
