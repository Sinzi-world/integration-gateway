package ru.integration.gateway.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

/**
 * Конфигурация целевого HTTP-сервиса 1С, к которому шлюз будет проксировать запрос.
 */
@Data
public class TargetConfig {

    /**
     * Полный URL HTTP-сервиса 1С.
     * Например: http://1c-server/base/hs/partners/create
     */
    @NotBlank(message = "URL целевого сервиса (target.url) не может быть пустым")
    @URL(message = "target.url должен быть валидным URL")
    private String url;

    /**
     * Параметры аутентификации при обращении к 1С.
     * Обязательное поле — даже для NONE тип должен быть явно указан.
     */
    @NotNull(message = "Секция target.auth обязательна. Укажите type: NONE если аутентификация не нужна")
    @Valid
    private AuthConfig auth;
}
