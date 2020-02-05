package javaLevel2.lesson3;

import java.util.*;

public class TelephoneTest {
    Map<String, List<String>> contacts = new HashMap<>();

    public TelephoneTest(Map<String, List<String>> contacts) {
        this.contacts = contacts;
    }

    public TelephoneTest() {
    }

    private void add(String name, String tel) {
        if (contacts.containsKey(name)) {
            List<String> list = contacts.get(name);
            list.add(tel);
            contacts.put(name,list);
        } else {
            List<String> list = new ArrayList<>();
            list.add(tel);
            contacts.put(name,list);
        }

    }
    private void get(String name) {
        if (contacts.containsKey(name)) {
            System.out.println(name + ": " + contacts.get(name));
        } else {
            System.out.println("No such contact");
        }
    }

    public static void main(String[] args) {
        Map<String, List<String>> contacts = new HashMap<>();

        contacts.put("Ivanov", new ArrayList<String>());
        contacts.put("Chernov", new ArrayList<String>());
        contacts.put("Ivanov", new ArrayList<String>());
        contacts.put("Xarlamov", new ArrayList<String>());
        contacts.put("Petrov", new ArrayList<String>());
        contacts.put("Petrova", new ArrayList<String>());
        contacts.put("Ivanova", new ArrayList<String>());
        contacts.put("Ivanchenko", new ArrayList<String>());
        contacts.put("Kolesnikov", new ArrayList<String>());

        TelephoneTest test = new TelephoneTest(contacts);
        test.add("Jones", "8-907-58-88-345");
        test.add("Ivanov", "11-22-33");
        test.add("Ivanov", "91-88-73");
        test.add("Ivanov", "77-66-53");
        test.add("Ivanov", "56-45-36");

        test.get("Ivanov");
        test.get("Kolesnikov");
        test.get("XXX");
    }
}
