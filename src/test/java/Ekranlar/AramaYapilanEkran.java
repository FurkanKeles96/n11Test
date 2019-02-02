/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ekranlar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author furkan
 * 
 * AramaYapilanEkran class'ında 2.sayfaya gitmemizi sağlayacak sayfayaGit değişkeni tanımlandı.
 * Favoirlere eklememizi sağlayan favoriBtn tanımlandı.
 * Aramada aranılan sonuç olup olmadığının onaylanması sağlanması için aramaSonuc değişkeni tanımlandı.
 * Favorilere eklenen ürün ile favoriler listesindeki ürünün aynı olduğunu onaylamak için favorilereEklenen değişkeni tanımlandı.
 * 
 * SayfayaGit metodu ile 2.sayfaya gitme işlemi yapıldı.
 * sonucBulunduMu metodu ile arama yapılan kelime ile ilgili sonuç çıkıp çıkmadığı hakkında konsol'a çıktı vermesi sağlandı.
 * favorilereEkle metodu ile istenilen ürün favorilere eklendi.
 * 
 */
public class AramaYapilanEkran {
    
    WebDriver driver;
    String aramaSonucu;
    String favorilereEklenenUrun;
    
    By sayfayaGit = By.xpath(".//*[@id='contentListing']/div/div/div[2]/div[3]/a[2]");
    By favoriBtn = By.xpath(".//*[@id='contentListing']/div/div/div[2]/section/div[2]/ul/li[3]/div/div[2]/span[2]");
    By aramaSonuc = By.xpath("//div[@id='contentListing']/div/div/div[2]/section/div/div/h1");
    //[@class='textImg followBtn']
    By favorilereEklenen = By.xpath("//li[3]/div/div/a/h3");
    
    public AramaYapilanEkran(WebDriver driver){
        this.driver=driver;
    }
    
    public void sayfayaGit(){
        driver.findElement(sayfayaGit).click();
    }
    
    public void sonucBulunduMu(){
        aramaSonucu = driver.findElement(aramaSonuc).getText();
        if(aramaSonucu.equals("Samsung")){
            System.out.println("Sonuc bulundu " + aramaSonucu);
        }
        else{
            System.out.println("Sonuc bulunamadı " + aramaSonucu);
        }
    }
    
    public void favorilereEkle(){
        driver.findElement(favoriBtn).click();
        favorilereEklenenUrun = driver.findElement(favorilereEklenen).getText();
    }
}
