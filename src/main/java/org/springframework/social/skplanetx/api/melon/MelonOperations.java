package org.springframework.social.skplanetx.api.melon;

import org.springframework.social.skplanetx.api.melon.dto.Melon;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/11/14
 */
public interface MelonOperations {

    ChartOperation getChart();
    NewReleasesOperation getNewReleases();
}
