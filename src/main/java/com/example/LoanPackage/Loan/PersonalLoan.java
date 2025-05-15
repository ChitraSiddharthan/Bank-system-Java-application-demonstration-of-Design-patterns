package com.example.LoanPackage.Loan;


import java.sql.SQLException;

public class PersonalLoan extends Loan{

    @Override
    public void ApplyForLoan() throws SQLException {
        calcInterestRate();
        setMonthlyInstallment(this.CalcMonthlyInstallment());
        super.addLoan();
    }

    @Override
    public void calcInterestRate() {
        rate=(1.8*super.getRepaymentPeriod()) /100;
    }

    @Override
    public double CalcMonthlyInstallment() {
        return (amount + rate* amount) / (super.getRepaymentPeriod() *1.f);
    }


}
