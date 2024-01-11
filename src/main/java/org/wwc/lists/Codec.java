package org.wwc.lists;

import java.util.Base64;

/**
 * this is leetcode problem: <a href="https://leetcode.com/problems/encode-and-decode-tinyurl/">tinyURL problem</a>
 * since it is part of the medium list problem so it is here.
 */
public class Codec {

    String baseUrl = "http://tinyurl.com/";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String retval = Base64.getEncoder().encodeToString(longUrl.getBytes());
        return baseUrl + retval;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String retval = shortUrl.split(baseUrl)[1];
        return new String(Base64.getDecoder().decode(retval));
    }
}

