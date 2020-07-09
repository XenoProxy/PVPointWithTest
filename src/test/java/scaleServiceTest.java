/*
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class scaleServiceTest {
    ScaleService scale = new ScaleService();
    @BeforeEach
    public void setUp(){
        scale.setListLength(scale.createPointList().size());
        scale.setInputPoints(scale.createPointList());
    }

    @Test
    public void isCreateScaleService(){
        assertNotNull(scale);
    }

    @Test
    public void getInputPoints() {
        ArrayList<Integer> listInput = new ArrayList<Integer>();
        listInput.add(0);
        listInput.add(100);
        listInput.add(200);
        listInput.add(300);
        listInput.add(400);
        String expectedInput = listInput.toString();
        assertEquals(expectedInput, scale.getInputPoints());
    }

    @Test
    public void getListLength() {
        int expectedArrayLength = 5;
        assertEquals(expectedArrayLength, scale.getListLength());
    }

    @Test
    void scaleService100() {
        ArrayList<Integer> listExpected = new ArrayList<Integer>();
        SpeedPlan speed = new SpeedPlan();
        speed.setSpeed(100);
        listExpected.add(0);
        listExpected.add(100);
        listExpected.add(200);
        listExpected.add(300);
        listExpected.add(400);
        String expectedPoints = listExpected.toString();
        String actualPoints = scale.scaleService(speed.getSpeed());
        assertEquals(expectedPoints, actualPoints);
    }
    @Test
    void scaleService50() {
        ArrayList<Integer> listExpected = new ArrayList<Integer>();
        SpeedPlan speed = new SpeedPlan();
        speed.setSpeed(50);
        listExpected.add(0);
        listExpected.add(50);
        listExpected.add(100);
        listExpected.add(150);
        listExpected.add(200);
        listExpected.add(250);
        listExpected.add(300);
        listExpected.add(350);
        listExpected.add(400);
        String expectedPoints = listExpected.toString();
        String actualPoints = scale.scaleService(speed.getSpeed());
        assertEquals(expectedPoints, actualPoints);
    }
    @Test
    void scaleService200() {
        ArrayList<Integer> listExpected = new ArrayList<Integer>();
        SpeedPlan speed = new SpeedPlan();
        speed.setSpeed(200);
        listExpected.add(0);
        listExpected.add(200);
        listExpected.add(400);
        String expectedPoints = listExpected.toString();
        String actualPoints = scale.scaleService(speed.getSpeed());
        assertEquals(expectedPoints, actualPoints);
    }
}*/
