public class Test {
    private float f = 1.0f;
    int m = 12;
    static int n = 1;

    public static void main(String args[]) {
        Test t = new Test();
        t.f=1.0f;
        //静态无法使用this调用
        //this.n;

    }
}
