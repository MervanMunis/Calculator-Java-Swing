import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField; // It holds the text of numbers and the result
    JButton[] numberButtons = new JButton[10]; // To store 10 Buttons for 10 numbers 0,1,2,3..9 in array
    JButton[] functionButtons = new JButton[11]; // To store 8 operation adding subtraction...

    JButton addButton, subtractionButton,multiplicationButton,divitionButton;
    JButton decimalButton, equivalentButton, deleteButton, clearButton;
    JButton squareRootButton, squareButton, negativeButton;

    JPanel panel; //To hold all the seprate buttons

    Font myFont = new Font("HelveticaNeu",Font.BOLD, 30); // Font Style

    double num1=0, num2=0, result=0;
    char operator; // It will hold the required characters

    public Calculator() {
        frame = new JFrame("Calculator"); // Initializing frame and giving the title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sets a close button.
        frame.setSize(480, 600);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50,25,250,50); // Locating and setting the bounds of object
        textField.setFont(myFont);
        textField.setEditable(false); // The text field is not editable

        addButton = new JButton("+");
        subtractionButton = new JButton("-");
        multiplicationButton = new JButton("*");
        divitionButton = new JButton("/");
        decimalButton = new JButton(".");
        equivalentButton = new JButton("=");
        deleteButton = new JButton("\u232B");
        clearButton = new JButton("C");
        squareRootButton = new JButton("√");
        squareButton = new JButton("X²");
        negativeButton = new JButton("+/-");

        functionButtons[0] = addButton;
        functionButtons[1] = subtractionButton;
        functionButtons[2] = multiplicationButton;
        functionButtons[3] = divitionButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equivalentButton;
        functionButtons[6] = deleteButton;
        functionButtons[7] = clearButton;
        functionButtons[8] = squareButton;
        functionButtons[9] = squareRootButton;
        functionButtons[10] = negativeButton;

        for (int i=0; i<11; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i=0; i<10;i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        negativeButton.setBounds(320,45,90,50);

        panel = new JPanel();
        panel.setBounds(10,100,400,400);
        panel.setLayout(new GridLayout(5,4,10,10));
        // panel.setBackground(Color.blue);

        panel.add(squareButton);
        panel.add(squareRootButton);
        panel.add(clearButton);
        panel.add(deleteButton);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subtractionButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiplicationButton);

        panel.add(decimalButton);
        panel.add(numberButtons[0]);
        panel.add(equivalentButton);
        panel.add(divitionButton);

        frame.add(negativeButton);
        frame.add(panel);
        frame.add(textField);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        Calculator calculator = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton numberButton : numberButtons) {
            if (e.getSource() == numberButton) {
                // Here the number is set into textField then it concated to make it string inside the text field.
                textField.setText(textField.getText().concat(numberButton.getText()));
            }
        }

        if (e.getSource() == decimalButton) {
            textField.setText(textField.getText().concat("."));
        }

        else if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText()); // The string inside textField is converted to a double number
            operator = '+';
            textField.setText("");
        }

        else if (e.getSource() == subtractionButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        else if (e.getSource() == multiplicationButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        else if (e.getSource() == divitionButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        else if (e.getSource() == squareButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = 's'; //Square
        }

        else if (e.getSource() == squareRootButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '√';
        }

        else if (e.getSource() == equivalentButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                case 's': //Square
                    result = Math.pow(num1,2);
                    break;
                case '√':
                    result = Math.sqrt(num1);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + operator);
            }
            textField.setText(String.valueOf(result));
            num1=result;
        }
        else if (e.getSource() == clearButton) {
            textField.setText("");
        }
        else if (e.getSource() == deleteButton) {
            String string = textField.getText();
            if (!string.isEmpty()) {
                String newString = string.substring(0, string.length() - 1);
                textField.setText(newString);
            }
        }
        if (e.getSource() == negativeButton) {
            double negativeNum1 = Double.parseDouble(textField.getText());
            negativeNum1*=-1;
            textField.setText(String.valueOf(negativeNum1));
        }
    }
}
