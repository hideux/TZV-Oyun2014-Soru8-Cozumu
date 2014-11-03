
public class Number2Text {

    private static final String[] birler = { " BİR", " İKİ", " ÜÇ", " DÖRT", " BEŞ", " ALTI", " YEDİ", " SEKİZ", " DOKUZ"};
    private static final String[] onlar = {" ON", " YİRMİ", " OTUZ", " KIRK", " ELLİ", " ALTMIŞ", " YETMİŞ", " SEKSEN", " DOKSAN" };
    private static final String[] katlar = { "", " BİN", " MİLYON", " MİLYAR", " TRİLYON"};

    public static String yaziyaCevir(long sayi) {

        StringBuffer sonuc = new StringBuffer();

        // Go through the number one group at a time.

        for (int i = katlar.length - 1; i >= 0; i--) {

            // Is the number as big as this group?
           long cutoff = (long) Math.pow((double) 10, (double) (i * 3));

            if (sayi >= cutoff) {
                int thisPart = (int) (sayi / cutoff);
                if (thisPart >= 100) {
                    if (thisPart / 100 > 1) {
                        sonuc.append(birler[thisPart / 100 -1]);
                    }

                    sonuc.append(" YÜZ");
                    thisPart = thisPart % 100;
                }

                if (thisPart >= 10) {
                    sonuc.append(onlar[(thisPart / 10) - 1]);
                    thisPart = thisPart % 10;
                }

                if (thisPart >= 1) {
                    if (!(cutoff == 1000 && thisPart == 1 && sayi>=1000 && sayi<200)) {
                        sonuc.append(birler[thisPart-1]);
                    }
                }

                sonuc.append(katlar[i]);
                sayi = sayi % cutoff;
            }
        }

        if (sonuc.length() != 0) {
            sonuc.deleteCharAt(0);
        }

        return sonuc.toString();
    }
}
