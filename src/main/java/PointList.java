import java.util.ArrayList;
import java.util.List;

public class PointList {
    public List<PVPoint> createPointList(){
        List<PVPoint> listPoint = new ArrayList<PVPoint>();
        listPoint.add(new PVPoint(new double[] {0, 100, 50, 0, 0, 100}, new double[] {0, 10, 10, 0, 50, 100}));
        listPoint.add(new PVPoint(new double[] {100, 300, 100, 50, 100, 150}, new double[] {5, 20, 15, 50, 60, 150}));
        listPoint.add(new PVPoint(new double[] {200, 500, 150, 100, 200, 200}, new double[] {10, 30, 20, 100, 70, 200}));
        listPoint.add(new PVPoint(new double[] {300, 700, 200, 150, 300, 250}, new double[] {15, 40, 25, 150, 80, 250}));
        listPoint.add(new PVPoint(new double[] {400, 900, 250, 200, 400, 300}, new double[] {20, 50, 30, 200, 90, 300}));
        listPoint.add(new PVPoint(new double[] {500, 1100, 300, 250, 500, 350}, new double[] {25, 60, 35, 150, 100, 350}));
        listPoint.add(new PVPoint(new double[] {600, 1300, 350, 300, 600, 400}, new double[] {30, 70, 40, 200, 110, 400}));
        listPoint.add(new PVPoint(new double[] {700, 1500, 400, 350, 700, 450}, new double[] {35, 80, 45, 250, 120, 450}));
        listPoint.add(new PVPoint(new double[] {800, 1700, 450, 400, 800, 500}, new double[] {40, 90, 50, 300, 130, 500}));
        listPoint.add(new PVPoint(new double[] {900, 1900, 500, 450, 900, 550}, new double[] {45, 100, 55, 350, 140, 550}));
        return  listPoint;
    }
}
