package upgradeRpgGame;

public class Warrior extends Hero {
    // 능력치 초기값
    private int power = 10;
    private int MP = 0;
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

    private String name = "전사";

    public int getPower() {
        return power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPower(int power) {   //능력치 최소 보장
        if(power >= 2) {
            this.power = power;
        }
    }

    public int getMP() {
        return MP;
    }

    public void setMP(int Mp) {
        this.MP = Mp;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    @Override
    void Attach() {
        System.out.println("공격발동 : 더블어택");
    }
}
