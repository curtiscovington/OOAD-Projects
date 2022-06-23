# OOAD-Project-3 CSCI-5448.
This is a repository for Project3 for CSCI-5448 Su22 

Team Members: 
Curtis Covington
Tim Coleman   


This repo contains Java code to run a Pet Store Simulation as defined in the [project 3 requirements](OOAD%20Project%203.pdf).
Below is a high level breakdown of the classes and subclasses. Please refer to the [UML design doc](Pet_Store_Simulation_UML.pdf) for more information.  

* Simulation (Main): Contains the main method to the launch the simulation (default of 30 days to simulate)
* Item (Abstract)
  * Pet (Abstract)
    * Dog 
    * Cat
    * Bird 
  * Supply (Abstract)
    * Food
    * Leash 
    * Toy 
    * Cat Litter
* Person (Abstract)
  * Employee (Abstract)
    * Clerk 
    * Trainer
* Store
* Bank 
* CashRegister
* Order

Code compiled and tested with Java SDK 12. 





