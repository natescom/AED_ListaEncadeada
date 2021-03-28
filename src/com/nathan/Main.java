package com.nathan;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedList listita = new LinkedList();
        listita.add(3);
        listita.add(30);
        listita.add(15);
        listita.add(48);
        listita.add(400);

        printLista(listita);

        int i;
        do{
            System.out.println("Inserir na lista:");
            i = new Scanner(System.in).nextInt();
            if(i<0)
                break;
            listita.add(i);
        }while (i>=0);

        int b;
        do {
            System.out.println("Inserir tal coisa em:");
            b = new Scanner(System.in).nextInt();
            if(b<0)
                break;
            int coisa = new Scanner(System.in).nextInt();
            listita.insert(coisa,b);
        }while (b>=0);

        printLista(listita);

    }

    public static void printLista(LinkedList listita){
        for (int j = 0; j < listita.length(); j++) {
            System.out.println(j+":"+listita.getData(j));
        }
    }
}
