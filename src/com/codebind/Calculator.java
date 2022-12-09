package com.codebind;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Calculator implements Runnable {
    public double eps = Math.pow(10,-5);;
    public JTextField textField;
    public JButton bt;

    public boolean  stop = false;
    public void Stop()
    {
        this.stop = true;
    }


    @Override
    public void run() {

        double S = 0, a = 1;
        int n = 0;

        do
        {
            if (stop==true)
                break;

            n++;
            double R = 1.0 / ((4.0 * n - 1) * (4.0 * n + 1));
            a *= R;
            S += a;

            textField.setText(String.valueOf(S));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        } while (Math.abs(a) >= eps);

        bt.setEnabled(true);
    }
}
