public class Employee extends Person {
    private String name;
    private int daysWorkedInARow;

    public Employee(String name) {
        this.name = name;
        
    }

    public void arriveAtStore() {
        daysWorkedInARow++;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // used to check if the employee has worked too many days
    public boolean isInNeedOfDayOff() {
        // if the employee has worked for 3 days without a day off, return true
        return daysWorkedInARow >= 3;
    }

    public void takeDayOff() { 
        daysWorkedInARow = 0;
    }
    
}
