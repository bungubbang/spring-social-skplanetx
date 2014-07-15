package org.springframework.social.skplanetx.api.user.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/11/14
 */
@JsonRootName(value = "profile")
public class SkplanetxUserProfile implements Serializable {

    private String serviceNo;   // 3rd party에게 제공되는 사용자 구분 값
    private String userId;      // 사용자 ID
    private String userName;    // 사용자 이름
    private String email;       // 이메일 주소

    public String getServiceNo() {
        return serviceNo;
    }

    public void setServiceNo(String serviceNo) {
        this.serviceNo = serviceNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkplanetxUserProfile)) return false;

        SkplanetxUserProfile that = (SkplanetxUserProfile) o;

        if (!userId.equals(that.userId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return userId.hashCode();
    }

    @Override
    public String toString() {
        return "SkplanetxUserProfile{" +
                "serviceNo='" + serviceNo + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
