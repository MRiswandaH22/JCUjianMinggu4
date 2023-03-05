package com.juaracoding.appium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class CatatanKeuanganPages {

    private AndroidDriver<MobileElement> driver;


    //link


    By btntutupGdrive = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]");

    By btnTambah = By.id("com.chad.financialrecord:id/fabMenu");

    By txtJudul = By.id("com.chad.financialrecord:id/toolbarTitle");

    By inputDate = By.id("com.chad.financialrecord:id/tvDate");
    By inputKategori = By.id("com.chad.financialrecord:id/tvName");
    By inputJumlah = By.id("com.chad.financialrecord:id/etAmount");
    By inputKeterangan = By.id("com.chad.financialrecord:id/etNote");

    By btnSimpan = By.id("com.chad.financialrecord:id/btSave");

    By btnPemasukan = By.id("com.chad.financialrecord:id/btnIncome");

    By txtPemasukan = By.id("com.chad.financialrecord:id/tvIncome");
    By txtPengeluaran = By.id("com.chad.financialrecord:id/tvExpense");
    By txtSaldo = By.id("com.chad.financialrecord:id/tvBalance");





    public CatatanKeuanganPages(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
//        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void tutupPopUp() {
        ((MobileElement) this.driver.findElement(this.btntutupGdrive)).click();
    }

    public String getTxtJudul(){
        return ((MobileElement) this.driver.findElement(this.txtJudul)).getText();
    }

    public void addDataPengeluaran() {
        ((MobileElement) this.driver.findElement(this.btnTambah)).click();
        ((MobileElement) this.driver.findElement(this.inputDate)).sendKeys("23 Mar 2023");
        ((MobileElement) this.driver.findElement(this.inputKategori)).sendKeys("Olahraga");
        ((MobileElement) this.driver.findElement(this.inputJumlah)).sendKeys("50000");
        ((MobileElement) this.driver.findElement(this.inputKeterangan)).sendKeys("sehari");
        ((MobileElement) this.driver.findElement(this.btnSimpan)).click();
    }

    public void addDataPemasukan(){
        ((MobileElement) this.driver.findElement(this.btnTambah)).click();
        ((MobileElement) this.driver.findElement(this.btnPemasukan)).click();
        ((MobileElement) this.driver.findElement(this.inputDate)).sendKeys("23 Mar 2023");
        ((MobileElement) this.driver.findElement(this.inputKategori)).sendKeys("Gaji");
        ((MobileElement) this.driver.findElement(this.inputJumlah)).sendKeys("1000000");
        ((MobileElement) this.driver.findElement(this.inputKeterangan)).sendKeys("sehari");
        ((MobileElement) this.driver.findElement(this.btnSimpan)).click();
    }

    public String getJumlahPemasukan(){
        return ((MobileElement) this.driver.findElement(this.txtPemasukan)).getText();
    }

    public String getJumlahPengeluaran(){
        return ((MobileElement) this.driver.findElement(this.txtPengeluaran)).getText();
    }

    public String getTotalSaldo(){
        return ((MobileElement) this.driver.findElement(this.txtSaldo)).getText();
    }


}



