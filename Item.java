abstract class Item {
    private String name;
    private double purchasePrice;
    private double listPrice;
    private double salePrice;
    private int dayArrived;
    private int daySold;

    public Item(String name, double purchasePrice, double listPrice, double salePrice, int dayArrived, int daySold) {
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.listPrice = listPrice;
        this.salePrice = salePrice;
        this.dayArrived = dayArrived;
        this.daySold = daySold;
    }

    public String getName() {
        return name;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getListPrice() {
        return listPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public int getDayArrived() {
        return dayArrived;
    }

    public int getDaySold() {
        return daySold;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public void setDayArrived(int dayArrived) {
        this.dayArrived = dayArrived;
    }

    public void setDaySold(int daySold) {
        this.daySold = daySold;
    }
}