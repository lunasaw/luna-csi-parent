package com.luna.csi.req;

/**
 * @author luna@mac
 * 2021年05月07日 19:04
 */
public class RegisterFaceReq {

    private String faceToken;

    private String faceUrl;

    private Long   userId;

    public String getFaceToken() {
        return faceToken;
    }

    public void setFaceToken(String faceToken) {
        this.faceToken = faceToken;
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
