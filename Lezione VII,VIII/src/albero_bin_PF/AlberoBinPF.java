package albero_bin_PF;

import java.util.*;

public class AlberoBinPF<T>{
	private NodoBinPF<T> radice;
	private int numNodi;
	private int altezza;
	private int numFoglie;//Alternativa alla gestione ricorsiva
	
	
//restituisce il numero di folgie//Alternativa alla gestione ricorsiva
	public int numFoglie() {

		return numFoglie;
	}
	
//	restituisce la radice dell'albero o null se esso e' vuoto
	public NodoBinPF<T> radice(){
		return radice;
	}
	
//	restituisce il contenuto di v
	public T info(NodoBinPF<T> v){
		return v.getInfo();
	}	

//	restituisce il numero di nodi
	public int numNodi(){
		return numNodi;
	}
	
//	restituisce l'altezza
	public int altezza(){
		return altezza;
	}
	
// 	restituisce il numero dei figli di v
	public int grado(NodoBinPF<T> v){
		if((v.getSin()!=null)&&(v.getDes()!=null))
			return 2;
		else
			if(v.getSin()!=null||v.getDes()!=null)
				return 1;
			
			
		return 0;
	}
	

//	rstiruisce il figlio sinistro di v o null se non c'e'
	public NodoBinPF<T> sin(NodoBinPF<T> v){
		return v.getSin();
	}
	
//	restituisce il figlio destro di v o null se non c'e'
	public NodoBinPF<T> des(NodoBinPF<T> v){
		return v.getDes();
	}
	
//	restituisce il padre del nodo v	
	public NodoBinPF<T> padre(NodoBinPF<T> v){
		return v.getPadre();
	}

	// restituisce il livello di un nodo
	public int livello(NodoBinPF<T> v){
		return v.livello();
	}
	

	
//	cambia il contenuto di v
	public void cambiaInfo(NodoBinPF<T> v, T info){
		v.setInfo(info);
	}
	
//	inserisce la radice in un albero vuoto e la restituisce
	public NodoBinPF<T> aggiungiRadice(T info){
		if (radice!=null){
            return null;
		}
        numNodi++;
        numFoglie=1;
        radice=new NodoBinPF<T>(info);
        return radice;
	}
	
//	inserisce un nodo come figlio sinistro di u e lo restiruisce	
	public NodoBinPF<T> aggiungiFiglioSin(NodoBinPF<T> u, T info){
		if(u.getSin()!=null){
			return null;
        }
		
		//getstione numero foglie: alternativa alla versone ricorsiva
		if(grado(u)==1) {
			numFoglie++;
		}
		
		NodoBinPF<T> temp=new NodoBinPF<T>(info);
		
		u.setSin(temp);
		temp.setPadre(u);
		
		//gestione altezza
		if(temp.livello()>altezza){
			altezza=temp.livello();
		}
		numNodi++;
		
	
		return u.getSin();
	}
	
//	inserisce un nodo come figlio destro di u e lo restiruisce
	public NodoBinPF<T> aggiungiFiglioDes(NodoBinPF<T> u, T info){
		if(u.getDes()!=null){
			return null;
		}
		
		//getstione numero foglie: alternativa alla versone ricorsiva
		if(grado(u)==1) {
			numFoglie++;
		}

		NodoBinPF<T> temp=new NodoBinPF<T>(info);
		u.setDes(temp);
		u.getDes().setPadre(u);
		
		//gestione altezza
		if(temp.livello()>altezza){
			altezza=temp.livello();
		}
		
		numNodi++;
	
		return u.getDes();
	}

/*
//	innesta un albero B in modo che la radice di B sia figlia sinistra di u
	public void innestaSin(NodoBinPF<T> u, AlberoBinPF<T> B){
		if (u.getSin()!=null){
            return;
		}
        u.setSin(B.radice);
		u.getSin().setPadre(u);
		B.radice=null; 	//  l'albero B diventa vuoto dopo l'innesto. Questo perche'
						//	se innestassi B anche su un altro albero, non saprei
						//	piu' quale sarebbe il padre della radice di B.
		numNodi=numNodi()+B.numNodi();
		if(u.livello()+B.altezza()+1>altezza){
			altezza=u.livello()+B.altezza()+1;
		}
	}
	
//	innesta un albero B in modo che la radice di B sia figlia destra di u
	public void innestaDes(NodoBinPF<T> u, AlberoBinPF<T> B){
		if (u.getDes()!=null){
			System.out.println("figlio destro gia' esistente");
            return;
		}
		u.setDes(B.radice);
		u.getDes().setPadre(u);
		B.radice=null;
		numNodi=numNodi()+B.numNodi();
		if(u.livello()+B.altezza()+1>altezza){
			altezza=u.livello()+B.altezza()+1;
		}
	}
*/


	//	Visita in PROFONDITA' (anticipata) alg. iterativo.
	public LinkedList<T> visitaDFS(){
		Stack<NodoBinPF<T>> p=new Stack<NodoBinPF<T>>(); 	// Struttura di servizio.
		LinkedList<T> nodiAlbero=new LinkedList<T>();			// Conterra' i nodi visitati.
		p.push(radice);
		while (!p.isEmpty()){
			NodoBinPF<T> u=p.pop();
			if (u!=null){
				nodiAlbero.add(u.getInfo());	//	Il nodo viene ''chiuso''.
				p.push(u.getDes());			//	Si inseriscono nella pila
				p.push(u.getSin());			//	i nodo ''aperti'', da visitare.
			}
		}
		return nodiAlbero;
	}
	
	
//	Visita in AMPIEZZA alg. iterativo
	public LinkedList<T> visitaBFS(){
		LinkedList<NodoBinPF<T>> c=new LinkedList<NodoBinPF<T>>(); //coda di servizio: la simulo con una LinkedList
		LinkedList<T> listaNodi=new LinkedList<T>(); //lista nodi in uscita
		c.add(radice); // add di LinkedList aggiunge in fondo
		while (!c.isEmpty()){
			NodoBinPF<T> u=c.remove();//remove di LinkedList toglie il primo
			if(u!=null){
				listaNodi.add(u.getInfo());	// Il nodo viene ''chiuso''.
				
				c.add(u.getSin());			// Si inseriscono nella coda
				c.add(u.getDes());			// i nodi ''aperti'', da visitare.
			}
		}
		return listaNodi;
	}
	
/*
 * ALTERNATIVA GESTIONE ALTEZZA
 * Calcolo il livello di uno dei nodo più bassi. Uno dei nodi più bassi
 * è sicuramente l'ultimo nodo restituito dalla Visita in Ampiezza.
 * Ma devo fare una visita in Ampiezza che restituisce i NODI e non le INFO dei nodi.
 * Scegliendo questa alternativa, allora la variabile int altezza nella classe AlberoDinPF
 * non serve e neanche il controllo del livello dei nodi inseriti rispetto all'altezza
 * nei metodi per inserire nodi nell'albero.	
 */
	
	public LinkedList<NodoBinPF<T>> visitaBFS_Nodi(){
		LinkedList<NodoBinPF<T>> c=new LinkedList<NodoBinPF<T>>(); //coda di servizio: la simulo con una LinkedList
		LinkedList<NodoBinPF<T>> listaNodi=new LinkedList<NodoBinPF<T>>(); //lista nodi in uscita
		c.add(radice); // add di LinkedList aggiunge in fondo
		while (!c.isEmpty()){
			NodoBinPF<T> u=c.remove();//remove di LinkedList toglie il primo
			if(u!=null){
				listaNodi.add(u);	// Il nodo viene ''chiuso''.
				
				c.add(u.getSin());			// Si inseriscono nella coda
				c.add(u.getDes());			// i nodi ''aperti'', da visitare.
			}
		}
		return listaNodi;
	}
	
	int altezza_() {
		NodoBinPF<T> n=visitaBFS_Nodi().get(visitaBFS_Nodi().size()-1);
		return n.livello();
	}
	

// VISITE RICORSIVE anticipata, simmetrica e posticipata.
//Queste ultime due, per farle iterative, prevedono l'uso
//di una pila che possa ospitare sia nodi che alberi
	
	public LinkedList<T> innesco_visita(String t){
		//t="simmetrica", "posticipata" o "anticipata"
		LinkedList<T> lista_nodi=new LinkedList<T>();//ospita le informazioni della visita
		visita_Ricorsiva(radice,lista_nodi,t);
		return lista_nodi;
	}
	
	private void visita_Ricorsiva(NodoBinPF<T> r, LinkedList<T> lista_nodi, String t){
		if(r==null)
			return;
		if(t=="anticipata"){
			lista_nodi.add(r.getInfo());
		}
		visita_Ricorsiva(r.getSin(),lista_nodi,t);
		if(t=="simmetrica"){
			lista_nodi.add(r.getInfo());
		}
		visita_Ricorsiva(r.getDes(),lista_nodi,t);
		if(t=="posticipata"){
			lista_nodi.add(r.getInfo());
		}
	}
	
//OPPURE un algoritmo compatto, non in due parti:
	
	public LinkedList<T> visita_Ricorsiva_comp(NodoBinPF<T> r, LinkedList<T> lista_nodi, String t){
		if(r==null){
			return lista_nodi;
		}
		else{
			if(t=="anticipata"){
				lista_nodi.add(r.getInfo());
			}
			visita_Ricorsiva(r.getSin(),lista_nodi,t);
			if(t=="simmetrica"){
				lista_nodi.add(r.getInfo());
			}
			visita_Ricorsiva(r.getDes(),lista_nodi,t);
			if(t=="posticipata"){
				lista_nodi.add(r.getInfo());
			}
			return lista_nodi;
		}
	}
	
	public int contaFoglie(NodoBinPF<T> a) {
		if (a == null) //albero vuoto
			return 0;
	    if (a.getSin() == null && a.getDes() == null) // foglia
	    	return 1;
	    
	    int fogliesx = contaFoglie(a.getSin()); //visita sottoalb. sin.
	    int fogliedx = contaFoglie(a.getDes());   //visita sottoalb. des.
	    return fogliesx + fogliedx;             //opera su nodo corrente
	    
	  }
	

	
	public String toString() {
		String[] t= {""};
		f(radice,t);
		return t[0];
	}

	
	private void f(NodoBinPF<T> v, String[] t) {
		if(v==null) {
			t[0]=t[0]+"null";
			return;
		}	
		t[0]=t[0]+v.toString()+"[";

		f(v.getSin(),t);
		
		t[0]=t[0]+",";

		f(v.getDes(),t);
		
		t[0]=t[0]+"]";
	}

	
	
}