package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.text.DecimalFormat;

public class ShoppingCartPage extends BaseTest {
    @Step("Alışveriş sayfası url doğrulama")
    public void cartPageVerification(){
        Assert.assertEquals(driver.getCurrentUrl(),cartPageUrl);
    }
    @Step("Alışveriş Sepetiniz Boş title kontrolü")
    public ShoppingCartPage emptyCart(){
        String emptyTitle = driver.findElement(By.cssSelector("h3[class='subpage-header']")).getText();
        Assert.assertEquals(emptyTitle,cartEmptyTitle);
        return this;
    }
    @Step("Alışveriş Sepetiniz Boş Image i görünürlük kontrolü")
    public ShoppingCartPage emptyCartImage(){
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='emptyImg']")).isDisplayed());
        return this;
    }
    @Step("Hemen Alışverişe Başla Butonu görünürlük kontrolü")
    public void startShoppingButton (){
        WebElement shoppingButton = driver.findElement(By.cssSelector("div[class='emptyImg']"));
        pageScrollDown(shoppingButton);
        Assert.assertTrue(shoppingButton.isDisplayed());
    }
    @Step("Sepet tutarı kontrolü")
    public void cartAmountController(){
        DecimalFormat df = new DecimalFormat("0.00");
        double expTotalPrice = 0.0;

        for (double price:orderAmount) {
            expTotalPrice+=price;
        }
        String dfexpTotalPrice =df.format(expTotalPrice);

        actTotalPrice = driver.findElement(By.cssSelector("span[class='total color-red']")).getText().split(" ")[0];
        actTotalPrice = actTotalPrice.replace(".","");
        /*
        System.out.println("act:"+actTotalPrice);
        System.out.println("exp:"+dfexpTotalPrice);
         */
        Assert.assertEquals(actTotalPrice,dfexpTotalPrice);
    }
}
