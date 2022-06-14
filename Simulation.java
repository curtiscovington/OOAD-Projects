import java.util.ArrayList;

public class Simulation {
    
    public static void main(String[] args) {
        Simulation sim = new Simulation(30);
        sim.runSimulation();
    }

    private int daysToSimulate;
    private Bank bank;
    private Store store;
    private ArrayList<Clerk> clerks = new ArrayList<Clerk>();
    private ArrayList<Trainer> trainers = new ArrayList<Trainer>();
    

    public Simulation(int daysToSimulate) {
        this.daysToSimulate = daysToSimulate;
        // Create a new bank
        bank = new Bank();
        store = new Store();

        clerks.add(new Clerk("John", bank));
        clerks.add(new Clerk("Sarah", bank));
        trainers.add(new Trainer("Timmy"));
        trainers.add(new Trainer("Sally"));
    }

    public void runSimulation() {
        for (int i = 0; i < daysToSimulate; i++) {
            runDay(i);
        }
    }

    public void runDay(int currentDay) {
        store.increaseAge();
        Clerk c = getClerkToWork();
        Trainer t = getTrainerToWork();
        store.arriveAtStore(c);
        store.arriveAtStore(t);
        store.runDay();
    }

    public Clerk getClerkToWork() {
        Clerk c;
        while (true) {
            // keep trying to get a trainer until they are not in need of a day off
            int index = (int) (Math.random() * clerks.size());
            if (!(c = clerks.get(index)).isInNeedOfDayOff()) {
                // set all others to have day off
                for (int i = 0; i < clerks.size(); i++) {
                    if (i != index) {
                        clerks.get(i).takeDayOff();
                    }
                }
                return c;
            }
        }
    }
    public Trainer getTrainerToWork() {
        Trainer t;
        while (true) {
            // keep trying to get a trainer until they are not in need of a day off
            int index = (int) (Math.random() * trainers.size());
            if (!(t = trainers.get(index)).isInNeedOfDayOff()) {
                // set all others to have day off
                for (int i = 0; i < trainers.size(); i++) {
                    if (i != index) {
                        trainers.get(i).takeDayOff();
                    }
                }
                return t;
            }
        }
    }
}
