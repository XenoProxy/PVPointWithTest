import java.util.Arrays;

public class PVPoint{
    double[] position;
    double[] velocity;

    public PVPoint(double[] position, double[] velocity)
    {
            this.position = position.clone();
            this.velocity = velocity.clone();
    }

    @Override
    public String toString(){
        return "positions:" + Arrays.toString(this.position) + " velocities:" + Arrays.toString(this.velocity);
    }

}

