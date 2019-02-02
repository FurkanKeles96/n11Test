/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Ekranlar.AnaSayfaEkrani;
import Ekranlar.FavorilerEkrani;
import Ekranlar.GirisYapEkrani;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author furkan
 * 
 * FavorilereGit class'ı ile favori sayfasına gidilmesi sağlandı.
 * Favorilere eklenen ürünle favoriler listesindeki ürünün aynı olduğu burada onaylanacak.
 *      (Henüz gerçekleştirilemedi.)
 * 
 * Açılan tarayıcıda giriş bilgileri tutulmadığı ve kullanıcının sürekli login olması gerektiği için
 *      giris yapmaya yarayan metod çağrıldı.
 */
public class FavorilereGit {
    String driverPath = "C:\\Users\\furkan\\Desktop\\geckodriver-v0.24.0-win64\\geckodriver.exe"; //Driver path'i değiştirilmeli
    public WebDriver driver;
    
    @Test
    public void FavorilereGit(){
        System.setProperty("webdriver.gecko.driver", driverPath);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);
        
        driver.get("https://www.n11.com");
        
        AnaSayfaEkrani ana=new AnaSayfaEkrani(driver);
        GirisYapEkrani giris = new GirisYapEkrani(driver);
        FavorilerEkrani favori = new FavorilerEkrani(driver);

        ana.girisSayfasinaGit();
        giris.kisaGirisYap();
        ana.favorilereGit();
        
        //favori.ayniUrunMu();
        
    }
}
