public class Main {

    public static void main(String[] args) {
        Medlem medlem;

        Medlem medlem1 = new Medlem("Camilla", "061026", true, "konkurrence");
        Medlem medlem2 = new Medlem("Lærke", "231119", true, "motionist");

        medlem1.cprOmregning();
        System.out.println(medlem1);
        medlem2.cprOmregning();
        System.out.println(medlem2);
        System.out.println(medlem2.betalKontigent());
    }
}
