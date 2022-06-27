package hw3;
public class Insurance extends DecoratorAddOn {
    private Item item;

    public Insurance(Item item, String name, double purchasePrice,int dayArrived) {

        super(name, purchasePrice, dayArrived);
        this.item = item;
    }


    @Override
    public double getSalePrice() {

        return super.getSalePrice() + item.getSalePrice();
    }

    @Override
    public String getName() {
        return  item.getName() + " and " + super.getName();
    }
   
}