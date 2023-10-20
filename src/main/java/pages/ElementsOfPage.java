package pages;

import org.openqa.selenium.By;

public class ElementsOfPage {

    public static By buttonAddAndDeleteElements = By.xpath("//li/a[@href='/add_remove_elements/']");
    public static By buttonStatusCodes = By.xpath("//li/a[@href='/status_codes']");
    public static By buttonKeyPresses = By.xpath("//li/a[@href='/key_presses']");
    public static By buttonHorizontalSlider = By.xpath("//li/a[@href='/horizontal_slider']");
    public static By buttonInputs = By.xpath("//li/a[@href='/inputs']");
    public static By buttonCheckBoxes = By.xpath("//li/a[@href='/checkboxes']");
    public static By buttonDynamicLoading = By.xpath("//li/a[@href='/dynamic_loading']");
    public static By buttonDragAndDrop = By.xpath("//li/a[@href='/drag_and_drop']");
    public static By buttonLogin = By.xpath("//li/a[@href='/login']");
    public static By buttonHovers = By.xpath("//li/a[@href='/hovers']");
    public static By buttonAddElement = By.cssSelector("button[onclick='addElement()']");
    public static By buttonStart = By.cssSelector("button");
    public static By buttonDeleteElement = By.cssSelector("button.added-manually");
    public static By listOfButtonDeleteElement = By.cssSelector("button.added-manually[onclick='deleteElement()']");
    public static By exampleFirst = By.xpath("//a[@href='/dynamic_loading/1']");
    public static By sliderSelector = By.cssSelector("input[type=range]");
    public static By idOfRange = By.id("range");
    public static By inputNumberSelector = By.cssSelector("[type='number']");
    public static By checkbox = By.cssSelector("input[type='checkbox']");
    public static By fieldWithText = By.cssSelector("#finish h4");
    public static By idOfColumnA = By.cssSelector("#column-a");
    public static By idOfColumnB = By.cssSelector("#column-b");
    public static By listOfFigures = By.cssSelector(".figure");
    public static By fieldUsername = By.id("username");
    public static By fieldPassword = By.id("password");
    public static By alertFlash = By.id("flash");
    public static By buttonLoginSelector = By.cssSelector("button.radius[type='submit']");
    public static By buttonLogout = By.xpath("//a[@href='/logout']");
}