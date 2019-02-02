/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Ekranlar.GirisYapEkrani;
import Ekranlar.AnaSayfaEkrani;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author furkan
 * 
 * GirisYap class'ı ile ilk olarak n11.com sitesinin açılıp açılmadığı onaylandı.
 * Sonrasında da giris ekranına gidilerek giris işlemlerinin yapılması sağlandı.
 */
public class GirisYap {
    String driverPath = "C:\\Users\\furkan\\Desktop\\geckodriver-v0.24.0-win64\\geckodriver.exe";
    public WebDriver driver;
    
    @Test
    public void GirisYap(){
            
        
        System.setProperty("webdriver.gecko.driver", driverPath);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);
        
        String url = "https://www.n11.com/";
        driver.get(url);
        try{
            Assert.assertEquals(url, driver.getCurrentUrl());  //Title ile de yapılabilir.
            System.out.println("Dogru sayfa acildi");
        }
        catch(Throwable pageNavigationError){
            System.out.println("Doğru sayfa açılmadı " + driver.getCurrentUrl().toString());
        }
        

        girisYapiliyor();
        
      
        
        //driver.quit();
    }
    
    public void girisYapiliyor(){
        AnaSayfaEkrani anasayfa = new AnaSayfaEkrani(driver);
        
        anasayfa.girisSayfasinaGit();
        
        GirisYapEkrani giris = new GirisYapEkrani(driver);
        
        giris.emailYaz();
        giris.sifreYaz();
        giris.girisTikla();
    }
}
