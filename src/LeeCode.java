import java.util.Stack;

public class LeeCode {
    //实现一个基本的计算器来计算一个简单的字符串表达式的值。
    //字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格

    /**
     * 遇到括号用栈处理，将之前的计算结果先压栈
     * 使用sign表示遇到的正负
     *
     * @param s 字符串
     * @return 计算的结果
     */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        //表示正负
        int sign = 1;
        int res= 0;
        int length = s.length();
        for(int i = 0 ; i < length;  i++){
            char ch = s.charAt(i);
            //判断是否是数字
            if(Character.isDigit(ch)){
                //当前字符代表的数字
                int cur = ch-'0';
                //是否是多位数
                while(i+1 < length && Character.isDigit(s.charAt(i+1))){
                    cur = cur*10 +s.charAt(++i) - '0';
                }
                res = res+sign*cur;
            }else if(ch == '+'){
                sign = 1;
            }else if(ch == '-'){
                sign = -1;
            }else if(ch == '('){
                stack.push(res);
                res = 0;
                stack.push(sign);
                sign = 1;
            }else if(ch == ')'){
                res = stack.pop() * res + stack.pop();
            }
        }
        return  res;
    }
    /**
     *  去重字符串中的元素，并且按照字典序最小输出
     * @param s 字符串
     * @return 去重后且字典序最小的字符串
     */
    public String removeDuplicateLetters(String s) {
        Stack<Character>  stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i ++){
            Character c=  s.charAt(i);
            //栈中有该元素，则直接去除当前元素
            if(stack.contains(c))
                continue;
            //若当前的栈顶元素比当前元素字典序大，且当前元素的位置后还有栈顶元素
            //将栈顶元素出栈，将当前元素入栈，这样来找到最优的排列
            //也可以使用 s.inexof(stack.peek(),i)表示规定检索的位置从i开始
            while(!stack.isEmpty() && stack.peek()>c && s.indexOf(stack.peek())!=-1){
                stack.pop();
            }
            stack.push(c);
        }
        char []res = new char[stack.size()];
        for(int i= 0 ; i<stack.size() ; i++){
            res[i] = stack.get(i);
        }
        return new String(res);
    }
    public static void main(String[] args) {
        int nums [] = {1,1,2,2,3};
        String s = "abcabcd";
        LeeCode l = new LeeCode();
        System.out.println(l.removeDuplicateLetters(s));
        String ss = "1+2+3+2+(1+2+3)-1-   3 -   2   +2";
        System.out.println(l.calculate(ss));
    }
}
