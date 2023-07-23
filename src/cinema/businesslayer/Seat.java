package cinema.businesslayer;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Seat {
    private int row;
    private int column;
    private int price;
    @JsonIgnore
    private boolean purchased;

    public Seat() {
    }

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.purchased = false;
        this.price = row <= 4 ? 10 : 8;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.row;
        hash = 53 * hash + this.column;
        return hash;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
