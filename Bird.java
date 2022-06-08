public class Bird extends Pet {
    private int size;
    private boolean mimicry;
    private boolean exotic;
    private boolean papers;

    public Bird(String name, double purchasePrice, double salePrice, int dayArrived, int daySold, String breed, int age, boolean healthy, int size, boolean mimicry, boolean exotic, boolean papers) {
        super(name, purchasePrice, salePrice, dayArrived, daySold, breed, age, healthy);
        this.size = size;
        this.mimicry = mimicry;
        this.exotic = exotic;
        this.papers = papers;
    }

    public int getSize() {
        return size;
    }

    public boolean isMimicry() {
        return mimicry;
    }

    public boolean isExotic() {
        return exotic;
    }

    public boolean isPapers() {
        return papers;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setMimicry(boolean mimicry) {
        this.mimicry = mimicry;
    }

    public void setExotic(boolean exotic) {
        this.exotic = exotic;
    }

    public void setPapers(boolean papers) {
        this.papers = papers;
    }
}
