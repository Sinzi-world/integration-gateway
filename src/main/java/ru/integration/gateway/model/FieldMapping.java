package ru.integration.gateway.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

/**
 * Правило маппинга одного поля: откуда взять значение и куда его положить.
 *
 * Поддерживает как плоские пути ($.name), так и вложенные ($.address.city).
 * Синтаксис намеренно упрощён относительно полного JSONPath:
 * поддерживается только dot-notation без фильтров и wildcards —
 * этого достаточно для задач интеграции с 1С.
 *
 * Примеры валидных путей:
 *   $.name
 *   $.address.city
 *   $.Контрагент.Наименование
 */
@Data
public class FieldMapping {

    /**
     * Путь к полю в исходном JSON.
     * Должен начинаться с "$." и содержать только допустимые символы идентификатора.
     */
    @NotBlank(message = "Поле 'from' не может быть пустым")
    @Pattern(
            regexp = "^\\$(\\.([\\w\\u0400-\\u04FF]+))+$",
            message = "Поле 'from' должно быть валидным JSONPath, например: $.name или $.address.city"
    )
    private String from;

    /**
     * Путь к полю в результирующем JSON.
     * Те же требования, что и для 'from'.
     */
    @NotBlank(message = "Поле 'to' не может быть пустым")
    @Pattern(
            regexp = "^\\$(\\.([\\w\\u0400-\\u04FF]+))+$",
            message = "Поле 'to' должно быть валидным JSONPath, например: $.Наименование или $.Город.Наименование"
    )
    private String to;
}