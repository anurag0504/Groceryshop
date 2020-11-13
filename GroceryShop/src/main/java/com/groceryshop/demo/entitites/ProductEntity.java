package com.cg.gsm.app.entities;

import java.sql.Timestamp;
import java.util.Arrays;
import javax.persistence.Entity;

@Entity
public class ProductEntity extends BaseEntity {

    private String name;
    private String categoryId;
    private String productCode;
    private String price;
    private String description;
    private String quantity;
    private byte[] image;

    public ProductEntity() {
        super();
    }

    public ProductEntity(long id, String createdBy, String modifiedBy, Timestamp createdDateTime, Timestamp modifiedDateTime, String name, String categoryId, String productCode,
            String price, String description, String quantity, byte[] image) {
        super(id, createdBy, modifiedBy, createdDateTime, modifiedDateTime);
        this.name = name;
        this.categoryId = categoryId;
        this.productCode = productCode;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ProductEntity [name=" + name + ", categoryId=" + categoryId + ", productCode=" + productCode + ", price=" + price + ", description=" + description + ", quantity="
                + quantity + ", image=" + Arrays.toString(image) + "]";
    }

    @Override
    public String getKey() {
        return String.valueOf(id);
    }

    @Override
    public String getValue() {
        return name;
    }

}
