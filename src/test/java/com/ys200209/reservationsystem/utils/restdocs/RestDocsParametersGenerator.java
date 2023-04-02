package com.ys200209.reservationsystem.utils.restdocs;

import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.restdocs.request.ParameterDescriptor;
import org.springframework.restdocs.request.PathParametersSnippet;

public class RestDocsParametersGenerator {
    public static PathParametersSnippet generate(List<RestDocsDto> restDocsDtos) {
        return pathParameters(
                generateParameters(restDocsDtos)
        );
    }

    private static List<ParameterDescriptor> generateParameters(List<RestDocsDto> restDocsDtos) {
        return restDocsDtos.stream()
                .map(dto -> parameterWithName(dto.getPath()).description(dto.getDescription()))
                .collect(Collectors.toList());
    }
}
