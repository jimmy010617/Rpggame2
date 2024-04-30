package upgradeRpgGame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.text.html.parser.Entity;

import java.util.Scanner;
import java.util.Set;

public class UserLoad {
    
    public static void account() throws Exception {
        Scanner scanner = new Scanner(System.in);
        Reader fr = new FileReader("user.txt");
        //Map을 이용하여 ID, 비밀번호값 임시저장하기
        Map<String, String> accountlist = new HashMap<>();

        String user = null;
        String pw = null;

        boolean idpwcheck = false;
        boolean run = true;
        String str = null;

        BufferedReader br = new BufferedReader(new FileReader(new File("user.txt")));

        str = br.readLine();
        while (str != null) {
            // ,로 자르기
            String account[] = str.split(",");
            // ,기준 왼쪽 문자열 accountlist배열에 add 시키기
            accountlist.put(account[0], account[1]);

            str = br.readLine();    //null일때까지 계속 읽어오기
        }

        System.out.println("현재 가입된 유저 :" + (accountlist.size() - 1) + "명");

        //Map.Entry로 ID,비번 나누기 (getKey, getValue)
        Set<Map.Entry<String, String>> entries = accountlist.entrySet();





        System.out.print("ID를 입력해주세요 : ");
        user = scanner.next();
        System.out.print("PW를 입력해주세요 : ");
        pw = scanner.next();

        for (Entry<String, String> entry : entries) {

            //ID, 비밀번호가 있는지 체크
            if (entry.getKey().equals(user) && entry.getValue().equals(pw)) {
                idpwcheck = true;   //해당 파일의 자료를 읽어들이고 자료 넣기

                BufferedReader br2 = new BufferedReader(new FileReader(new File("user.txt")));

                str = br2.readLine();
                while (str != null) {

                    // ,로 자르기
                    String account[] = str.split(",");
                    // ID,비번 체크후 영웅 객체 넣기
                    if(account[0].equals(user)) {
                        //직업 넣기
                        if(account[2].equals("전사")) {
                            RPG.User = new Warrior();
                        } else if (account[2].equals("법사")) {
                            RPG.User = new Wizard();
                        } else if (account[2].equals("도적")) {
                            RPG.User = new thief();
                        }


                        //능력치, 돈 불러오기
                        RPG.User.setHp(Integer.parseInt(account[3]));
                        RPG.User.setPower(Integer.parseInt(account[4]));
                        RPG.User.setInt(Integer.parseInt(account[5]));
                        RPG.User.setDex(Integer.parseInt(account[6]));
                        RPG.User.setMoney(Integer.parseInt(account[7]));

                        RPG.ID = entry.getKey();    //RPG ID에 읽어온 ID 넣기
                        RPG.PW = entry.getValue();  //RPG PW에 저장하는데 필요함

                    }
                    str = br2.readLine();   //null일때까지 계속 읽어오기
                }
            }
        }

        //ID, 비밀번호가 맞으면 정상 로그인
        if(idpwcheck == true)

        {
            System.out.println("|||" + RPG.ID + "님 환영합니다^^");
            RPG.GamePage();     //게임 페이지로 이동
        } else {
            System.out.println("입력한 User 정보가 없거나 Pw가 일치하지 않습니다.");
            RPG.page1();        //첫장으로 다시 이동
        }

        System.out.println();
        System.out.println();

        fr.close();
    }
}
