package com.juaracoding.appium;

import com.juaracoding.appium.pages.CatatanKeuanganPages;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestCatatanKeuanganPages {

    private static AndroidDriver<MobileElement> driver;

    private CatatanKeuanganPages catatanKeuanganPages;

    public TestCatatanKeuanganPages(){

    }



    @BeforeClass
    public void setUpMobile() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME,"SM A515F");
        dc.setCapability(MobileCapabilityType.UDID,"RR8N102A6XA");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"12");

        dc.setCapability("appPackage","com.chad.financialrecord");
        dc.setCapability("appActivity","com.rookie.catatankeuangan.feature.splash.SplashActivity");
        dc.setCapability("autoGrantPermissions", true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);

        delay(3);
    }

    @BeforeMethod
    public void pageObject(){
        this.catatanKeuanganPages = new CatatanKeuanganPages(driver);
    }

    @Test(priority = 1)
    public void testPengeluaran(){
        //stepAction
        this.catatanKeuanganPages.tutupPopUp();
        this.catatanKeuanganPages.addDataPengeluaran();
//        this.catatanKeuanganPages.getTxtJudul();
        delay(3);

        //step verify
//        Assert.assertEquals(this.catatanKeuanganPages.getTxtJudul(),"Buat Transaksi");
//        System.out.println(this.catatanKeuanganPages.getTxtJudul());
        Assert.assertEquals(this.catatanKeuanganPages.getJumlahPengeluaran(),"50.000");
        System.out.println("Pengeluaran Anda : "+this.catatanKeuanganPages.getJumlahPengeluaran());
    }

    @Test(priority = 2)
    public void testPemasukan(){
        //stepAction
        this.catatanKeuanganPages.addDataPemasukan();
        delay(3);

        //step verify
        Assert.assertEquals(this.catatanKeuanganPages.getJumlahPemasukan(),"1.000.000");
        System.out.println("Pemasukan Anda : "+this.catatanKeuanganPages.getJumlahPemasukan());
        Assert.assertEquals(this.catatanKeuanganPages.getTotalSaldo(),"950.000");
        System.out.println("Total Saldo anda : "+this.catatanKeuanganPages.getTotalSaldo());
    }


    @AfterClass
    public void quitApp(){
        delay(3);
        //untuk menutup Android
        driver.quit();
        System.out.println("Mobile Quit");
    }

    static void delay(int detik){
        //biar tidak redudant
        //untuk delay 3 detik
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
