package hw4;
public class Haphazard implements TrainingAlgorithm {

    public Haphazard() {
    }

    public boolean toggleHousebroken(boolean isHousebroken) {

        // 10% change of changing boolean
        if (Math.random() < .10 ) {

            if (isHousebroken) {
                return false; 
            }
            else {
                return true;
            }

        }
        return isHousebroken;

    }

    public String getTraningAlgoName() {
        
        return "Haphazard";
    }
}