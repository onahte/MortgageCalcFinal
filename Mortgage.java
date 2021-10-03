package MortgageCalcFinal;

import java.util.Scanner;
import java.text.NumberFormat;

public class Mortgage {

    private int loan;
    private float rate;
    private int term;
    final private int MONTHS = 12;
    final private int PERCENT = 100;

    public Mortgage() {
        loan = requestLoan();
        rate = requestRate() / PERCENT / MONTHS;
        term = requestTerm() * MONTHS;
    }

    private int requestLoan() {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        System.out.print("How much would you like to borrow? ($1k - $1m) ");
        input = scanner.nextInt();
        while (input < 1000 || input > 1000000) {
            System.out.print("Please enter a valid ammount: ");
            input = scanner.nextInt();
        }
        return input;
    }

    private float requestRate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What is the interest rate? ");
        return scanner.nextFloat();
    }

    private int requestTerm() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many years would you like to repay? (0 - 30) ");
        return scanner.nextInt();
    }

    public void printMonthlyPayment(){
        double payment = loan * (rate * Math.pow(1 + rate, term)) / (Math.pow(1 + rate, term) - 1);
        System.out.println("Your monthly payment is: " + NumberFormat.getCurrencyInstance().format(payment));
    }

    private double calculatePaymentSchedule(int paymentsMade){
        return (loan * (Math.pow(1 + rate, term) - Math.pow(1 + rate, paymentsMade)) / (Math.pow(1 + rate, term) - 1));
    }

    public void printPaymentSchedule(){
        System.out.println("Payment Schedule");
        System.out.println("----------------");
        for (int paymentsMade = 0; paymentsMade <= term; paymentsMade++)
            System.out.println(NumberFormat.getCurrencyInstance().format(calculatePaymentSchedule(paymentsMade)));
    }
