package com.ys200209.reservationsystem.utils.restdocs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

public interface RestDocsTemplate {
    List<RestDocsDto> generateRestDocsFields(String rootField);

    @JsonIgnore
    boolean isPathParameters();
}
