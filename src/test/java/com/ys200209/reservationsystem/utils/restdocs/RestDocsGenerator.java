package com.ys200209.reservationsystem.utils.restdocs;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;

import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.restdocs.snippet.Snippet;

public class RestDocsGenerator {
    public static RestDocumentationResultHandler generate(String identifier, RestDocsTemplate request, RestDocsTemplate response) {
        if (request == null && response == null) {
            return generateNoneFieldsDocument(identifier);
        }
        if (request == null) {
            return generateResponseFieldsDocument(identifier, response);
        }
        if (response == null) {
            return generateRequestFieldsDocument(identifier, request);
        }
        return generateAllFieldsDocument(identifier, request, response);
    }

    private static RestDocumentationResultHandler generateNoneFieldsDocument(String identifier) {
        return document(identifier);
    }

    private static RestDocumentationResultHandler generateResponseFieldsDocument(String identifier, RestDocsTemplate response) {
        return document(identifier,
                preprocessResponse(prettyPrint()),
                getGenerateResponse(response));
    }

    private static RestDocumentationResultHandler generateRequestFieldsDocument(String identifier, RestDocsTemplate request) {
        return document(identifier,
                preprocessRequest(prettyPrint()),
                getGenerateRequest(request));
    }

    private static RestDocumentationResultHandler generateAllFieldsDocument(String identifier, RestDocsTemplate request, RestDocsTemplate response) {
        return  document(identifier,
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()),
                getGenerateRequest(request),
                getGenerateResponse(response));
    }

    private static Snippet getGenerateRequest(RestDocsTemplate request) {
        if (request.isPathParameters()) {
            return RestDocsParametersGenerator.generate(request.generateRestDocsFields(null));
        }
        return RestDocsFieldsGenerator.generateRequest(request.generateRestDocsFields(null));
    }

    private static Snippet getGenerateResponse(RestDocsTemplate response) {
        if (response.isPathParameters()) {
            return RestDocsParametersGenerator.generate(response.generateRestDocsFields(null));
        }
        return RestDocsFieldsGenerator.generateResponse(response.generateRestDocsFields(null));
    }
}
