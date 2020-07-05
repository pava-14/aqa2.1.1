package ru.netology.order;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CreditCardOrderTest {

    @Test
    public void shouldCreditCardOrder() {
        open("http://localhost:9999");

        SelenideElement form = $("form.form");
        form.$("[data-test-id=name] input").setValue("Петров Иван Петрович");
        form.$("[data-test-id=phone] input").setValue("+79099099090");
        form.$("[data-test-id=agreement]").click();
        form.$("button[type=button]").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
