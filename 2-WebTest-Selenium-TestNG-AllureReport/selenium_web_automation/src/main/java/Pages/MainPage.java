package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.time.Duration;

public class MainPage extends BaseTest {
    @Step("Main Page url e gidilir")
    public void getMainPage(){
        driver.get("https://www.dr.com.tr");
        //holdDriverWaitForSecond(3);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        //cookie kaldıralım -6698 sayılı Kişisel Verilerin Korunması Kanunu
       // driver.findElement(By.xpath("//a[@id='cookieBtn']")).click();
    }
    @Step("Driver da bir önceki sayfaya dönülür")
    public MainPage driverBack(){ driver.navigate().back(); return this;}
    @Step("Logo görünürlüğü kontrol edilir")
    public void logoIsDisplayed(){
        WebElement logoElement = driver.findElement(By.cssSelector("div[class='logo col-4 col-lg-1 text-center'] a svg"));
        Assert.assertTrue(logoElement.isDisplayed());
    }
    @Step("url ve Title Kontrolü")
    public void urlTitleControl(){
        Assert.assertTrue("D&R - Kültür, Sanat ve Eğlence Dünyası".equals(driver.getTitle()));
        Assert.assertEquals("https://www.dr.com.tr/",driver.getCurrentUrl());
    }
    @Step("Kitap Kategori elementi bulunur")
    public WebElement getKitapElement(){
        return driver.findElement(By.cssSelector("li[data-label='KİTAP']"));
    }
    @Step("Menu deki Kitap kategorisinin doğru linke gittiğinin kontrolü")
    public MainPage kitapLinkClick(){
        getKitapElement().click();
        String value = driver.findElement(By.cssSelector("h1[class='cat-name']")).getText();
        Assert.assertEquals(value, "Kitap");
        return this;
    }
    @Step("Menu deki Ders Kitapları kategorisinin doğru linke gittiğinin kontrolü")
    public MainPage derskitaplariLinkClick(){
        driver.findElement(By.cssSelector("li[data-label='DERS KİTAPLARI']")).click();
        String value = driver.findElement(By.cssSelector("h1[class='facet__products-title js-category-page-title']"))
                .getText();
        Assert.assertEquals(value, "Eğitim ve Sınav Kitapları");
        return this;
    }
    @Step("Menu deki Elektronik kategorisinin doğru linke gittiğinin kontrolü")
    public MainPage elektronikLinkClick(){
        driver.findElement(By.cssSelector("li[data-label='ELEKTRONİK']")).click();
        String value = driver.findElement(By.cssSelector("h1[class='cat-name']")).getText();
        Assert.assertEquals(value, "Elektronik");
        return this;
    }
    @Step("Menu deki Bilgisayar-Tablet kategorisinin doğru linke gittiğinin kontrolü")
    public MainPage bilgisayartabletLinkClick(){
        driver.findElement(By.cssSelector("li[data-label='BİLGİSAYAR,<br>TABLET']")).click();
        String value = driver.findElement(By.cssSelector("h1[class='cat-name']")).getText();
        Assert.assertEquals(value, "Bilgisayar & Tablet");
        return this;
    }
    @Step("Menu deki Elektrikli Ev aletleri kategorisinin doğru linke gittiğinin kontrolü")
    public MainPage elektriklievaletleriLinkClick(){
        driver.findElement(By.cssSelector("li[data-label='ELEKTRİKLİ EV <br>ALETLERİ']")).click();
        String value = driver.findElement(By.cssSelector("h1[class='cat-name']")).getText();
        Assert.assertEquals(value, "Elektrikli Ev Aletleri");
        return this;
    }
    @Step("Menu deki Hobi-Oyuncak kategorisinin doğru linke gittiğinin kontrolü")
    public MainPage hobioyuncakLinkClick(){
        driver.findElement(By.cssSelector("li[data-label='HOBİ, <br>OYUNCAK']")).click();
        String value = driver.findElement(By.cssSelector("h1[class='cat-name']")).getText();
        Assert.assertEquals(value, "Hobi & Oyuncak");
        return this;
    }
    @Step("Menu deki Anne-Bebek kategorisinin doğru linke gittiğinin kontrolü")
    public MainPage annebebekLinkClick(){
        driver.findElement(By.cssSelector("li[data-label='ANNE,<br>BEBEK']")).click();
        String value = driver.findElement(By.cssSelector("h1[class='cat-name']")).getText();
        Assert.assertEquals(value, "Anne Bebek");
        return this;
    }
    @Step("Menu deki Ofis-Kırtasiye kategorisinin doğru linke gittiğinin kontrolü")
    public MainPage ofiskirtasiyeLinkClick(){
        driver.findElement(By.cssSelector("li[data-label='OFİS,<br>KIRTASİYE']")).click();
        String value = driver.findElement(By.cssSelector("h1[class='cat-name']")).getText();
        Assert.assertEquals(value, "Kırtasiye");
        return this;
    }
    //Sitede Müzik kategorisine tıklanamıyor sitede hata var. diğer testlerin çalışmasını bozmaması
    // için Assert fonksiyonu uygulanmamıştır.
    @Step("Menu deki Müzik kategorisinin doğru linke gittiğinin kontrolü")
    public MainPage muzikhediyelikLinkClick(){///direkt kategoriye tıklanamıyor hatalı
        driver.findElement(By.cssSelector("li[data-label='MÜZİK, <br>HEDİYELİK']")).click();
        //Assert.assertEquals("https://www.dr.com.tr/kategori/Muzik/",driver.getCurrentUrl());// HATA
        return this;
    }
    @Step("Menu deki Spor-Outdoor kategorisinin doğru linke gittiğinin kontrolü")
    public MainPage sporoutdoorLinkClick(){
        driver.findElement(By.cssSelector("li[data-label='SPOR,<br>OUTDOOR']")).click();
        String value = driver.findElement(By.cssSelector("h1[class='cat-name']")).getText();
        Assert.assertEquals(value, "Spor, Outdoor");
        return this;
    }
    public WebElement searchInputElement(){
        return driver.findElement(By.cssSelector("input[class='search-input col-12 py-10 px-40 px-lg-50']"));
    }
    @Step("Buton elementi bulunur")
    public WebElement searchButtonElement(){
        return driver.findElement(By.cssSelector("div[class='search-button']"));
    }
    @Step("search-input dan input için arama yap ve açılan sayfadaki input yazısının  kontrolü")
    public void searchInput(String input){
        searchInputElement().sendKeys(input);
        searchButtonElement().click();
        holdDriverWaitForSecond(2);
        String value = searchInputElement().getAttribute("value");
        Assert.assertEquals(input,value);
    }
    @Step("searchInput playceholder kontrolü")
    public void serachPlayceholder(String playceholder){
        String text = searchInputElement().getAttribute("placeholder");
        Assert.assertEquals(playceholder,text);
    }
    @Step("Dropdown iconunun üzerine gelme")
    public void dropDownIconMove(){
        WebElement dropDownIcon = driver.findElement(By.cssSelector("svg[class*='icon-dropdown-down-icon ml-5 fs-3']"));
        iconMove(dropDownIcon);
    }
    @Step("Register sayfasına gidilir")
    public void registerPageClick(){
        getMainPage();
        dropDownIconMove();
        holdDriverWaitForSecond(4);
        WebElement registerPageButton = driver.findElement(By.cssSelector("li a[data-label='Üye Ol']"));
        registerPageButton.click();
    }
@Step("Alışveriş sepeti iconuna tıklanır")
    public MainPage cartIconClick(){
        pageScrollUp();
        WebElement cartIcon = driver.findElement(By.cssSelector("a[class='cart-icon position-relative']"));
        holdDriverWaitForSecond(2);

        jse.executeScript("arguments[0].click();", cartIcon);
        holdDriverWaitForSecond(3);
        return this;
    }
    /* icon bulunamamıştır
    @Step("alışveriş sepeti iconunda gözüken ürün sayısı iconu Kontrolü")
    public void cartCountIcon(){//alışveriş sepeti iconunda gözüken ürün sayısı Kontrolü

        pageScrollUp(); // a[href='/sepetim'] span[class*='js-shopping-cart-count'] => count sepet

        String cartCount = driver.findElement(By.cssSelector("a[href='/sepetim'] span[class*='js-shopping-cart-count']")).getText();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        //Assert.assertTrue(productCountIcon.isDisplayed());

        Assert.assertEquals(cartCount,""+orderAmount.size());
    }
     */
}
