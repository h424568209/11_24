import java.util.Scanner;

public class Main_11_22_2 {
    //饥饿的小易
    public void AnOther() {
        Scanner in = new Scanner(System.in);
        int x0 = in.nextInt();
        in.close();
        int count = 0;
        while (x0 != 0 && count <= 300000) {
            x0 = ((x0 << 1) + 1) % 1000000007;
            count++;
        }
        int res = (count + 2) / 3;
        System.out.println(res > 100000 ? -1 : res);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x0 = scanner.nextLong();
        long m = 1000000007;//取模的值
        long s = 100000; //神秘力量使用的次数
        long[] begin = new long[3]; //f(x) = 4x+3 执行3次 //3次的取值
        begin[0] = x0;
        begin[1] = (4 * begin[0] + 3) % m;
        begin[2] = (4 * begin[1] + 3) % m;
        long minStep = s;
        long cur = 0;
        int step = 0; //执行的步数
        for (int i = 0; i < 3; i++) {
            cur = begin[i];
            step = i;
            while (cur != 0 && step < minStep) {
                cur = (8 * cur + 7) % m; //g(x) = 8x+7 执行
                step++;
            }
            minStep = minStep < step ? minStep : step;
        }
        if (minStep < s) //如果执行步长没有超过s输出最小步长
        {
            System.out.println(minStep);
        } else {//超过返回-1
            System.out.println(-1);
        }
    }
}
