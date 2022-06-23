# OOAD-Project-3 CSCI-5448.
This is a repository for Project3 for CSCI-5448 Su22 

Team Members:   
Curtis Covington   
Tim Coleman     


Logs from the Logger class are in the logs directory.

This repo contains Java code to run a Pet Store Simulation as defined in the [project 3 requirements](OOAD%20Project%203.pdf) which has extended support from project 2 and includes items (high level): 

|  High Level Feature |  Done |
|---|---|
| Stop selling Toys | Yes  | 
| Use Poisson distribution for employee arrival | Yes  | 
| Add new clerk and trainer | Yes  | 
| Adjust for 10% change of being sick | Yes  | 
| New Ferret  | Yes  | 
| New Snake  | Yes  | 
| New Treats  | Yes  | 
| Use a Decorator pattern for add-ons  | Yes  | 
| Use Strategy pattern to assign a training algorithm  | Yes  | 
| Use an Observer Pattern to publish a summary of employee actions  | Yes  | 
| Create an event consumer class called a Logger | Yes  | 
| Create an event consumer class called a Tracker | Yes  |
| Update UML class diagram for observer, decorator and strategy | Yes  |
| Add UML Activity diagram for app flow | Yes  |


Below is a high level breakdown of the classes and subclasses. Please refer to the [UML design doc](Pet_Store_Simulation_UML_Project_3.pdf ) for more information and the [Activity UML diagram](Pet_Store_UML_Activity_Diagram.pdf) to see the application flow. 

* Simulation (Main): Contains the main method to the launch the simulation (default of 30 days to simulate)
* Item (Abstract)
  * Pet (Abstract)
    * Dog 
    * Cat
    * Bird
    * Snake
    * Ferret
  * Supply (Abstract)
    * Food
    * Leash 
    * Toy 
    * Cat Litter
    * Treat
* Person (Abstract)
  * Employee (Abstract)
    * Clerk 
    * Trainer
* Store
* Bank 
* CashRegister
* Order

Code compiled and tested with Java SDK 12. 





