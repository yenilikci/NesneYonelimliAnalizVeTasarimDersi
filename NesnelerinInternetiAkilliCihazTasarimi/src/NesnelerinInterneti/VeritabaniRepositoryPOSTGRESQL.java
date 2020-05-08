package NesnelerinInterneti;
import java.sql.*;
import java.util.Scanner;
public class VeritabaniRepositoryPOSTGRESQL
{
    private static VeritabaniRepositoryPOSTGRESQL instance = null;
    private synchronized static void createInstance()
    {
        if (instance == null)
            instance = new VeritabaniRepositoryPOSTGRESQL();
    }
    public static VeritabaniRepositoryPOSTGRESQL getInstance()
    {
        if (instance == null)
            createInstance();
        return instance;
    }

    boolean dogrulama = false;
    //Connection nesnesinden baglan fonksiyonu:
    private static Connection baglan()
    {
        Connection baglanti = null;
        try {
            baglanti = DriverManager.getConnection("jdbc:postgresql://localhost:5432/nesnelerininterneti",
                    "postgres", "veritabani");
            if (baglanti != null) //bağlantı varsa
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baglanti;
    }

    public void dogrula() throws SQLException {
        Connection dogrulamaBaglantisi = this.baglan();
        String veritabaniKullanici = "" , veritabaniSifre = "";
        Statement stmt = dogrulamaBaglantisi.createStatement();
        String SQL= "SELECT *  FROM \"kullanicilar\"";
        while (dogrulama == false)
        {
            ResultSet rs = stmt.executeQuery(SQL);
            Scanner veriAl = new Scanner(System.in);
            System.out.print("Kullanıcı adınızı giriniz: "); String kAdi = veriAl.next();
            System.out.print("Şifrenizi giriniz: "); String sifre = veriAl.next();
            // Kullanıcı adı ve şifre kontrolü
            while (rs.next()) {
                veritabaniKullanici = rs.getString("kullaniciadi");
                veritabaniSifre = rs.getString("kullanicisifre");
                if (kAdi.equals(veritabaniKullanici) && sifre.equals(veritabaniSifre)) { System.out.println("Giriş başarılı!\n");
                    dogrulama = true;
                    break;
                } else { System.out.println("Kullanıcı adı ve şifre kombinasyonu yanlış!\nKullanıcı bilgilerinizi lütfen tekrar giriniz.\n");
                    dogrulama = false;
                    break;
                }
            }
        }
        dogrulamaBaglantisi.close();
    }
}