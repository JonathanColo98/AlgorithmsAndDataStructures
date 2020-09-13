package _Queue;

public class QueueArray<T> implements Queue<T> {
	
	//elementi sempre mantenuti nelle prime posizioni.
	//Si estrae sempre l'elemento di posto 0.
	//Ricompattamento dopo ogni estrazione.
	// Non efficiente a cuasa del ricompattamento
	
	private T[] queue;// struttura interna per la coda
	private final int max; // numero massimo di elementi;
	private int n;// numero elementi presenti e primaposizione libera

	public QueueArray(int M){
		n=0;
		max=M;
		queue=(T[]) new Object[max];
		
		//queue = new T[max] NON SI PUO' FARE
	}
	
	public boolean isFull() {
		return n==max;
	}
	
	public boolean isEmpty() {
		return n==0;
	}
	
	public void clear() {
		n=0;
	}
	
	public boolean enQueue(T x){
		if (isFull()) {
			return false;
		}
		queue[n++] = x;
		return true;
	}

	public T top(){// chi sarà il prossimo estratto
		if (isEmpty()) {
			return null;
		}
		return queue[0];
	}
	
	public T deQueue(){
		if (isEmpty()) {
			return null;
		}
		T x=this.top();
		n--;
		for(int i=0;i<=n-1;i++) {
			queue[i]=queue[i+1];
		}
		return x;
	}
}
