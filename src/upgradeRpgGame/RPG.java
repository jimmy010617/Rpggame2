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
            System.out.println();
            System.out.println("(1).전사 || (2).법사 || (3).도적 || (4).종료");
            System.out.println();
            System.out.println("=============================================");

            System.out.print("선택(->)");
            int input2 = scan.nextInt();
            System.out.println();

            //영웅 객체
            if(input2 == 1) {
                User = new Warrior();
            } else if (input2 == 2) {
                User = new Wizard();
            } else if (input2 == 3) {
                User = new Thief();
            } else if(input2 == 4) {
                exitApp();
            }

            System.out.println();
            System.out.println("    ======== " + User.getName() + " 영웅이 선택되었습니다. ======== ");
            System.out.println();

            //파일 읽어오기를 통한 ID 비번 저장
            try {
                UserAdd.account();
            } catch(Exception e) {

                e.printStackTrace();
            }

            run = false;
            break;

        }

    }

    static void GamePage() {    //게임실행페이지
        run = true;
        while(run) {
            System.out.println("====================Heros Town=====================");
            System.out.println();
            System.out.println("1.정보 || 2.던전 || 3.강화&포션 || 4.저장 || 5.종료");
            System.out.println();
            System.out.println("===================================================");
            System.out.println("선택(->)");
            int input = scan.nextInt();

            System.out.println();

            switch (input) {
            case 1:
                //영웅 정보 구현
                System.out.println("============= ● " + ID + "님 Status ● ==========");
                System.out.println(" ● Class: " + User.getName());
                System.out.println();
                System.out.println(" ● H.P: " + User.getHp());
                System.out.println(" ● Pow: " + User.getPower());
                System.out.println(" ● M.P: " + User.getMp());
                System.out.println(" ● Dex: " + User.getDex());
                System.out.println(" ● Money: " + User.getMoney() + "(Won)");

                break;
            
            case 2:
            //던전으로 이동
                run = false;
                DungeonPage();
                break;
            case 3:
                run = false;
                shop();
                //상점 구현
                break;
            case 4:
                //저장 기능 구현
                try {
                    UserSave.account();
                } catch(Exception e) {

                    e.printStackTrace();
                }
                break;
            case 5:
                exitApp();
                break;
            }

        }

    }

    static void shop() {
        run = true;

        while(run) {
            System.out.println("==============shop==============");
            System.out.println("1.물건사기 | 2.마을로가기 | 3.종료");
            System.out.println("================================");
            System.out.println("선택 >>");
            int input = scan.nextInt();

            boolean run2 = true;

            while(run2) {
                switch (input) {

                case 1: //물건사기

                    System.out.println("============================================================");
                    System.out.println("1.힘강화 | 2.지능강화 | 3.민첩강화 | 4.물약사기 | 5.뒤로가기");
                    System.out.println("===W100=======w100========w100==========w10=================");
					System.out.println("============================================================");

                    System.out.println("선택>>");
                    int input2 = scan.nextInt();

                    switch (input2) {
                        case 1: //전사 전용 무기 구현
                            
                            if(User.getName() == "전사") {

                                //무기 살 돈이 있는지 확인
                                if(User.getMoney() >= 100) {
                                    //무기 구매 시 힘 증가 표시
                                    int accpower = User.getPower();
                                    accpower += 10;
                                    System.out.println("힘이 +10 증가 하였습니다.");
                                    User.setPower(accpower);
                                    System.out.println("힘 능력치 : " + User.getPower());

                                    //무길르 샀을때 돈 감소
                                    int money = User.getMoney();
                                    money -= 100;
                                    User.setMoney(money);

                                    System.out.println("남은 자산은 : " + User.getMoney());

                                } else {
                                    System.out.println("살 돈이 없습니다.");
                                }

                            } else {
                                System.out.println("전용 능력치가 아닙니다.");
                            }

                            break;
                        case 2: //마법사 전용 무기 구현
                            
                            if(User.getName() == "법사") {

                                //무기 살 돈이 있는지 확인
                                if(User.getMoney() >= 100) {
                                    //무기 구매 시 힘 증가 표시
                                    int accpower = User.getMp();
                                    accpower += 10;
                                    System.out.println("지능이 +10 증가 하였습니다.");
                                    User.setMp(input);(accpower);
                                    System.out.println("지능 능력치 : " + User.getMp());

                                    //무기를 샀을 때 돈 감소
                                    int money = User.getMoney();
                                    money -= 100;
                                    User.setMoney(money);

                                    System.out.println("남은 자산은 : " + User.getMoney());

                                } else {
                                    System.out.println("살 돈이 없습니다.");
                                }
                        
                            } else {
                                System.out.println("전용 능력치가 아닙니다.");
                            }

                            break;
            
                        case 3: //도적 전용 무기 구현

                            if(User.getName() == "도적") {

                                //무기 살돈이 있는지 확인
                                if(User.getMoney() >= 100) {
                                    //무기 구매시 힘 증가 표시
                                    int accpower = User.getDex();
                                    accpower += 10;
                                    System.out.println("민첩이 +10 증가 하였습니다.");
                                    User.setDex(accpower);
                                    System.out.println("민첩 능력치 : " + User.getDex());

                                    //무기를 샀을 때 돈 감소
                                    int money = User.getMoney();
                                    money -= 100;
                                    User.setMoney(money);

                                        System.out.println("남은 자산은 : " + User.getMoney());

                                } else {
                                    System.out.println("살 돈이 없습니다.");
                                }

                            } else {
                                System.out.println("전용 능력치가 아닙니다.");
                            }

                            break;
                        case 4://포션

                            if(User.getMoney() >= 0 && User.getHp() < 100) {//돈
                                    

                                int Money = User.getMoney();//돈 차감
                                Money -= 10;
                                User.setMoney(Money);

                                //HP 회복 10씩
                                int AddHP = User.getHp();
                                AddHP += 10;
                                User.setHp(AddHP);

                                //정보 출력
                                System.out.println("10원을 주고 물약을 샀습니다 체력 10이 회복됩니다.");
                                System.out.println("남은 자산 : " + User.getMoney());
                                System.out.println("련재 체력 : " + User.getHp());

                            } else {
                                System.out.println("체력이 가득차 있거나 물약을 살 돈이 없습니다.");
                            }

                            break;
                        case 5: //뒤로가기
                            shop();
                            run2 = false;
                            run = false;
                            break;                          
                        }

                        break;

                case 2://마을로 가기
                        GamePage();
                        break;
                case 3:
                        System.out.println("프로그램이 종료 되었습니다.");
                        System.exit(0);
                        break;
                }
            }              
        }
    }

    static void DungeonPage() {
        run = true;

        while(run) {
            System.out.println("====================던전=======================");
            System.out.println("1.동굴 | 2.심해 | 3.정글 | 4.마을로가기 | 5.종료");
            System.out.println("===============================================");
            System.out.println("선택>>");
            int input = scan.nextInt();

            switch (input) {
                case 1: //던전 공격 화면 구현
                    run = false;
                    Attack(1);
                    break;
            
                case 2: //던전 공격 화면 구현
                    run = false;
                    Attack(2);
                    break;
                
                case 3: //던전 공격 화면 구현
                    run = false;
                    Attack(3);
                    break;
                
                case 4:
                    GamePage();
                    break;

                case 5:
                    System.out.println("프로그램이 종료 되었습니다.");
                    System.exit(0);
            }

        }

    }

    static void Attack(int location) {//공격화면
        //입장 알림

            String disp = null;
            switch (location) {
            case 1:
                disp = "동굴";
                break;
        
            case 2:
                disp = "심해";

                if(User.getPower() >= 25 || User.getMp() >= 25 || User.getDex() >= 25) {
                    break;
                } else {
                    System.out.println("!!! 현재 능력치 부족으로 입장이 불가 합니다. 25레벨 부터 가능 !!!");
                    DungeonPage();
                }
            
            case 3:
                disp = "정글";

                if(User.getPower() >= 35 || User.getMp() >= 35 || User.getDex() >= 35) {
                    break;
                } else {
                    System.out.println("!!! 현재 능력치 부족으로 입장이 불가 합니다. 35레벨 부터 가능 !!!");
                    DungeonPage();
                } 
            }

            System.out.println("===============================================");
            System.out.println("===============================================");
            System.out.println("===============================================");
            System.out.println("======================" + disp + "=====================");
            System.out.println("===============================================");
            System.out.println("===============================================");
            System.out.println("===============================================");

            System.out.println();
            System.out.println();
            run = true;

            //몬스터 구현(던전에 따라 다르게)

            //박쥐 몬스터로 Test
            GameMonster = new Bat();

            while (run) {
                
                GameMonster.getAttackname();

                //몬스터 정보 및 공격 출력
                System.out.println(GameMonster.getName() + "이(가) 공격을 하였다." + GameMonster.getAttackname() + "(" + GameMonster.getAttacknum() + ")");

                //몬스터가 유저한테 공격하는 소스 코드
                int UserHP = User.getHp();
                UserHP -= GameMonster.getAttacknum();   //몬스터 공격
                User.setHp(UserHP);

                System.out.println(User.getName() + "의 HP가 " + "(" + GameMonster.getAttacknum() + ") 감소 하였다. 현재 H.P : " + User.getHp());

                //HP가 0이면 마을로 돌아가기
                if(User.getHp() <= 0) {
                    User.setHp(10); //최소 HP 주기
                    System.out.println("싸울힘이 없다. 마을로 강제 귀환 되며 능력치가 감소합니다.");
                    //죽을시 직업 능력치 -1
                }
            }
    }
}
