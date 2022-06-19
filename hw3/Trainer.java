package hw3;
public class Trainer extends Employee {
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


}