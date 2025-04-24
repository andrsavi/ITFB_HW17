Проверка с помощью ITFB_HW17.jmx

valid_inn
  request:
    POST data:
    {
    "inn": "7709190001"
    }

  response body:
    {"message":"ИНН прошел проверку","organizationName":"ООО \"Заглушкасервис\""}


invalid_inn
  request:
    POST data:
    {
    "inn": "1234567890"
    }

  response body:
    {"message":"ИНН не прошел проверку","organizationName":null}
