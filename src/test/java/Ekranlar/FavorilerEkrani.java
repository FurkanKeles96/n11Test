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
 * FavorilerEkrani class'ında favori silmemizi sağlayan favoriSilBtn tanımlandı.
 * Favori sildikten sonra ekrana çıkan pop up'ta "Tamam"a tıklayabilmek için tamamBtn tanımlandı. (Henüz tamama tıklama işlemini gerçekleştiremiyor)
 * Silinip silinmediğini onaylayabilmemiz için ekrana çıkan pop up'taki onay mesajını tutmayı sağlayan silindiMesaj tanımlandı. (Henüz onaylama işlemini gerçekleştirmiyor)
 * FavoriyeEklenen değişkeni ile silinmesini istediğimiz ürünün ne olduğu bilgisi tutulmasını sağlayacak değişken tanımlandı.
 * 
 * FavoriSil metodu ile favorilere eklenen ürünün favorilerden silinmesi sağlandı.
 *      Silinip silinmediğini onaylama işlemi burada yapılacak. (Henüz gerçekleştirilemedi.)
 * AynıUrunMu metoduyla favorilere eklediğimiz ürünle silmek istediğimiz ürünün aynı olup olmadığı kontrol edilmesi sağlanacak.
 *      (Henüz bu işlemi gerçekleştiremiyor.)
 * 
 */
public class FavorilerEkrani {
    
    WebDriver driver;
    String favoriListesindekiUrun;
    String aramadaFavorilereEklenenUrun;

    //By favoriSilBtn = By.xpath("//div[@id='p-291761723']/div[3]/span");
    By favoriSilBtn = By.xpath(".//*[@id='view']/ul/li[1]/div/div[3]/span");
    By tamamBtn = By.xpath("//div[4]/div/div/span");
    By silindiMesaj = By.xpath("//div[4]/div/span[2]");
    By favoriyeEklenen = By.xpath("//a/h3");
    
    By aramadaFavorilereEklenen = By.xpath("//li[3]/div/div/a/h3");
    
    AramaYapilanEkran aramaEkrani = new AramaYapilanEkran(driver);
    
    public FavorilerEkrani(WebDriver driver){
        this.driver=driver;
    }

    
    public void favoriSil(){
        driver.findElement(favoriSilBtn).click();
        //driver.findElement(tamamBtn).click();  --Tıklama işlemi istenildiği gibi çalışmıyor.
        driver.navigate().refresh(); //Sayfaya çıkan pop up'ın gitmesi için refresh yapıldı.
        
        /*if(driver.findElement(silindiMesaj).getText().substring(18, 24).equals("silindi")){ //Çıkan pop up'tan istenilen text alma işlemi çalışmıyor.
            System.out.println("BAŞARIYLA SİLİNDİ");
        }
        else{
            System.out.println("Hata");
        }*/
    }
    
    public void ayniUrunMu(){
        favoriListesindekiUrun = driver.findElement(favoriyeEklenen).getText();
        aramadaFavorilereEklenenUrun = driver.findElement(aramadaFavorilereEklenen).getText();
        
        if(aramaEkrani.favorilereEklenenUrun.equals(favoriListesindekiUrun)){
            System.out.println("Favorilere eklediğiniz ürün bu sayfada bulunmaktadır.");
        }
        else{
            System.out.println("Favorilere eklediğiniz ürün bu sayfada bulunmamaktadır.");
        }
        
    }
}
