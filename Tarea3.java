import Quicksort;
import OrdenaMezcla;

public class Tarea3
{
	private static void llenararreglo(int[] a)
	{
        	for (int i=0; i<a.length; i++)
        	{
            		a[i]= (int)(Math.random()*a.length);
        	}
    	}	

	private static void imprimirarreglo(int []a)
    	{
        for (int i=0; i<a.length; i++)
            {
                System.out.print(a[i] + ", ");
            }
    	}
		
	private static void intercambiar(int[] a,int i,int j)
	{
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}

	private static void copiaraenb(int[] a, int[] b)
	{
		for (int i=0; i<a.length;i++)
		{
			b[i]=a[i];
		}
	}

	public static int[] permutaciones(int N,int[] a, int i) 	
	{
		int[] perm = new int [a.length];
		if (i!=N) 
		{
			int j=i; 
			while (j<N) 
			{
				intercambiar(a,i,j);
				if (j==a.length-1)
				{
					copiaraenb(a,perm);
					int k=0;
					while( k<a.length/2)
					{	
						int l=a.length-1;
						for (l; l>(a.length/2); l--)
						{
							intercambiar(perm,k,l);
							k++;
						}
					}		                
				}
				permutaciones(N, a, i+1);
				intercambiar(a,i,j);
				j++;
				if (j<a.length)
				{
				copiaraenb(a,perm);
				}		                
	                }
	        }	 
		return perm;
	}

	public static void main(String[] args)
	{
		int[] pruebas = new int[6];
		pruebas[0]=10;
		pruebas[1]=11;	
		pruebas[2]=12;
		pruebas[3]=13;
		pruebas[4]=14;
		pruebas[5]=15;

		for(int i=0; i<pruebas.length; i++)
		{
			int[] a = new int[pruebas[i]];
			int[] ap = new int[pruebas[i]];
			int[] bp = new int[pruebas[i]];
			int izq=0;
			int der=pruebas[i]-1;			
			llenararreglo(a);
			System.out.println("\nARREGLO NUMERO 0"+(i+1));
			System.out.println("\nEl arreglo original es:");
			imprimirarreglo(a);
			System.out.println();
			
			// Genero una permutacion de dicho arreglo y hago una copia de ella
			ap = permutaciones(pruebas[i],a,pruebas[i]-2);
			copiaraenb(ap,bp);
			System.out.println("\nLa permutacion de este arreglo es:");
			imprimirarreglo(ap);

			// Mido el tiempo del ordenamiento por Quicksort			
			long tiempoInicio1 = System.currentTimeMillis();
			Quicksort.quicksort(ap,izq,der); 
			long tiempoquicksort = System.currentTimeMillis() - tiempoInicio1;
			System.out.println("\nQuicksort: el programa tardo "+ tiempoquicksort + " milisegundos en ordenar el arreglo 0"+(i+1));
			
			// Mido el tiempo del ordenamiento por mezcla
			long tiempoInicio2 = System.currentTimeMillis();
			OrdenaMezcla.ordenamezcla(bp,izq,der);			
			long tiempomezcla = System.currentTimeMillis() - tiempoInicio2;
			System.out.println("Mezcla: el programa tardo "+ tiempomezcla + " milisegundos en ordenar el arreglo 0"+(i+1));

			// Imprimo la suma del tiempo de los dos algoritmos 				
			System.out.println("La suma de ambos tiempos es:"+ (tiempomezcla+tiempoquicksort));   	
		}
		System.out.println();
	}
}		
