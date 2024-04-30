package upgradeRpgGame;

public class Wizard extends Hero {
     // 능력치 초기값
     private int power = 0;
     private int MP = 10;
     private int dex = 0;
     private int HP = 100;
     private int Money = 1000;
 
     public int getMoney() {
         return Money;
     }
 
     public void setMoney(int money) {
         if(money >= 0) {
             this.Money = money;
         }
 
     }
 
     public int getHP() {
         return HP;
     }
 
     public void setHP(int Hp) {
         HP = Hp;
     }
 
     private String name = "법사";
 
     public int getPower() {
         return power;
     }

     public void setPower(int power) {
        this.power = power;
     }
 
     public String getName() {
         return name;
     }
 
     public void setName(String name) {
         this.name = name;
     }
 
     public int getMP() {
        return MP;
    }

     public void setMP(int Mp) {   //능력치 최소 보장
         if(MP >= 2) {
             this.MP = Mp;
         }
     }
 
     public int getDex() {
         return dex;
     }
 
     public void setDex(int dex) {
         this.dex = dex;
     }
 
     @Override
     void Attach() {
         System.out.println("공격발동 : 매직클로");
     }
}
