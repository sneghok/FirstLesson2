public class FirstLesson {

    //        + , - , / , * , % , += , -= , *= , /= , %= ++ , --)
    public static void main(String[] args) {
        int h = 13;
        float f = 23.1f;
        double d = 24.4;
        boolean c = true;
        char ch1 = 'a';
        byte n = 3;
        long m = 5;
        short q = 3;

        System.out.println("h="+h+ "; f="+f+ "; d="+d+ "; n="+n+ "; m="+m+ "; q="+q);
        System.out.println("h + 3 =  "+ (h + 3));
        System.out.println("d - 2 = "+ (d - 2));
        System.out.println("m / 5 = "+ (m / 5));
        System.out.println("n * 1 = "+ (n * 1));
        System.out.println("q % 1.5 = "+ (q % 1.5));
        System.out.println("h += 3 = "+ (h += 3));
        System.out.println("d -= 10 = "+ (d -= 10));
        System.out.println("m *= 7 = "+ (m *= 7));
        System.out.println("q /= 6 = "+ (q /= 6));
        System.out.println("n %= 4 = "+ (n %= 4));
        System.out.println("f++  = "+ (f++ ));
        System.out.println("h-- = "+ (--h));

        String s = "Andriy";
        String r = "Julia";
        String u = "Andriy";
        s.equals(r);
        System.out.println("s = Andriy");
        System.out.println("r = Julia");
        System.out.println("u = Andriy");
        System.out.println("s.equals(r) = "+ s.equals(r));
        System.out.println("s.equals(u) = "+ s.equals(u));
    }
}
