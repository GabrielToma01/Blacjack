package com.example.blackjack;
import java.util.Timer;
import java.util.TimerTask;

public class TimedDealer {
    Timer timer;

    public TimedDealer(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
    }

    class RemindTask extends TimerTask {
        public void run() {
            timer.cancel(); //Terminate the timer thread
        }
    }

    public static void main(String args[]) {
        new TimedDealer(2);
        System.out.println("Task scheduled.");
    }
}
