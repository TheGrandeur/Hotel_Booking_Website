package com.example.mgateway.filter;



import com.example.mgateway.utils.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;




@Component
public class JwtFilter implements GlobalFilter, Ordered {

    @Autowired
    private JwtUtil jwtUtil;


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
      String path = exchange.getRequest().getURI().getPath();
      System.out.println(path);
      if(isPublicEndpoint(path)){
           return chain.filter(exchange);
      }

      String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return unauthorized(exchange);
        }

        String token = authHeader.substring(7);
        System.out.println(token);
        try {
            jwtUtil.isValidate(token);
            exchange
                    .getRequest()
                    .mutate()
                    .header("X-user-Id", jwtUtil.extractUsername(token))
                    .build();

        } catch (Exception e) {
            
            return unauthorized(exchange);
        }
      return chain.filter(exchange);
    }
    private boolean isPublicEndpoint(String path) {
        return path.startsWith("/users/login")
                || path.startsWith("/users/signup")
                || path.startsWith("/users/register");
    }

    private Mono<Void> unauthorized(ServerWebExchange exchange) {
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        return exchange.getResponse().setComplete();
    }

    @Override
    public int getOrder() {
        return -1; // runs before security
    }



}

