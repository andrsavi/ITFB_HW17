package com.example.ITFB_HW16_2;

import com.example.ITFB_HW16_2.PassportRequest;
import com.example.ITFB_HW16_2.PassportResponse;
import com.example.ITFB_HW16_2.PassportValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/validate-passport")
public class ValidationController {

    private final PassportValidationService validationService;

    @Autowired
    public ValidationController(PassportValidationService validationService) {
        this.validationService = validationService;
    }

    @PostMapping
    public PassportResponse validatePassport(@RequestBody PassportRequest request) {
        boolean result = validationService.validate(request);
        return new PassportResponse(result);
    }
}
