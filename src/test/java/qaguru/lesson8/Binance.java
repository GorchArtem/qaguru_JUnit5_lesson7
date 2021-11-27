package qaguru.lesson8;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.*;

public class Binance {
    String URL = "https://www.mvideo.ru/";


    @Test
    @Tag("BLOCKER")
    @DisplayName("Поиск товара Iphone")
    void SearchProductTest() {
        open(URL);

        $(".input__field").setValue("iphone").pressEnter();
        $(".ng-star-inserted").shouldHave(Condition.text("iphone"));
    }

    @ValueSource(strings = {"rtx", "iphone"})
    @Tag("BLOCKER")
    @DisplayName("Поиск товара rtx")
    @ParameterizedTest
    void SearchProductMVideoTest(String searchQuery) {
        open(URL);

        $(".input__field").setValue(searchQuery).pressEnter();
        $(".ng-star-inserted").shouldHave(Condition.text(searchQuery));
    }
}
