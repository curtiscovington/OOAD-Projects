package hw4;

import java.beans.PropertyChangeListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger implements PropertyChangeListener {

    StoreEvent event;
    int day;
    String fileName;

    public Logger(int day) {
        this.day = day;
        fileName = "logs/Logger-" + day + ".txt";
        File file = new File(fileName);
        try {
            if (file.getParentFile() != null && !file.getParentFile().mkdirs()) {
                // handle permission problems here
            }
            file.createNewFile();

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void propertyChange(java.beans.PropertyChangeEvent evt) {
        event = (StoreEvent) evt.getNewValue();
        write();
    }

    private void write() {
        // appends to a file Logger-n.txt where n is the day
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(event.toString());
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
