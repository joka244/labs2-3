package sample;

public class StoreAssortment {
    private Clothes[] clothes;
    private int[] quantity;

    public StoreAssortment(Clothes[] clothes, int[] quantity) {
        this.clothes = clothes;
        this.quantity = quantity;
    }

    public StoreAssortment() {
    }

    public void setQuantityFromIndex(int index, int value) {
        try {
            quantity[index] = value;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Clothes[] getClothes() {
        return clothes;
    }

    public void setClothes(Clothes[] clothes) { this.clothes = clothes;
    }

    public int[] getQuantity() {
        return quantity;
    }

    public void setQuantity(int[] quantity) {
        this.quantity = quantity;
    }
}
