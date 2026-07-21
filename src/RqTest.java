public class RqTest {

    public static void main(String[] args){
        testActionName();
        testGetParam();
    }

    public static void testGetParam(){
        Rq rq = new Rq("목록?searchKeyword=영광"); // key=value
        String searchKeyword = rq.getParam("searchKeyword", ""); // "영광"

        System.out.println(searchKeyword);  // 영광

        Rq rq2 = new Rq("목록?keywordType=content"); // key=value
        String keywordType = rq2.getParam("keywordType", ""); // "content"

        System.out.println(keywordType);  // content

        Rq rq3 = new Rq("목록?keywordType=author"); // key=value
        String keywordType1 = rq3.getParam("keywordType", ""); // "author"

        System.out.println(keywordType1);  // author
    }

    public static void testActionName(){
        Rq rq = new Rq("삭제?id=1");
        String action = rq.getActionName();     // 삭제
        System.out.println(action);

        Rq rq2 = new Rq("수정?id=1");
        String action2 = rq2.getActionName();    // 수정
        System.out.println(action2);
    }
}
