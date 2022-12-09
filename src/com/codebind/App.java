package com.codebind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends  JFrame{

    private JButton Start_button;
    private JPanel panel1;
    private JButton Stop_button;
    private JTextField Result_tF;
    private Calculator calculator;


public App() {

    setContentPane(panel1);
    setTitle("Lab_2.1");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
    setSize(600,200);
    setVisible(true);



    Start_button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculator = new Calculator();
            calculator.textField = Result_tF;
            calculator.bt = Start_button;
            Start_button.setEnabled(false);
            Thread thread = new Thread(calculator);
            thread.start();


        }
    });

    Stop_button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(calculator != null)
            {
                calculator.Stop();
                Start_button.setEnabled(true);
            }

        }
    });
}

    public static void main(String[] args) {
       App newApp = new App();

    }
}
