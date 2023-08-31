public class User {
    private String username;
    private String password;
private double balance;

public User(String username,String password){
    this.username = username;
    this.password = password;
    balance = 0;
}
    public double getBalance(){
    return balance;
    }
    public String getUsername(){
    return username;
    }
    public String getPassword(){
    return password;
    }
    public boolean auntephic(String p){
    return this.password.equals(p);
    }
public void deposit(double amount){
    balance+=amount;
    System.out.println("Deposit: " + amount);
}
public void withdraw(double amount){
    if(balance>=amount){
        balance-=amount;
    }
    System.out.println("Withdraw: " + amount);
}



}
