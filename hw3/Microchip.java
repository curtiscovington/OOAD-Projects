package hw3;
public class Microchip extends DecoratorAddOn {
    private Item item;

    public Microchip(Item item, String name, double purchasePrice,int dayArrived) {

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