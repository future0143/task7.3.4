package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.ConfigSetup;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import steps.BaseSteps;


public class WorkWithWaiting extends BaseSteps implements ConfigSetup {

    @Test
    @DisplayName(value = "Добавление и удаление элементов")
    @Description("Проверка появления и исчезновения элементов")
    public void addAndDeleteElements() {
        clickButton(buttonAddAndDeleteElements);

        int numberOfAdding = 3;
        checkElementAppearanceAfterAdding(buttonAddElement, buttonDeleteElement, numberOfAdding);

        checkElementDisappearanceAfterDeleting(listOfButtonDeleteElement);
    }

    @Test
    @DisplayName(value = "Проверка кодов состояния")
    @Description("Проверка появления текста")
    public void checkStatusCodes() {
        clickButton(buttonStatusCodes);

        String code200 = "200";
        checkStatusCodeAfterClickButton(code200);

        String code301 = "301";
        checkStatusCodeAfterClickButton(code301);

        String code404 = "404";
        checkStatusCodeAfterClickButton(code404);

        String code500 = "500";
        checkStatusCodeAfterClickButton(code500);
    }

    @Test
    @DisplayName(value = "Нажатие клавиш на клавиатуре")
    @Description("Проверка соответствия нажатых клавиш отображаемому тексту")
    public void checkKeysPressed() {
        clickButton(buttonKeyPresses);

        String inputNumber = "5";
        checkKeysPressesToDisplayedText(inputNumber);

        Keys inputEnter = Keys.ESCAPE;
        checkKeysPressesToDisplayedText(inputEnter);

        Keys inputSpace = Keys.SPACE;
        checkKeysPressesToDisplayedText(inputSpace);

        String inputLetter = "L";
        checkKeysPressesToDisplayedText(inputLetter);
    }

    @Test
    @DisplayName(value = "Горизонтальный слайдер")
    @Description("Ожидание появления определенного текста")
    public void horizontalSlider() {
        clickButton(buttonHorizontalSlider);

        SelenideElement slider = clickButton(sliderSelector);

        sendKeysToElement(slider, Keys.ARROW_RIGHT);
        sendKeysToElement(slider, Keys.ARROW_RIGHT);
        sendKeysToElement(slider, Keys.ARROW_RIGHT);
        sendKeysToElement(slider, Keys.ARROW_LEFT);

        String expectedText = "3.5";
        checkText(idOfRange, expectedText);
    }

    @Test
    @DisplayName(value = "Проверка отображения входных данных в соответствии с типом данных")
    @Description("Ожидание определенного значения")
    public void inputData() {
        clickButton(buttonInputs);

        String numberForInput = "89003508881";
        sendKeysToElementBySelector(inputNumberSelector, numberForInput);

        checkValue(inputNumberSelector, numberForInput);

        String wordForInput = "World";
        sendKeysToElementBySelector(inputNumberSelector, wordForInput);

        checkElementIsEmpty(inputNumberSelector);
    }

    @Test
    @DisplayName(value = "Установка флажков")
    @Description("Проверка появления атрибута")
    public void setCheckBox() {
        clickButton(buttonCheckBoxes);

        String attributeForCheck = "checked";
        clickElementAndCheckHaveAttribute(checkbox, 0, attributeForCheck);

        clickElementAndCheckHaveNotAttribute(checkbox, 1, attributeForCheck);
    }

    @Test
    @DisplayName(value = "Динамическая загрузка")
    @Description("Ожидание появление текста")
    public void waitTextAfterDynamicLoading() {
        clickButton(buttonDynamicLoading);

        clickButton(exampleFirst);

        clickButton(buttonStart);
        Configuration.timeout = 5000;

        String expectedText = "Hello World!";
        checkText(fieldWithText, expectedText);
    }

    @Test
    @DisplayName(value = "Перемещение объектов - одного на место другого")
    @Description("Ожидание появление текста")
    public void dragAndDropElement() {
        clickButton(buttonDragAndDrop);

        checkElementIsDraggable(idOfColumnA);
        checkElementIsDraggable(idOfColumnB);

        dragElementOntoAnother(idOfColumnA, idOfColumnB);

        String expectedTextColumnA = "B";
        checkText(idOfColumnA, expectedTextColumnA);
        String expectedTextColumnB = "A";
        checkText(idOfColumnB, expectedTextColumnB);
    }

    @Test
    @DisplayName(value = "Наведение курсора на элементы")
    @Description("Ожидание появление текста")
    public void hoverOnElement() {
        clickButton(buttonHovers);

        hoverOnElementAndCheckText(listOfFigures);
    }

    @Test
    public void test() {
        clickButton(buttonLogin);

        String invalidUsername = "username";
        String invalidPassword = "password";
        String expectedUnsuccessfulAlert = " Your username is invalid! ";
        loginAttempt(invalidUsername, invalidPassword, expectedUnsuccessfulAlert);

        String validUsername = "tomsmith";
        String validPassword = "SuperSecretPassword!";
        String expectedSuccessAlert = " You logged into a secure area! ";
        loginAttempt(validUsername, validPassword, expectedSuccessAlert);
        Selenide.sleep(2000);

        clickButton(buttonLogout);

        String alertAfterLogout = " You logged out of the secure area! ";
        checkText(alertFlash, alertAfterLogout);
    }
}