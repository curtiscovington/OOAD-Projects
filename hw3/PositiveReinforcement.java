package hw3;
public class PositiveReinforcement implements TrainingAlgorithm {


    public PositiveReinforcement() {
    }

    public boolean toggleHousebroken(boolean isHousebroken) {

        // 50% chance of changing from False to True 
        if (!isHousebroken) {
            if (Math.random() < .50 ) {
                return true;
            }
        }
        else {
            return isHousebroken;
            
        }
        return isHousebroken;
    }


    public String getTraningAlgoName() {
        
        return "Positive Reinforcement";
    }
}