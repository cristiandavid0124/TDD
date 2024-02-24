package edu.eci.cvds.tdd;

import org.junit.Assert;
import org.junit.Test;
import edu.eci.cvds.tdd.aerodescuentos.CalculadorDescuentos;

import static org.junit.Assert.assertThrows;

public class TarifasTest {
    @Test
    public void Should_ThrowException_When_BaseRateLessThanOne() {
        Assert.assertThrows(IllegalArgumentException.class, () -> CalculadorDescuentos.calculoTarifa(0, 10, 18));
    }

    @Test
    public void Should_CalculateRate_When_BaseRateEqualToOne(){
        double rate = CalculadorDescuentos.calculoTarifa(1, 10, 18);
        Assert.assertEquals(1, rate, 0.0001);
    }

    @Test
    public void Should_CalculateRate_When_BaseRateGraterThanOne(){
        double rate = CalculadorDescuentos.calculoTarifa(2, 10, 18);
        Assert.assertEquals(2, rate, 0.0001);
    }

    @Test
    public void Should_ThrowException_When_DaysInAdvanceLessThanZero() {
        Assert.assertThrows(IllegalArgumentException.class, () -> CalculadorDescuentos.calculoTarifa(1, -1, 18));
    }

    @Test
    public void Should_CalculateRate_When_DaysInAdvanceEqualToZero(){
        double rate = CalculadorDescuentos.calculoTarifa(1, 0, 18);
        Assert.assertEquals(1, rate, 0.0001);
    }

    @Test
    public void Should_CalculateRate_When_DaysInAdvanceGraterThanZero(){
        double rate = CalculadorDescuentos.calculoTarifa(1, 1, 18);
        Assert.assertEquals(1, rate, 0.0001);
    }

    @Test
    public void Should_ThrowException_When_AgeLessThanZero() {
        Assert.assertThrows(IllegalArgumentException.class, () -> CalculadorDescuentos.calculoTarifa(1, 1, -1));
    }

    @Test
    public void Should_CalculateRateWithDiscount_When_AgeEqualToZero(){
        double rate = CalculadorDescuentos.calculoTarifa(1, 1, 0);
        Assert.assertEquals(0.95, rate, 0.0001);
    }

    @Test
    public void Should_CalculateRateWithDiscount_When_AgeGreaterThanZero(){
        double rate = CalculadorDescuentos.calculoTarifa(1, 1, 1);
        Assert.assertEquals(0.95, rate, 0.0001);
    }

    @Test
    public void Should_ThrowException_When_AgeGreaterThan135() {
        Assert.assertThrows(IllegalArgumentException.class, () -> CalculadorDescuentos.calculoTarifa(1, 1, 136));
    }

    @Test
    public void Should_CalculateRateWithDiscount_When_AgeEqualTo135(){
        double rate = CalculadorDescuentos.calculoTarifa(1, 1, 135);
        Assert.assertEquals(0.92, rate, 0.0001);
    }

    @Test
    public void Should_CalculateRateWithDiscount_When_AgeELessThan135(){
        double rate = CalculadorDescuentos.calculoTarifa(1, 1, 134);
        Assert.assertEquals(0.92, rate, 0.0001);
    }

    @Test
    public void Should_CalculateRateWithDiscount_When_AgeELessThan18(){
        double rate = CalculadorDescuentos.calculoTarifa(1, 1, 17);
        Assert.assertEquals(0.95, rate, 0.0001);
    }

    @Test
    public void Should_CalculateRate_When_AgeEqualTo18(){
        double rate = CalculadorDescuentos.calculoTarifa(1, 1, 18);
        Assert.assertEquals(1, rate, 0.0001);
    }

    @Test
    public void Should_CalculateRate_When_AgeGreaterThan18(){
        double rate = CalculadorDescuentos.calculoTarifa(1, 1, 19);
        Assert.assertEquals(1, rate, 0.0001);
    }

    @Test
    public void Should_CalculateRate_When_AgeLessThan65(){
        double rate = CalculadorDescuentos.calculoTarifa(1, 1, 65);
        Assert.assertEquals(1, rate, 0.0001);
    }

    @Test
    public void Should_CalculateRate_When_AgeEqualTo65(){
        double rate = CalculadorDescuentos.calculoTarifa(1, 1, 65);
        Assert.assertEquals(1, rate, 0.0001);
    }

    @Test
    public void Should_CalculateRateWithDiscount_When_AgeGreaterThan65(){
        double rate = CalculadorDescuentos.calculoTarifa(1, 1, 66);
        Assert.assertEquals(0.92, rate, 0.0001);
    }

    @Test
    public void Should_CalculateRate_When_DaysInAdvanceLessThan20(){
        double rate = CalculadorDescuentos.calculoTarifa(1, 19, 18);
        Assert.assertEquals(1, rate, 0.0001);
    }

    @Test
    public void Should_CalculateRate_When_DaysInAdvanceEqualTo20(){
        double rate = CalculadorDescuentos.calculoTarifa(1, 20, 18);
        Assert.assertEquals(1, rate, 0.0001);
    }

    @Test
    public void Should_CalculateRateWithDiscount_When_DaysInAdvanceGreaterThan20(){
        double rate = CalculadorDescuentos.calculoTarifa(1, 21, 18);
        Assert.assertEquals(0.85, rate, 0.0001);
    }

    @Test
    public void Should_CalculateRateWithDiscount_When_DaysInAdvanceGreaterThan20AndAgeLessThan18(){
        double rate = CalculadorDescuentos.calculoTarifa(1, 21, 17);
        Assert.assertEquals(0.8, rate, 0.0001);
    }

    @Test
    public void Should_CalculateRateWithDiscount_When_DaysInAdvanceGreaterThan20AndAgeGreaterThan65(){
        double rate = CalculadorDescuentos.calculoTarifa(1, 21, 66);
        Assert.assertEquals(0.77, rate, 0.0001);
    }

}
