package tests;

import static helpers.FakeUsersData.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationForm;

public class TestAuthorizationForm extends BaseTest {
    @Test(description = "Форма авторизации. Неверный заполненный E-Mail и пароль ")
    public void invalidEmailPassword() {
        AutomationForm automationForm = new AutomationForm()
                .openPracticePage()
                .fillEmail(getEmail())
                .fillPassword(getPassword())
                .clickAuthButton();
        Assert.assertEquals(automationForm.getInvalidEmailPassword().getText(), "Неверный E-Mail или пароль");

    }

    @Test(description = "Форма авторизации. Пустые поля")
    public void emptyFields() {
        AutomationForm automationForm = new AutomationForm()
                .openPracticePage()
                .clickAuthButton();
        Assert.assertEquals(automationForm.getEmailFormatError().getText(), "Неверный формат E-Mail");
    }

    @Test(description = "Форма авторизации. Неверный формат E-Mail")
    public void invalidEmail() {
        AutomationForm automationForm = new AutomationForm()
                .openPracticePage()
                .fillEmail(getWrongEmail())
                .fillPassword(getPassword())
                .clickAuthButton();
        Assert.assertEquals(automationForm.getEmailFormatError().getText(), "Неверный формат E-Mail");
    }

    @Test(description = "Форма авторизации. Пустой E-Mail")
    public void emptyEmail() {
        AutomationForm automationForm = new AutomationForm()
                .openPracticePage()
                .fillPassword(getPassword())
                .clickAuthButton();
        Assert.assertEquals(automationForm.getEmailFormatError().getText(), "Неверный формат E-Mail");
    }

    @Test(description = "Форма авторизации. Пустой пароль")
    public void emptyPassword() {
        AutomationForm automationForm = new AutomationForm()
                .openPracticePage()
                .fillEmail(getEmail())
                .clickAuthButton();
        Assert.assertEquals(automationForm.getInvalidEmailPassword().getText(), "Неверный E-Mail или пароль");
    }

    @Test(description = "Форма авторизации. Правильные данные")
    public void correctData() {
        AutomationForm automationForm = new AutomationForm()
                .authorize(getCorrectEmail(), getCorrectPassword());
        Assert.assertTrue(automationForm.getDataSend().isDisplayed());
    }


}

