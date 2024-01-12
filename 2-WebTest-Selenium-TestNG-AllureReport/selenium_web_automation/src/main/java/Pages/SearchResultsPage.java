package Pages;

import Base.BaseTest;
import Categories.Books;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SearchResultsPage extends BaseTest {
    static WebElement addCartButton;
    Books book = new Books();
    @Step("arama yapılan değerin title ile karşılaştırılması")
    public void productsTitleController(String product){
        String title = driver.findElement(By.cssSelector("h1[class='facet__products-title'")).getText();
        Assert.assertEquals(title, "\"".concat(product).concat("\" için arama sonuçları"));
    }
    @Step("Tükenen ürünleri gösterme click limi kontrolü")
    public void notForSaleIsCheck(){
        String checked = driver.findElement(By.cssSelector("input[data-model='ShowNotForSale']")).getAttribute("checked");
        Assert.assertEquals(checked,"true");
    }
    @Step("Listelenen ürünlerden ilkinin sepete eklenmesi")
    public String getFirstProductElement(){

        String firstProductElementLocation = "div[class*='facet__products-list']>div:first-child div[class='prd-main-wrapper']";

        iconMove(driver.findElement(By.cssSelector(firstProductElementLocation)));

        addCartButton = driver.findElement(By.cssSelector(
                firstProductElementLocation+" button[class*='add-cart-btn']"));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertTrue(addCartButton.isDisplayed());

        addCartButton.click();

        book.isEBook(firstProductElementLocation);

        return driver.findElement(By.cssSelector(
                firstProductElementLocation+" div[class='prd-prices'] div"))
                .getAttribute("data-price");

    }
    @Step("Listelenen ürünlerden sayfa sonundaki ürünün sepete eklenmesi")
    public  String getLastProductElement(){

        String lastProductElementLocation = "div[class*='facet__products-list']>div:last-child div[class='prd-main-wrapper']";

        iconMove(driver.findElement(By.cssSelector(lastProductElementLocation)));

        addCartButton = driver.findElement(By.cssSelector(
                lastProductElementLocation+" button[class*='add-cart-btn']"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertTrue(addCartButton.isDisplayed());

        addCartButton.click();

        book.isEBook(lastProductElementLocation);

        return driver.findElement(By.cssSelector(
                lastProductElementLocation+" div[class='prd-prices'] div"))
                .getAttribute("data-price");

        }
    @Step("Arama sonuçlarının ilk ve son elementi sepete ekle")
    public void addToCart(){
        orderAmount.add(Double.parseDouble(getFirstProductElement()));
        orderAmount.add(Double.parseDouble(getLastProductElement()));
        holdDriverWaitForSecond(3);
    }
}
