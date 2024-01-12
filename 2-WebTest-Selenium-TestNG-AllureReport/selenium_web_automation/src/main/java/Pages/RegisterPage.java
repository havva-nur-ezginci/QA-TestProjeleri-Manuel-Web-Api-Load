package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RegisterPage extends BaseTest {
    @Step("Kayıt sayfasının başarıyla görünür olduğunu doğrulayın")
    public void registerPageIsVisible(){
        Assert.assertEquals(driver.findElement(By.xpath("//h3[text()='Üye Ol']")).getText(),
                "Üye Ol");
    }
    @Step("Fırst Name Doldurulur")
    public RegisterPage firstNameDoldur(String text){
        driver.findElement(By.id("firstName")).sendKeys(text);
        return this;
    }
    @Step("Last Name Doldurulur")
    public RegisterPage lastNameDoldur(String text){
        driver.findElement(By.id("lastName")).sendKeys(text);
        return this;
    }
    @Step("Email Doldurulur")
    public RegisterPage emailDoldur(String text){
        driver.findElement(By.cssSelector("input[class='textbox_v2 js-email-control']")).sendKeys(text);
        return this;
    }
    @Step("Password Doldurulur")
    public RegisterPage passwordDoldur(String text){
        driver.findElement(By.id("passwordNew")).sendKeys(text);
        return this;
    }
    @Step("Uyelik sozlesmesi onaylanır")
    public RegisterPage uyelikSozlesmesiCheckBox(){

        WebElement checkBox1 = driver.findElement(By.xpath(
                "//a[@title='Üyelik Sözleşmesi']/following-sibling::span"));
        pageScrollDown(checkBox1);
        checkBox1.click();
        return this;
    }
    @Step("Aydinlatma Metni onaylanır")
    public RegisterPage aydinlatmaMetniCheckBox(){
        driver.findElement(By.xpath(
                "//a[@title='D&R Üyeliği Aydınlatma Metni']/following-sibling::span")).click();
        return this;
    }
    @Step("Register butonuna tıklanır")
    public void registerButtonClick(){
        WebElement button = driver.findElement(By.cssSelector("div[class='signup-buttons mt-15'] button"));
        pageScrollDown(button);
        button.click();
    }
    @Step("Error Sifre 6 karakterden az Mesaj Kontrolü")
    public void errorPasswordMessageController1(String text){//6 karakter den az
        String value = driver.findElement(By.id("passwordNew-error")).getText();
        Assert.assertEquals(value, text);
    }
    @Step("Error Sifre 0 harf Mesaj Kontrolü")
    public void errorPasswordMessageController2(String text){//0 harf
        String value = driver.findElement(By.cssSelector("span[class='js-register-error-text']")).getText();
        Assert.assertEquals(value, text);
    }
    @Step("Error Mail Mesaj Kontrolü")
    public void errorMailMessageController(String text){
        String value = driver.findElement(By.id("email-error")).getText();
        Assert.assertEquals(value, text);
    }
    @Step("Error Firstname Mesaj Kontrolü")
    public void errorFirstnameMessageController(String text){
        String value = driver.findElement(By.id("firstName-error")).getText();
        Assert.assertEquals(value, text);
    }
    @Step("Error Lastname Mesaj Kontrolü")
    public void errorLastnameMessageController(String text){
        String value = driver.findElement(By.id("lastName-error")).getText();
        Assert.assertEquals(value, text);
    }
    @Step("Error Password Mesaj Kontrolü")
    public void errorPasswordMessageController(String text){
        String value = driver.findElement(By.id("passwordNew-error")).getText();
        Assert.assertEquals(value, text);
    }
    @Step("Error Üyekik sözleşmesi Mesaj Kontrolü")
    public void erroreMembershipAgreementMessageController(String text){
        String value = driver.findElement(By.id("membershipAgreement-error")).getText();
        Assert.assertEquals(value, text);
    }
    @Step("Error Üyekik sözleşmesi Mesaj Kontrolü")
    public void errorMembershipClarificationMessageController(String text){
        String value = driver.findElement(By.id("membershipClarification-error")).getText();
        Assert.assertEquals(value, text);
    }
    @Step("Üyelik Doğrulama Mesaj Kontrolü")
    public void membershipVerificationMessageController(String text){
        pageScrollUp();
        String value = driver.findElement(By.cssSelector("div[class='gsm-validation__title']")).getText();
        Assert.assertEquals(value, text);
    }
    @Step("Üyelik Doğrulama Text Area Kontrolü")
    public void membershipVerificationContentController(String text){
        String value = driver.findElement(By.cssSelector("p[class='email-verification__popup-text']")).getText();
        Assert.assertTrue(value.equals(text));
    }
    @Step("Mail Doğrulama Kodu Girişi")
    public RegisterPage setVerificationCode(String codeNumber){
        driver.findElement(By.cssSelector("input[id='code']")).sendKeys(codeNumber);
        return this;
    }
    @Step("Doğrulama Kodu Butonuna Tıklama")
    public RegisterPage verificationButtonClick(){
        driver.findElement(By.xpath("//button[text()='Doğrula']")).click();
        holdDriverWaitForSecond(4);
        return this;
    }
    @Step("Hatalı Code Error Message Kontrolü")
    public RegisterPage errorVerificationCodeMessageController(String text){
        String value = driver.findElement(By.id("code-msg")).getText();
        Assert.assertEquals(value,text);
        return this;
    }
    @Step("Varolan kullanıcı Error Message Kontrolü")
    public void errorExistingUserMessageController(String text){
        String value = driver.findElement(By.cssSelector("span[class='js-register-error-text']")).getText();
        Assert.assertEquals(value,text);
    }

}

