package springTest;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class BeanScopeTest {

/*    @Test
    public void testIdentity() {
        *//*
         * 동일성 : 객체 주소가  같다.
         * 동등성 : 객체의 값이 같다.
         *//*
        System.out.println("동일성에 대한 테스트를 진행합니다.");

        A a1 = new A();
        A a2 = new A();
    }*/

    @Test
    public void testEquals() {
        System.out.println("테스트");

        A a1 = new A(10, "안녕");
        A a2 = new A(10, "안녕");
        A a3 = new A(5, "Hello");

        Assert.assertNotEquals(a1, a2);
    }
}

class A {
    private int a1;
    private String a2;

    public A(int a1, String a2) {
        this.a1 = a1;
        this.a2 = a2;
    }
}