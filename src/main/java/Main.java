public class Main {

    public static void main(String[] args) {
        Medlem medlem;

        Medlem medlem1 = new Medlem("Camilla", "061026", true, true);

        medlem1.cprOmregning();
        System.out.println(medlem1);
    }
}
