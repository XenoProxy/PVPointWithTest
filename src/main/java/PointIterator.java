import java.util.Iterator;
import java.util.NoSuchElementException;

public class PointIterator<Double> implements Iterator<Double> {
    private int index;
    private int speed;
    private Double[] pointList;

    public PointIterator(Double[] pointList){
        this.pointList = pointList;
    }

    public boolean hasNext() {
        if(index < pointList.length){
            return true;
        }else {
            return false;
        }
    }

    public Double next() {
        if(this.hasNext()) {
            return pointList[index += speed];
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