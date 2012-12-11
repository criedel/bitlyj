package com.rosaloves.bitlyj;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.rosaloves.bitlyj.data.Pair;

public class OauthBitlyProvider extends SimpleProvider {

    private static final String OAUTH_ENDPOINT = "https://api-ssl.bitly.com/v3";
    private String accessToken;

    public OauthBitlyProvider(String accessToken) {
        super(null, null, null, null);
        this.accessToken = accessToken;
    }

    @Override
    public String toString() {
        return "OAuth Bitly Provider";
    }

    @Override
    protected String getUrlForCall(BitlyMethod<?> m) {
        StringBuilder sb = new StringBuilder(OAUTH_ENDPOINT).append(m.getName() + "?").append("&access_token=").append(accessToken).append("&format=xml");

        try {
            for (Pair<String, String> p : m.getParameters()) {
                sb.append("&" + p.getOne() + "=" + URLEncoder.encode(p.getTwo(), "UTF-8"));
            }
        }
        catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
