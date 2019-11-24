public class Main_11_22_1 {
    //另类加法
    public  int addAB(int A, int B){
        if(B==0){
            return  A;
        }
        int sum = A^B;
        int carry = (A&B)<<1;
        return addAB(sum,carry);
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 99999;
        Main_11_22_1 m = new Main_11_22_1();
        System.out.println(m.addAB(a,b));

    }
}
