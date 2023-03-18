package com.ys200209.reservationsystem.web.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ys200209.reservationsystem.domain.category.CategoriesResponseDto;
import com.ys200209.reservationsystem.domain.display.DisplayInfosRequestDto;
import com.ys200209.reservationsystem.domain.display.DisplayInfosResponseDto;
import com.ys200209.reservationsystem.domain.repository.JdbcReservationRepositoryTest;
import com.ys200209.reservationsystem.domain.service.ReservationService;
import com.ys200209.reservationsystem.utils.restdocs.RestDocsFieldsGenerator;
import com.ys200209.reservationsystem.utils.restdocs.RestDocsGenerator;
import com.ys200209.reservationsystem.utils.restdocs.RestDocsTemplate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.restdocs.templates.TemplateFormats;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebMvcTest(ReservationController.class)
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
class ReservationControllerTest {
    private ObjectMapper objectMapper = new ObjectMapper();

    @MockBean
    ReservationService service;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    void setUp(RestDocumentationContextProvider restDocumentation) {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(documentationConfiguration(restDocumentation).snippets()
                                .withTemplateFormat(TemplateFormats.asciidoctor())
                        /*.withTemplateFormat(TemplateFormats.markdown())*/)
                .build();
    }

    @Test
    void testApiCategories() throws Exception {
        // when
        when(service.getCategories()).thenReturn(JdbcReservationRepositoryTest.categories);

        // then
        mockMvc.perform(get("/api/categories"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size").exists())
                .andExpect(jsonPath("$.items").isArray())
                .andExpect(jsonPath("$.items[0].id").value(1))
                .andExpect(jsonPath("$.items[0].name").value("전시"))
                .andExpect(jsonPath("$.items[0].count").value(10))
                .andExpect(jsonPath("$.items[4].id").value(5))
                .andExpect(jsonPath("$.items[4].name").value("연극"))
                .andExpect(jsonPath("$.items[4].count").value(13))
                .andDo(RestDocsGenerator.generate("/api/categories", null, new CategoriesResponseDto()));
    }

    @Test
    void testApiDisplayInfos() throws Exception {
        // given
        DisplayInfosRequestDto requestDto = DisplayInfosRequestDto.builder()
                .categoryId(0)
                .start(0)
                .build();

        // then
        mockMvc.perform(get("/api/displayinfos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isOk())
                .andDo(RestDocsGenerator.generate("/api/displayinfos", new DisplayInfosRequestDto(), new DisplayInfosResponseDto()));
    }
}
