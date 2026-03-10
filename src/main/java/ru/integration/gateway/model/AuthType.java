package ru.integration.gateway.model;

/**
 * Тип аутентификации при обращении к HTTP-сервису 1С.
 *
 * BASIC  — HTTP Basic Auth (логин + пароль), наиболее распространён в 1С
 * BEARER — Bearer-токен в заголовке Authorization, используется в OAuth2-сценариях
 * NONE   — без аутентификации, для открытых сервисов в тестовом окружении
 */
public enum AuthType {
    BASIC,
    BEARER,
    NONE
}