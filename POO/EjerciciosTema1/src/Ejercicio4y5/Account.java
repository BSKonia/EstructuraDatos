package Ejercicio4y5;

public class Account {
    private String name;
    private String surname;
    private String id;
    private double balance;

    public Account(String name, String surname, String id, double balance) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double money) {
        if (money > 0) {
            this.balance = this.balance + money;
        }
    }

    public boolean withdraw(double money) {

        if (money > this.balance)
            return false;

        this.balance = this.balance - money;
        return true;
    }


    //método mío
    public void retire(double moneyretired) {
        if (moneyretired < this.balance) {
            this.balance = this.balance - moneyretired;

        } else System.out.println("No tienes saldo suficiente");
    }
}