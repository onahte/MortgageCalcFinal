package MortgageCalcFinal

public class Main {

    public static void main(String[] args) {

        int principal = (int) Console.readNumber("How much would you like to loan? ",
                1000, 1_000_000);
        float rate = (float) Console.readNumber("What is the annual loan rate? ",
                0, 20);
        int years = (int) Console.readNumber("What is the loan term length? ",
                0, 30);
        var calculator = new MortgageCalculator(principal, rate, years);
        var report = new MortgageReport(calculator);
        report.printMonthlyPayment();
        report.printPaymentSchedule();

    }
}
