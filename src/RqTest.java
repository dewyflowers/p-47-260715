public class RqTest {

    public static void main(String[] args){
        //testActionName();
        //testGetParam();

        //testGetParamEx();
        testGetParamEx2();
        testGetParamAsInt();
    }

    public static void testGetParamAsInt(){
        Rq rq1 = new Rq("삭제?id=3");
        int id1 = rq1.getParamAsInt("id", -1); // 3
        System.out.println(id1);

        Rq rq2 = new Rq("삭제?id=");
        int id2 = rq2.getParamAsInt("id", -1); // -1
        System.out.println(id2);
    }

    public static void testGetParamEx3(){
        Rq rq = new Rq("목록?searchKeyword=&keywordkkk");
        String searchKeyword = rq.getParam("searchKeyword", "");    // ""
        String keyword = rq.getParam("keyword", "");    // ""
        System.out.println(searchKeyword);  // ""
        System.out.println(keyword);  // "kkk"
    }

    public static void testGetParamEx2(){
        Rq rq = new Rq("목록?searchKeyword=");
        String searchKeyword = rq.getParam("searchKeyword", "origin");    // "origin"
        System.out.println(searchKeyword);  // "origin"
    }

    public static void testGetParamEx() {
        Rq rq = new Rq("목록?");
        String searchKeyword = rq.getParam("searchKeyword", "");    // ""
        System.out.println(searchKeyword);  // ""
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
