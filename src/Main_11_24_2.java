public class Main_11_24_2 {
    public static void main(String[] args) {
        int million = 10;
        int SumMillion = 0 ;
        int SumPeoson = 0;
        for(int i= 0 ; i < 30 ; i++){
            SumMillion += million;
        }
        for(int i = 1 ; i <= 30 ; i++){
            SumPeoson += (long)Math.pow(2,i-1);
        }
        System.out.println(SumMillion);
        System.out.println(SumPeoson);
    }
}
