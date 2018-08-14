package hello;

public class Hello {
    private String text1, text2;

    public void sayHello() {
        text1 = "Hello";
        text2 = "World!";

        System.out.println(String.format("%s %s", text1, text2));
//		System.out.println(text1 + " " + text2);
    }
}
