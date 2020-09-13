package _Queue;

public class QueueCircolare<T> implements Queue<T>{

	private T[] queue;
	private final int max;
	private int front, rear;
	
	public QueueCircolare(int M) {
		queue=(T[]) new Object[M];
		front=rear=0;
		max=M;
	}
	
	
	
	private int increase(int index) {
		return (index+1)%max;
	}
	
	
	public boolean isFull() {
		return increase(rear)==front;
	}

	
	public boolean isEmpty() {
		return front==rear;
	}

	public void clear() {
		front=rear=0;
	}

	public boolean enQueue(T x) {
		if(isFull())
			return false;
		queue[rear]=x;
		increase(rear);
		return true;
	}

	public T deQueue() {
		T x=top();
		if(x==null) {
			return null;
		}
		front=increase(front);
		return x;
	}

	public T top() {
		if(isEmpty()) {
			return null;
		}
		return queue[front];
	}
	
	
	public String toString() {
		String t="[";
		for(int i=front;i<=rear-1;i=increase(i)) {
			t=t+" "+ queue[i];
		}
		return t+"]";
	}
	
	
	

}
