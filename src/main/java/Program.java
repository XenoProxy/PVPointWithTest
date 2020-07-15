import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) throws Exception {
        PointList pointList = new PointList();
        PointEnumeration enumeration = new PointEnumeration(pointList);
        int i = 0;
        PointIterator iterator = pointList.iterator(); //вывод списка точек в консоль
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            if(i>3){
                iterator.changeSpeed(200);
            }
            i++;
        }
    }


}
