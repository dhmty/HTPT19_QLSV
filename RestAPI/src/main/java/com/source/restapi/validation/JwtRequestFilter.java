package com.source.restapi.validation;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebFilter(urlPatterns = "/api/*")
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Value("${secretKey}")
    String secretKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try{
            // response validate JWT
            String jwt = getJwtFromRequest(request);
            if (StringUtils.hasText(jwt) && validateRequest(jwt, secretKey)) {
                request.setAttribute("token", jwt);
                filterChain.doFilter(request, response);
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("AUTHENTICATION_ERROR");
            }
        }
        catch (Exception  ex) {
            filterChain.doFilter(request, response);
        }
    }

    private String getJwtFromRequest(HttpServletRequest request) {

        String bearerToken = request.getHeader("Authorization");
        // Kiểm tra xem header Authorization có chứa thông tin jwt không
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public static boolean validateRequest(String token, String sKey) throws Exception {
        try {
            if (Objects.equals(Jwts.parser().setSigningKey(sKey).parseClaimsJws(token).getHeader().getAlgorithm(),
                    String.valueOf(SignatureAlgorithm.HS256))) {
                return true;
            }

        } catch (MalformedJwtException | SignatureException | IllegalArgumentException | UnsupportedJwtException | ExpiredJwtException ex) {
            return false;
        }
        return false;
    }
}