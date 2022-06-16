package hw2;
public class Order {
    Item item;
    int daysToFill;
    public Order(Item item) {
        this.item = item;
        // random days to fill order between 1 and 3
        this.daysToFill = (int) (Math.random() * 3) + 1;
    }

    public Item checkForOrder() {
        if (daysToFill > 0) {
            daysToFill--;
            return null;
        } else {
            return item;
        }
    }
    
}
