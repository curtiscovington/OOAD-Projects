# OOAD-Project-3 CSCI-5448.
This is a repository for Project3 for CSCI-5448 Su22 

Team Members:   
Curtis Covington   
Tim Coleman     


Logs from the Logger class are in the logs directory.

This repo contains Java code to run a Pet Store Simulation as defined in the [project 4 requirements](OOAD%20Project%204.pdf) which has extended support from project 3 and includes items (summary): 

|  Feature |  Done |
|---|---|
| [Project_Proposal](Project_Proposal.pdf) | Yes  | 
| [UML Sequence Diagram](Pet_Store_Sequence_diagram.pdf) | Yes  | 
| [UML Class Diagram](Pet_Store_Simulation_UML_Project_4.pdf) | Yes  | 
| Run for two stores | Yes  | 
| Pool of employees work stores | Yes  | 
| Command Line Interface (CLI) [console out](logs/CommandMenuConsole.txt) | Yes  | 
| Factory Pattern| Yes  | 
| Singleton patterns  | Yes  | 
| JUnit Tests (15+ asserts) [console out](logs/JUnitConsole.txt) | Yes  | 


Below is a high level breakdown of the classes and subclasses. Please refer to the [UML design doc](Pet_Store_Simulation_UML_Project_4.pdf ) for more information and the [Activity UML diagram](Pet_Store_UML_Activity_Diagram.pdf) to see the application flow as well as the [UML sequence diagram](Pet_Store_Sequence_diagram.pdf)

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





