package com.Bzhan.JDBC;

public class Users {
    //封装用户信息
    private int account;
    private int password;

    public Users(int account, int password) {
        this.account = account;
        this.password = password;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "account=" + account +
                ", password=" + password +
                '}';
    }
}
