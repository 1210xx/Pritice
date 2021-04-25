package test;


public class TestSwap {
    int a = 3;
    int b = 4;
    public static void main(String[] args) {
        int a1 = 6;
        int a2 = 7;
        TestSwap swap = new TestSwap();
        swap.swap();
        System.out.println("a: "+ swap.a );
        System.out.println("b: "+ swap.b);
    }

    public void swap(){
        int temp;
        temp = this.a;
        this.a = this.b;
        this.b = temp;
    }



}
