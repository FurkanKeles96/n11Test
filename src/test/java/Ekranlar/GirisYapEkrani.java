package Ekranlar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 *
 * @author furkan
 * 
 * GirisYapEkrani class'ı ile giriş yaparken kullanmamız gereken alanlar tanımlandı.
 * Email, şifre ve giriş yapmaya yarayan loginBtn tanımlandı.
 * 
 * EmailYaz metodu ile email alanına email bilgisi yazılması sağlandı.
 * SifreYaz metodu ile sifre alanına sifre bilgisi yazılması sağlandı.
 * GirisTikla metodu ile giriş yapma butonuna tıklanması sağlandı.
 * 
 * Giris yaparken EmailYaz, SifreYaz ve GirisTikla metodlarını teker teker çağırmamak için
 *      kisaGirisYap metodu tanımlandı.
 */
public class GirisYapEkrani {
    
    WebDriver driver;
    
    By email = By.id("email");
    By pass = By.id("password");
    By loginBtn = By.id("loginButton");
    
    public GirisYapEkrani(WebDriver driver){
        this.driver=driver;
        
    }
    
    public void emailYaz(){
        driver.findElement(email).sendKeys("seleniumbotdeneme@gmail.com");
    }
    
    public void sifreYaz(){
        driver.findElement(pass).sendKeys("selenium123.");
    }
    
    public void girisTikla(){
        driver.findElement(loginBtn).click();
    }
    
    public void kisaGirisYap(){  //Bazı yerlerde  emailYaz, sifre yaz ve girisTikla methodlarını tek tek çağırmamak için
        emailYaz();
        sifreYaz();
        girisTikla();
        
    }
}
