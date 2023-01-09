package sample;


public class UserReserve {
    private Clothes clothes;
    private int quantity;
    private double totalAmount;

    public UserReserve() {
        this.clothes = new Clothes();
        this.quantity = 0;
        this.totalAmount = 0;
    }

    public UserReserve(Clothes clothes, int quantity) {
        this.clothes = clothes;
        this.quantity = quantity;
        this.totalAmount = clothes.getPrice() * quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public int getQuantity () {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
