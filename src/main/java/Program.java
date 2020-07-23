import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
       List<PVTPoint> originPointList;
        originPointList = new ArrayList<PVTPoint>();
        originPointList.add(new PVTPoint(new Double[] {0.0, 100.0, 50.0, 0.0, 0.0, 100.0}, new Double[] {0.0, 10.0, 10.0, 0.0, 50.0, 100.0}));
        originPointList.add(new PVTPoint(new Double[] {100.0, 300.0, 100.0, 50.0, 100.0, 150.0}, new Double[] {5.0, 20.0, 15.0, 50.0, 60.0, 150.0}));
        originPointList.add(new PVTPoint(new Double[] {200.0, 500.0, 150.0, 100.0, 200.0, 200.0}, new Double[] {10.0, 30.0, 20.0, 100.0, 70.0, 200.0}));
        originPointList.add(new PVTPoint(new Double[] {300.0, 700.0, 200.0, 150.0, 300.0, 250.0}, new Double[] {15.0, 40.0, 25.0, 150.0, 80.0, 250.0}));
        originPointList.add(new PVTPoint(new Double[] {400.0, 900.0, 250.0, 200.0, 400.0, 300.0}, new Double[] {20.0, 50.0, 30.0, 200.0, 90.0, 300.0}));
        originPointList.add(new PVTPoint(new Double[] {500.0, 1100.0, 300.0, 250.0, 500.0, 350.0}, new Double[] {25.0, 60.0, 35.0, 150.0, 100.0, 350.0}));
        originPointList.add(new PVTPoint(new Double[] {600.0, 1300.0, 350.0, 300.0, 600.0, 400.0}, new Double[] {30.0, 70.0, 40.0, 200.0, 110.0, 400.0}));
        originPointList.add(new PVTPoint(new Double[] {700.0, 1500.0, 400.0, 350.0, 700.0, 450.0}, new Double[] {35.0, 80.0, 45.0, 250.0, 120.0, 450.0}));
        originPointList.add(new PVTPoint(new Double[] {800.0, 1700.0, 450.0, 400.0, 800.0, 500.0}, new Double[] {40.0, 90.0, 50.0, 300.0, 130.0, 500.0}));
        originPointList.add(new PVTPoint(new Double[] {900.0, 1900.0, 500.0, 450.0, 900.0, 550.0}, new Double[] {45.0, 100.0, 55.0, 350.0, 140.0, 550.0}));

        Harmonica harmonica = new Harmonica(originPointList);
        int index = 0;
        PointIterator iterator = harmonica.iterator(); //вывод списка точек в консоль
        iterator.changeSpeed(1);

        while (iterator.hasNext()){
            System.out.println(iterator.next());
           /* if(index > 3){
                iterator.changeSpeed(10);
            }*/
            index++;
        }
        System.out.println("List's length: " + harmonica.getMotorList().get(0).velocity.length);
        System.out.println("List's length: " + harmonica.getMotorList().get(1).velocity.length);
        System.out.println("List's length: " + harmonica.getMotorList().get(2).velocity.length);
        System.out.println("List's length: " + harmonica.getMotorList().get(3).velocity.length);
        System.out.println("List's length: " + harmonica.getMotorList().get(4).velocity.length);
        System.out.println("List's length: " + harmonica.getMotorList().get(5).velocity.length);
    }
}