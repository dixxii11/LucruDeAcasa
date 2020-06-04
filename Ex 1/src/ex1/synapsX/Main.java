package ex1.synapsX;

import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        String str = "                    apples, pears # and bananas\ngrapes\nbananas !apples";
        String[] markers = {"#", "!"};

        Function f = new Function();

        System.out.println(str);
        System.out.println("-----------");
        System.out.println(f.solution(str, markers));
    }
}
