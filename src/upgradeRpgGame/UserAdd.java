package upgradeRpgGame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class UserAdd {
    public static void account() throws Exception {

        Scanner scanner = new Scanner(System.in);
        Reader fr = new FileReader("user.txt");
        Map<String, String> accountlist = new HashMap<>();

        String user = null;
        boolean run = true;
        String str = null;

        BufferedReader br = new BufferedReader(new FileReader(new File("user.txt")));

        str = br.readLine();
        while (str != null) {

            String account[] = str.split(",");
            accountlist.put(account[0], account[1]);

            str = br.readLine();
        }

        int Usercnt = accountlist.size();
        System.out.println("현재 회원 수는 " + (Usercnt - 1) + "명 이며 사용할 ID, PW를 입력하세요.)");

        Set<Map.Entry<String, String>> entries = accountlist.entrySet();

        System.out.println();
        System.out.println();

        FileWriter fw = new FileWriter("user.txt", true);

        boolean IDcheck = false;

        System.out.println("1. 사용하실 ID를 입력해주세요 : ");
        user = scanner.next();

        for (Entry<String, String> entry : entries) {

            if (entry.getKey().equals(user)) {
                IDcheck = true;
            }
        }
        if (IDcheck == true) {
            System.out.println();
            System.out.println("이미 사용중인 ID 입니다!!");
            System.out.println();
            RPG.page1();
        }

        else if(IDcheck == false) {
            RPG.ID = user;
            fw.write("\\r");
            fw.write(user);
            fw.write(",");

            System.out.print("2. 사용하실 PW를 입력해주세요 : ");
            user = scanner.next();
            fw.write(user);
            RPG.PW = user;
            System.out.println();
            System.out.println("계정 생성이 완료 되었습니다.");
            System.out.println();

            String AddUserInfo = "";
            AddUserInfo = "," + RPG.User.getName() + "," + RPG.User.getHp() + "," + RPG.User.getPower() + ","
                    + RPG.User.getInt() + "," + RPG.User.getDex() + "," + RPG.User.getMoney();
            
            fw.write(AddUserInfo.trim());
            
            fw.flush();
            fw.close();

            RPG.GamePage();
        }
    }
}