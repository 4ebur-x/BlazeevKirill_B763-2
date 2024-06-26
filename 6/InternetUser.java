class InternetUser extends mobileOperator{
    InternetUser(String operator, int money, int balance,float traffic, String number,String number1, String tariff){
        super(operator,money,balance,traffic,number,number1,tariff);
    }

    @Override
    public void makeContract() {
    System.out.println("Договор с " + operator + " подписан.");
        System.out.println(" ");
    }

    @Override
    public void createAccount(String userName,String password) {
        this.userName = userName;
        this.password = password;
    System.out.println("Вы успешно создали аккаунт!");
    System.out.println("Ваш номер - " + number);
    System.out.println("Ваш лицевой счет - " + number1);
        System.out.println(" ");
    }

    @Override
    public void editAccount(String userName,String password) {

       if(!(this.userName.equals(userName)) && !(this.password.equals(password)) ){
            this.userName = userName;
            this.password = password;
            System.out.println("Вы успешно сменили имя и пароль пользователя!");
       }
       else if (!(this.userName.equals(userName))){
            this.userName = userName;
            System.out.println("Вы успешно сменили имя пользователя!");
        }
       else if (!(this.password.equals(password))){
            this.password = password;
            System.out.println("Вы успешно сменили пароль пользователя!");
        }
       else {
            System.out.println("Никаких изменений не было!");
       }
        System.out.println(" ");
    }

    @Override
    public void info() {
        System.out.println("Имя пользователя - " + userName);
        System.out.println("Пароль пользователя - " + password);
        System.out.println("Оператор пользователя - " + operator);
        System.out.println("Номер пользователя - " + number);
        System.out.println("Лицевой счет пользователя - " + number1);
        System.out.println(" ");
    }

    @Override
    public void checkBalance() {
        System.out.println("Ваш баланс - " + balance + " Руб.");
        System.out.println("Остаток по тарифу - " + traffic + " Гб.");
        System.out.println(" ");
    }



    @Override
    public void paymentInfo() {
    for(byte i = 0 ; i < payment.size();i++){
        System.out.println("Пополнение кошелька на " + payment.get(i) );

    }
        System.out.println(" ");
    }


    @Override
    public void changeTariffPlanOperator(String operator, String tariff) {

        if(!(this.operator.equals(operator)) && !(this.tariff.equals(tariff)) ){
            this.operator = operator;
            this.tariff = tariff;
            System.out.println("Вы успешно сменили оператора на " + this.operator);
            System.out.println("Вы успешно сменили тариф на " +"\"" + tariff+"\"");
        }
        else if (!(this.operator.equals(operator))){
            this.operator = operator;
            System.out.println("Вы успешно сменили оператора на " + this.operator);
        }
        else if (!(this.tariff.equals(tariff))){
            this.tariff = tariff;
            System.out.println("Вы успешно сменили тариф на " +"\"" + tariff+"\"");
        }
        else {
            System.out.println("Никаких изменений не было!");
        }
        System.out.println(" ");

    }

    @Override
    public void addMoney(int Add) {
    balance =+ Add;
    payment.add(Add);
    }

    @Override
    public void closeAccount(boolean Choice ) {
        if (Choice){
            operator = null;
            userName = null;
            password = null;
            money = 0;
            balance = 0;
            number = null;
            number1 = null;
            traffic = 0;
            tariff= null;
            System.out.println("Аккаунт удалён");
        }
        else {
            System.out.println("Вы не удалили аккаунт");
        }
        System.out.println(" ");
    }

    @Override
    public void addUser(String number) {

    }

    @Override
    public void delUser(String number) {

    }
}
