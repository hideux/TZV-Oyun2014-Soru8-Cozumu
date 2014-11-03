//  Cevap: 1110611626 BİRMİLYARYÜZONMİLYONALTIYÜZONBİRBİNALTIYÜZYİRMİALTI
public class Main {

    static final int kacTaneBulunacak = 3;

    public static void main(String[] args) {
        /*
        System.out.println(Number2Text.yaziyaCevir(11));
        System.out.println(Number2Text.yaziyaCevir(1));
        System.out.println(Number2Text.yaziyaCevir(121));
        System.out.println(Number2Text.yaziyaCevir(100));
        System.out.println(Number2Text.yaziyaCevir(1001));
        System.out.println(Number2Text.yaziyaCevir(10234));
        System.out.println(Number2Text.yaziyaCevir(11230));
        System.out.println(Number2Text.yaziyaCevir(21200));
        System.out.println(Number2Text.yaziyaCevir(101010));
        System.out.println(Number2Text.yaziyaCevir(1222));
        System.out.println(Number2Text.yaziyaCevir(9999));
        System.out.println(Number2Text.yaziyaCevir(111111));
        System.out.println(Number2Text.yaziyaCevir(1001000));
        */

        for (long sayi=1; sayi < 10000000000L; sayi++) {

            String okunusOrj = Number2Text.yaziyaCevir(sayi);
            String okunus = okunusOrj.replace(" ", "");
            while (okunus.length() > 2) {

                String ilkHarf = String.valueOf(okunus.charAt(0));
                okunus = okunus.substring(1);
                boolean flag = true;
                for (int i=0; i < kacTaneBulunacak-1; i++) {
                    if (okunus.contains(ilkHarf)) {
                        int index = okunus.indexOf(ilkHarf);
                        okunus = okunus.substring(0, index) + okunus.substring(index+1);
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    break;
                } else {
                    okunus = okunus.replace(ilkHarf,"");
                }
            }
            if (okunus.length() == 0) {
                System.out.println(sayi + " " + okunusOrj.replace(" ",""));
                break;
            }
            // her 10000000 sayıda bir konsola ilerlemeyi basar
            if ((sayi % 10000000)==0) {
                System.out.println(sayi);
            }
        }
    }
}
