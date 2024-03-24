import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import javax.swing.*;
import javax.swing.text.StyledEditorKit.ItalicAction;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;


public class URLShortenerGUI extends JFrame {
    private URLShortener shortener;
    private JTextField longURLField;
    private JButton shortenButton;
    private JTextField shortURLField;

    public URLShortenerGUI(String apiKey) {
        super("URL Shortener");
        this.shortener = new URLShortener(apiKey);

        JLabel titleLabel = new JLabel("URL Shortener", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        longURLField = new JTextField(30);
        shortenButton = new JButton("Shorten URL");
        shortURLField = new JTextField(30);
        shortURLField.setEditable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        panel.add(titleLabel);
        panel.add(new JLabel("Enter the long URL to shorten:"));
        panel.add(longURLField);
        panel.add(shortenButton);
        panel.add(new JLabel("Shortened URL:"));
        panel.add(shortURLField);

        // Add action listener to the button
        shortenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String longURL = longURLField.getText();
                if (!longURL.isEmpty()) {
                    String shortURL = shortener.shortenURL(longURL);
                    if (shortURL != null) {
                        shortURLField.setText(shortURL);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a long URL.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Set up frame
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Center the frame on screen
        setVisible(true);
    }

    public static void main(String[] args) {
        String apiKey = "bcbad9f6b530dd34f14237e7a563ddfa";
        new URLShortenerGUI(apiKey);
    }
}
