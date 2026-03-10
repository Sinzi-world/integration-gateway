package ru.integration.gateway.model;

import jakarta.validation.Valid;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Конфигурация трансформации данных для одного маршрута.
 *
 * Содержит два независимых набора правил маппинга:
 * - request:  применяется к телу запроса ДО отправки в 1С
 * - response: применяется к ответу 1С ДО возврата клиенту
 *
 * Оба списка опциональны: если правил нет — данные передаются без изменений (pass-through).
 */
@Data
public class TransformConfig {

    /**
     * Правила маппинга полей входящего запроса.
     * Например: $.name -> $.Наименование
     */
    @Valid
    private List<FieldMapping> request = new ArrayList<>();

    /**
     * Правила маппинга полей ответа от 1С.
     * Например: $.Ref -> $.id
     */
    @Valid
    private List<FieldMapping> response = new ArrayList<>();
}