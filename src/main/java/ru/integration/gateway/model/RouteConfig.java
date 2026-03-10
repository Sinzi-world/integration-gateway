package ru.integration.gateway.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

/**
 * Конфигурация одного маршрута шлюза.
 *
 * Маршрут — это полное описание того, как обработать входящий запрос:
 * на какой path реагировать, куда проксировать и как трансформировать данные.
 *
 * Пример в application.yaml:
 *
 *   - id: create-counterparty
 *     path: /api/v1/counterparties
 *     method: POST
 *     target:
 *       url: http://1c-server/base/hs/partners/create
 *       auth:
 *         type: BASIC
 *         username: integration
 *         password: secret
 *     transform:
 *       request:
 *         - from: $.name
 *           to:   $.Наименование
 *       response:
 *         - from: $.Ref
 *           to:   $.id
 */
@Data
public class RouteConfig {

    /**
     * Уникальный идентификатор маршрута.
     * Используется в логах и сообщениях об ошибках.
     */
    @NotBlank(message = "Идентификатор маршрута (id) не может быть пустым")
    private String id;

    /**
     * URL-путь, на который шлюз будет реагировать.
     * Должен начинаться с '/'. Например: /api/v1/counterparties
     */
    @NotBlank(message = "Путь маршрута (path) не может быть пустым")
    @Pattern(regexp = "^/.*", message = "Путь маршрута должен начинаться с '/'")
    private String path;

    /**
     * HTTP-метод маршрута: GET, POST, PUT, DELETE, PATCH.
     */
    @NotBlank(message = "HTTP-метод маршрута (method) не может быть пустым")
    @Pattern(
            regexp = "^(GET|POST|PUT|DELETE|PATCH)$",
            message = "Метод должен быть одним из: GET, POST, PUT, DELETE, PATCH"
    )
    private String method;

    /**
     * Конфигурация целевого сервиса 1С.
     */
    @NotNull(message = "Секция target обязательна для маршрута")
    @Valid
    private TargetConfig target;

    /**
     * Правила трансформации данных.
     * Опционально — если секция отсутствует, данные передаются без изменений.
     */
    @Valid
    private TransformConfig transform = new TransformConfig();
}