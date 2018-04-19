package step24.ex5;

public class Account {
    String accountId;
    long balance;
    
    public Account(String accountId, long balance) {
        this.accountId = accountId;
        this.balance = balance;
        
    }
    
    public long withdraw(long money) {
        // 문제점? 
        // 돈을 뽑고 저장이 제대로 안된 상태에서 
        // 딜레이 시간에 CPU를 뺏겨버려 100만원보다 더 많은 돈을 뽑는 경우가 발생한다.
        long b = this.balance;
        
        for (int i = 0; i < 1000; i++) Math.asin(45.765); // CPU를 뺏길 기회를 제공
        b -= money;

        for (int i = 0; i < 1000; i++) Math.asin(45.765);
        
        if (b < 0)
            return 0;
        
        for (int i = 0; i < 1000; i++) Math.asin(45.765);
        
        this.balance = b;
        
        for (int i = 0; i < 1000; i++) Math.asin(45.765);
        
        return money;
    }
}
