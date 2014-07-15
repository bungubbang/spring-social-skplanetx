package org.springframework.social.skplanetx.api.melon;

import org.springframework.social.skplanetx.api.impl.AbstractSkplanetxOperations;
import org.springframework.social.skplanetx.api.melon.dto.Melon;
import org.springframework.web.client.RestTemplate;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/15/14
 */
public class NewReleasesTemplate extends AbstractSkplanetxOperations implements NewReleasesOperation {

    private RestTemplate restTemplate;
    private Integer version;

    public NewReleasesTemplate(RestTemplate restTemplate, boolean isAuthorized, Integer version) {
        super(isAuthorized);
        this.restTemplate = restTemplate;
        this.version = version;
    }

    @Override
    public Melon getAlbums(int page, int count) {
        return restTemplate.getForObject("http://apis.skplanetx.com/melon/newreleases/albums?version={version}&page={page}&count={count}", Melon.class, version, page, count);
    }

    @Override
    public Melon getAlbums(int page, int count, String genreId) {
        return restTemplate.getForObject("http://apis.skplanetx.com/melon/newreleases/albums/{genreId}?version={version}&page={page}&count={count}", Melon.class, genreId, version, page, count);
    }

    @Override
    public Melon getSongs(int page, int count) {
        return restTemplate.getForObject("http://apis.skplanetx.com/melon/newreleases/songs?version={version}&page={page}&count={count}", Melon.class, version, page, count);
    }

    @Override
    public Melon getSongs(int page, int count, String genreId) {
        return restTemplate.getForObject("http://apis.skplanetx.com/melon/newreleases/songs/{genreId}?version={version}&page={page}&count={count}", Melon.class, genreId, version, page, count);
    }

}
