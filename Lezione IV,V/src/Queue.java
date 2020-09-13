package _Queue;

public interface Queue<T> {
	
	public boolean isFull();
	public boolean isEmpty();
	public void clear();
	public boolean enQueue(T x);
	public T deQueue();
	public T top();	
}
