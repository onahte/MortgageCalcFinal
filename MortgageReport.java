package MortgageCalcFinal;

import java.text.NumberFormat;
public class MortgageReport {

    private final NumberFormat currency;
    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator){
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance()
    }

    public void printMonthlyPayment (){
        double mortgage = calculator.calculateMonthlyPayment();
        String mortgageFormatted = currency.format(mortgage);
        System.out.println("Monthly Payment");
        System.out.println("---------------");
        System.out.println(mortgageFormatted);
    }
    public void printPaymentSchedule (){
        System.out.println("Payment Schedule");
        System.out.println("----------------");
        for (double balance: calculator.getMonthlyBalance())
            System.out.println(currency.format(balance));
    }
}
