package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();
    @Test
    public void validateRegistryResult() {
        Person person = new Person(1026222444);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }
    // TODO Complete with more test cases

    @Test
    public void validateDeadState() {
        Person person = new Person(1026222444);
        person.setAlive(false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    @Test
    public void validateStateAlive() {
        Person person = new Person(1026222444);
        person.setAlive(true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void validateUnderAgeZero() {
        Person person = new Person(1026222444);
        person.setAge(0);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void validateUnderAgeOne() {
        Person person = new Person(1026222444);
        person.setAge(1);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void validateUnderAgeSeventeen() {
        Person person = new Person(1026222444);
        person.setAge(17);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void validateInvalidAgeBigNegative() {
        Person person = new Person(1026222444);
        person.setAge(-1000);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    @Test
    public void validateInvalidAgeSmallNegative() {
        Person person = new Person(1026222444);
        person.setAge(-1);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    @Test
    public void validateInvalidAgeImpossible() {
        Person person = new Person(1026222444);
        person.setAge(136);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }


    @Test
    public void validateAgeOkInferiorLimit() {
        Person person = new Person(1026222444);
        person.setAge(18);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void validateAgeOkSmall() {
        Person person = new Person(1026222444);
        person.setAge(19);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void validateAgeOkBig() {
        Person person = new Person(1026222444);
        person.setAge(134);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void validateAgeOkSuperiorLimit() {
        Person person = new Person(1026222444);
        person.setAge(135);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void validateSamePersonVoteTwice() {
        Person person = new Person(1026222444);

        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);

        RegisterResult result2 = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DUPLICATED, result2);
    }

    @Test
    public void validateTwoDifferentVotes() {
        Person person = new Person(1026222444);

        Person person2 = new Person(1026222445);

        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);

        RegisterResult result2 = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.VALID, result2);
    }
}
