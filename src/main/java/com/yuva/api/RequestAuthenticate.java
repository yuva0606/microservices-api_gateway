//package com.yuva.api;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Component
//public class RequestAuthenticate implements GlobalFilter {
//
//    private static final List<String> EXCLUDED_PATHS = Arrays.asList(
//            "/users/register", "/users/login", "/products/get/id","/products/get/all","/products/get/search","/products/get/filter","/inventory/test"
//    );
//
//    @Autowired
//    private JwtService jwtService;
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        String path = exchange.getRequest().getURI().getPath();
//
//        // Skip JWT validation for certain paths
//        if (EXCLUDED_PATHS.contains(path)) {
//            return chain.filter(exchange);
//        }
//
//        // JWT validation logic here for other paths
//        String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");
//        if (authHeader != null && authHeader.startsWith("Bearer ")) {
//            String jwtToken = authHeader.substring(7);
//            if (isValidJwt(jwtToken)) {
//                String username = extractUsername(jwtToken);
//                String role = extractUserRole(jwtToken);
//                exchange.getRequest().mutate()
//                        .header("Authenticated-Username", username)
//                        .header("Authenticated-Role", role)
//                        .build();
//            } else {
//                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//                return exchange.getResponse().setComplete();
//            }
//        } else {
//            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//            return exchange.getResponse().setComplete();
//        }
//        return chain.filter(exchange);
//    }
//
//    private boolean isValidJwt(String jwtToken) {
//        try{
//            jwtService.validateToken(jwtToken);
//        }
//        catch (Exception e){
//            return false;
//        }
//        return true;
//    }
//
//    private String extractUsername(String jwtToken) {
//        return jwtService.extractUserName(jwtToken);
//    }
//
//    private String extractUserRole(String jwtToken) {
//        return jwtService.getRole(jwtToken);
//    }
//
//}
