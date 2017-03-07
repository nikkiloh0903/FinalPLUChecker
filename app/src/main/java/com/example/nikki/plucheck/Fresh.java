package com.example.nikki.plucheck;

/**
 * Created by Nikki on 28/2/17.
 */
public class Fresh {
    private String brand, name, sku, plu, price;

    public Fresh(String brand, String product, String SKU, String PLU){}

    public Fresh (String brand, String name, String sku, String plu, String price) {
        this.brand = brand;
        this.name = name;
        this.sku = sku;
        this.plu = plu;
        this.price = price;
    }

    public String getBrand() {return brand;}

    public void setBrand(String brand) {this.brand = brand;}

    public String getName () {return name;}

    public void setName (String name) {this.name = name;}

    public String getSKU () {return sku;}

    public void setSKU (String sku) {this.sku = sku;}

    public String getPLU () {return plu;}

    public void setPLU (String plu) {this.plu = plu;}

    public String getPrice () {return price;}

    public void setPrice (String price) {this.price = price;}

}