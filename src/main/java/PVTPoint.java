import java.util.Arrays;

public class PVTPoint{
    double[] position;
    double[] velocity;

    public PVTPoint(double[] position, double[] velocity)
    {
        this.position = position.clone();
        this.velocity = velocity.clone();
    }

    @Override
    public String toString(){
        return "positions of motor:" + Arrays.toString(this.position) + " velocities of motor:" + Arrays.toString(this.velocity);
    }

}