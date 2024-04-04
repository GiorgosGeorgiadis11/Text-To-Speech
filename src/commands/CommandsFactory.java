package commands;

import java.awt.event.ActionListener;
import javax.swing.JPanel;

import com.sun.speech.freetts.Voice;

// Class declaration
public class CommandsFactory {

    // Instance variables
    private JPanel panel;
    private String textArea;
    private String fileName;
    private int flag;
    private Voice talk;

    // Constructor
    public CommandsFactory() {

    }

    // Method to create an ActionListener based on the command string
    public ActionListener createCommand(String s) {
        // Use a switch statement to determine which ActionListener to create
        switch (s) {
            case "newDoc":
                // Return a new NewDocument instance
                return new NewDocument(panel, talk);
            case "editDoc":
                // Return a new EditDocument instance
                return new EditDocument(panel, textArea, talk);
            case "saveDoc":
                // Return a new SaveDocument instance
                return new SaveDocument(panel, textArea, fileName, talk);
            case "openDoc":
                // Return a new OpenDocument instance
                return new OpenDocument(panel, talk);
            case "LineDoc":
                // Return a new LineToSpeech instance
                return new LineToSpeech(panel, fileName, flag, talk);
            case "encodingDoc":
                // Return a new TuneEncoding instance
                return new TuneEncoding(panel, textArea, fileName, talk);
            case "audioDoc":
                // Create a new TuneAudio instance and make it visible
                TuneAudio audioDoc = new TuneAudio(talk);
                audioDoc.setVisible(true);
                // Return the new TuneAudio instance
                return audioDoc;
            default:
                // Return null if the command string doesn't match any cases
                return null;
        }
    }

    // Method to set the panel instance variable
    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    // Method to set the textArea instance variable
    public void setTextArea(String textArea) {
        this.textArea = textArea;
    }

    // Method to set the fileName instance variable
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    // Method to set the flag instance variable
    public void setFlag(int flag) {
        this.flag = flag;
    }

    // Method to set the talk instance variable
    public void setTalk(Voice talk) {
        this.talk = talk;
    }
}