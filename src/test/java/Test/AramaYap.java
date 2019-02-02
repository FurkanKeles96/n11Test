/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Ekranlar.AnaSayfaEkrani;
import Ekranlar.AramaYapilanEkran;
import Ekranlar.GirisYapEkrani;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author furkan
 * 
 * AramaYap class'ında istenilen ürünün aramasının yapılması sağlandı.
 * Sonrasında istenildiği üzere 2.sayfaya gidilip 3.sıradaki ürünü favorilere ekledi.
 * 
 * Açılan tarayıcıda giriş bilgileri tutulmadığı ve kullanıcının sürekli login olması gerektiği için
 *      giris yapmaya yarayan metod çağrıldı.
 * 
 * 
 */
public class AramaYap {
    
    String driverPath = "C:\\Users\\furkan\\Desktop\\geckodriver-v0.24.0-win64\\geckodriver.exe"; //Driver path'i değiştirilmeli
    public WebDriver driver;
    
    @Test
    public void AramaYap(){
        System.setProperty("webdriver.gecko.driver", driverPath);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);
        
        driver.get("https://www.n11.com");
        
        AnaSayfaEkrani anasayfa = new AnaSayfaEkrani(driver);
        AramaYapilanEkran arama = new AramaYapilanEkran(driver);
        GirisYapEkrani giris = new GirisYapEkrani(driver);
        
        anasayfa.girisSayfasinaGit();
        giris.kisaGirisYap();
        
        anasayfa.aramaYap("Samsung");
        arama.sonucBulunduMu();
        
        arama.sayfayaGit();//2.sayfaya gidecek
        arama.favorilereEkle();//3.sıradaki ürünü favorilere ekleyecek
        
        
    }
    
}
