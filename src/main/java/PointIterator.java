import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PointIterator<PVTPoint> implements Iterator {
    private int index;
    private double speed;
    private List<PVTPoint> pointList;

    public PointIterator(List<PVTPoint> list){
        this.pointList = list;
    }

    public boolean hasNext() {
        if(index < pointList.size()){ return true;
        }else {
            return false;
        }
    }

    public PVTPoint next() {
        if(this.hasNext()) {
            return pointList.get(index++);
        }else {
            return null;
        }
    }

    public double changeSpeed(double speed){
        this.speed = speed;
        return speed;
    }

    public void remove() {

    }
}