import Base.BaseTest;
import Pages.MainPage;
import Pages.SearchResultsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainTests extends BaseTest {
    MainPage mainPage = new MainPage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();

    @BeforeMethod(description = "Ana Sayfaya giriş")
    public void test(){
        mainPage.getMainPage();
    }

    @Test(description = "Ana sayfada url ve Title Kontrolü")
    public void test1(){
        mainPage.urlTitleControl();
    }

    @Test(description = "Ana Sayfa Logo Kontrolü")
    public void test2(){
        mainPage.logoIsDisplayed();
    }

    @Test(description = "menu link kontrolü")
    public void test3(){
        mainPage
                .kitapLinkClick()
                .driverBack()
                .derskitaplariLinkClick()
                .driverBack()
                .elektronikLinkClick()
                .driverBack()
                .bilgisayartabletLinkClick()
                .driverBack()
                .elektriklievaletleriLinkClick()
                .driverBack()
                .hobioyuncakLinkClick()
                .driverBack()
                .annebebekLinkClick()
                .driverBack()
                .ofiskirtasiyeLinkClick()
                .driverBack()
                .sporoutdoorLinkClick()
                .driverBack()
                .muzikhediyelikLinkClick();//sitede hata var click yapılamıyor
                //.driverBack();
    }
    @Test(description = "SearchInput playceholder kontrolü")
    public void test4(){
        mainPage.serachPlayceholder("Kitap, Elektronik, Oyuncak, Kırtasiyede ürün, kategori ve marka ara… ");
    }
    @Test(description = "search-input dan input için arama yap ve açılan sayfadaki input title yazısı  kontrolü")
    public void test5(){
        mainPage.searchInput(searchValue);
        searchResultsPage.productsTitleController(searchValue);
    }
}
