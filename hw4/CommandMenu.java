package hw4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommandMenu {
    
    Map<Integer, Command> commandMap;

    CommandMenu() {

        commandMap = new HashMap<Integer, Command>();

    }


    public void addCommand(int commandIndex, Command command) {

        commandMap.put(commandIndex, command);

    }  

    public void getCommand(int commandIndex) {

        System.out.println(commandMap.get(commandIndex) );

    }  

    public void executeCommand(int commandIndex) {

        commandMap.get(commandIndex).execute();

    }  

    public void getAllCommands() {

        for(int key: commandMap.keySet()) {
            System.out.println(key + ": " + commandMap.get(key) );
        }

    }  

    public void executeAllCommands() {

        System.out.println("Execute all commands");

        for (Command command : commandMap.values()) {
            command.execute();
        }

    }  



}
