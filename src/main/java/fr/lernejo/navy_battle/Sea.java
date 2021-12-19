package fr.lernejo.navy_battle;

import java.util.Arrays;

public class Sea {
    public final char[][] sea = new char[10][10];
    public Sea() {
        for (final char[] chars : sea) {
            Arrays.fill(chars, '-');
        }
    }
    public void Display(){
        System.out.println(" A B C D E F G H I J \n -------------------\n");
        int num_line = 0;
        for (final char[] line : sea){
            System.out.println(num_line+" \n");
            num_line++;
        }
        System.out.println("--------------------");
    }
}
