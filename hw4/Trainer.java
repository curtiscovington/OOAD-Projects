package hw4;

import java.util.ArrayList;

public class Trainer extends Employee {
    // Delgate the training algo behavior using Strategt pattern 
    TrainingAlgorithm trainerAlgo; 

    public Trainer(String name) {
        super(name);
        assignTrainingAlgorithm(); 
    }

    // Helper method to randonly assign a training method
    private void assignTrainingAlgorithm(){

        String[] traningAlgoTypes = { "Haphazard", "PositiveReinforcement", "NegativeReinforcement"};
        String traningType = traningAlgoTypes[(int) (Math.random() * traningAlgoTypes.length)];

        this.setTrainingAlgorithm(traningType);

    }

    public boolean setTrainingAlgorithm(String trainingType) {

        if (trainingType.equals("Haphazard")) {
            this.trainerAlgo = new Haphazard();
            return true; 
        }

        if (trainingType.equals("PositiveReinforcement")) {
            this.trainerAlgo = new PositiveReinforcement();
            return true; 
        }

        if (trainingType.equals("NegativeReinforcement")) {
            this.trainerAlgo = new NegativeReinforcement();
            return true; 
        }

        System.out.println("Error setting TrainingAlgorithm. Training Algo Type " + trainingType + " not recognized ");
        return false;

    }

    public TrainingAlgorithm getTrainingAlgorithm(String trainingType) {
        return this.trainerAlgo;
        
    }

    // Method to train every animal based on the training algo assigned
    public void trainAnimals(ArrayList<Item> allItems ) { 


        boolean houseBroken;

        // Filter for dogs and cats only 
        // TODO. Maybe create a new abstact class for Household pets that have housebroken? 
        for (Item item : allItems) {

            if (item instanceof Dog) {

                houseBroken = this.trainerAlgo.toggleHousebroken(((Dog)item).isHousebroken());
               
                if (houseBroken != ((Dog)item).isHousebroken()) {
                    if (houseBroken) {
                        System.out.println(  "Trainer " + this.getName() + " using " + this.trainerAlgo.getTraningAlgoName() + " for Dog is now housebroken");
                    }
                    else {
                       System.out.println(  "Trainer " + this.getName() + " using " + this.trainerAlgo.getTraningAlgoName() + " for Dog is now not housebroken");
                    }
                }
                ((Dog)item).setHousebroken(houseBroken);
            }
            if (item instanceof Cat) {

                houseBroken = this.trainerAlgo.toggleHousebroken(((Cat)item).isHousebroken());
                if (houseBroken != ((Cat)item).isHousebroken()) {

                    if (houseBroken) {
                        System.out.println(  "Trainer " + this.getName() + " using " + this.trainerAlgo.getTraningAlgoName() + " for Cat is now housebroken");
                    }
                    else {
                       System.out.println(  "Trainer " + this.getName() + " using " + this.trainerAlgo.getTraningAlgoName() + " for Cat is now not housebroken");
                    }
                }
                ((Cat)item).setHousebroken(houseBroken);
            }
        }
    }

    @Override
    public String getEmployeeType() {
        return "Trainer";
    }
}