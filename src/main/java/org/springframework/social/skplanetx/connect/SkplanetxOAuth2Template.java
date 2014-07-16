package org.springframework.social.skplanetx.connect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.skplanetx.connect.response.TokenResponse;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/11/14
 */
public class SkplanetxOAuth2Template extends OAuth2Template {

    private static final String	AUTHORIZE_URL		= "https://oneid.skplanetx.com/oauth/authorize";
    private static final String	ACCESS_TOKEN_URL	= "https://oneid.skplanetx.com/oauth/token";

    public SkplanetxOAuth2Template(String appId, String appSecret) {
        super(appId, appSecret, AUTHORIZE_URL, ACCESS_TOKEN_URL);
        setUseParametersForClientAuthentication(true);
    }

    @Override
    protected RestTemplate createRestTemplate() {
        return super.createRestTemplate();
    }

    @Override
    protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
        String tokenUrl = accessTokenUrl
                                    + "?client_id={client_id}"
                                    + "&client_secret={client_secret}"
                                    + "&code={code}"
                                    + "&scope={scope}"
                                    + "&redirect_uri={redirect_uri}"
                                    + "&grant_type=authorization_code";

        TokenResponse response = getRestTemplate().getForObject(tokenUrl, TokenResponse.class, parameters.toSingleValueMap());
        Long expires = response.getExpires_in();
        return new AccessGrant(response.getAccess_token(), response.getScope(), response.getRefresh_token(), expires != null ? expires : null);
    }


}
