package edu.escuelaing.arem;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldSolveMeanFirstColumn()
    {
        MyMeanStandardLinkedList list = new MyMeanStandardLinkedList();
        list.add(160);
        list.add(591);
        list.add(114);
        list.add(229);
        list.add(230);
        list.add(270);
        list.add(128);
        list.add(1657);
        list.add(624);
        list.add(1503);
        double mean = list.calcMean();

        assertTrue( mean == 550.0 );
    }

    @Test
    public void shouldSolveStandardFirstColumn()
    {
        MyMeanStandardLinkedList list = new MyMeanStandardLinkedList();
        list.add(160);
        list.add(591);
        list.add(114);
        list.add(229);
        list.add(230);
        list.add(270);
        list.add(128);
        list.add(1657);
        list.add(624);
        list.add(1503);
        double standard = list.calcStandard();
        assertTrue( standard == 411.0960958218893 );
    }

    @Test
    public void shouldSolveMeanSecondColumn()
    {
        MyMeanStandardLinkedList list = new MyMeanStandardLinkedList();
        list.add(15.0);
        list.add(69.9);
        list.add(6.5);
        list.add(22.4);
        list.add(28.4);
        list.add(65.9);
        list.add(19.4);
        list.add(198.7);
        list.add(38.8);
        list.add(138.2);
        double mean = list.calcMean();
        assertTrue( mean == 59.0 );
    }


    @Test
    public void shouldSolveStandardSecondColumn()
    {
        MyMeanStandardLinkedList list = new MyMeanStandardLinkedList();
        list.add(15.0);
        list.add(69.9);
        list.add(6.5);
        list.add(22.4);
        list.add(28.4);
        list.add(65.9);
        list.add(19.4);
        list.add(198.7);
        list.add(38.8);
        list.add(138.2);
        double standard = list.calcStandard();
        assertTrue( standard ==  46.380072349136235);
    }

}
