import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String cmd;
    private Map<String, String> paramMap = new HashMap<String, String>();


    Rq(String cmd){
        this.cmd = cmd;

        // "목록?keywordType=content&keyword=과거"
        String[] cmdBits = cmd.split("\\?");    // ["목록", "keywordType=content&keyword=과거&page=1"]

        String params = cmdBits[1]; // "keywordType=content&keyword=과거&page=1"

        String[] paramBits = params.split("&"); // ["keywordType=content", "keyword=과거", "page=1"]


        // ---------------------------------------------------
        for(String param : paramBits){
            String[] keyValue = param.split("=");
            paramMap.put(keyValue[0], keyValue[1]);
        }

    }

    public String getActionName(){
        // 문자열 쪼개기 -> split

        String[] cmdBits = cmd.split("\\?");    // ? 기호를 기준으로 잘라준다. ["삭제", "id=1"]

        return cmdBits[0];
    }

    public String getParam(String key, String defaultValue){
        // 키 - 밸류 저장 방식 구조 => map
        return paramMap.get(key);
    }
}
