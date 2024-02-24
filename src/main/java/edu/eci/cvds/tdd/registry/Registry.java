package edu.eci.cvds.tdd.registry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Registry {
    HashSet<Integer> voters = new HashSet<Integer>();
    public RegisterResult registerVoter(Person p) {
        if (!p.isAlive()){
            return RegisterResult.DEAD;
        }
        if (p.getAge() < 0 || p.getAge() > 135){
            return RegisterResult.INVALID_AGE;
        }
        if (p.getAge() >= 0 && p.getAge() < 18){
            return RegisterResult.UNDERAGE;
        }
        if (voters.contains(p.getId())) {
            return RegisterResult.DUPLICATED;
        }
        voters.add(p.getId());
        return RegisterResult.VALID;
    }
}
