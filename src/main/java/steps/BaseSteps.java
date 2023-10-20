package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import condition.CustomCondition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.ElementsOfPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BaseSteps extends ElementsOfPage {

    @Step(value = "Проверка появления элементов после добавления")
    public static void checkElementAppearanceAfterAdding(By selectorForAdding, By selectorOfElement, int numberOfAdding) {
        for (int i = 0; i < numberOfAdding; i++) {
            clickButton(selectorForAdding);
            $((selectorOfElement)).shouldBe(visible);
        }
    }

    @Step(value = "Проверка появления нажатого статус кода")
    public static void checkStatusCodeAfterClickButton(String code) {
        $(byLinkText(code)).click();
        $("body").shouldHave(text("This page returned a " + code + " status code."));

        Selenide.back();
    }

    @Step(value = "Проверка исчезновения элементов после удаления")
    public static void checkElementDisappearanceAfterDeleting(By listOfButtonDeleteElement) {
        $$(listOfButtonDeleteElement).forEach(element -> {
            element.click();
            element.should(disappear);
        });
    }

    @Step(value = "Проверка соответствия нажатых клавиш отображаемому тексту")
    public static void checkKeysPressesToDisplayedText(Keys input) {
        $(byId("target")).sendKeys(input);
        $(byId("result")).shouldHave(Condition.text("You entered: " + input.name()));
    }

    @Step(value = "Проверка соответствия нажатых клавиш отображаемому тексту")
    public static void checkKeysPressesToDisplayedText(String input) {
        $(byId("target")).sendKeys(input);
        $(byId("result")).shouldHave(Condition.text("You entered: " + input));
    }

    public static SelenideElement clickButton(By selector) {
        SelenideElement element = $(selector);
        element.click();

        return element;
    }

    @Step(value = "Ввод клавиш действия")
    public void sendKeysToElement(SelenideElement element, Keys keys) {
        element.sendKeys(keys);
    }

    @Step(value = "Ввод текста в элемент")
    public void sendKeysToElementBySelector(By selector, String keys) {
        $(selector).setValue(keys);
        Selenide.sleep(2000);
    }

    @Step(value = "Проверить текст у элемента")
    public void checkText(By selector, String expectedText) {
        $(selector).shouldHave(Condition.text(expectedText));
    }

    @Step(value = "Проверить значение у элемента")
    public void checkValue(By selector, String expectedText) {
        $(selector).shouldHave(value(expectedText));
    }

    @Step(value = "Проверить, что элемент пуст")
    public void checkElementIsEmpty(By selector) {
        $(selector).shouldBe(empty);
    }

    @Step(value = "Нажать на элемент и проверить наличие атрибута")
    public void clickElementAndCheckHaveAttribute(By selector, int index, String attribute) {
        $$(selector).get(index).click();
        $$(selector).get(index).shouldHave(attribute(attribute));
    }

    @Step(value = "Нажать на элемент и проверить отсутствие атрибута")
    public void clickElementAndCheckHaveNotAttribute(By selector, int index, String attribute) {
        $$(selector).get(index).click();
        $$(selector).get(index).shouldNotHave(attribute(attribute));
    }

    @Step(value = "Перетащить один элемент на место другого")
    public void dragElementOntoAnother(By firstSelector, By secondSelector) {
        SelenideElement columnA = $(firstSelector);
        SelenideElement columnB = $(secondSelector);

        columnA.dragAndDropTo(columnB);
    }

    @Step(value = "Навести курсор на все элементы списка и проверить появившийся текст")
    public void hoverOnElementAndCheckText(By selectorOfList) {
        ElementsCollection listOfElements = $$(selectorOfList);
        for (int i = 0; i < listOfElements.size(); i++) {
            listOfElements.get(i).hover();
            listOfElements.get(i).shouldHave(Condition.text("name: user" + (i + 1)));
        }
    }

    @Step(value = "Проверка элемента на возможность перетаскивания")
    public void checkElementIsDraggable(By selector) {
        $(selector).shouldHave(CustomCondition.draggable("true"));
    }

    @Step(value = "Попытка входа")
    public void loginAttempt(String username, String password, String expectedAlert) {
        sendKeysToElementBySelector(fieldUsername, username);
        sendKeysToElementBySelector(fieldPassword, password);

        clickButton(buttonLoginSelector);

        checkText(alertFlash, expectedAlert);
    }
}