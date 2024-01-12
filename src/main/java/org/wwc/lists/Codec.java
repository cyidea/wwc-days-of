package org.wwc.lists;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * this is leetcode problem: <a href="https://leetcode.com/problems/encode-and-decode-tinyurl/">tinyURL problem</a>
 * since it is part of the medium list problem so it is here.
 */
public class Codec {

    Map<String, Integer> encodeMap = new HashMap<>();
    Map<String, String> decodeMap = new HashMap<>();

    int nextval = 0;
    String baseUrl = "http://tinyurl.com/";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        Integer retval = encodeMap.get(longUrl);
        // if there is no such url encoded already, we need to get the next available number
        String ret = "";
        if (retval == null) {
            retval = ++nextval;
            encodeMap.put(longUrl, retval);
            ret = baseUrl + retval;
            decodeMap.put(ret, longUrl);
        } else {
            // if can get the number
            ret = baseUrl + retval;
        }
        return ret;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decodeMap.get(shortUrl);
    }
}

