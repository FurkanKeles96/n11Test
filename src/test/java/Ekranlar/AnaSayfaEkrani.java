/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ekranlar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


/**
 *
 * @author furkan
 * 
 * Anasayfada yer alan ögelerin tanımlaması burada yapıldı.
 * Arama çubuğu, arama yapma butonu, giriş ekranına gitmeyi sağlayan buton, istek ve favorilere gitmeyi sağlayan buton
 * tanımlandı. Son olarak da direkt olarak favorilerim sayfası açılmadığı için istek ve favoriler sayfası kısmındaki
 * favoriler butonu da burada tanımlandı.
 * 
 * Hover değişkeni "Favoriler"e gitmemiz için Hesabım yazısı üstünde durduğumuzda açılması gereken menü.
 * Hover ile o menünün açılmasını sağlayıp istekVefavoriler sayfasına gidiş yapılması sağlandı.
 * 
 * Arama yapma, giriş sayfasına gitme ve istek listesine gitmeyi sağlayan metodlar burada tanımlandı.
 */
public class AnaSayfaEkrani {
    
    WebDriver driver;
    String kelime;
    
    By aramaCubugu = By.id("searchData");
    By aramaYapBtn = By.className("searchBtn");
    By girisBtn = By.className("btnSignIn");

    
    By istekVefavoriler = By.xpath("//header[@id='header']/div/div/div[2]/div[2]/div[2]/div[2]/div/a[2]");
    By favorilerim = By.xpath("//div[@id='myAccount']/div[3]/ul/li/div/a/h4"); //İstek listem ve favorilerime girdikten sonra
                                                                               //favorilere gitmek için
    
    By hover = By.xpath("//header[@id='header']/div/div/div[2]/div[2]/div[2]/div/a");
    


    
    public AnaSayfaEkrani(WebDriver driver){
        this.driver = driver;
    }
   
    
    public void aramaYap(String kelime){
        this.kelime = kelime;
        
        driver.findElement(aramaCubugu).sendKeys(kelime);
        driver.findElement(aramaYapBtn).click();
        
    }
    
    public void girisSayfasinaGit(){
        driver.findElement(girisBtn).click();
    }
    
    public void favorilereGit(){

        WebElement elmnt = driver.findElement(hover);
        Actions actions = new Actions(driver);
        actions.moveToElement(elmnt).perform(); // açılır menüyü gösteriyor
        driver.findElement(istekVefavoriler).click();
        driver.findElement(favorilerim).click(); //favoriler ekranındaki favoriler kısmını açmak için
    }
    
}
