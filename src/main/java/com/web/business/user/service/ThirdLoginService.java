package com.web.business.user.service;

import com.qq.connect.api.OpenID;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.oauth.Oauth;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @Date Created on 2017/3/30.
 * @Author SongJiuHua.
 * @description
 */
@Service
public class ThirdLoginService {

    OkHttpClient client = new OkHttpClient();

    private final static String AUTHORIZE_CODE_URL = "https://graph.qq.com/oauth2.0/authorize";


    /**
     * 根据appId获取AuthorizeCode
     * @param appId  申请QQ登录成功后，分配给应用的appId
     * @param redirectUri  成功授权后的回调地址
     */
    public void getQQAuthorizeCode(HttpServletRequest request1, String appId, String redirectUri){
        String url = AUTHORIZE_CODE_URL + "?response_type=code&client_id=" + appId + "&redirect_uri=" + redirectUri + "&state=test";
        try {
            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();

            AccessToken accessTokenObj = new Oauth().getAccessTokenByRequest(request1);
            String accessToken = accessTokenObj.getAccessToken();
            OpenID openIDObj = new OpenID(accessToken);
            String openID = openIDObj.getUserOpenID();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
