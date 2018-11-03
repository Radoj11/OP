package testPkg;

import agh.cs.lab2.MoveDirection;

import java.util.*;

public class streamsTests {

    public static void main(String[] args){
        List<String> my = new ArrayList<>(Arrays.asList(args));
        cosTam(my);
    }

    public static void cosTam(List<String> dirsony){
        Set<String> set = mkTypes();
        dirsony
                .stream()
                .filter( s -> set.contains(s))
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);
    }

    public static Set<String> mkTypes(){
       Set<String> newS = new HashSet<>();
       newS.add("f");
       newS.add("forward");
       newS.add("backward");
       newS.add("b");
       newS.add("r");
       newS.add("right");
       newS.add("l");
       newS.add("left");
       return newS;
    }
}
