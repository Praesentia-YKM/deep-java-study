package collection.iterable;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MyArrayMain {

    public static void main(String[] args) {
        MyArray myArray = new MyArray(new int[]{1, 2, 3, 4});

        Iterator<Integer> iterator = myArray.iterator();
        System.out.println("iterator 사용");
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            System.out.println("value = " + value);
        }

        //추가
        System.out.println("for-each 사용");
        for (int value : myArray) {
            System.out.println("value = " + value);
        }

        String jsonStr = "{\"name\": \"John\", \"age\": \"30\"}";
        JSONObject jObject = new JSONObject(jsonStr);
        System.out.println(jObject.toString());

        Map<String, String> resultMap = convertJsonToMap(jsonStr);

        // 결과 출력
        System.out.println(resultMap);

    }

    public static Map<String, String> convertJsonToMap(String jsonStr) {
        JSONObject jsonObject = new JSONObject(jsonStr);
        Map<String, String> map = new HashMap<>();

        for (String key : jsonObject.keySet()) {
            map.put(key, jsonObject.get(key).toString());
        }

        return map;
    }

}