
import com.mongodb.client.*;

import java.lang.reflect.Array;
import java.util.*;

import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.Iterator;


public class Main {

    public void test(){
        int num = 0;
        for(int i=0; i<=50; i++){
            num =num+i;
            System.out.print(num+", ");
        }
    }

    public static void main(String[] args) {
        long start1 = System.nanoTime();
        Main obj = new Main();
        MongoClient client = MongoClients.create("mongodb+srv://testUser:123asd123@cluster0.eqohqrx.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("test");
        MongoCollection<Document> collection = db.getCollection("notes");
        FindIterable<Document> documents = collection.find().sort(new Document("_id", -1)).limit(1);
        Document lastDocument = documents.first();
        String title1  = collection.find().sort(new Document("_id", -1)).limit(1).projection(Projections.include("text1")).first().getString("text1");
        String title2  = collection.find().sort(new Document("_id", -1)).limit(1).projection(Projections.include("text2")).first().getString("text2");
        String title3  = collection.find().sort(new Document("_id", -1)).limit(1).projection(Projections.include("text3")).first().getString("text3");
        String title4  = collection.find().sort(new Document("_id", -1)).limit(1).projection(Projections.include("text4")).first().getString("text4");
        String title5  = collection.find().sort(new Document("_id", -1)).limit(1).projection(Projections.include("text5")).first().getString("text5");
        String title6  = collection.find().sort(new Document("_id", -1)).limit(1).projection(Projections.include("text6")).first().getString("text6");
        String title7  = collection.find().sort(new Document("_id", -1)).limit(1).projection(Projections.include("text7")).first().getString("text7");
        String title8  = collection.find().sort(new Document("_id", -1)).limit(1).projection(Projections.include("text8")).first().getString("text8");
        String title9  = collection.find().sort(new Document("_id", -1)).limit(1).projection(Projections.include("text9")).first().getString("text9");
        String title10  = collection.find().sort(new Document("_id", -1)).limit(1).projection(Projections.include("text10")).first().getString("text10");
        String title11  = collection.find().sort(new Document("_id", -1)).limit(1).projection(Projections.include("text11")).first().getString("text11");
        String title12  = collection.find().sort(new Document("_id", -1)).limit(1).projection(Projections.include("text12")).first().getString("text12");
        String title13  = collection.find().sort(new Document("_id", -1)).limit(1).projection(Projections.include("text13")).first().getString("text13");
        String title14  = collection.find().sort(new Document("_id", -1)).limit(1).projection(Projections.include("text14")).first().getString("text14");
        String title15  = collection.find().sort(new Document("_id", -1)).limit(1).projection(Projections.include("text15")).first().getString("text15");
        List<String> strAr1 = new ArrayList<>();
        strAr1.add((title1));
        strAr1.add((title2));
        strAr1.add((title3));
        strAr1.add((title4));
        strAr1.add((title5));
        strAr1.add((title6));
        strAr1.add((title7));
        strAr1.add((title8));
        strAr1.add((title9));
        strAr1.add((title10));
        strAr1.add((title11));
        strAr1.add((title12));
        strAr1.add((title13));
        strAr1.add((title14));
        strAr1.add((title15));

        strAr1.removeIf(Objects::isNull);

        for (String s :strAr1) {
            System.out.println(s);
        }

        //String inputk = "Ali eve gel\neve gel sonra\neve gel sonra çarşı\nçarşıya git\ngit ekmek al";
        //String[] allSentences = inputk.split(System.lineSeparator());

        for (int i = 0; i < strAr1.size(); i++) {
            System.out.println("000000"+strAr1.get(i)+"000000");
        }

        String cümle = twoField(strAr1.get(0),strAr1.get(1));

        for (int i = 2; i < strAr1.size(); i++) {
            cümle = twoField(cümle,strAr1.get(i));
        }
        System.out.println("777"+cümle+"777");
        //gönderilecekler : cümle , time2
        obj.test();
        long end1 = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds: ");
        double time = (end1-start1);
        System.out.println(time + "\n");
        double time2 = time/1000000000;
        System.out.println(time2);
        MongoCollection<Document> gradesCollection = db.getCollection("results");
        Document result = new Document("_id", new ObjectId());
        result.append("allSentences", cümle);
        result.append("time", time2);
        gradesCollection.insertOne(result);


    }

    public static String twoField(String ilkstring, String ikinciString) {
        String[] strArray1 = null;
        String[] strArray2 = null;

        strArray1 = ilkstring.split(" ");
        strArray2 = ikinciString.split(" ");
        System.out.println(strArray1[0]);
        System.out.println(strArray2[0]);

        int sayac1 = 1;
        int sayac2 = 1;

        for(int i = 0; i < ilkstring.length(); i++)
        {
            if(ilkstring.charAt(i) == ' ') {
                sayac1++;
            }
        }
        System.out.println("1. Girilen cumlede " + sayac1 + " tane kelime vardir.");
        for(int i = 0; i < ikinciString.length(); i++)
        {
            if(ikinciString.charAt(i) == ' ') {
                sayac2++;
            }
        }
        System.out.println("2. Girilen cumlede " + sayac2 + " tane kelime vardir.");
        for (int i = 0; i < sayac1; i++) {
            System.out.println("-------" + strArray1[i]);

        }
        ArrayList<Integer> ortakNoktaforfirsttext = new ArrayList<Integer>();
        ArrayList<Integer> ortakNoktaforsecondtext = new ArrayList<Integer>();
        for (int i = 0; i < sayac1; i++) {
            for(int k = 0; k < sayac2; k++){
                if(strArray2[k].contains(strArray1[i]) == true ){
                    ortakNoktaforfirsttext.add(i);
                    ortakNoktaforsecondtext.add(k);
                    System.out.println("birinci cümle için ortak nokta "+i);
                    System.out.println("ikinci cümle için ortak nokta "+k);
                    break;
                }
            }
        }
        int a = sayac2-ortakNoktaforsecondtext.get(0);
        int cumleTamamiUzunlugu = ortakNoktaforfirsttext.get(0)+a;
        int eklenecekKelime = 0;
        int kalanKelime = cumleTamamiUzunlugu-ortakNoktaforfirsttext.get(0)-1;
        System.out.println("kalan nokta "+kalanKelime);
        System.out.println("//////"+cumleTamamiUzunlugu);
        String[] cumleTamami = new String[cumleTamamiUzunlugu];
        for(int i=0;i<ortakNoktaforfirsttext.get(0);i++){
            cumleTamami[i] = strArray1[i];
            eklenecekKelime++;
            System.out.println("eklenecek kelime "+eklenecekKelime);
        }
        for (int i = ortakNoktaforsecondtext.get(0); i < sayac2; i++) {
            cumleTamami[eklenecekKelime] = strArray2[i];
            eklenecekKelime++;
        }
        String tümCümle = "";
        for (int i = 0; i < cumleTamamiUzunlugu; i++) {
            if(i == cumleTamamiUzunlugu-1){
                tümCümle += cumleTamami[i];
            }else{
                tümCümle += cumleTamami[i]+ " ";
            }
        }
        return tümCümle;


        /*List<String> strAr1 = new ArrayList<>();
        int sayi = 1;
        System.out.println("title"+Integer.toString(sayi));
        while(("title" + Integer.toString(sayi)) != null) {
            strAr1.add(("title" + Integer.toString(sayi)));
            System.out.println(strAr1.get(sayi - 1));
            sayi++;
        }*/

    }

}
