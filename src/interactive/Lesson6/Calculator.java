package interactive.Lesson6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    JPanel argumentPanel = new JPanel();
    JLabel arg1Label = new JLabel("arg 1");
    JLabel arg2Label = new JLabel("arg 2");
    JTextField arg1Field = new JTextField(1);
    JTextField arg2Field = new JTextField(1);
    JPanel grid = new JPanel();
    JLabel label = new JLabel("Result: ");
    JLabel result = new JLabel();
    JButton plus = new JButton("+");
    JButton minus = new JButton("-");
    JButton multiply = new JButton("*");
    JButton divide = new JButton("/");
    JButton pow = new JButton("^");

    int res = 0;

    public Calculator(String title) {
        super(title);
        this.setPreferredSize(new Dimension(320,320));
        this.setLocation(300,100);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        argumentPanel.setLayout(new GridLayout(1,4,5,12));
        argumentPanel.add(arg1Label);
        argumentPanel.add(arg1Field);
        argumentPanel.add(arg2Label);
        argumentPanel.add(arg2Field);
        this.getContentPane().add(argumentPanel, BorderLayout.NORTH);
        grid.setLayout(new GridLayout(6,2,5,12));
        grid.add(label);
        grid.add(result);
        grid.add(plus);
        grid.add(minus);
        grid.add(multiply);
        grid.add(divide);
        grid.add(pow);
        this.getContentPane().add(grid);

        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isInputValid())  {
                    res = Integer.parseInt(arg1Field.getText()) + Integer.parseInt(arg2Field.getText());
                    arg1Field.setText("");
                    arg2Field.setText("");
                }
                result.setText(String.valueOf(res));
            }
        });

        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isInputValid()){
                    res = Integer.parseInt(arg1Field.getText()) - Integer.parseInt(arg2Field.getText());
                    arg1Field.setText("");
                    arg2Field.setText("");
                }
                result.setText(String.valueOf(res));
            }
        });

        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isInputValid()){
                    res = Integer.parseInt(arg1Field.getText()) * Integer.parseInt(arg2Field.getText());
                    arg1Field.setText("");
                    arg2Field.setText("");
                }
                result.setText(String.valueOf(res));
            }
        });

        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isInputValid()){
                    res = Integer.parseInt(arg1Field.getText()) / Integer.parseInt(arg2Field.getText());
                    arg1Field.setText("");
                    arg2Field.setText("");
                }
                result.setText(String.valueOf(res));
            }
        });

        pow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isInputValid()){
                    res = (int) Math.pow(Double.parseDouble(arg1Field.getText()), Double.parseDouble(arg2Field.getText()));
                    arg1Field.setText("");
                    arg2Field.setText("");
                }
                result.setText(String.valueOf(res));
            }
        });

        pack();
        this.setVisible(true);
    }

    public boolean isInputValid() {
        if ((arg1Field.getText() == null || arg1Field.getText().isEmpty()) && (arg2Field.getText() == null || arg2Field.getText().isEmpty())) {
            return false;
        } else if (!isDigit(arg1Field.getText()) && !isDigit(arg2Field.getText())) {
            showDialog();
        }

        return true;
    }

    private static boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void showDialog() {
        JDialog dialog = new JDialog();
        JLabel label = new JLabel("Input is invalid!");
        dialog.setTitle("Invalid input");
        dialog.getContentPane().add(label);
        dialog.setSize(200,100);
        dialog.setLocation(300,100);
        dialog.setVisible(true);
    }



    public static void main(String[] args) {
        new Calculator("My calculator");
    }
}
