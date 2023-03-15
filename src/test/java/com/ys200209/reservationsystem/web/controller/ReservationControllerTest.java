package com.ys200209.reservationsystem.web.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ys200209.reservationsystem.domain.repository.JdbcReservationRepositoryTest;
import com.ys200209.reservationsystem.domain.service.ReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.templates.TemplateFormats;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebMvcTest(ReservationController.class)
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
class ReservationControllerTest {
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
                .andDo(document("/api/categories",
                        preprocessResponse(prettyPrint()),
                        responseFields(
                                fieldWithPath("size").description("카테고리 개수"),
                                fieldWithPath("items[]").description("카테고리 정보"),
                                fieldWithPath("items[].id").description("카테고리 id"),
                                fieldWithPath("items[].name").description("카테고리 이름"),
                                fieldWithPath("items[].count").description("카테고리에 포함된 전시 상품(display_info)의 수")
                        )));
    }
}
