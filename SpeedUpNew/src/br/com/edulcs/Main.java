package br.com.edulcs;

import java.util.Scanner;

public class Main {

    public static long[] numeros = {7, 37, 8431, 13033, 524287, 664283, 3531271, 2147483647};

    public static void main(String[] args) {

        System.out.println("Selecione uma opção: ");
        System.out.println("1 - Algoritmo 1");
        System.out.println("2 - Algoritmo 2");
        System.out.println("3 - Algoritmo 3\n");

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        switch (n){
            case 1 -> algoritmo1();
            case 2 -> algoritmo2();
            case 3 -> algoritmo3();
        }

    }

    public static void algoritmo1(){

        System.out.println("==========================");
        System.out.println("Utilizando o Algoritmo 1\n");

        for(long numero:numeros){
            if(testaPrimoEx(numero)){
                System.out.printf("O número %d é primo.\n", numero);
            } else{
                System.out.printf("O número %d NÃO é primo.\n", numero);
            }
        }

    }
    public static void algoritmo2(){

        System.out.println("==========================");
        System.out.println("Utilizando o Algoritmo 2\n");

        for(long numero:numeros){
            if(testaPrimoTwo(numero)){
                System.out.printf("O número %d é primo.\n", numero);
            } else{
                System.out.printf("O número %d NÃO é primo.\n", numero);
            }
        }

    }

    public static void algoritmo3(){

        System.out.println("==========================");
        System.out.println("Utilizando o Algoritmo 3\n");

        for(long numero:numeros){
            if(testaPrimoThree(numero, 2)){
                System.out.printf("O número %d é primo.\n", numero);
            } else{
                System.out.printf("O número %d NÃO é primo.\n", numero);
            }
        }

    }



    public static boolean testaPrimoEx(long n) {

        long tempoInicial = System.currentTimeMillis();

        boolean EhPrimo = true;
        int d = 2;
        if (n <= 1)
            EhPrimo = false;

        while (EhPrimo == true && d <= n /2) {
            if (n % d  == 0)
                EhPrimo = false;
            d = d + 1;
        }

        System.out.println("O algoritmo testaPrimoEx foi executado em: " + (System.currentTimeMillis() - tempoInicial) + "ms");

        return EhPrimo;
    }

    public static boolean testaPrimoTwo(long n){

        long tempoInicial = System.currentTimeMillis();

        // Verifique se o número é menor que
        // igual a 1
        if (n <= 1) {
            System.out.println("O algoritmo testaPrimoTwo foi executado em: " + (System.currentTimeMillis() - tempoInicial) + "ms");
            return false;
        }
        // Verifique se o número é 2
        else if (n == 2) {
            System.out.println("O algoritmo testaPrimoTwo foi executado em: " + (System.currentTimeMillis() - tempoInicial) + "ms");
            return true;
        }
        // Verifique se n é um múltiplo de 2
        else if (n % 2 == 0) {
            System.out.println("O algoritmo testaPrimoTwo foi executado em: " + (System.currentTimeMillis() - tempoInicial) + "ms");
            return false;
        }


        // Caso contrário, verifique as probabilidades
        for (int i = 3; i <= Math.sqrt(n); i += 2)
        {
            if (n % i == 0) {
                System.out.println("O algoritmo testaPrimoTwo foi executado em: " + (System.currentTimeMillis() - tempoInicial) + "ms");
                return false;
            }

        }
        System.out.println("O algoritmo testaPrimoTwo foi executado em: " + (System.currentTimeMillis() - tempoInicial) + "ms");
        return true;

    }

    public static boolean testaPrimoThree(long n, int i){

        long tempoInicial = System.currentTimeMillis();

        if(n >= 2147483647)
            n = (long) Math.sqrt(n);

        // Base cases
        if (n <= 2) {
            System.out.println("O algoritmo testaPrimoThree foi executado em: " + (System.currentTimeMillis() - tempoInicial) + "ms");
            return (n == 2) ? true : false;
        }
        if (n % i == 0) {
            System.out.println("O algoritmo testaPrimoThree foi executado em: " + (System.currentTimeMillis() - tempoInicial) + "ms");
            return false;
        }
        if (i * i > n) {
            System.out.println("O algoritmo testaPrimoThree foi executado em: " + (System.currentTimeMillis() - tempoInicial) + "ms");
            return true;
        }

        // Check for next divisor
        return testaPrimoThree(n, i + 1);

    }
}
