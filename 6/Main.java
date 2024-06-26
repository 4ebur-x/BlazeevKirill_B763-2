
public class Main {
    public static void main(String[] args) {
    mobileOperator internetUser = new InternetUser("мтс",200,0,2.9f,"8914842134","345678756565","Всё включено");
    mobileOperator corpUser = new CorpUser("мтс",200,0,2.9f,"8914842134","345678756565","Всё включено");
//    internetUser.makeContract();
//    internetUser.createAccount("Кирилл","wasd23");
//    internetUser.info();
//    internetUser.editAccount("Вася", "1234");
//    internetUser.info();
//    internetUser.checkBalance();
//    internetUser.changeTariffPlanOperator("билайн","не все включено");
//    internetUser.info();
//    internetUser.addMoney(500);
//    internetUser.addMoney(1500);
//    internetUser.paymentInfo();
//    internetUser.checkBalance();
//    internetUser.closeAccount(true);
//    internetUser.info();
//    internetUser.checkBalance();

        corpUser.makeContract();
        corpUser.createAccount("Кирилл","wasd23");
        corpUser.info();
        corpUser.addUser("1");
        corpUser.addUser("11");
        corpUser.addUser("111");
        corpUser.addUser("1111");
        corpUser.addUser("11111");
        corpUser.info();
        corpUser.delUser("2");
        corpUser.info();
        corpUser.editAccount("Вася", "1234");
        corpUser.info();
        corpUser.checkBalance();
        corpUser.changeTariffPlanOperator("билайн","не все включено");
        corpUser.info();
        corpUser.addMoney(500);
        corpUser.addMoney(1500);
        corpUser.paymentInfo();
        corpUser.checkBalance();
        corpUser.closeAccount(true);
        corpUser.info();
        corpUser.checkBalance();
    }
}


