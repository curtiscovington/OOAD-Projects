public class Bird extends Pet {
    private int size;
    private boolean mimicry;
    private boolean exotic;
    private boolean papers;

    public Bird(String name, double purchasePrice, int dayArrived, String breed, int age, boolean healthy, int size, boolean mimicry, boolean exotic, boolean papers) {
        super(name, purchasePrice, dayArrived, breed, age, healthy);
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

    static public Item newRandomItem(int dayArrived) {
        // an array of random dog names to choose from
        String[] names = { "Zera", "Birdy", "Boo", "Joey" };
        // choose a random name
        String name = names[(int) (Math.random() * names.length)];
        // random purchase price between $25 and $100.00
        double purchasePrice = (Math.random() * 75) + 25;

        String[] breeds = { "Scarlet Macaw", "Cockatiel", "Parrot" };
        String breed = breeds[(int) (Math.random() * breeds.length)];

        // random age between 1 and 10
        int age = (int) (Math.random() * 50) + 1;

        // random size between 1 and 5
        int size = (int) (Math.random() * 3) + 1;

        return new Bird(name, purchasePrice, dayArrived, breed, age, true, size, Math.random() < 0.5, Math.random() < 0.5, Math.random() < 0.5);
    }
}
