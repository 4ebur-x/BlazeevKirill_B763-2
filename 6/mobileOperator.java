
import java.util.ArrayList;

public abstract class mobileOperator{
    protected String operator, userName , password;
    protected int money;
    protected int balance;
    protected String number;
    protected float traffic;
    protected String tariff;
    protected String number1;
    protected ArrayList<Integer> payment = new ArrayList<>();
    protected ArrayList<String> CorpNumber = new ArrayList<>();

    public mobileOperator(String operator, int money, int balance,float traffic,String number,String number1, String tariff) {
        this.operator = operator;
        this.money = money;
        this.balance = balance;
        this.traffic = traffic;
        this.number = number;
        this.number1 = number1;
        this.tariff = tariff;
    }



    public abstract void makeContract();
    public abstract void createAccount(String userName,String password);
    public abstract void editAccount(String userName,String password);
    public abstract void info();
    public abstract void checkBalance();
    public abstract void paymentInfo();
    public abstract void changeTariffPlanOperator(String operator, String tariff);
    public abstract void addMoney(int Add);
    public abstract void closeAccount(boolean Choice);

}
