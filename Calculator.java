// A simple GUI Calculator with Java
// Author: Joel Tanko
// Matric No.U23/CS/1043
// Email: 7thogofe@gmail.com



// import GUI Components
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    public static boolean answer = true;

    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            // check for zero division
            System.out.println("Cannot divide by 0");
        }
        return num1 / num2;
    }

    public static double exponent(double num, double pow) {
        // using Math.pow to handle exponentiation
        double ans = Math.pow(num, pow);
        return ans;
    }

    public static void main(String[] args) {
        // Create the base GUI frame
        JFrame frame = new JFrame("Simple GUI Calculator - By Joel Tanko");

        // Set the layout and size of the window
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 400);
        frame.setResizable(false); // disable resizing of calculator - scatter's buttons

        
        // Create the text field for showing the input/output
        JTextField textField = new JTextField();
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font size to 16px
        textField.setPreferredSize(new Dimension(300, 50)); // Adjust the size to match button size
        frame.add(textField, BorderLayout.NORTH);

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 3)); // Adjust the grid to fit the Clear button

        // Define the buttons
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "^", "=", "+",
            "C"
        };

        // Add buttons to the panel
        for (String label : buttonLabels) {

            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font size for the buttons
            buttonPanel.add(button);
            button.addActionListener(new ActionListener() {
            
                // on click function
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    String[] values = textField.getText().split(" ");
   
                    if ("0123456789.".contains(command)) {
                        // Append numbers or decimal points to the text field
                        if (answer == true){
                            answer = false;
                            textField.setText("");

                        }
                        textField.setText(textField.getText() + command);

                    } else if (command.equals("=")) {
                        // if the equals to button is clicked
                        // Perform calculation on the expression
                        try {
                            String expression = textField.getText();
                            // convert result to double
                            double result = evaluateExpression(expression);
                            textField.setText(String.valueOf(result));
                            answer = true;

                        } catch (Exception ex) {

                            textField.setText("Error");
                        }
                    } else if (command.equals("C")) {
                        // Clear the text field
                        textField.setText("");
                    } else {
                        // Handle operators
                         if (values.length >= 3){
                            // don't add any value to the input box
                        }else{
                            textField.setText(textField.getText() + " " + command + " ");
                        }
                    }
                

                }
            });
        }

        // Add the panel to the frame
        frame.add(buttonPanel, BorderLayout.CENTER);

        // Show the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Evaluate the expression inputted by the user
    public static double evaluateExpression(String expression) {
        // Split the expression into components
        String[] tokens = expression.split(" ");
        int num1 = Integer.parseInt(tokens[0]);
        int num2 = Integer.parseInt(tokens[2]);
        String operator = tokens[1];
        
        switch (operator) {
            case "+":
                return add(num1, num2);
            case "-":
                return subtract(num1, num2);
            case "*":
                return multiply(num1, num2);
            case "/":
                return divide(num1, num2);
            case "^":
                return exponent(num1, num2);
            default:
                return 0;
        }
    }
}

