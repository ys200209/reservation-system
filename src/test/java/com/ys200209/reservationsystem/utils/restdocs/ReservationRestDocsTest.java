package com.ys200209.reservationsystem.utils.restdocs;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ys200209.reservationsystem.domain.category.CategoriesResponseDto;
import com.ys200209.reservationsystem.domain.detaildisplay.DetailDisplayInfosRequestDto;
import com.ys200209.reservationsystem.domain.detaildisplay.DetailDisplayInfosResponseDto;
import com.ys200209.reservationsystem.domain.display.DisplayInfosRequestDto;
import com.ys200209.reservationsystem.domain.display.DisplayInfosResponseDto;
import com.ys200209.reservationsystem.domain.promotion.PromotionsResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.templates.TemplateFormats;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith({RestDocumentationExtension.class})
@SpringBootTest
public class ReservationRestDocsTest {
    private ObjectMapper objectMapper = new ObjectMapper();

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    void setUp(RestDocumentationContextProvider restDocumentation) {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(documentationConfiguration(restDocumentation).snippets()
                                .withTemplateFormat(TemplateFormats.asciidoctor()))
                .build();
    }

    @Test
    void generateDocsApiCategories() throws Exception {
        // then
        String URI = "/api/categories";
        mockMvc.perform(get(URI))
                .andExpect(status().isOk())
                .andDo(RestDocsGenerator.generate(URI, null, new CategoriesResponseDto()));
    }

    @Test
    void generateDocsApiDisplayInfos() throws Exception {
        // given
        DisplayInfosRequestDto requestDto = DisplayInfosRequestDto.builder()
                .categoryId(3)
                .start(0)
                .build();

        // then
        String URI = "/api/displayinfos";
        mockMvc.perform(get(URI)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isOk())
                .andDo(RestDocsGenerator.generate(URI, new DisplayInfosRequestDto(), new DisplayInfosResponseDto()));
    }

    @Test
    void generateDocsApiPromotions() throws Exception {
        // then
        String URI = "/api/promotions";
        mockMvc.perform(get(URI))
                .andExpect(status().isOk())
                .andDo(RestDocsGenerator.generate(URI, null, new PromotionsResponseDto()));
    }

    @Test
    void generateDocsApiDetailDisplayInfos() throws Exception {
        // then
        String URI = "/api/displayinfos/{displayId}";
        mockMvc.perform(get(URI, 1))
                .andExpect(status().isOk())
//                .andDo(RestDocsGenerator.generate("/api/detailDisplayInfos", new DetailDisplayInfosRequestDto(), new DetailDisplayInfosResponseDto()));
                .andDo(document("/api/detailDisplayInfos",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        pathParameters(
                                parameterWithName("displayId").description("The ID of the user to retrieve")
                        ),
                        RestDocsFieldsGenerator.generateResponse(new DetailDisplayInfosResponseDto().generateRestDocsFields(null))));
    }
}
