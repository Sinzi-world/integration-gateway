package ru.integration.gateway.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Конфигурация аутентификации при обращении к HTTP-сервису 1С.
 *
 * Поля username/password используются только при type=BASIC.
 * Поле token используется только при type=BEARER.
 * При type=NONE все поля игнорируются.
 */
@Data
public class AuthConfig {

    /**
     * Тип аутентификации. Обязательное поле.
     */
    @NotNull(message = "Тип аутентификации (auth.type) должен быть указан: BASIC, BEARER или NONE")
    private AuthType type;

    // --- BASIC ---

    /** Логин пользователя 1С для Basic Auth */
    private String username;

    /** Пароль пользователя 1С для Basic Auth */
    private String password;

    // --- BEARER ---

    /** Bearer-токен для заголовка Authorization */
    private String token;
}