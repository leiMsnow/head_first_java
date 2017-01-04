package com.ray.java;

import com.ray.java.basic.simple_clone.Person;

import java.util.*;

/**
 * Created by dangdang on 5/9/16.
 */
public class TestMain {

    private int hhh = 0;

    class InnerClass {

        public InnerClass() {
            hhh = 1;
        }
    }

    public static void main(String[] args) {

        short c = 7;
        long t = 42;
//        calcArea(t,20);


//        byte h = calcArea(2,20);

//        main.calcArea(2,2);

//        String main = null;
//
//        if ("0".equals(main)) {
//            System.out.println("null");
//        }
//
//        ArrayList<String> arrayList = new ArrayList<>(1);
//        arrayList.add("111");
//        arrayList.add("222");
//
//
//        System.out.println(arrayList.get(0));
//
//        System.out.println(getRandomMacAddress());
//
//        Date today = new Date();
//        System.out.println(String.format("%ta,%<tb,%<tD", today));
//
//        int x = 10;
//        x = ~x;
//        System.out.println("x: " + x);
//        int y = 6;
//        int a = x | y;
//        System.out.println("a: " + a);
//        y = 10 >> 2;
//        System.out.println("y: " + y);
//
//        String params1 = "paycenter://1412475623,60;";//&sign_checkout=09e66d099039d5ccc3eb809d8a8901c5&is_oversea=0&is_ebook=0";
//        String params2[] = params1.split(";&");
//        System.out.println(params2[0]+";");
//        System.out.println("&"+params2[1]);

//        Map<String, String> map = getActionParams("paycenter://" + params2[1] );
//        System.out.println(map);

//        testInput();

//        Person person = new Person("zhangsan");
//        person = new Person("lisi");
//
//        System.out.println(Long.MAX_VALUE + "");

//        autoboxingTest();

//        addSomeObj();

//        testMath();

        String action = "search://key=a&b&cid=123";
        String[] actions = action.split("//");
        System.out.println(actions[0] + "  " + actions[1]);

        String [] keyid = actions[1].split("&");
        String key = keyid[0];
        System.out.println(key);
    }

    public static void testMath() {
//        for (int j = 0; j < 100; j++) {
        System.out.println((int) ((Math.random() * 9 + 1) * 100000));
//        }
    }

    private static int calcArea(int height, int width) {
        return height * width;
    }

    private static double calcArea(double height, double width) {
        return height * width;
    }

    static String getRandomMacAddress() {
        String alphabet = "abcdef1234567890";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int random1 = new Random().nextInt(alphabet.length());
            int random2 = new Random().nextInt(alphabet.length());
            if (i > 0) {
                stringBuilder.append(":");
            }
            stringBuilder.append(alphabet.charAt(random1))
                    .append(alphabet.charAt(random2));
        }
        return stringBuilder.toString();
    }

    private static Map<String, String> getActionParams(String url) {

        int actionIndex = url.indexOf("://");
        if (actionIndex < 0) return null;

        Map<String, String> actionParams = new HashMap<>();
        String action = url.substring(0, actionIndex + 3);
        url = url.substring(action.length());
        actionParams.put("action", action);
        String[] params = url.split("&");
        for (String param : params) {
            String[] values = param.split("=");
            if (values.length == 2)
                actionParams.put(values[0], values[1]);
        }

        return actionParams;
    }

    public static String parseMapParams(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {

            stringBuilder.append("&");
            stringBuilder.append(entry.getKey());
            stringBuilder.append("=");
            stringBuilder.append(entry.getValue());

        }
        return stringBuilder.toString();
    }

    private static void testInput() {

        int cur = 1000;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入产品数量:");
        while (scanner.hasNext()) {
            int order = scanner.nextInt();
            if (order > 0 && (order + cur) <= 2000) {
                System.out.println("成功了" + (order + cur));
            } else {
                System.out.println("失败了");
            }
        }

    }


    public static void autoboxingTest() {

        long startTime = System.currentTimeMillis();
        long sum = 0l;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("time: " + (endTime - startTime) + " sum: " + sum);
    }

//    private void car(double a, double b) {
//        (2 * a + 0.4 * b) * 0.5 - (1.3 * a + 0.3 * b-10)
//    }

    public static void addSomeObj() {
        Person person = new Person("1");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            persons.add(person);
        }

        System.out.println("psersons.size: " + persons.size());
        persons.get(2).setName("2");
        for (Person person1 : persons) {
            System.out.println("person:" + person1);
        }
    }

}
