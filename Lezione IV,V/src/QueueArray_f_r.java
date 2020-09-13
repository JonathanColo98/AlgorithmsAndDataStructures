package _Queue;
public class QueueArray_f_r<T> implements Queue<T> {
	// Coda realizzata con un array in cui vengono mantenuti aggiornati due
	//indici: front e rear.
	//il primo elemento ha indice front;
	//l'ultimo elemento ha indice rear-1.
	//Si estrae sempre front. Si inserisce in rear.
	
	
	private T[] queue;//struttura interna
	private int max;  //capacita' massima
	int front,rear;   
	
	//costruttore
	public QueueArray_f_r(int M){
		max=M;
		front=0;
		rear=0;
		queue=(T[]) new Object[max];
	}
	
	public boolean isFull() {//si può inserire anche in indice max-1, l'ultimo posto
		return rear==max;
	}
	
	public void clear(){ //rendere vuota la coda
		front=rear=0;
	}
	
	public boolean isEmpty(){
		return front==rear;
	}
	
	public boolean enQueue(T x){
		if (isFull()){
			return false;
		}

		queue[rear++]=x;
		return true;
	}
	
	public T top(){//chi sarà il prossimo estratto
		if(isEmpty()){
			return null;
		}
		return queue[front];
	}
	
	public T deQueue() {
		if(isEmpty()){
			return null;
		}
		return queue[front++];
	}
	

	public String toString(){
		String t="[";
		for(int i=front;i<rear;i++)
			t=t + " " + queue[i];
		t=t+" ]";
		return t;
	}
	
}