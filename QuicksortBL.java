public class QuicksortBL {
	// algoritmo de ordenamiento por quicksort del libro de barbara liskov
	// "program development in java"
	private static void llenararreglo(int[] a) {
       	for (int i=0; i<a.length; i++) {
			a[i]= (int)(Math.random()*a.length);
       	}
   	}

	private static void imprimirarreglo(int []a) {
    	for (int i=0; i<a.length; i++) {
        	System.out.print(a[i] + ", ");
		}
    }
	
	public static void quicksort(int[] a,int izq, int der) {
		// REQUIRES:
		// MODIFIES: a
		// EFFECTS : 
		if (izq >= der) return;
		int mid = partition(a,izq,der);
		quicksort(a,izq,mid);
		quicksort(a,mid+1,der);
	}

	public static int partition(int[] a, int i, int j) {
		// REQUIRES: 
		// MODIFIES: a
		// EFFECTS : 
		int x = a[i];
		while (true)
		{
			while (a[j] > x) j--;
			while (a[i] < x) i++;
			if (i < j)
			{
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				j--;
				i++;
			}
			else return j;
		}
	}

	public static void main (String[] args) {
		System.out.println("\nORDENAMIENTO POR QUICKSORT");        	
		int N = Console.readInt("\nIntroduzca el tamaño del arreglo:");
	    int[] a = new int[N];
		int izq = 0;
		int der = N-1;
	
		//Genero valores aleatorios para llenar las casillas del arreglo "a"        
		llenararreglo(a);

		//Imprimo el arreglo original
        System.out.println("\nEl arreglo original es:");
        imprimirarreglo(a);
		System.out.println();

		//Ordeno el arreglo utilizando Quicksort BL
		quicksort(a,izq,der);			
		
		//Imprimo el arreglo ordenado
		System.out.println("\nEl arreglo ordenado por Quicksort es:");       
        imprimirarreglo(a);
		System.out.println("\n");
	}
}
