import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class PointIterator<PVTPoint> implements Iterator<PVTPoint> {
    private int index;
    private int speed;
    private List<PVTPoint> pointList;

    public PointIterator(List<PVTPoint> pointList){
        this.pointList = pointList;
    }

    public boolean hasNext() {
        if(index + speed < pointList.size()){
            return true;
        }else {
            return false;
        }
    }

    public PVTPoint next() {
        if(this.hasNext()) {
            PVTPoint result = pointList.get(index);
            index += speed;
            return result;
        }else {
            throw new NoSuchElementException();
        }
    }

    public void changeSpeed(int speed){
        this.speed = speed;
    }

    public void remove() {
    }
}