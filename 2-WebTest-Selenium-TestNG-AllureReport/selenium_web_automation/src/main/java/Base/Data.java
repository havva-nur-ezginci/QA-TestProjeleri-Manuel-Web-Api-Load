package Base;
import java.util.ArrayList;
import java.util.List;

public class Data {
    public static String browser = "Chrome";
    public static String firstname = "testName123";
    public static String lastname = "testLastname123";
    public static String email = "dedd@mail.com";
    public static String password = "testsifresi9";//required: 6 Karakter 1 Harf 1 Rakam
    public static String searchValue = "müzik aletleri";
    public static List<Double> orderAmount = new ArrayList<>();
    public static String actTotalPrice;
    public String errorMessageExistingUserText = "Girdiğiniz e-posta adresi zaten kullanılıyor.";
    public String errorMessageVerificationCodeText = "Girilen kod yanlış";
    public String errorMessageFirstnameText = "Lütfen adınızı giriniz.";
    public String errorMessageLastnameText = "Lütfen soyadınızı giriniz.";
    public  String errorMessageMailText1 = "Lütfen e-posta adresinizi giriniz.";
    public  String errorMessageMailText2 = "Lütfen geçerli bir e-posta adresi giriniz.";
    public  String errorMessagePasswordText = "Lütfen şifrenizi giriniz.";
    public  String  errorMessageMembershipAgreementText  = "Lütfen üyelik sözleşmesini onaylayın.";
    public String errorMessageMembershipClarificationText = "Lütfen D&R Üyeliği Aydınlatma Metni’ni onaylayın.";
    public  String errorMessagePasswordText1 = "Şifreniz 6-16 karakter aralığında olmalı";
    public  String errorMessagePasswordText2 = "Şifreniz minimum 6 karakter olmalı en az 1 rakam ve büyük veya küçük harf içermelidir.";
    public String messageMembershipVerificationText ="Doğrulama Kodu Girin";
    public  String eKitapMessageInformation = "e-Kitap iadesi olmayan dijital bir üründür. Fiziki teslimat yapılmayacaktır.";
    public String cartPageUrl = "https://www.dr.com.tr/sepetim";
    public String cartEmptyTitle = "Alışveriş Sepetiniz Boş";
}
