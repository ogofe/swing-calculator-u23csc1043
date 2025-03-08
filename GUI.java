// A simple GUI Calculator with Java
// Author: Joel Tanko
// Matric No. U23/CS/1043
// Email: 7thogofe@gmail.com

// CalculatorGUI.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Import the Calculator module
import Calculator;

public class CalculatorGUI {
    private static boolean answer = true;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple GUI Calculator");
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 400);
        frame.setResizable(false);

        JTextField textField = new JTextField();
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        textField.setPreferredSize(new Dimension(300, 50));
        frame.add(textField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 3));

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "^", "=", "+",
            "C"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 16));
            buttonPanel.add(button);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    String[] values = textField.getText().split(" ");

                    if ("0123456789.".contains(command)) {
                        if (answer) {
                            answer = false;
                            textField.setText("");
                        }
                        textField.setText(textField.getText() + command);

                    } else if (command.equals("=")) {
                        try {
                            String expression = textField.getText();
                            double result = Calculator.evaluateExpression(expression); // Using CalculatorOperations
                            textField.setText(String.valueOf(result));
                            answer = true;
                        } catch (Exception ex) {
                            textField.setText("Error");
                        }
                    } else if (command.equals("C")) {
                        textField.setText("");
                    } else {
                        if (values.length < 3) {
                            textField.setText(textField.getText() + " " + command + " ");
                        }
                    }
                }
            });
        }

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

