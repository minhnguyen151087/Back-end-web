package com.example.web.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    @Autowired
    private final JwtUserService jwtUserServices;
    @Autowired
    private final JwtTokenUtil jwtTokenUtil;

    public JwtRequestFilter(JwtUserService jwtUserServices, JwtTokenUtil jwtTokenUtil) {
        this.jwtUserServices = jwtUserServices;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        try {
            String token = getJwt(request);
            if(StringUtils.hasText(token) && token != null && jwtTokenUtil.validateToken(token)){
                String username = jwtTokenUtil.getUsernameFromToken(token);
                UserDetails userDetails = jwtUserServices.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,null,userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }catch (Exception e){
            logger.error("Can't set user authentication -> Message: {}",e);
        }
        chain.doFilter(request,response);

    }
    private String getJwt(HttpServletRequest request){
        String authHeader = request.getHeader("Authorization");
        if(authHeader != null && authHeader.startsWith("Bearer")){
            return authHeader.replace("Bearer"," ");
        }
        return null;
    }
}
