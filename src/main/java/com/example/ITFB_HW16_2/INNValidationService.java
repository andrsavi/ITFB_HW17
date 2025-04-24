package com.example.ITFB_HW16_2;

import com.example.ITFB_HW16_2.INNRequest;
import org.springframework.stereotype.Service;

@Service
public class INNValidationService {

    public INNResponse validate(INNRequest request) {
        String inn = request.getInn();
        if (inn == null || inn.length() != 10) {
            return new INNResponse("ИНН не прошел проверку", null);
        }

        // шаги проверки ИНН
        int[] multipliers = {2, 4, 10, 3, 5, 9, 4, 6, 8}; //множители
        int sum = 0;

        // применение множителей к первым 9 цифрам ИНН
        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(inn.charAt(i)) * multipliers[i];
        }

        int controlNumber = sum % 11;

        if (controlNumber == 10) {
            controlNumber = 0;
        }

        // сравнение контрольного числа с 10й цифрой ИНН
        int tenthDigit = Character.getNumericValue(inn.charAt(9));

        if (controlNumber != tenthDigit) {
            return new INNResponse("ИНН не прошел проверку", null);
        }

        String organizationName;
        int firstDigit = Character.getNumericValue(inn.charAt(0));

        if (firstDigit < 5) {
            organizationName = "ООО \"Рога и копыта\"";
        } else if (firstDigit >= 5 && firstDigit <= 8) {
            organizationName = "ООО \"Заглушкасервис\"";
        } else {
            organizationName = "ООО \"Волга\"";
        }

        return new INNResponse("ИНН прошел проверку", organizationName);
    }
}
