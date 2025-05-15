package com.example.UserFactory;

import com.example.banksystem.Account.Account;
import com.example.banksystem.Transaction;
import com.example.dataBase.DataBaseMapping;

import java.sql.SQLException;


public class Client extends User {
    private Account account;
    private Transaction transaction;
    public Client(String firstName, String lastName, int userId, int ssd, String password, String email, Account account,
                  int salary, String address, String status, String gender) {
        this.account = account;
        this.firstName = firstName;
        this.lastName = lastName;
        this.UserId = userId;
        this.Password = password;
        this.Salary = salary;
        this.Email = email;
        this.SSN = ssd;
        this.Address = address;
        this.status = status;
        this.gender = gender;
    }
    public Client() {
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return this.account;
    }

    public static void CreateUser(Client user) throws SQLException {
        DataBaseMapping.addUserToDataBase(user);
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public void addTransaction() throws SQLException {
        this.transaction.addTransaction(this.transaction);
    }

}