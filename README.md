1- Manuel test için kullanılan site : https://tr.surveymonkey.com/

Manuel test raporları **TestRail** de oluşturulmuştur.

2- Web otomasyon projesinde **Selenium, TestNG, AllureReport** teknolojileri kullanılmıştır.

otomasyon da kullanılan site : https://www.dr.com.tr/
allure-result altında test sonuçları bulunmaktadır.

proje yolunda cmd => allure serve allure-results 

komutu çalıştırarak detaylı rapor görülebilir.

3- Api test projesinde **Chakram, Mocha, AllureReport** kullanılmıştır. 
Api testinde kullanılan site : https://petstore.swagger.io/

chakram ile terminalden test çalıştırma  => npm test

mocha - allureReport ile test ve rapor oluşturma:

test çalıştır => node runner.js

rapor oluştur => npx allure serve allure-results

4- Load test projesinde **Locust** kullanılmıştır.
Yük testinde kullanılan site : https://petstore.swagger.io/

Locust load test raporlarına (.html) indirilip bakılmalıdır.

sanal oluşturulmuş venv klasörü kullanılmak istenirse

virtual environment kurulu olmalıdır => pip3 install virtualenv

venv klasörünü kullanmak için proje yolunda => venv\Scripts\activate
komutunu çalıştırarak aktif hale getirilmelidir.

**İlgili Projeler:**

- [Web Test Projesi (Selenium, JUnit, TestNG ve Maven)](https://github.com/havva-nur-ezginci/Java_Test_Projects/tree/master/com.MavenSelenium/src/test/java)
- [API Test Projesi (Postman ve RestAssured)](https://github.com/havva-nur-ezginci/Java_Test_Projects/tree/master/API_Testing/src/test/java)

