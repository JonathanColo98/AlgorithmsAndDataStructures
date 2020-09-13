package _Queue;

	
	public class QueueDinamico<T> implements Queue<T>{
		
		//coda con front e rear che prevede il raddoppiamento e il dimezzamento
		//Non c'è più bisogno della capacità massima
		
		private T[] queue;// struttura interna
		private int front,rear; //
		
		//costruttore
		public QueueDinamico(){
			queue=(T[]) new Object[1];
			/* ci pensa il checkDoubling a raddoppiare subito...
			 * Inoltre, in questa maniera la lunghezza è 
			 * sempre una potenza di due.
			 */
			front=rear=0;
		}
		
		public int getFront() {
			return front;
		}
		
		public int getRear() {
			return rear;
		}
		
		public int getQueue() {
			return queue.length;
		}
			
		
	// il metodo seguente controlla se c'è la necessita di raddoppiare l'array	
		private void checkDoubling() {
			if (rear == queue.length - 1) {
				System.out.println("qui raddoppio");
				T[] tmp = (T[]) new Object[2 * queue.length];
				for (int i = front; i < rear; i++) {
					tmp[i] = queue[i];
				}
				queue = tmp;
			}
		}

	// il metodo seguente controlla se c'è la necessita di dimezzare l'array
		private void checkHalving() {
			if (rear-front == queue.length / 4) {
				System.out.println("Adesso dimezzo");
				T[] tmp = (T[]) new Object[queue.length / 2];
				for (int i = front; i < rear; i++) {
					tmp[i-front] = queue[i];
				}
				queue = tmp;
				rear=rear-front;
				front=0;
			}
		}
		
		public void clear(){
			front=rear=0;
		}
		
		public boolean isFull() {
			return false;
		}
		
		public boolean isEmpty(){
			return front==rear;
		}
		
		public boolean enQueue(T x){//commenta il tipo di ritorno
			checkDoubling();
			queue[rear++]=x;
			
			return true;// la coda non è mai piena
		}
		
		public T top(){
			if(isEmpty()){
				return null;
			}
			return queue[front];
		}
		
		public T deQueue(){
			if(isEmpty()){
				return null;
			}
			T x=queue[front];
			front++;
			checkHalving();
			return x;		
		}
		
		public String toString(){
			String t="[";
			for(int i=front;i<rear;i++){
				t=t+" "+queue[i];
			}
			t=t+"]";
			return t;
		}
}