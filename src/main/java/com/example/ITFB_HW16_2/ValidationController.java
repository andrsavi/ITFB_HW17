package com.example.ITFB_HW16_2;

import com.example.ITFB_HW16_2.INNRequest;
import com.example.ITFB_HW16_2.INNResponse;
import com.example.ITFB_HW16_2.INNValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/validate-inn")
public class ValidationController {

    private final INNValidationService validationService;

    @Autowired
    public ValidationController(INNValidationService validationService) {
        this.validationService = validationService;
    }

    @PostMapping
    public INNResponse validateINN(@RequestBody INNRequest request) {
        return validationService.validate(request);
    }
}
