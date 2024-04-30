package upgradeRpgGame;

public abstract class Hero {    //영웅 기본 속성 및 기능 설계

    // 힘, 지능, 민첩, 영웅 클래스 이름
    int power;
    int MP;
    int dex;
    String name;
    int HP;
    int Money;

    public int getMoney() {
        return Money;
    }

    public void setMoney(int money) {
        Money = money;
    }

    //공격
    abstract void Attach();

    public int getPower() {
        return power;
    }

    public int getHp() {
        return HP;
    }

    public void setHp(int Hp) {
        HP = Hp; 
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getMp() {
        return MP;
    }

    public void setMp(int Mp) {
        this.MP = Mp;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
