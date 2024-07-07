package com.online_quiz_api.online_gateway_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableDiscoveryClient
public class OnlineGatewayApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineGatewayApiApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth-service", r -> r.path("/api/users/**").uri("http://localhost:8081/api/user"))
                .route("course-service", r -> r.path("/api/courses/**").uri("http://localhost:8082/api/courses"))
                .route("chat-service", r -> r.path("/api/chat/**").uri("http://localhost:8083"))
                .route("quiz-service", r -> r.path("/api/quiz/**").uri("http://localhost:8085/api/quiz"))
                .build();
    }

}


