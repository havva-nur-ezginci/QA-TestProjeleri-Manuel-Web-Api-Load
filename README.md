1- Manuel test için kullanılan site : https://tr.surveymonkey.com/

2- Web otomasyon projesinde Selenium, TestNg, AllureReport teknolojileri kullanılmıştır.
otomasyon da kullanılan site : https://www.dr.com.tr/
allure-result altında test sonuçları bulunmaktadır.
proje yolunda cmd => allure serve allure-results 
komutu çalıştırarak detaylı rapor göülebilir.

3- Api testinde kullanılan site : https://petstore.swagger.io/

chakram ile terminalden test çalıştırma  => npm test

mocha - allureReport ile test ve rapor oluşturma:

test çalıştır => node runner.js

rapor oluştur => npx allure serve allure-results

4- Yük testinde kullanılan site : https://petstore.swagger.io/
Locust load test raporlarına (.html) indirilip bakılmalıdır.
