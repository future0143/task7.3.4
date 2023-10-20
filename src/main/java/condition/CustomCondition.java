package condition;

import com.codeborne.selenide.CheckResult;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;
import org.openqa.selenium.WebElement;

import javax.annotation.Nonnull;

public class CustomCondition {

    public static Condition draggable(String expectedLabelValue) {
        return new Condition(expectedLabelValue) {
            @Nonnull
            @Override
            public CheckResult check(Driver driver, WebElement element) {
                String actualValue = element.getAttribute("draggable");
                boolean isLabelValueMatches = actualValue.equalsIgnoreCase(expectedLabelValue);
                return new CheckResult(isLabelValueMatches, actualValue);
            }
        };
    }
}