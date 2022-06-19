package hw3;
public class NegativeReinforcement implements TrainingAlgorithm {


    public NegativeReinforcement() {
    }

    public boolean toggleHousebroken(boolean isHousebroken) {

        // 20% chance of housebroken changing from True to False; 
        // 40% chance of changing from False to True 
        if (isHousebroken) {
            if (Math.random() < .20 ) {
                return false;
            }
        }
        else {
            if (Math.random() < .40 ) {
                return true; 
            }
        }
        return isHousebroken;
    }
}