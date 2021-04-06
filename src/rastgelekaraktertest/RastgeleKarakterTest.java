package rastgelekaraktertest;
import rastgelekarakterlibrary.RastgeleKarakter;

/**
*
* @author Feyza Gezerer
* @since 17.03.2017
* 
* Açıklama
* 
*/
public class RastgeleKarakterTest {
    
    public static void main(String[] args) {
        
        RastgeleKarakter r = new RastgeleKarakter();
        
        System.out.println("Rastgele karakter : "+r.rastgeleUret());
        System.out.println("Rastgele karakter : "+r.rastgeleUret());
        System.out.println("Rastgele 3 karakter : "+r.rastgeleUret(3));
        System.out.println("Rastgele 3 karakter : "+r.rastgeleUret(3));
        
        System.out.println("Verilen iki karakter (a,t) : "+r.rastgeleIkisiArasindaUret("a", "t"));
        System.out.println("Verilen iki karakter (a,t)(10) : "+r.rastgeleIkisiArasindaUret("a", "t",10));
        
        System.out.println("Belirtilen Karakterler(a,b,e,z,x) : "+r.rastgeleBelirtilendenUret(new String[]{"a", "b", "e", "z", "x"}));
        System.out.println("Belirtilen Karakterler(a,b,e,z,x) : "+r.rastgeleBelirtilendenUret(new String[]{"a", "b", "e", "z", "x"}));
        System.out.println("Belirtilen Karakterler(a,b,e,z,x)(8) : "+r.rastgeleBelirtilendenUret(new String[]{"a", "b", "e", "z", "x"}, 8));

        System.out.println("Rastgele cümle : "+r.rastgeleCumleUret());

    }
}
