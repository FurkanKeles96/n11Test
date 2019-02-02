/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Ekranlar.AnaSayfaEkrani;
import Ekranlar.AramaYapilanEkran;
import Ekranlar.FavorilerEkrani;
import Ekranlar.GirisYapEkrani;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author furkan
 * 
 * Bütün test case'lerini tek class üzerinden çağırmamızı sağlayan class.
 *      Şu an tam olarak istenildiği gibi çalışmıyor.
 */
public class TumCaseler {
    String driverPath = "C:\\Users\\furkan\\Desktop\\geckodriver-v0.24.0-win64\\geckodriver.exe";
    public WebDriver driver;
    
    @Test
    public void Tek(){
        System.setProperty("webdriver.gecko.driver", driverPath);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);
        
        driver.get("https://www.n11.com");
        
        AnaSayfaEkrani anasayfa = new AnaSayfaEkrani(driver);
        
        anasayfa.girisSayfasinaGit();
        
        GirisYapEkrani giris = new GirisYapEkrani(driver);
        
        giris.emailYaz();
        giris.sifreYaz();
        giris.girisTikla();
        
        anasayfa.aramaYap("Samsung");
        
        AramaYapilanEkran arama = new AramaYapilanEkran(driver);
        
        arama.sayfayaGit();
        
        arama.favorilereEkle();
        
        
        anasayfa.favorilereGit();
        
        //FavorilerEkrani favori = new FavorilerEkrani(driver);
        
        //favori.favoriSil();
        
    }
}
