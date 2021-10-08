package MortgageCalcFinal

public class MortgageCalculator {
    private final static int MONTHS = 12;
    private final static int PERCENT = 100;

    private int principal;
    private float rate;
    private int years;

    float monthlyInterest = getMonthlyInterest();
    int totalMonths = getTotalMonths();

    public MortgageCalculator (int principal, float rate, int years){
        this.principal = principal;
        this.rate = rate;
        this.years = years;
    }

    public double calculateMonthlyPayment(){
        double payment = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, totalMonths)) / (Math.pow(1 + monthlyInterest, totalMonths) - 1);
        return payment;
    }

    private double calculateMonthlyBalance(int paymentsMade){
        double payment = principal * (Math.pow(1 + monthlyInterest, totalMonths) - Math.pow(1 + monthlyInterest, paymentsMade))
                / (Math.pow(1 + monthlyInterest, totalMonths) - 1);
        return payment;
    }

    public Double[] getMonthlyBalance(){
        var balances = new Double[totalMonths];
        for (int paymentsMade = 0; paymentsMade <= balances.length; paymentsMade++ )
            balances[paymentsMade - 1] = calculateMonthlyBalance(paymentsMade);
        return balances;
    }

    private float getMonthlyInterest(){
        return rate / PERCENT / MONTHS;
    }

    private int getTotalMonths(){
        return years * MONTHS;
    }
}
