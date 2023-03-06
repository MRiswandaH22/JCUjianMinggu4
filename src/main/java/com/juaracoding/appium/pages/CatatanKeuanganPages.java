package com.juaracoding.appium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatatanKeuanganPages {

    private AndroidDriver<MobileElement> driver;


    //link


    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]")
    private MobileElement btnGDrive;
//    By btntutupGdrive = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]");

    @AndroidFindBy (id = "com.chad.financialrecord:id/fabMenu")
    private MobileElement btnTambah;
//    By btnTambah = By.id("com.chad.financialrecord:id/fabMenu");

    @AndroidFindBy (id = "com.chad.financialrecord:id/toolbarTitle")
    private MobileElement txtJudul;
//    By txtJudul = By.id("com.chad.financialrecord:id/toolbarTitle");

    @AndroidFindBy (id = "com.chad.financialrecord:id/tvDate")
    private MobileElement btnDate;
    @AndroidFindBy (xpath = "//android.view.View[@content-desc=\"08 Maret 2023\"]")
    private MobileElement pilihTanggal;
    @AndroidFindBy (id = "android:id/button1")
    private MobileElement btnOkDate;


    @AndroidFindBy (id = "com.chad.financialrecord:id/spCategory")
    private MobileElement btnKategory;
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[6]/android.widget.LinearLayout/android.widget.TextView")
    private MobileElement inputKategoryPengeluaran;
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView")
    private MobileElement inputKategoryPemasukan;
//    By inputKategori = By.id("com.chad.financialrecord:id/tvName");
    @AndroidFindBy (id = "com.chad.financialrecord:id/etAmount")
    private MobileElement inputJumlah;

    //    By inputJumlah = By.id("com.chad.financialrecord:id/etAmount");
    @AndroidFindBy (id = "com.chad.financialrecord:id/etNote")
    private MobileElement inputKeterangan;
//    By inputKeterangan = By.id("com.chad.financialrecord:id/etNote");

    @AndroidFindBy (id = "com.chad.financialrecord:id/btSave")
    private MobileElement btnSimpan;
//    By btnSimpan = By.id("com.chad.financialrecord:id/btSave");

    @AndroidFindBy (id = "com.chad.financialrecord:id/btnIncome")
    private MobileElement btnPemasukan;
//    By btnPemasukan = By.id("com.chad.financialrecord:id/btnIncome");

    @AndroidFindBy (id = "com.chad.financialrecord:id/tvIncome")
    private MobileElement txtPemasukan;
//    By txtPemasukan = By.id("com.chad.financialrecord:id/tvIncome");
    @AndroidFindBy (id = "com.chad.financialrecord:id/tvExpense")
    private MobileElement txtPengeluaran;
//    By txtPengeluaran = By.id("com.chad.financialrecord:id/tvExpense");

    @AndroidFindBy (id = "com.chad.financialrecord:id/tvBalance")
    private MobileElement txtSaldo;
//    By txtSaldo = By.id("com.chad.financialrecord:id/tvBalance");





    public CatatanKeuanganPages(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void tutupPopUp() {
        btnGDrive.click();
        btnTambah.click();
    }

//    public String getTxtJudul(){
//        return txtJudul.getText();
//    }

    public void addDataPengeluaran() {
        btnDate.click();
        pilihTanggal.click();
        btnOkDate.click();
        btnKategory.click();
        inputKategoryPengeluaran.click();
        inputJumlah.sendKeys("50000");
        inputKeterangan.sendKeys("sehari");
        btnSimpan.click();
    }

    public void addDataPemasukan(){
        btnTambah.click();
        btnPemasukan.click();
        btnDate.click();
        pilihTanggal.click();
        btnOkDate.click();
        btnKategory.click();
        inputKategoryPemasukan.click();
        inputJumlah.sendKeys("1000000");
        inputKeterangan.sendKeys("sehari");
        btnSimpan.click();
    }

    public String getJumlahPemasukan(){
        return txtPemasukan.getText();
    }

    public String getJumlahPengeluaran(){
        return txtPengeluaran.getText();
    }

    public String getTotalSaldo(){
        return txtSaldo.getText();
    }


}



