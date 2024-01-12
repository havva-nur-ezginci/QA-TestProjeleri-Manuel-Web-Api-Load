import Base.BaseTest;
import Pages.MainPage;
import Pages.SearchResultsPage;
import Pages.ShoppingCartPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchResultsTest extends BaseTest {
    MainPage mainPage = new MainPage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @BeforeMethod(description = "Arama sayfası git")
    public void test(){
        mainPage.getMainPage();
        mainPage.searchInput(searchValue);
    }
    @Test(description = "Tükenen Ürünleri Gösterme tikli Kontrolü")
    public void test1(){
        searchResultsPage.notForSaleIsCheck();
    }

    @Test(description = "sepete ekle - sonuç sayfasındaki ilk ve son öğeyi ekle")
    public void test2(){
        searchResultsPage.addToCart();
    }

    @Test(description = "alışveriş sepeti iconuna tıklayıp açılan popup da tutar Kontrolü")
    public void test3(){
        test2();
        mainPage.cartIconClick();
        shoppingCartPage.cartAmountController();
    }
}
