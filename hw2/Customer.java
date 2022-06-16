package hw2;
public class Customer extends Person {
    // the customers intent to buy something either an Item, a Supply, or a Pet
    private String intent;

    public Customer() {
        // random number 0 - 2
        int random = (int) (Math.random() * 3);
        if (random == 0) {
            intent = "item";
        } else if (random == 1) {
            intent = "supply";
        } else {
            intent = "pet";
        }
    }

    public boolean examineItem(Item item) {
        // if the item is an instance of the intent then return true
        if (item instanceof Pet) {
            if (intent.equals("pet")) {
                return true;
            } else {
                return false;
            }
        } else if (item instanceof Supply) {
            if (intent.equals("supply")) {
                return true;
            } else {
                return false;
            }
        } else if (item instanceof Item) {
            if (intent.equals("item")) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
