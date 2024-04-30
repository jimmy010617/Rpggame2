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

public class UserSave {
    
    public static void account() throws Exception {
        Scanner scanner = new Scanner(System.in);
        Reader fr = new FileReader("user.txt");

        //Map을 이용하여 ID, 비밀번호값 임시저장하기
        Map<String, String> accountlist = new HashMap<>();

        String user = null;
        String str = null;

        BufferedReader br = new BufferedReader(new FileReader(new File("user.txt")));

        str = br.readLine();
        String TempUserInfo = "";

        String UserInfo = "";
        while (str != null) {

            TempUserInfo += (str + "\r\n");

            str = br.readLine();    //null일때까지 계속 읽어오기
        }

        //replace로 접속된 ID만 찾아 능력치 및 정보로 바꿔준다
        UserInfo += (TempUserInfo.replace(RPG.ID + "," + RPG.PW,
        RPG.ID + "," + RPG.PW + "," + RPG.User.getName() + "," + RPG.User.getHp() + "," +
        RPG.User.getPower() + "," + RPG.User.getInt() + "," + RPG.User.getDex() + "," + RPG.User.getMoney())
        + "\r\n");

        //User파일에 들어갈 text 미리보기
        FileWriter fw = new FileWriter("user.txt");
        //데이터 덮어쓰면서 밀려날시 공백제거
        fw.write(UserInfo.trim());
        fw.flush();

        System.out.println();
        System.out.println("현재까지의 진행상황을 일기에 기록 하였습니다");
        System.out.println();
    }
}
