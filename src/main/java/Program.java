import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) throws Exception {
       /* List<PVTPoint> originPointList = new ArrayList<PVTPoint>();
        originPointList = new ArrayList<PVTPoint>();
        originPointList.add(new PVTPoint(new double[] {0, 100, 50, 0, 0, 100}, new double[] {0, 10, 10, 0, 50, 100}));
        originPointList.add(new PVTPoint(new double[] {100, 300, 100, 50, 100, 150}, new double[] {5, 20, 15, 50, 60, 150}));
        originPointList.add(new PVTPoint(new double[] {200, 500, 150, 100, 200, 200}, new double[] {10, 30, 20, 100, 70, 200}));
        originPointList.add(new PVTPoint(new double[] {300, 700, 200, 150, 300, 250}, new double[] {15, 40, 25, 150, 80, 250}));
        originPointList.add(new PVTPoint(new double[] {400, 900, 250, 200, 400, 300}, new double[] {20, 50, 30, 200, 90, 300}));
        originPointList.add(new PVTPoint(new double[] {500, 1100, 300, 250, 500, 350}, new double[] {25, 60, 35, 150, 100, 350}));
        originPointList.add(new PVTPoint(new double[] {600, 1300, 350, 300, 600, 400}, new double[] {30, 70, 40, 200, 110, 400}));
        originPointList.add(new PVTPoint(new double[] {700, 1500, 400, 350, 700, 450}, new double[] {35, 80, 45, 250, 120, 450}));
        originPointList.add(new PVTPoint(new double[] {800, 1700, 450, 400, 800, 500}, new double[] {40, 90, 50, 300, 130, 500}));
        originPointList.add(new PVTPoint(new double[] {900, 1900, 500, 450, 900, 550}, new double[] {45, 100, 55, 350, 140, 550}));*/

        double[] input = {0, 100, 200, 300, 400, 500};
        double[] input2 = {100, 300, 400, 500, 600, 700, 800, 900, 1000};
        double[] input3 = {0, 50, 100, 150, 200};
        Harmonica harmonica = new Harmonica(input2);
        System.out.println(input2.length);
        System.out.println(harmonica.getPositions().length);
        System.out.println(harmonica.toString());
        /*PointEnumeration enumeration = new PointEnumeration(originPointList);
        int i = 0;
        PointIterator iterator = o.iterator(); //вывод списка точек в консоль
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            if(i>3){
                iterator.changeSpeed(200);
            }
            i++;
        }*/
    }
}