

public class Main {

    public static void main(String[] args) {

        Medlem medlem1 = new Medlem("Camilla", "061026", MedlemsStatus.AKTIV, "konkurrence");
        Medlem medlem2 = new Medlem("Lærke", "231119", MedlemsStatus.PASSIV, "motionist");
        Medlem medlem3 = new Medlem("Christian", "100894", MedlemsStatus.AKTIV, "konkurrence");

        medlem1.cprOmregning();
        System.out.println(medlem1);
        medlem2.cprOmregning();
        System.out.println(medlem2);
        medlem3.cprOmregning();
        System.out.println(medlem3);
    }
}
