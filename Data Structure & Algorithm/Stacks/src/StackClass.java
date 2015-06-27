import java.util.EmptyStackException;

public class StackClass implements Stack {

	public static final int CAPACITY = 1024;
	private int N;
	private Object s[];
	private int t = -1;

	@Override
	public int Size() {
		// TODO Auto-generated method stub
		return t + 1;
	}

	@Override
	public Boolean isEmpty() {
		// TODO Auto-generated method stub
		return (t < 0);
	}

	@Override
	public Object top() throws EmptyStackException {
		// TODO Auto-generated method stub
		if (isEmpty())
			throw new EmptyStackException();
		return s[t];
	}

	@Override
	public void push(Object element) throws Exception {
		// TODO Auto-generated method stub
		if (Size() == N) {
			throw new Exception("Stack OverFlow");
		}
		s[++t] = element;

	}

	@Override
	public Object pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		Object elment;
		if (isEmpty())
			throw new EmptyStackException();
		elment = s[t];
		s[t--] = null;
		return elment;
	}

	public StackClass() {
		// TODO Auto-generated constructor stub
	}

	public StackClass(int cap) {
		// TODO Auto-generated constructor stub
		N = cap;
		s = new Object[N];
	}

}
