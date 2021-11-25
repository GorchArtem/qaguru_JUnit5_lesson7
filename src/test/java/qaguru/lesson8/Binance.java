package qaguru.lesson8;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class Binance {
    String binanceURL = "https://www.binance.com/ru/trade/BTC_USDT?layout=basic";


    @Test
    @Tag("BLOCKER")
    @DisplayName("поиск торговой пары USDT/RUB")
    void USDTRUBSearchTest() {
        open(binanceURL);

        $("[data-testid=searchInput]").sendKeys("USDT/RUB");

        $(".item-symbol-text").shouldHave(Condition.text("USDT /RUB"));
    }
}
