package ru.integration.gateway.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Spring-конфигурация, которая регистрирует GatewayProperties как бин.
 *
 * @EnableConfigurationProperties указывает Spring Boot загрузить
 * GatewayProperties из application.yaml и сделать его доступным
 * для инъекции через @Autowired / конструктор во всех компонентах.
 */
@Configuration
@EnableConfigurationProperties(GatewayProperties.class)
public class GatewayConfig {
}