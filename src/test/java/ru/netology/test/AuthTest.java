package ru.netology.test;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static ru.netology.data.DataGenerator.Registration.getRegisteredUser;


public class AuthTest {
    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    @DisplayName("Should successfully login with active registered user")
    void shouldSuccessFullyLoginIfActiveRegisteredUser() {
        var reqisteredUser = getRegisteredUser("active");
        $("[data-test-id='login'] input").setValue(reqisteredUser.getLogin());
        $("[data-test-id='password'] input").setValue(reqisteredUser.getLogin());
        $("[data-test-id='action-login']input").click();
        $(".notification__content").should(Condition.exactText("Неверно указан логин или пароль"));

    }
}
