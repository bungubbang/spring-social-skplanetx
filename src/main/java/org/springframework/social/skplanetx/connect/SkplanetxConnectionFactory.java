package org.springframework.social.skplanetx.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.skplanetx.api.Skplanetx;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/11/14
 */
public class SkplanetxConnectionFactory extends OAuth2ConnectionFactory<Skplanetx> {

    public SkplanetxConnectionFactory(String appId, String appSecret, String appKey) {
        super("skplanetx", new SkplanetxServiceProvider(appId, appSecret, appKey), new SkplanetxAdapter());
    }
}
