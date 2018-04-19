package step24.ex5;

public class ATM extends Thread {
    Account account;
    
    public ATM(String name, Account account) {
        super(name);
        this.account = account;
    }
    
    @Override
    public void run() {
        long money = 100;
        long sum = 0;
        
        while (true) {
            money = account.withdraw(100);
            if(money <= 0) break;
            sum += money;
        }
        // 위의 while문을 줄이면 
        // while ((money = account.withdraw(100)) > 0);
        
        System.out.printf("%s가 찾은돈: %d원\n", this.getName(), sum);
    }

}
