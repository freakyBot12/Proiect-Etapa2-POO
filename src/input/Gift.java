package input;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class Gift {

    private String productName;
    private double price;
    private String category;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int quantity;

    public Gift() {

    }

    public Gift(final String productName,
                final double price,
                final String category,
                final int quantity) {
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(final String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }
}
