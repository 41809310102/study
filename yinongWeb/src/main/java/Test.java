import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
//        // {"succ":1,"msg":"msg"}
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("succ", 1);
//        map.put("msg", "操作成功");
//        // object -> json string
//        String str = mapper.writeValueAsString(map);
//        System.out.println(str);

        List<UserInfo> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUsername("java" + i);
            userInfo.setPassword("pwd" + i);
            list.add(userInfo);
        }
        String result = mapper.writeValueAsString(list);
        System.out.println(result);
    }
}
