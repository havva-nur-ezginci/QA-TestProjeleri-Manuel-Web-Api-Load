import Base.BaseTest;
import Pages.MainPage;
import Pages.ShoppingCartPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingCartTests extends BaseTest {
    MainPage mainPage = new MainPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @BeforeMethod(description = "Alışveriş sepeti sayfasına git")
    public void test(){
        mainPage.getMainPage();
        mainPage.cartIconClick();
        shoppingCartPage.cartPageVerification();
    }
   @Test(description = "Alışveriş sepeti boş kontrolü")
    public void test1(){
        shoppingCartPage
                .emptyCart()
                .emptyCartImage()
                .startShoppingButton();
    }
}
