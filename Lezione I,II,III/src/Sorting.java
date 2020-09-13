public class Sorting {
	
	public static void main(String[] args) {
		int n=30;
		int[] A=new int[n];
		for(int i=0;i<n;i++){
			A[i]=(int)(Math.random()*100);
		}

		Sorting.stampa(A);
		Sorting.bubbleSortUS(A);//chiamata ad uno dei metodi successivi
		Sorting.stampa(A);

/*		Per utilizzare ShellSort:
*		
*		int[] p={12,7,5,3,1};// ad esempio...
*		Sorting.shellSort(p,v); //oppure shell.Sort2(p,v);
*		Sort.stampa(A);
*/


	}
	

//BUBBLE SORT E SUE VARIANTI
	
	public static void bubbleSort(int[] v){
		int i,j;
		for(i=v.length-1;i>=1;i--){
			for(j=1;j<=i;j++){
				if(v[j-1]>v[j]){
					scambia(v,j-1,j);
				//vedi in fondo al file.
				}
			}
		}
	}
		
	public static void bubbleSort_2(int[] v){ // BubbleSort con Flag
		int i,j;
		for(i=v.length-1;i>=1;i--){
			boolean scambiAvvenuti=false;
			for(j=1;j<=i;j++){
				if(v[j-1]>v[j]){
					scambia(v,j-1,j);
					scambiAvvenuti=true;
				}
			}
			if(scambiAvvenuti==false){ //oppure if (!scambiAvvenuti)
				break;
			}		
		}
	}
	
	public static void bubbleSortRicorsivo(int[] v, int n)	{
		//n e' la dimensione di A. Serve per la ricorsione
		if (n==1)
			return;
		
		boolean scambiAvvenuti;
		scambiAvvenuti=false;
		for(int j=1;j<=n-1;j++){
			if(v[j-1]>v[j]){
				scambia(v,j-1,j);
				scambiAvvenuti=true;
			}
		}
	//	stampa(v);
		if(scambiAvvenuti==true){
			bubbleSortRicorsivo(v,n-1);
		}
	}
	
	public static void bubbleSortUS(int[] v){
		/*Si memorizza la posizione dell'Ultimo Scambio avvenuto.
		 * Da li' in poi il'array e' ordinato 
		 */
		int j, fine, ultimoScambio;
		fine=v.length-1;
		for(int i=fine;i>=1;i--){
 			ultimoScambio=0;
			for(j=1;j<=fine;j++){
				if(v[j-1]>v[j]){
					scambia(v,j-1,j);
					ultimoScambio=j;
				}	
			}
			fine=ultimoScambio;
		}
	}

	public static void shakerSort(int[] v) {
		int inizio=0;			//inizio e fine saranno incrementati e decrementato dopo ogni scansione
		int fine=v.length-1;
		
		for(int j=1;j<=v.length-1;j++) {// il numero di iterazioni è lo stesso del bubble Sort normale
			boolean scambiAvvenuti=false;
			for(int i=inizio+1;i<=fine;i++) {
				if(v[i-1]>v[i]) {
					scambia(v,i-1,i);
					scambiAvvenuti=true;
				}
			}
			stampa(v);
			if(!scambiAvvenuti){
				System.out.println("Qui\n");	
				break;
			}
			
			scambiAvvenuti=false;
			fine--;// il MAX ha raggiunto la fine, quindi la decremento
			for(int i=fine;i>=inizio+1;i--) {
				if(v[i-1]>v[i]) {
					scambia(v,i-1,i);
					scambiAvvenuti=true;
				}	
			}
			stampa(v);
			if(!scambiAvvenuti){
				System.out.println("qui\n");	
				break;
			}	
			inizio++; //il MIN ha raggiunto l'inizio, quindi lo incremento.
		}
	}
	
	
	public static void shakerSort_2(int[] v){ // Bubble Sort bidirezionale
		//versione con lo while invece che col for
		int inizio=0;
		int fine=v.length-1;
		boolean scambiAvvenuti=true;
		
		while(scambiAvvenuti==true){
			scambiAvvenuti=false;
			for(int i=inizio+1;i<=fine;i++){
				if(v[i-1]>v[i]){
					scambia(v,i-1,i);
					scambiAvvenuti=true;
				}//end if
			}//end for
			if(scambiAvvenuti==false){
				break;
				//esce dallo while se non ci sono stati scambi
			}
			
//se non e' uscito, si fa l'iterazione da destra a sinistra: si ricomincia
			scambiAvvenuti=false;
	//decremento end perche' gli elementi dopo end sono gia' ordinati
			fine=fine-1;
			for(int i=fine;i>=inizio+1;i--){
				if(v[i-1]>v[i]){
					scambia(v,i-1,i);
					scambiAvvenuti=true;
				}//end if
			}//end for
	//incremento inizio poiche' gli elementi prima sono ordinati		
			inizio=inizio+1;
			if(scambiAvvenuti==false){
				break;
			}
		}
		
	}
	
	public static void combSort(int[] v){
		int passo=v.length; //inizializza il passo
		boolean scambiAvvenuti=false;
		while(passo>1 || scambiAvvenuti==true){
			//aggiorna il passo per il prossimo passaggio
			if(passo>1)
					passo=(int)(passo/1.25);
			System.out.println("passo= "+passo);
			scambiAvvenuti=false;
			for(int i=0;i+passo<=v.length-1;i++){
				if(v[i]>v[i+passo]){
					scambia(v,i,i+passo);
					scambiAvvenuti=true;
				}
			}
			//stampa(v);
		}
	}
	
	
	
//INSERTION SORT E SUE VARIANTI
public static void insertionSort(int[] v){
		int i,j,t;
		for(i=1;i<=v.length-1;i++){
			t=v[i];
			j=i;
			while(j>=1 && v[j-1]>t){
		/*
		 * Se j>=1 lo metti dopo il controllo v[j-1]>t
		 * non va bene				
		 */
				v[j]=v[j-1];
				j=j-1;
			}
			v[j]=t;
		}
	}
	
	public static void insertionSortRicorsivo(int[] v, int n){
		if (n>1){
			insertionSortRicorsivo(v,n-1);
			//ordina l'array con dimensione n-1
		}
		int value=v[n-1]; //e da qui sistemo l'n-esimo elemento
		int j=n-1;
		while (j >= 1 && v[j-1] > value){
			v[j] = v[j-1];
			j = j-1;
		}    
		v[j] = value;
	}
	
	public static void shellSort(int[] col, int[] v){
		int i,j,k,h,t;
		
		for (k=0; k<col.length; k++){			
	        h=col[k];
	        for (i=h; i<v.length; i++){
	          	t=v[i];
	            j=i;
	            while (j>=h && v[j-h]>t){
	                v[j]=v[j-h];
	                j=j-h;
	            }
	            v[j]=t;
	        }
	    }
	}
	

/* Nella versione successiva si esegue dapprima insertion sort 
su tutti glie lementi della prima colonna,
poi su tutti quella della seconda colonna, etc...
Ciò comporta un ciclo for in più,
quello con l=0 fino a l=h-1.
*/

	public static void shellSort2(int[] col, int[] v){
		int i,j,k,h,t;
		
		for (k=0; k<col.length; k++){			
	        h=col[k];
	        for(int l=0;l<=h-1;l++) {
	        	for (i=h; i<v.length; i=i+h){
	        		t=v[i];
	        		j=i;
	        		while (j>=h && v[j-h]>t){
	        			v[j]=v[j-h];
	        			j=j-h;
	        		}
	        		v[j]=t;
	        	}
	        }
	    }
	}



//SELECTION SORT	
public static void selectionSort(int[] v){
		int i,j,min;
		for (i=0;i<=v.length-2;i++){
			min=i;
			for(j=i+1;j<=v.length-1;j++)
				if(v[j]<v[min])
					min=j;
			if(min!=i){
				scambia(v,i,min);	
			}
		}
	}
	
public static void selectionSortRicorsivo(int v[], int i, int n)
	{
		// Cercare il minimo in v[i, i+1,..., n-1]
	//	if(n==1)
	//		return;
		int min = i;
		for (int j = i + 1; j < n; j++)
		{
			// se v[j] < v[min, allora si ha un nuovo minimo.
			if (v[j] < v[min])
				min = j;
		}
		
		// scambia il minimo con v[i].

		scambia(v, min, i);

		if (i <= n-2) {
			selectionSortRicorsivo(v, i + 1, n);
		}
	}

	
//METODI DI SERVIZIO
	
	public static void scambia(int[] v,int i, int j){
		int temp=v[i];
		v[i]=v[j];
		v[j]=temp;		
	}
	
	public static void stampa(int[] v){
		int i;
		for(i=0;i<v.length;i++){
			System.out.printf("%2d ",v[i]);
		}
		System.out.println();	
	}
}