import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private final Scanner sc = new Scanner(System.in);
    private final ArrayList<Wise> wiseList = new ArrayList<>();
    private int lastId = 0;

    public void run(){
        System.out.println("== 명언 앱 ==");
        String cmd;

        // 반복
        while(true){
            System.out.print("명령) ");
            cmd = sc.nextLine().trim();  // 입력값 받기

            if(cmd.equals("종료")){
                break;
            }
            else if(cmd.equals("등록")){
                actionWrite(); // option + enter를 하면 없는 함수 intelliJ가 만들어준다.
            }
            else if(cmd.equals("목록")){
                actionList();
            }
            else if(cmd.startsWith("삭제?id=")){
                try {
                    int targetId = Integer.parseInt(cmd.substring("삭제?id=".length()).trim());
                    actionDelete(targetId);
                }
                catch (NumberFormatException e) {
                    System.out.println("명언 번호는 숫자로 입력해주세요.");
                }
            }
            else if(cmd.startsWith("수정?id=")){
                try {
                    int targetId = Integer.parseInt(cmd.substring("수정?id=".length()).trim());
                    modify(targetId);
                }
                catch (NumberFormatException e) {
                    System.out.println("명언 번호는 숫자로 입력해주세요.");
                }
            }
            else{
                System.out.println("잘못된 명령입니다.");
            }
        }

        sc.close();
    }

    private int write(String content, String author){
        int id = lastId + 1;
        ++lastId;

        wiseList.add(new Wise(id, content, author));
        return id;
    }

    private void actionWrite(){
        System.out.print("명언: ");
        String content = sc.nextLine();
        System.out.print("작가: ");
        String author = sc.nextLine();

        int id = write(content, author);
        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
    }

    private void actionList(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for(int i = wiseList.size()-1; i >= 0; --i){
            Wise wise = wiseList.get(i);

            System.out.printf("%d / %s / %s\n", wise.getId(), wise.getAuthor(), wise.getContent());
        }
    }

    private void actionDelete(int targetId){
        for(int i = 0; i < wiseList.size(); ++i) {
            if (wiseList.get(i).getId() == targetId) {
                wiseList.remove(i);
                System.out.printf("%d번 명언이 삭제되었습니다.\n", targetId);
                return;
            }
        }
        System.out.printf("%d번 명언은 존재하지 않습니다.\n", targetId);
    }

    private void modify(int targetId){
        for(int i = 0; i < wiseList.size(); ++i) {
            if (wiseList.get(i).getId() == targetId) {
                Wise wise = wiseList.get(i);
                System.out.print("명언(기존) : " + wise.getContent() + "\n");
                System.out.print("명언 : ");
                wise.setContent(sc.nextLine());
                System.out.print("작가(기존) : " + wise.getAuthor() + "\n");
                System.out.print("작가 : ");
                wise.setAuthor(sc.nextLine());
                return;
            }
        }
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", targetId);
    }

}