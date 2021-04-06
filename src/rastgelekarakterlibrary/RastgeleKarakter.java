package rastgelekarakterlibrary;

/*/**

*

* @author Feyza Gezerer
* @since 17.03.2017
* 
 *
 */
public class RastgeleKarakter {
    //rastgeleliği saglamak icin sistemin zamanını kullanacaz.
    //istenilen karakterler girilmezse bu array kullanılacak
    private String[] karakterler = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    
    //rastgele tek karakter uretir.
    public String rastgeleUret() {
        int arrayIndex = rastgeleSayiUret(karakterler.length);//array in hangi elemanı
        int buyukKucuk = rastgeleSayiUret(2);//buyuk mu olacak kucuk mu
        if (buyukKucuk == 0) {
            return karakterler[arrayIndex];
        } else {
            return karakterler[arrayIndex].toUpperCase();
        }
    }

    //girilen sayı kadar rastgeleUret() fonksiyonunu cagıracagız.
    public String rastgeleUret(int maxLength) {
        String sonuc = "";
        for (int i = 0; i < maxLength; i++) {
            sonuc += rastgeleUret();
        }
        return sonuc;
    }

    //iki karakterin arraydeki indexleri bulunacak
    //bu indexlerin arasında kalanlardan yeni bir index secilecek.
    public String rastgeleIkisiArasindaUret(String ilk, String son) {
        int ilkIndex = getIndex(ilk);
        int sonIndex = getIndex(son);
        int buyukKucuk = rastgeleSayiUret(2); //karakterin buyuk mu kucuk mu olacagını secmek için.0 ise kucuk 1 ise buyuk olacak
        int arrayIndex = rastgeleSayiUret(ilkIndex, sonIndex);
        if (buyukKucuk == 0) {
            return karakterler[arrayIndex];
        } else {
            return karakterler[arrayIndex].toUpperCase();
        }
    }

    //girilen sayı kadar rastgeleIkisiArasindaUret(String ilk,String son) fonksiyonunu cagıracagız.
    public String rastgeleIkisiArasindaUret(String ilk, String son, int maxLength) {
        String sonuc = "";
        for (int i = 0; i < maxLength; i++) {
            sonuc += rastgeleIkisiArasindaUret(ilk, son);
        }
        return sonuc;
    }

    public String rastgeleBelirtilendenUret(String[] arrayKarakter) {
        int index = rastgeleSayiUret(arrayKarakter.length);
        return arrayKarakter[index];
    }

    public String rastgeleBelirtilendenUret(String[] arrayKarakter, int maxLength) {
        String sonuc = "";
        for (int i = 0; i < maxLength; i++) {
            sonuc += rastgeleBelirtilendenUret(arrayKarakter);
        }
        return sonuc;
    }

    /*
    maximum 1000 karakterli cümle olacak.
    **/
    public String rastgeleCumleUret() {
        String cumle = "";
        boolean noktalamaMi = false;//virgül,nokta ve bosluk kontrolleri için.ardarda gelmemeleri lazım
        boolean buyukHarfMi = true;//noktadan sonra buyuk harf icin
        int max = rastgeleSayiUret(1000);//cumlenin karakter uzunluğu

        for (int i = 0; i < max; i++) {
            if (i == max - 1) {//cumlenin sonunda nokta olmalı
                cumle += ".";
            } else {
                int index;
                if (i == 0 || noktalamaMi) {//cumlenin baslangıcı. virgül,nokta veya bosluk olmamalı
                    index = rastgeleSayiUret(karakterler.length);
                } else {//baslangıcı değil 
                    index = rastgeleSayiUret(karakterler.length + 5);
                }
                if (index >= karakterler.length) {//noktalama işareti veya bosluk gelmeli.
                    //nokta ihtimali 1/8
                    //virgül ihtimali 1/4
                    //bosluk ihtimali 5/8
                    int index2 = rastgeleSayiUret(8);
                    if (index2 == 0) {
                        cumle += ".";
                        buyukHarfMi = true;//noktadan sonra buyuk harfle baslamalı
                        noktalamaMi = true;//iki nokta yanyana gelmesin diye
                    } else if (index2 == 1 || index2 == 2) {
                        cumle += ",";
                        buyukHarfMi = false;//virgülden sonra buyuk harf gelmez
                        noktalamaMi = true;//iki virgül yanyana gelmesin diye
                    } else {
                        cumle += " ";
                        buyukHarfMi = false;
                        noktalamaMi = true;
                    }
                } else {
                    if (buyukHarfMi) {
                        cumle += karakterler[index].toUpperCase();
                    } else {
                        cumle += karakterler[index];
                    }
                    buyukHarfMi = false;
                    noktalamaMi = false;
                }
            }

        }
        return cumle;
    }

    //0 ile max arasında sayı üretir.0 dahil
    private int rastgeleSayiUret(int max) {
        return (int) (System.nanoTime() % max);
    }

    //ikisi arasında sayı üretir.min ve max dahil değil
    private int rastgeleSayiUret(int min, int max) {
        int rastgele;
        do {
            rastgele = (int) (System.nanoTime() % max);
        } while (rastgele <= min);

        return rastgele;
    }

    //girilen karakterin hangi indexte oldugunu bulacak.
    private int getIndex(String karakter) {
        for (int i = 0; i < karakterler.length; i++) {
            if (karakterler[i].equalsIgnoreCase(karakter)) {
                return i;
            }
        }
        return -1;
    }
}
