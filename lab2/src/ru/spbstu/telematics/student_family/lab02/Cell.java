package lab2;

public class Cell<T> {

	private T storedObject;

	Cell(T storedObject) {
		this.storedObject = storedObject;
	};

	public T getStoredObject() {
		return storedObject;
	}

	public void setStoredObject(T storedObject) {
		this.storedObject = storedObject;
	}

}
