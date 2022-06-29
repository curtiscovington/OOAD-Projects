package hw4;

public class EmployeeFactory {
    public static Employee create(String type, Bank bank) {
        String firstNames[] = {"John", "Jane", "Mary", "Bob", "Tom", "Jack", "Joe", "Sue", "Mary", "Jane", "Bob", "Tom", "Jack", "Joe", "Sue"};
        String lastNames[] = {"Smith", "Jones", "Williams", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin"};

        int randomIndex1 = (int) (Math.random() * firstNames.length);
        int randomIndex2 = (int) (Math.random() * lastNames.length);
        String name = firstNames[randomIndex1] + " " + lastNames[randomIndex2];
        // clerk or trainer
        if (type.equals("clerk")) {
            return new Clerk(name, bank);
        } else if (type.equals("trainer")) {
            return new Trainer(name);
        } else {
            return null;
        }
    }
}
