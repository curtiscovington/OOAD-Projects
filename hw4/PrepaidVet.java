package hw4;
public class PrepaidVet extends DecoratorAddOn {
    private Item item;
    private int quantity;

    public PrepaidVet(Item item, String name, double purchasePrice,int dayArrived, int quantity) {

        super(name, purchasePrice, dayArrived);
        this.item = item;
        this.quantity = quantity;
    }


    @Override
    public double getSalePrice() {

        return (super.getSalePrice() *  this.quantity) + item.getSalePrice();
    }

    @Override
    public String getName() {
        return   item.getName() + " and " + this.quantity + " " + super.getName();
    }
   
}