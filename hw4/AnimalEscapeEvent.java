package hw3;

public class AnimalEscapeEvent extends StoreEvent {
    Pet pet;

    public AnimalEscapeEvent(Employee employee, Pet pet) {
        super(employee);
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
    }

    @Override
    public String toString() {
        String str = super.toString();
        return "AnimalEscapeEvent: " + str + ", pet: " + pet.getName();
    }
}
