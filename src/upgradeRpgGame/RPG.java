package upgradeRpgGame;

import java.util.Scanner;

public class RPG {
    static Hero User = null;
    static Monster GameMonster = null;

    static String ID;
    static String PW;
    static boolean run;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        //게임 실행 page1으로 이동
        run = true;
        page1();

    }

    static void page1() {

        while (run) {
            System.out.println();
            System.out.println("============= Heros Adventure ==============");
            System.out.println();
            System.out.println("(1).새로시작 || (2).불러오기 || (3).종료하기");
            System.out.println();
            System.out.println("============================================");
            System.out.print("선택(->)");
            int input = scan.nextInt();
            System.out.println();

            switch (input) {
                case 1:
                    run = false;
                    page2();
                    break;
        
                case 2:
                    page3();
                    break;
            
                case 3:

                exitApp();

            }
        }
    }

    static void page3() {

        try {
                UserLoad.account();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    static void page2() {
        run = true;

        while (run) {

            System.out.println("================= Hero Select ===============");
        }
    }
}
