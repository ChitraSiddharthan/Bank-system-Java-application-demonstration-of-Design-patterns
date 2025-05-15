package com.example.banksystem.Account;

public class CertificateDeposit extends SavingsAccount{
    private double withdrawalCost =0.2F;
    public CertificateDeposit() {
        accountType = "Certificate Deposit";
    }
    public void withdraw(float amount) {
        this.setBalance((float)(this.getBalance()-(withdrawalCost + amount)));
    }
    public  boolean canWithdraw(double amount){
        withdrawalCost*=amount;
        System.out.println(amount+withdrawalCost <= this.getBalance());
        return amount + withdrawalCost <= this.getBalance();
    }
}
