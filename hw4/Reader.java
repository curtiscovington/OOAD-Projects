package hw4;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Reader {
  // Default contructor
  static Scanner userInput;
  Reader() {

    userInput = new Scanner(System.in);

  }

  public static Scanner getReader() {

      return userInput;
  }
     

}


