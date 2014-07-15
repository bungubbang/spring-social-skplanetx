package org.springframework.social.skplanetx.api;

import org.springframework.social.skplanetx.api.melon.MelonOperations;
import org.springframework.social.skplanetx.api.user.UserOperations;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/11/14
 */
public interface Skplanetx {

    UserOperations getUser();

    MelonOperations getMelon();
}
