
public class StackArray<T>{
	
	
	private T[] stack;// struttura interna per la pila
	private final int max;// massimo numero di elementi
	private int top;//prima posizione libera e numero elementi presenti
	
	public StackArray(int M) {
		top=0;
		max=M;
		stack=(T[]) new Object[max];
	}
	
	
	public boolean isFull() {
		return top==max;
	}
	
	public boolean isEmpty() {
		return top==0;
	}
	
	public void clear() {
		top=0;
	}
	
	public boolean push(T x){
		if (isFull()) {
			return false;
		}
				
		stack[top++] = x;
		return true;
	}
	
	public T pop(){
	
		if (isEmpty()) {
			return null;
		}
		
		return stack[--top];
	}
	
	public T top(){
		if (isEmpty()) {
			return null;
		}	
		
		return stack[top-1];
	
	}
	
	public int getTop() {
		return top;
	}

}
