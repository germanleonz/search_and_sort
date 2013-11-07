public class DeterminarMaxFrec {

    /**
     * Procedimiento para llenar las casillas de un arreglo con valores
     * aleatorios
     *
     * @param a     Arreglo que se desea ordenar
     */
    private static void llenarArreglo(int[] a)
    {
       	for (int i = 0; i < a.length; i++)
       	{
            a[i] = (int)(Math.random()*a.length);
       	}
    }

    private static void imprimirArreglo(int[] a)
    {
       	for (int i = 0; i < a.length; i++)
       	{
            System.out.print(a[i] + " ");
       	}
    }

    public static void quicksort(int[] a, int izq, int der)
    {
        int puestopivote = (izq + der) / 2;
		//Poner pivote al principio del arreglo				
		int temp = a[izq];
		a[izq] = a[puestopivote];
		a[puestopivote] = temp;
		
		int ultimopeq = izq;
		int temp1 = 0;
		for ( int i = izq+1; i <= der; i++)
		{
			if (a[i] < a[izq])
			{
		    	ultimopeq++;
		       	temp1 = a[ultimopeq];
				a[ultimopeq] = a[i];
				a[i] = temp1;
			}
		}
		// Poner pivote en entre parte menor y parte mayor
		temp = a[izq];
		a[izq] = a[ultimopeq];
		a[ultimopeq] = temp;

		puestopivote = ultimopeq;
		//Ordenar parte izquierda
		if (izq < (puestopivote - 1))
		{
		        quicksort(a, izq, puestopivote-1);
		}		
		//Ordenar parte derecha
		if ((puestopivote + 1) < der) 
		{
		        quicksort(a, puestopivote+1, der);
		}
	}	

	public static int determinarMaxFrecuencia(int n, int[] a) {

		// Ordenamos el arreglo original hallar la maxF
		quicksort(a, 0 , n-1);
		//Imprimimos el arreglo ordenado
		System.out.println("\nArreglo ordenado:");
		imprimirArreglo(a);

		int maxFrec = 0;
		int i = 0;
		while (i < n && ((n-i-1) > maxFrec)) {
			int elem = a[i];
			int j = i + 1;
			int maxFrecTemp = 1;
			while (j < n && a[j] == elem) {
				maxFrecTemp++;
				j++;
			}
			if (maxFrecTemp > maxFrec) {
				maxFrec = maxFrecTemp;
			}
			i = j;
		}
		return maxFrec;
	}

	public static void main(String[] args) {
		int N = Console.readInt("Introduzca el tamaño del arreglo:");
        int[] a = new int[N];
		// Llenamos a con numeros aleatorios
		llenarArreglo(a);
		// Su arreglo original es
		System.out.println("Su arreglo original es: ");
		imprimirArreglo(a);
		// Calculamos la frecuencia maxima de algun elemento en a
		int maxF = determinarMaxFrecuencia(N, a);
		System.out.println("La maxima frecuencia de un elemento es: " +maxF);
	}
}
