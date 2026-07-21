import java.util.HashMap;
import java.util.Map;

public class Rq {
    String actionName;
    private Map<String, String> paramMap = new HashMap<String, String>();


    Rq(String cmd){
        // "목록?keywordType=content&keyword=과거"
        String[] cmdBits = cmd.split("\\?");    // ["목록", "keywordType=content&keyword=과거&page=1"]
        this.actionName = cmdBits[0];

        String params = cmdBits.length > 1 ? cmdBits[1] : ""; // "keywordType=content&keyword=과거&page=1"

        String[] paramBits = params.split("&"); // ["keywordType=content", "keyword=과거", "page=1"]

        if(params.equals("")){
            return;
        }

        for(String param : paramBits){
            String[] keyValue = param.split("=");
            if(keyValue.length < 2){
                continue;
            }
            paramMap.put(keyValue[0], keyValue[1]);
        }

    }

    public String getActionName(){
        // 문자열 쪼개기 -> split

        // String[] cmdBits = cmd.split("\\?");    // ? 기호를 기준으로 잘라준다. ["삭제", "id=1"]

        return actionName;
    }

    public String getParam(String key, String defaultValue){
        // 키 - 밸류 저장 방식 구조 => map
        return paramMap.getOrDefault(key, defaultValue);
    }

    public int getParamAsInt(String key, int defaultValue){
        String rst = getParam(key, "");
        try{
            return Integer.parseInt(rst);
        }catch (NumberFormatException e){
            System.out.println("잘못된 입력값을 넣어서 기본값으로 반환됩니다.");
            return defaultValue;
        }
    }

}
