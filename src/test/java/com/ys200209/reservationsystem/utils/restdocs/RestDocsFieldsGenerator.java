package com.ys200209.reservationsystem.utils.restdocs;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.RequestFieldsSnippet;
import org.springframework.restdocs.payload.ResponseFieldsSnippet;

public class RestDocsFieldsGenerator {
    public static RequestFieldsSnippet generateRequest(List<RestDocsDto> restDocsDtos) {
        return requestFields(
                generateFields(restDocsDtos)
        );
    }

    public static ResponseFieldsSnippet generateResponse(List<RestDocsDto> restDocsDtos) {
        return responseFields(
                generateFields(restDocsDtos)
        );
    }

    private static List<FieldDescriptor> generateFields(List<RestDocsDto> restDocsDtos) {
        return restDocsDtos.stream()
                .map(dto -> fieldWithPath(dto.getPath()).description(dto.getDescription()))
                .collect(Collectors.toList());
    }
}
