package framework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayCadastro {

    public static void main (String[]args){
        Scanner read = new Scanner(System.in);

        ArrayList<String> sDirector = new ArrayList();

        sDirector.add("Steven Spielbelg;18/12/1946;Jurassic Park;1993");
        sDirector.add("David Yates;08/10/1963;Harry Potter;2007");
        sDirector.add("Lilly Wachowski;29/12/1967;1999");
        sDirector.add("Joss Whedon;23/06/1964;Os Vingadores;2012");

        int i;

        System.out.println("Percorrendo o Array List (usando o índice)\n");
        int n = sDirector.size();
        for (i = 0;i < n; i++){
            System.out.printf("Posição %d- %s\n", i, sDirector.get(i));
        }
        System.out.println("\nInforme a posição a ser excluída:\n");
        i = read.nextInt();

        try{
            sDirector.remove(i);
        } catch (IndexOutOfBoundsException e){
            System.out.printf("\nErro: posição inválida (%s).",e.getMessage());
        }

        System.out.printf("\nPercorrendo o ArrayList (usando for-each)\n");
        i = 0;
        for (String contato : sDirector){
            System.out.printf("Posição %d %s\n",i,contato);
            i++;
        }

        System.out.printf("\nPercorrendo o Array List (usando for-each)\n");
        i = 0;
        Iterator<String> iterator = sDirector.iterator();
        while (iterator.hasNext()){
            System.out.printf("Posição %d- %s\n",i,iterator.hasNext());
            i++;
        }

    }
}
