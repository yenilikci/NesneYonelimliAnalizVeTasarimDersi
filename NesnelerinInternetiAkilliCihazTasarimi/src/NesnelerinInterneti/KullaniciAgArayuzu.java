package NesnelerinInterneti;
import java.sql.*;
import java.util.Scanner;
public class KullaniciAgArayuzu implements IObserver
{
    boolean cihazDurum;
    @Override
    public void beklemede() {
        System.out.println("---------------------Durum Bilgisi-------------------------");
        System.out.println("Cihaz beklemede...");
        System.out.println("------------------------------------------------------------");
        cihazDurum = false;
    }
    @Override
    public void kontrol() {
        System.out.println("---------------------Durum Bilgisi-------------------------");
        System.out.println("Cihaz kontrol ediliyor...");
        System.out.println("------------------------------------------------------------");
        cihazDurum = true;
    }
    KullaniciAgArayuzu() throws SQLException {
        System.out.println("------------------------------------------------------------");
        System.out.println("Akıllı cihaz çalıştırıldı");
        System.out.println("------------------------------------------------------------");
        VeritabaniRepositoryPOSTGRESQL.getInstance().dogrula(); //new yerine singleton
        MerkeziIslemBirimi merkeziIslem = new MerkeziIslemBirimi();
        Scanner islem = new Scanner(System.in);
        int islemSec;
        while (true)
        {
            System.out.println("İşlem seçiniz");
            System.out.println("1-Soğutucu Aç");
            System.out.println("2-Soğutucu Kapat");
            System.out.println("3-Sıcaklık Görüntüle");
            System.out.println("4-Çıkış Yap");
            System.out.print("İşleminiz: ");
            islemSec = islem.nextInt();
            if (islemSec == 1)
            {
                kontrol();
                merkeziIslem.sogutucuAcik(this);
                beklemede();
            }
            else if (islemSec == 2)
            {
                kontrol();
                merkeziIslem.sogutucuKapali(this);
                beklemede();
            }
            else if (islemSec == 3)
            {
                kontrol();
                merkeziIslem.sicaklikGoster(this);
                beklemede();
            }
            else if (islemSec == 4)
            {
                System.out.println("------------------------------------------------------------");
                System.out.println("Akıllı cihaz kapanıyor...");
                System.out.println("------------------------------------------------------------");
                System.exit(0);
            }
            else
            {
                System.out.println("------------------------------------------------------------");
                System.out.println("Listelenen aksiyonlardan birini seçiniz!");
                System.out.println("------------------------------------------------------------");
            }
        }
    }
}
