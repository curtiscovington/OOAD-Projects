public class Employee {
    private String name;
    private int lastDayOff;

    public Employee(String name) {
        this.name = name;
        this.lastDayOff = 0;
    }

    public void arriveAtStore() {
        System.out.println(name + " has arrived at the store.");
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // used to check if the employee has worked too many days
    public boolean isInNeedOfDayOff(int currentDay) {
        // if the employee has worked for 3 days without a day off, return true
        return (currentDay - lastDayOff >= 3);
    }
    
}
