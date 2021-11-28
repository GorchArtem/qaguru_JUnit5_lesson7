package qaguru.lesson8;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;
import static com.codeborne.selenide.Selenide.*;
public class MVideoTests {
    String URL = "https://www.mvideo.ru/";


    @Test
    @Tag("BLOCKER")
    @DisplayName("Поиск товара Iphone на сайте МВидео")
    void SearchProductTest() {
        open(URL);

        $(".input__field").setValue("iphone").pressEnter();
        $(".ng-star-inserted").shouldHave(Condition.text("iphone"));
    }

    @ValueSource(strings = {
            "rtx",
            "iphone"
    })
    @Tag("BLOCKER")
    @ParameterizedTest(name = "Поиск товара {0} на сайте МВидео")
    void SearchProductMVideoTest(String searchQuery) {
        open(URL);

        $(".input__field").setValue(searchQuery).pressEnter();
        $(".ng-star-inserted").shouldHave(Condition.text(searchQuery));
    }

    @CsvSource(value = {
            "rtx| Видеокарта",
            "iphone| Смартфон"
    },
    delimiter = '|')
    @Tag("BLOCKER")
    @ParameterizedTest(name = "Поиск товара {0} на сайте МВидео и проверка наличия текста {1}")
    void SearchProductMVideo1Test(String searchQuery, String expectedResult) {
        open(URL);

        $(".input__field").setValue(searchQuery).pressEnter();
        $(".ng-star-inserted").shouldHave(Condition.text(expectedResult));
    }


    static Stream<Arguments> SearchProductMVideo2Test(){
        return Stream.of(
                Arguments.of("rtx", "Видеокарта"),
                Arguments.of("iphone", "Смартфон")
        );
    }

    @MethodSource
    @Tag("BLOCKER")
    @ParameterizedTest(name = "Поиск товара {0} на сайте МВидео и проверка наличия текста {1}")
    void SearchProductMVideo2Test(String searchQuery, String expectedResult) {
        open(URL);

        $(".input__field").setValue(searchQuery).pressEnter();
        $(".ng-star-inserted").shouldHave(Condition.text(expectedResult));
    }
}
