

public class Main {

    public static void main(String[] args) {
        Formand formand = new Formand();
        Kasserer kasserer = new Kasserer();

     //formand.tilføjMedlem("Kasper","011275", MedlemsStatus.AKTIV,"motionist");
       //formand.tilføjMedlem("Lær","121156",MedlemsStatus.PASSIV,"konkurrence");
       //formand.tilføjMedlem("Camilla", "061026", MedlemsStatus.AKTIV, "konkurrence");
       //formand.tilføjMedlem("isa", "020202", MedlemsStatus.AKTIV,"motionist");
       formand.visMedlemmer();


        Medlem medlem1 = new Medlem("Camilla", "061026", MedlemsStatus.AKTIV, "konkurrence");
        Medlem medlem2 = new Medlem("Lærke", "231119", MedlemsStatus.PASSIV, "motionist");
        Medlem medlem3 = new Medlem("Christian", "100894", MedlemsStatus.AKTIV, "konkurrence");

        System.out.println("\n");
        System.out.println("Svømmeklubbens samlede forventede betalte kontigent: " + kasserer.forventetKontigentIndkomst() + " kr.");
        System.out.println("\n");

        medlem1.cprOmregning();
        System.out.println(medlem1);
        medlem2.cprOmregning();
        System.out.println(medlem2);
        medlem3.cprOmregning();
        System.out.println(medlem3);
    }
}
