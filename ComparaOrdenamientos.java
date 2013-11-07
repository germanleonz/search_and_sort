/**
 * Archivo: ComparaOrdenamientos.java
 *
 * Descripcion: Implementacion en Java/JML de un programa que compare
 *              la eficiencia de los algoritmos de ordenamiento por insercion,
 *              seleccion, burbuja, mergesort, heapsort y Quicksort.
 *
 * Autor: German Leon
 */

import algoritmosOrdenamiento.*;

public class ComparaOrdenamientos {
    /**
     * Procedimiento para llenar las casillas de un arreglo con valores
     * aleatorios
     *
     * @param a     Arreglo que se desea ordenar
     */
    private static void llenararreglo(int[] a)
    {
       	for (int i = 0; i < a.length; i++)
       	{
            a[i] = (int)(Math.random()*a.length);
       	}
    }

    /**
     * Procedimiento para copiar los valores de las casillas de un arreglo
     * en un nuevo arreglo
     *
     * @param a     Arreglo que se desea copiar
     * @param b     Arreglo clon del primero
     */
    private static void copiaraenb(int[] a, int[] b)
    {
        for (int i = 0; i < a.length; i++)
        {
            b[i] = a[i];
        }
    }	

    /**
     * Programa cliente
     */
    public static void main(String[] args)
    {
        int[] tamanos = new int[5];
		tamanos[0] = 4000;
		tamanos[1] = 10000;
		tamanos[2] = 20000;
		tamanos[3] = 30000;
		tamanos[4] = 50000;
		
		for(int i = 0; i < tamanos.length; i++)
		{			
            int[] a = new int[tamanos[i]];
            int[] b = new int[tamanos[i]];
            int[] c = new int[tamanos[i]];
            int[] d = new int[tamanos[i]];
            int[] e = new int[tamanos[i]];
            int[] f = new int[tamanos[i]];
          
            // Lleno el arreglo "a" con valores aleatorios
            llenararreglo(a);
		
            // Hago copias del arreglo original "a"
            copiaraenb(a,b);
            copiaraenb(a,c);
            copiaraenb(a,d);
            copiaraenb(a,e);
            copiaraenb(a,f);

			int izq = 0;
            int der = (tamanos[i]-1);
			
			System.out.println("\nARREGLO NUMERO 0"+(i+1));		
			
            // Mido el tiempo del ordenamiento por Quicksort y lo imprimo por pantalla
            long tiempoInicio1 = System.currentTimeMillis();
            Quicksort.quicksort(a, izq, der);
            long tiempoquicksort = System.currentTimeMillis() - tiempoInicio1;
            System.out.println("\nQuicksort: el programa tardo " 
                              + tiempoquicksort
                              + " milisegundos en ordenar el arreglo numero 0"
                              + (i+1));

            // Mido el tiempo del ordenamiento por mezcla y lo imprimo por pantalla
            long tiempoInicio2 = System.currentTimeMillis();
	    	OrdenaMezcla.ordenaMezcla(b, izq, der);
            long tiempomezcla = System.currentTimeMillis() - tiempoInicio2;
            System.out.println("\nMezcla: el programa tardo "
                              + tiempomezcla
                              + " milisegundos en ordenar el arreglo numero 0"
                              +(i+1));
            /*
            // Mido el tiempo del ordenamiento por Heapsort y lo imprimo por pantalla
            long tiempoInicio3 = System.currentTimeMillis();
	    	Heapsort.heapsort(c);
            long tiempoheapsort = System.currentTimeMillis() - tiempoInicio3;
            System.out.println("\nHeapsort: el programa tardo "
							  + tiempoheapsort 
							  + " milisegundos en ordenar el arreglo numero 0"
							  +(i+1));
            */

            // Mido el tiempo del ordenamiento por insercion y lo imprimo por pantalla
            long tiempoInicio4 = System.currentTimeMillis();
            OrdenaInsercion.ordenaInsercion(d);
            long tiempoinsercion = System.currentTimeMillis() - tiempoInicio4;
            System.out.println("\nInsercion: el programa tardo "
                              + tiempoinsercion
                              + " milisegundos en ordenar el arreglo numero 0"
                              + (i+1));

            // Mido el tiempo del ordenamiento por seleccion y lo imprimo por pantalla
            long tiempoInicio5 = System.currentTimeMillis();
	    	OrdenaSeleccion.ordenaSeleccion(e);
            long tiemposeleccion = System.currentTimeMillis() - tiempoInicio5;
            System.out.println("\nSeleccion: el programa tardo "
                              + tiemposeleccion
                              + " milisegundos en ordenar el arreglo numero 0"
                              + (i+1));
			
            // Mido el tiempo del ordenamiento por burbuja y lo imprimo por pantalla
            long tiempoInicio6 = System.currentTimeMillis();
            OrdenaBurbuja.ordenaBurbuja(f);
            long tiempoburbuja = System.currentTimeMillis() - tiempoInicio6;
            System.out.println("\nBurbuja: el programa tardo "
                              + tiempoburbuja
                              + " milisegundos en ordenar el arreglo numero 0"
                              + (i+1));
			/*
			// Mido el tiempo del ordenamiento por Quicksort BL y lo imprimo por pantalla
            long tiempoInicio7 = System.currentTimeMillis();
			QuicksortBL.quicksort(a, izq, der);
            long tiempoquicksortBL = System.currentTimeMillis() - tiempoInicio7;
            System.out.println("\nQuicksort BL: el programa tardo " 
                              + tiempoquicksortBL
                              + " milisegundos en ordenar el arreglo numero 0"
                              + (i+1));
			*/
        }
		System.out.println();
    }
}
