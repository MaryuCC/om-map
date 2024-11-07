package com.cola.omlink.utils;

import jakarta.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractHeaderUtil {
    private static final Pattern BEARER_PATTERN = Pattern.compile("^Bearer\\s+(\\S+)$");

    public static String extractToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        Matcher matcher = BEARER_PATTERN.matcher(authHeader != null ? authHeader : "");
        if (matcher.find()) {
            return matcher.group(1);
        }
        return request.getHeader("x-vapi-secret");
    }
}
