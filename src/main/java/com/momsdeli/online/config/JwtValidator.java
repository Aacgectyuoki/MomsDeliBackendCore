package com.momsdeli.online.config;

import com.momsdeli.online.utils.MomsDeliUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.Nonnull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.List;

public class JwtValidator extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtValidator.class);

    @Override
    protected void doFilterInternal(@Nonnull HttpServletRequest request, @Nonnull HttpServletResponse response, @Nonnull FilterChain filterChain) throws ServletException, IOException {
        String jwt = request.getHeader(MomsDeliUtils.JWT_HEADER);

        if (StringUtils.isNotBlank(jwt)) {
            jwt = jwt.substring(7); // Remove "Bearer " prefix

            try {
                SecretKey secretKey = Keys.hmacShaKeyFor(MomsDeliUtils.SECRET_KEY.getBytes());
                Claims claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(jwt).getBody();

                String email = String.valueOf(claims.get("email"));
                String authorities = String.valueOf(claims.get("authorities"));
                List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);

                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, null, grantedAuthorities);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                logger.debug("JWT Token successfully validated for user: {}", email);
            } catch (Exception e) {
                logger.error("Error validating JWT token: {}", e.getMessage());
                throw new BadCredentialsException("Invalid token from jwt validator", e);
            }
        } else {
            logger.debug("JWT Token not found in the request headers.");
        }

        filterChain.doFilter(request, response);
    }
}
