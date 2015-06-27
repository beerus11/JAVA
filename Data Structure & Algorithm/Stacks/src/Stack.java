import java.util.EmptyStackException;

public interface Stack {
	public int Size();

	public Boolean isEmpty();

	public Object top() throws EmptyStackException;

	public void push(Object element) throws Exception;

	public Object pop() throws EmptyStackException;
}
