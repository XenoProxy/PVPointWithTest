import java.util.ArrayList;
import java.util.List;

public class PointIterator implements Iterator<PVPoint>{
    private int index;
    private List<PVPoint> pointList;
    private  double speed;

    public PointIterator(List<PVPoint> list, double speed){
        this.pointList = list;
        this.speed = speed;
    }

    public boolean hasNext() {
        if(index < pointList.size()){ return true;
        }else {
            return false;
        }
    }

    public PVPoint next() {
        if(this.hasNext()) {
            return pointList.get(index++);
        }else {
            return null;
        }
    }
}
