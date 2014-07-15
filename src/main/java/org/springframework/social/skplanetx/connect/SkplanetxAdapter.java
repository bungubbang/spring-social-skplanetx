package org.springframework.social.skplanetx.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.skplanetx.api.Skplanetx;
import org.springframework.social.skplanetx.api.user.dto.SkplanetxUserProfile;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/11/14
 */
public class SkplanetxAdapter implements ApiAdapter<Skplanetx> {
    @Override
    public boolean test(Skplanetx api) {
        try {
            api.getUser().getProfile();
            return true;
        } catch (ApiException e) {
            return false;
        }
    }

    @Override
    public void setConnectionValues(Skplanetx api, ConnectionValues values) {
        SkplanetxUserProfile userProfile = api.getUser().getProfile();

        values.setProviderUserId(userProfile.getUserId());
        values.setDisplayName(userProfile.getUserName());

        /**
         * SKplanetx 에서 지원하지 않는 필드
         */
        values.setImageUrl(null);
        values.setProfileUrl(null);
    }

    @Override
    public UserProfile fetchUserProfile(Skplanetx api) {
        SkplanetxUserProfile userProfile = api.getUser().getProfile();
        return new UserProfileBuilder()
                                    .setName(userProfile.getUserName())
                                    .setEmail(userProfile.getEmail())
                                    .setUsername(userProfile.getUserName())
                                .build();
    }


    /**
     * SKPlanetx 에서 아직 지원하지 않는 기능
     *
     * @param api
     * @param message
     */
    @Override
    public void updateStatus(Skplanetx api, String message) {

    }
}
