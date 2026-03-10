package ru.integration.gateway.config;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;
import ru.integration.gateway.model.RouteConfig;

import java.util.List;

/**
 * Корневой класс конфигурации шлюза.
 *
 * Связывается с секцией "gateway" в application.yaml через @ConfigurationProperties.
 * Аннотация @Validated гарантирует, что при старте приложения все маршруты
 * будут проверены — если конфигурация невалидна, приложение не запустится
 * и выдаст понятное сообщение об ошибке.
 */
@Data
@Validated
@ConfigurationProperties(prefix = "gateway")
public class GatewayProperties {

    /**
     * Список маршрутов шлюза.
     * Должен содержать хотя бы один маршрут — иначе шлюз бессмысленен.
     */
    @NotEmpty(message = "Необходимо настроить хотя бы один маршрут в секции gateway.routes")
    @Valid
    private List<RouteConfig> routes;
}