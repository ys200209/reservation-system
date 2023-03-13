package com.ys200209.reservationsystem.study;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestDocsController {
    @GetMapping("/api/test")
    public ResponseDto testMethod(
            @RequestBody RequestDto request) {
        return new ResponseDto("success");
    }
}
