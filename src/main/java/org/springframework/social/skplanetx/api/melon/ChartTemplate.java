package org.springframework.social.skplanetx.api.melon;

import org.springframework.social.skplanetx.api.impl.AbstractSkplanetxOperations;
import org.springframework.social.skplanetx.api.melon.dto.Melon;
import org.springframework.web.client.RestTemplate;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/15/14
 */
public class ChartTemplate extends AbstractSkplanetxOperations implements ChartOperation {

    private RestTemplate restTemplate;
    private Integer version;

    public ChartTemplate(RestTemplate restTemplate, boolean isAuthorized, Integer version) {
        super(isAuthorized);
        this.restTemplate = restTemplate;
        this.version = version;
    }

    @Override
    public Melon getRealTime(int page, int count) {
        return restTemplate.getForObject("http://apis.skplanetx.com/melon/charts/realtime?version={version}&page={page}&count={count}", Melon.class, version, page, count);
    }

    @Override
    public Melon getTodayTopSongs(int page, int count) {
        return restTemplate.getForObject("http://apis.skplanetx.com/melon/charts/todaytopsongs?version={version}&page={page}&count={count}", Melon.class, version, page, count);
    }

    @Override
    public Melon getTopAlbums(int page, int count) {
        return restTemplate.getForObject("http://apis.skplanetx.com/melon/charts/topalbums?version={version}&page={page}&count={count}", Melon.class, version, page, count);
    }

    @Override
    public Melon getTopGenres(int page, int count) {
        return restTemplate.getForObject("http://apis.skplanetx.com/melon/charts/topgenres?version={version}&page={page}&count={count}", Melon.class, version, page, count);
    }

    @Override
    public Melon getTopGenres(int page, int count, String genreId) {
        return restTemplate.getForObject("http://apis.skplanetx.com/melon/charts/topgenres/{genreId}?version={version}&page={page}&count={count}", Melon.class, genreId, version, page, count);
    }

    @Override
    public Melon getGenres() {
        return restTemplate.getForObject("http://apis.skplanetx.com/melon/genres?version={version}", Melon.class, version);
    }


}