import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCount extends JFrame {

    private JTextArea inputTextArea;
    private JButton countButton;
    private JLabel resultLabel;

    public WordCount() {
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        initComponents();

        setVisible(true);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        inputTextArea = new JTextArea(10, 30);
        inputTextArea.setLineWrap(true); // For word wrap
        inputTextArea.setWrapStyleWord(true); // Wrap at word boundaries
        JScrollPane scrollPane = new JScrollPane(inputTextArea);

        countButton = new JButton("Count Words");
        countButton.setFont(new Font("Times New Roman", Font.BOLD, 26));
        countButton.setForeground(Color.WHITE);
        countButton.setBackground(Color.BLUE);
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });

        resultLabel = new JLabel("Number of words: ");
        resultLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
        resultLabel.setForeground(Color.PINK);

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(countButton, BorderLayout.SOUTH);
        mainPanel.add(resultLabel, BorderLayout.NORTH);

        add(mainPanel);
    }

    private void countWords() {
        String paragraph = inputTextArea.getText();
        int wordCount = countWords(paragraph);
        resultLabel.setText("Number of words: " + wordCount);
    }

    private int countWords(String paragraph) {
        if (paragraph == null || paragraph.isEmpty()) {
            return 0;
        }

        String[] words = paragraph.split("\\s+"); // Splitting the paragraph by whitespace
        return words.length;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordCount();
            }
        });
    }
}
