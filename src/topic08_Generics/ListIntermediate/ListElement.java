package topic08_Generics.ListIntermediate;

public class ListElement<T> {
	private T data;
	protected ListElement<T> next = null;
	
	protected ListElement(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
}
