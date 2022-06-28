package hw4;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Reader {
  // Default contructor
  Reader() {
  }

  
  // Static method to collect user input strings from console
  public static String getUserInputString() {
    // Assuming valid strings as input. 
    Scanner userInput = new Scanner(System.in);
    String line = userInput.nextLine();
    userInput.close();
    return line;
  }
}


