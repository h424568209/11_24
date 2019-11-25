import java.util.*;

public class Main_11_24_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            int n = scanner.nextInt();
            if(n>s.length()){
                return;
            }
            int count = 0;
            int sum = 0;
            String ress= "";
            for(int i =0 ; i < s.length()-n+1 ; i++){
                String res = s.substring(i,n+i);
                for(int j = 0 ; j < n ; j++){
                    if(res.charAt(j) == 'C' || res.charAt(j) =='G'){
                        count++;
                    }
                }
                if(count>sum){
                    sum = count;
                    ress = res;
                }
                count = 0;
            }
            System.out.println(ress);
            }
        }
    }
