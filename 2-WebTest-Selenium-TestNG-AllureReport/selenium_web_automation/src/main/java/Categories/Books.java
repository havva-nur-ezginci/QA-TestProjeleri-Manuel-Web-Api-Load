package Categories;
import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Books extends BaseTest {
    @Step("e-kitap eklenmiştir popup görünürlüğü kontrolü")
    public void ekitapPopup(){
        Assert.assertTrue(driver.findElement(By.xpath(
                "//h2[text()='Ürün Sepetinize Eklenmiştir.']")).isDisplayed());
    }
    @Step("e-kitap sepete eklemede açılan popup ı kapat")
    public void closePopup(){
        Assert.assertEquals(driver.findElement(
                        By.cssSelector("h2[class='basket-modal__title fs-5 text-center js-popup-title']")).getText(),
                "Ürün Sepetinize Eklenmiştir.");

        Assert.assertEquals(driver.findElement(
                        By.cssSelector("div[class='basket-modal__ebook-text js-ebook-text']")).getText(),
                "e-Kitap iadesi olmayan dijital bir üründür. Fiziki teslimat yapılmayacaktır.");

        driver.findElement(By.cssSelector("button[class*='btn basket-modal__btn-more']")).click();//alışverişe devam et
    }
    @Step("Ekitap popu içerik kontrolü")
    public void popupContentControl(){
        String eKitapBilgiMesaji =  driver.findElement(By.cssSelector("div[class='basket-modal__ebook-text js-ebook-text'] p")).getText();
        Assert.assertEquals(eKitapBilgiMesaji,eKitapMessageInformation);
    }
    @Step("Elementin e-kitap olup olmadığının kontrolü")
    public void isEBook(String locateElemet) {
        if(driver.findElement(By.cssSelector(locateElemet+" div[class='product-img'] a"))
                .getAttribute("href").contains("/kitap/") ||
                driver.getCurrentUrl().contains("kitap")){

            WebElement bookElement = driver.findElement(By.cssSelector(locateElemet+" div[class*='prd-media-type'] span"));
            if (bookElement.getAttribute("title").equals("e-Kitap")) {
               popupContentControl();
                //closePopup();
            }
        }
    }
}
