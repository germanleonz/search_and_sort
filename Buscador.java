/**
 * Archivo: BusquedaBinaria.java
 *
 * Descripcion: Implementacion en Java de los algoritmos
 *              busqueda Lineal y busqueda binaria sobre
 *              un arreglo de enteros
 *
 * Autor: German Leon
 */

import java.util.Scanner;

public class Buscador {
    public boolean busquedaBinaria (int []a, int e) {
        boolean esta = false;
        int inf      = 0;
        int sup      = a.length;
        int k        = 0;
        int m        = (sup + inf) / 2;

        while (sup!=inf && !esta) {
            if (a[m] > e) {
                sup = m;
            }
            else if (a[m] < e) {
                inf = m + 1;
            }
            else {
                esta = true;
                sup  = inf;
            }
            m = (sup + inf) / 2;
        }
        return esta;
    }

    public boolean busquedaLineal(int []a, int e) {
        boolean esta = false;
        int N        = a.length;
        int k        = 0;

        while (!esta && k < N) {
            if (a[k] == e) {
                esta = true;
            }
            k++;
        }
        return esta;
    }

    public static void main(String[] args) {
        Buscador b = new Buscador();
        Scanner sc = new Scanner(System.in);

        System.out.print("Tamaño del arreglo: ");
        int N   = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < a.length; i++) {
            System.out.print("Introduzca el numero a[" + i + "]: ");
            a[i] = sc.nextInt();
        }

        System.out.print("Que numero desea buscar?: ");
        int e = sc.nextInt();
        if (b.busquedaLineal(a, e)) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
}
