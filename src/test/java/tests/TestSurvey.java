package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationForm;

import static helpers.FakeUsersData.*;

public class TestSurvey extends BaseTest{
    @Test(description = "Анкета. Пустые данные")
    public void emptyData() {
        AutomationForm automationForm = new AutomationForm()
                .authorize(getCorrectEmail(), getCorrectPassword()).clickDataSend();
        Assert.assertEquals(automationForm.getEmailFormatError().getText(), "Неверный формат E-Mail");

    }

    @Test(description = "Анкета. Заполнен E-mail")
    public void fillEmail() {
        AutomationForm automationForm = new AutomationForm()
                .authorize(getCorrectEmail(), getCorrectPassword())
                .fillDataEmail(getEmail())
                .clickDataSend();
        Assert.assertEquals(automationForm.getBlankNameError().getText(), "Поле имя не может быть пустым");

    }

    @Test(description = "Анкета. Заполнено Имя")
    public void fillName() {
        AutomationForm automationForm = new AutomationForm()
                .authorize(getCorrectEmail(), getCorrectPassword());
        automationForm.fillName(getName()).clickDataSend();
        Assert.assertEquals(automationForm.getEmailFormatError().getText(), "Неверный формат E-Mail");

    }

    @Test(description = "Анкета. Не заполнен E-mail")
    public void notFillEmail() {
        AutomationForm automationForm = new AutomationForm()
                .authorize(getCorrectEmail(), getCorrectPassword());
        automationForm.fillName(getName()).dataGenderFemale().selectDataCheck11().selectDataCheck12().dataSelect21().clickDataSend();
        Assert.assertEquals(automationForm.getEmailFormatError().getText(), "Неверный формат E-Mail");

    }

    @Test(description = "Анкета. Некорректно заполнен E-mail")
    public void incorrectEmail() {
        AutomationForm automationForm = new AutomationForm()
                .authorize(getCorrectEmail(), getCorrectPassword());
        automationForm.fillDataEmail(getWrongEmail()).fillName(getName()).selectDataCheck11().selectDataCheck12().dataSelect22().clickDataSend();
        Assert.assertEquals(automationForm.getEmailFormatError().getText(), "Неверный формат E-Mail");

    }

    @Test(description = "Анкета. Заполнены все поля. Пол - Мужской, оба чекбокса, первая радиокнопка")
    public void fillAll() {
        AutomationForm automationForm = new AutomationForm()
                .authorize(getCorrectEmail(), getCorrectPassword())
                .fillDataEmail(getEmail())
                .fillName(getName())
                .selectDataCheck11()
                .selectDataCheck12()
                .dataSelect21()
                .clickDataSend()
                .buttonOk();
        Assert.assertEquals(automationForm.getCheckData().getText(), getEmail());
        Assert.assertEquals(automationForm.getCheckName().getText(), getName());
        Assert.assertEquals(automationForm.getCheckGender().getText(), "Мужской");
        Assert.assertEquals(automationForm.getCheckChoice1().getText(), "1.1, 1.2");
        Assert.assertEquals(automationForm.getCheckChoice2().getText(), "2.1");

    }

    @Test(description = "Анкета. Заполнены все поля 2")
    public void fillAll2() {
        AutomationForm automationForm = new AutomationForm()
                .authorize(getCorrectEmail(), getCorrectPassword());
        automationForm.fillDataEmail(getEmail()).fillName(getName()).dataGenderFemale().selectDataCheck11().selectDataCheck12().dataSelect22().clickDataSend();
        automationForm.buttonOk();
        Assert.assertEquals(automationForm.getCheckData().getText(), getEmail());
        Assert.assertEquals(automationForm.getCheckName().getText(), getName());
        Assert.assertEquals(automationForm.getCheckGender().getText(), "Женский");
        Assert.assertEquals(automationForm.getCheckChoice1().getText(), "1.1, 1.2");
        Assert.assertEquals(automationForm.getCheckChoice2().getText(), "2.2");

    }

    @Test(description = "Анкета. Заполнены все поля 3")
    public void fillAll3() {
        AutomationForm automationForm = new AutomationForm()
                .authorize(getCorrectEmail(), getCorrectPassword());
        automationForm.fillDataEmail(getEmail()).fillName(getName()).dataGenderFemale().selectDataCheck11().selectDataCheck12().dataSelect23().clickDataSend();
        // Assert.assertEquals(automationForm.getModalWindow(),"Данные добавлены.");
        automationForm.buttonOk();
        Assert.assertEquals(automationForm.getCheckData().getText(), getEmail());
        Assert.assertEquals(automationForm.getCheckName().getText(), getName());
        Assert.assertEquals(automationForm.getCheckGender().getText(), "Женский");
        Assert.assertEquals(automationForm.getCheckChoice1().getText(), "1.1, 1.2");
        Assert.assertEquals(automationForm.getCheckChoice2().getText(), "2.3");

    }

    @Test(description = "Анкета. Заполнены все поля 4")
    public void fillAll4() {
        AutomationForm automationForm = new AutomationForm()
                .authorize(getCorrectEmail(), getCorrectPassword());
        automationForm.fillDataEmail(getEmail()).fillName(getName()).selectDataCheck12().dataSelect21().clickDataSend();
        // Assert.assertEquals(automationForm.getModalWindow(),"Данные добавлены.");
        automationForm.buttonOk();
        Assert.assertEquals(automationForm.getCheckData().getText(), getEmail());
        Assert.assertEquals(automationForm.getCheckName().getText(), getName());
        Assert.assertEquals(automationForm.getCheckGender().getText(), "Мужской");
        Assert.assertEquals(automationForm.getCheckChoice1().getText(), "1.2");
        Assert.assertEquals(automationForm.getCheckChoice2().getText(), "2.1");

    }

    @Test(description = "Анкета. Заполнены все поля 5")
    public void fillAll5() {
        AutomationForm automationForm = new AutomationForm()
                .authorize(getCorrectEmail(), getCorrectPassword());
        automationForm.fillDataEmail(getEmail()).fillName(getName()).dataGenderFemale().selectDataCheck11().dataSelect23().clickDataSend();
        // Assert.assertEquals(automationForm.getModalWindow(),"Данные добавлены.");
        automationForm.buttonOk();
        Assert.assertEquals(automationForm.getCheckData().getText(), getEmail());
        Assert.assertEquals(automationForm.getCheckName().getText(), getName());
        Assert.assertEquals(automationForm.getCheckGender().getText(), "Женский");
        Assert.assertEquals(automationForm.getCheckChoice1().getText(), "1.1");
        Assert.assertEquals(automationForm.getCheckChoice2().getText(), "2.3");

    }

    @Test(description = "Анкета. Поля без чекбоксов")
    public void notFillAll() {
        AutomationForm automationForm = new AutomationForm()
                .authorize(getCorrectEmail(), getCorrectPassword());
        automationForm.fillDataEmail(getEmail()).fillName(getName()).dataGenderFemale().clickDataSend();
        // Assert.assertEquals(automationForm.getModalWindow(),"Данные добавлены.");
        automationForm.buttonOk();
        Assert.assertEquals(automationForm.getCheckData().getText(), getEmail());
        Assert.assertEquals(automationForm.getCheckName().getText(), getName());
        Assert.assertEquals(automationForm.getCheckGender().getText(), "Женский");
        Assert.assertEquals(automationForm.getCheckChoice1().getText(), "Нет");
        Assert.assertEquals(automationForm.getCheckChoice2().getText(), "");

    }

}
