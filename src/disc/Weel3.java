package disc;

public class Weel3 {
    static {
        boolean x = false;
        System.out.println("x = " + x);
        i = 12;
    }

    public static String method() {
        int x = 26;
      
        return "method x: " + x;
    }

    public static void main(String[] args) {
        System.out.println(method());
        {
            int x = 27;
            System.out.println("x = " + x);
        }
        
        int x = 12;
        System.out.println("x = " + x);


        double a = 2.1;
        float b = a;

        int c = 1;
        double d = c;

        short e = 2;
        int f = e;

        long g = c;
    }
}
