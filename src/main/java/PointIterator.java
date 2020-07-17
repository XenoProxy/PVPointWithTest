import java.util.Iterator;

public class PointIterator<Double> implements Iterator {
    private int index;
    private Double[] pointList;

    public PointIterator(Double[] pointList){
        this.pointList = pointList;
    }

    public boolean hasNext() {
        if(index < pointList.length){ return true;
        }else {
            return false;
        }
    }

    public Double next() {
        if(this.hasNext()) {
            return pointList[index++];
        }else {
            return null;
        }
    }

    public void remove() {

    }
}