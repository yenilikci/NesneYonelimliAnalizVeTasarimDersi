package NesnelerinInterneti;

public class MerkeziIslemBirimi implements IObservableMerkeziIslemBirimi
{
    private boolean sogutucuDurum;
    Eyleyici eyle = new Eyleyici();
    SicaklikAlgilayici sicaklikAlgila = new SicaklikAlgilayici();
    @Override
    public void sogutucuAcik(IObserver observer)
    {
        if (this.sogutucuDurum) //true ise
        {
            System.out.println("------------------------------------------------------------");
            System.out.println("Soğutucu zaten açık tekrar açamazsınız!");
            System.out.println("------------------------------------------------------------");
        }else {
            this.sogutucuDurum = eyle.sogutucuAc();
            sicaklikAlgila.sicaklikAta(sogutucuDurum);
            System.out.println("------------------------------------------------------------");
            System.out.println("Soğutucu Açıldı!");
            System.out.println("------------------------------------------------------------");
        }
    }
    @Override
    public void sogutucuKapali(IObserver observer)
    {
        if (!this.sogutucuDurum) //false ise
        {
            System.out.println("------------------------------------------------------------");
            System.out.println("Soğutucu zaten kapalı tekrar kapatamazsınız!");
            System.out.println("------------------------------------------------------------");
        }else
        {
            this.sogutucuDurum = eyle.sogutucuKapat();
            sicaklikAlgila.sicaklikAta(sogutucuDurum);
            System.out.println("------------------------------------------------------------");
            System.out.println("Soğutucu Kapalı!");
            System.out.println("------------------------------------------------------------");
        }
    }
    @Override
    public void sicaklikGoster(IObserver observer)
    {
        System.out.println("------------------------------------------------------------");
        System.out.println("Sıcaklık Değeri: " + sicaklikAlgila.sicaklikOku());
        System.out.println("------------------------------------------------------------");
    }
}