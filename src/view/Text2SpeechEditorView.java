package view;

import java.awt.*;
import javax.swing.*;
import commands.CommandsFactory; // Import the CommandsFactory class
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Text2SpeechEditorView {
	private JFrame frame; // Frame for the application
	private CommandsFactory factory; // Factory for creating commands
	private JLayeredPane layeredPane; // Layered pane for displaying panels
	private JPanel panel; // Initial panel
	private static final String VOICE = "kevin16"; // Default voice setting
	private static final int FRAME_WIDTH = 450; // Frame width
	private static final int FRAME_HEIGHT = 300; // Frame height

	//Main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Text2SpeechEditorView window = new Text2SpeechEditorView();
					window.initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void initialize() {
		frame = new JFrame(); // Initialize frame
		frame.setBounds(100, 100, FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initializeMenuBar(); // Initialize menu bar
		initializeLayeredPane(); // Initialize layered pane
		initializeFactories(); // Initialize factories
		frame.setVisible(true); // Make the frame visible
	}

	private void initializeMenuBar() {
		JMenuBar menuBar = new JMenuBar(); // Initialize menu bar
		frame.setJMenuBar(menuBar);

		JMenu menu = new JMenu("Menu"); // Initialize menu
		menuBar.add(menu);

		// Set voice properties
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		Voice voice = VoiceManager.getInstance().getVoice(VOICE);

		// Initialize New Document menu item
		JMenuItem newDocumentItem = new JMenuItem("New Document");
		newDocumentItem.addActionListener(e -> switchPanel(voice, "newDoc"));
		menu.add(newDocumentItem);

		// Initialize Open Document menu item
		JMenuItem openDocumentItem = new JMenuItem("Open Document");
		openDocumentItem.addActionListener(e -> switchPanel(voice, "openDoc"));
		menu.add(openDocumentItem);

		// Initialize Audio Tune menu item
		JMenuItem audioTuneItem = new JMenuItem("Audio Tune");
		audioTuneItem.addActionListener(e -> factory.createCommand("audioDoc"));
		menu.add(audioTuneItem);
	}

	private void initializeLayeredPane() {
		layeredPane = new JLayeredPane(); // Initialize layered pane
		layeredPane.setBounds(0, 0, 434, 240);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));

		panel = new JPanel(); // Initialize initial panel
		layeredPane.add(panel, "main panel");
		panel.setLayout(null);

		JLabel welcomeLabel = new JLabel("WELCOME"); // Initialize welcome message
		welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		welcomeLabel.setBounds(138, 78, 232, 59);
		panel.add(welcomeLabel);
	}

	private void initializeFactories() {
		factory = new CommandsFactory(); // Initialize factory
	}

	private void switchPanel(Voice voice, String commandName) {
		layeredPane.removeAll(); // Clear layered pane
		layeredPane.add(panel); // Add the new panel
		layeredPane.repaint(); // Repaint the layered pane
		layeredPane.revalidate(); // Validate the layered pane
		factory.setPanel(panel); // Set the panel for the factory
		factory.setTalk(voice); // Set the voice for the factory
		factory.createCommand(commandName); // Create the command
	}
}