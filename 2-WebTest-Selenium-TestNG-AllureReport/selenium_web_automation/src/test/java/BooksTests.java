import Base.BaseTest;
import Categories.Books;
import Pages.MainPage;
import Pages.SearchResultsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BooksTests extends BaseTest {
    MainPage mainPage = new MainPage();
    Books books = new Books();
    SearchResultsPage searchResultsPage = new SearchResultsPage();

    @BeforeMethod(description = "E-kitap kategorisine giriş")
    public void test(){
        mainPage.getMainPage();
        mainPage.searchInput("E-kitap");
    }
    @Test(description = "sepete e-kitap ekleme ve popup kontrolü")
    public void test1(){
        searchResultsPage.getFirstProductElement();
        books.ekitapPopup();
        books.closePopup();
    }
}
