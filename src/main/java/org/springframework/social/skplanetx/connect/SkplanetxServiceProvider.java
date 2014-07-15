package org.springframework.social.skplanetx.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.skplanetx.api.Skplanetx;
import org.springframework.social.skplanetx.api.impl.SkplanetxTemplate;
import org.springframework.util.Assert;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/11/14
 */
public class SkplanetxServiceProvider extends AbstractOAuth2ServiceProvider<Skplanetx> {

    private final String appKey;

    public SkplanetxServiceProvider(String appId, String appSecret, String appKey) {
        super(new SkplanetxOAuth2Template(appId, appSecret));

        Assert.notNull(appKey, "Appkey cannot be null");
        this.appKey = appKey;
    }

    @Override
    public Skplanetx getApi(String accessToken) {
        return new SkplanetxTemplate(appKey, accessToken);
    }
}
