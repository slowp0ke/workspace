package ru.spbstu.telematics.ivanov722.lab02;

public class Cell<T> {

	
	private T storedObject;
	
	Cell(T storedObject){
		this.storedObject=storedObject;
	};

	public T getStoredObject() {
		return storedObject;
	}

	public void setStoredObject(T storedObject) {
		this.storedObject = storedObject;
	}
	
}
