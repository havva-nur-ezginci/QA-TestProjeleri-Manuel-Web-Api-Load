import Base.BaseTest;
import Pages.MainPage;
import Pages.RegisterPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTests extends BaseTest {
    RegisterPage registerPage = new RegisterPage();
    MainPage mainPage = new MainPage();

  @BeforeMethod(description = "Üye ol page (link) e tıkla ve Doğrula 'Üye Ol'")
  public void test1(){
      mainPage.registerPageClick();
      registerPage.registerPageIsVisible();
  }

    @Test(description = "Hatalı Sıfre Ile Kullanıcı Olusturma")
    public void test2() {// sifre :  6 Karakter 1 Harf 1 Rakam formatında olmalıdır.
      registerPage
              .firstNameDoldur(firstname)
              .lastNameDoldur(lastname)
              .emailDoldur(email)
              .passwordDoldur("aaa")//>>> HATA!!! 6 karakterden az
              .uyelikSozlesmesiCheckBox()
              .aydinlatmaMetniCheckBox()
              .registerButtonClick();

      registerPage.errorPasswordMessageController1(errorMessagePasswordText1);
      holdDriverWaitForSecond(2);
    }
  @Test(description = "Hatalı Sıfre Ile Kullanıcı Olusturma")
  public void test3() {// sifre :  6 Karakter 1 Harf 1 Rakam formatında olmalıdır.
    registerPage
            .firstNameDoldur(firstname)
            .lastNameDoldur(lastname)
            .emailDoldur(email)
            .passwordDoldur("123456")//>>> HATA!!! 6 rakam 0 harf
            .uyelikSozlesmesiCheckBox()
            .aydinlatmaMetniCheckBox()
            .registerButtonClick();

    registerPage.errorPasswordMessageController2(errorMessagePasswordText2);
    holdDriverWaitForSecond(2);
  }
  @Test(description = "Hatalı Mail Ile Kullanıcı Olusturma- s@mail.c")
  public void test4() {
    registerPage
            .firstNameDoldur(firstname)
            .lastNameDoldur(lastname)
            .emailDoldur("mail.com")//>>> minimum örnek format =>s@mail.c
            .passwordDoldur(password)
            .uyelikSozlesmesiCheckBox()
            .aydinlatmaMetniCheckBox()
            .registerButtonClick();

    registerPage.errorMailMessageController(errorMessageMailText2);
    holdDriverWaitForSecond(2);
  }
  @Test(description = "Zorunlu alanların boş geçilmesi ve uyarı mesaj kontrolü")
  public void test5(){
    registerPage.registerButtonClick();
    registerPage.errorFirstnameMessageController(errorMessageFirstnameText);
    registerPage.errorLastnameMessageController(errorMessageLastnameText);
    registerPage.errorMailMessageController(errorMessageMailText1);
    registerPage.errorPasswordMessageController(errorMessagePasswordText);
    registerPage.erroreMembershipAgreementMessageController(errorMessageMembershipAgreementText);
    registerPage.errorMembershipClarificationMessageController(errorMessageMembershipClarificationText);

    holdDriverWaitForSecond(2);
  }

    @Test(description = "Kullanıcı Olusturma")
    public void test6() {
        registerPage
                .firstNameDoldur(firstname)
                .lastNameDoldur(lastname)
                .emailDoldur(email)
                .passwordDoldur(password)
                .uyelikSozlesmesiCheckBox()
                .aydinlatmaMetniCheckBox()
                .registerButtonClick();


        registerPage.membershipVerificationMessageController(messageMembershipVerificationText);
        registerPage.membershipVerificationContentController(
                email+" isimli adresinize gönderdiğimiz doğrulama kodunu giriniz.");
    }
//test üst üste çok fazla çalıştırılacaksa email değiştirilmelidir. site aynı maile üst üste kod göndermiyor.
  @Test(description = "Kullanıcı Olusturma ve hatalı doğrulama kodu")
  public void test7() {
      email = "lkdjsldvj1572sd@gmail.com" ;
      test6();// Doğru kullanıcı oluşturma
      registerPage
           .setVerificationCode("111111")//>>Hatali Code!!
           .verificationButtonClick()
           .errorVerificationCodeMessageController(errorMessageVerificationCodeText);
  }
  @Test(description = "Var olan kullanıcı ile yeni kullanıcı olusturma")
    public void test8(){
      email = "deneme123@gmail.com";
      registerPage
              .firstNameDoldur(firstname)
              .lastNameDoldur(lastname)
              .emailDoldur(email)
              .passwordDoldur(password)
              .uyelikSozlesmesiCheckBox()
              .aydinlatmaMetniCheckBox()
              .registerButtonClick();

      pageScrollUp();
      registerPage.errorExistingUserMessageController(errorMessageExistingUserText);
  }
}
