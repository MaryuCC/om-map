package com.cola.ommap.config;


import com.cola.ommap.config.auth.StoredApiToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static com.cola.ommap.utils.ExtractHeaderUtil.extractToken;


@Component
public class BearerTokenFilter extends OncePerRequestFilter {
    private final StoredApiToken storedApiToken;

    public BearerTokenFilter(StoredApiToken storedApiToken) {
        this.storedApiToken = storedApiToken;
    }

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request,
                                    @NotNull HttpServletResponse response,
                                    @NotNull FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        // 排除 /doc.html 不进行过滤
        if ("/doc.html".equals(requestURI)) {
            filterChain.doFilter(request, response);
            return;
        }

        String tokenText = extractToken(request);

        if (tokenText != null) {
            Authentication authentication = storedApiToken.verifyToken(tokenText);
            if (authentication != null) {
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }
}
