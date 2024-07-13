import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class findSelenideAtGitTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    public void findSelenideTest() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $$("a[data-view-component='true'].Truncate-text")
                .findBy(href("/selenide/selenide/wiki/SoftAssertions"))
                .shouldBe(visible)
                .click();
        $("a#user-content-3-using-junit5-extend-test-class")
            .shouldHave(href("#3-using-junit5-extend-test-class"))
            .scrollIntoView(true);
    }
}
