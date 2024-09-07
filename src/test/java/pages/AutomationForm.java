package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationForm extends BasePage {

    @FindBy(id = "loginEmail")
    private WebElement email;

    @FindBy(id = "loginPassword")
    private WebElement password;

    @FindBy(id = "authButton")
    private WebElement clickauthButton;

    @FindBy(id = "invalidEmailPassword")
    private WebElement invalidEmailPassword;

    @FindBy(id = "emailFormatError")
    private WebElement emailFormatError;

    @FindBy(id = "blankNameError")
    private WebElement blankNameError;

    @FindBy(id = "dataSend")
    private WebElement dataSend;

    @FindBy(id = "dataEmail")
    private WebElement dataEmail;

    @FindBy(id = "dataName")
    private WebElement dataName;

    @FindBy(id = "dataGender")
    private WebElement dataGender;

   @FindBy(xpath = "//select[@id='dataGender']/option[2]")
    private WebElement womanGender;

    @FindBy(xpath = "//div[@class='uk-modal uk-open']//div[@class='uk-margin uk-modal-content']/text()")
    private WebElement modalWindow;

    @FindBy(xpath = "//button[text()='Ok']")
    private WebElement buttonOk;

    @FindBy(id = "dataCheck11")
    private WebElement dataCheck11;

    @FindBy(id = "dataCheck12")
    private WebElement dataCheck12;

    @FindBy(id = "dataSelect21")
    private WebElement dataSelect21;

    @FindBy(id = "dataSelect22")
    private WebElement dataSelect22;

    @FindBy(id = "dataSelect23")
    private WebElement dataSelect23;

    @FindBy(xpath = "//*[@id=\"dataTable\"]/tbody/tr[1]/td[1]")
    private WebElement checkData;

    @FindBy(xpath = " //*[@id=\"dataTable\"]/tbody/tr[1]/td[3]")
    private WebElement checkGender;

    @FindBy(xpath = "//*[@id=\"dataTable\"]/tbody/tr[1]/td[4]")
    private WebElement checkChoice1;

    @FindBy(xpath = "//*[@id=\"dataTable\"]/tbody/tr[1]/td[5]")
    private WebElement checkChoice2;

    @FindBy(xpath = "//*[@id=\"dataTable\"]/tbody/tr[1]/td[2]")
    private WebElement checkName;

    public AutomationForm() {

        PageFactory.initElements(driver, this);
    }

   public WebElement getInvalidEmailPassword() {
     return invalidEmailPassword;
    }

    public WebElement getEmailFormatError() {
        return emailFormatError;
    }

    public WebElement getBlankNameError() {
        return blankNameError;
    }

    public WebElement getDataSend() {
        return dataSend;
    }

    public WebElement getModalWindow() {
        return modalWindow;
    }

    public WebElement getCheckData() {
        return checkData;
    }

    public WebElement getCheckGender() {
        return checkGender;
    }
    public WebElement getCheckChoice1() {
        return checkChoice1;
    }
    public WebElement getCheckChoice2() {
        return checkChoice2;
    }

    public WebElement getCheckName() {
        return checkName;
    }

    @Step("Открываем страницу")
    public AutomationForm openPracticePage() {
        driver.get(URL);
        return new AutomationForm();
    }

    @Step("Заполняем E-mail")
    public AutomationForm fillEmail (String emailFill) {
        email.sendKeys(emailFill);
        return new AutomationForm();
    }

    @Step("Заполняем Пароль")
    public AutomationForm fillPassword (String passwordFill) {
        password.sendKeys(passwordFill);
        return new AutomationForm();
    }

    @Step("Заполняем логин и пароль ")
    public AutomationForm authorize(String emailData, String passwordData) {
        openPracticePage();
        email.sendKeys(emailData);
        password.sendKeys(passwordData);
        clickButton();
        return new AutomationForm();
    }

    @Step("Нажимаем вход ")
    public AutomationForm clickButton() {
        clickauthButton.click();
        return new AutomationForm();
    }

    @Step("Нажимаем добавить ")
    public AutomationForm clickDataSend() {
        dataSend.click();
        return new AutomationForm();
    }

    @Step("Заполняем E-mail2")
    public AutomationForm fillDataEmail (String emailFill) {
        dataEmail.sendKeys(emailFill);
        return new AutomationForm();
    }

    @Step("Заполняем Имя")
    public AutomationForm fillName (String nameFill) {
        dataName.sendKeys(nameFill);
        return new AutomationForm();
    }

    @Step("Заполняем пол Женский")
    public AutomationForm dataGenderFemale () {
        dataGender.click();
        womanGender.click();
        return new AutomationForm();
    }

    @Step("Выбираем ч/б Вариант 1.1")
    public AutomationForm selectDataCheck11 () {
        dataCheck11.click();
        return new AutomationForm();
    }

    @Step("Выбираем ч/б Вариант 1.2")
    public AutomationForm selectDataCheck12 () {
        dataCheck12.click();
        return new AutomationForm();
    }

    @Step("Выбираем Вариант 2.1")
    public AutomationForm dataSelect21 () {
        dataSelect21.click();
        return new AutomationForm();
    }

    @Step("Выбираем Вариант 2.2")
    public AutomationForm dataSelect22 () {
        dataSelect22.click();
        return new AutomationForm();
    }

    @Step("Выбираем Вариант 2.3")
    public AutomationForm dataSelect23 () {
        dataSelect23.click();
        return new AutomationForm();
    }

    @Step("Нажимаем кнопку ОК")
    public AutomationForm buttonOk () {
        buttonOk.click();
        return new AutomationForm();
    }


}


