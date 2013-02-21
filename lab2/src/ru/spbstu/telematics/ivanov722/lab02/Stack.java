package ru.spbstu.telematics.ivanov722.lab02;

import java.util.Iterator;
import java.lang.reflect.Array;

public class Stack<T> implements IStack<T>, Iterable<T> {

	public Cell<T>[] storage;
	public int defaultLength;
	public int top;

	Stack() {
		defaultLength = 10;
		top = 0;
		storage = (Cell<T>[]) Array.newInstance(Cell.class, defaultLength);
	};

	@SuppressWarnings("unchecked")
	public void push(T o) {
		if (top != defaultLength) {
			storage[top] = new Cell(o);
			top++;
		} else {
			System.out.println("Stack is full");
			return;
		}
	};

	public T pop() {
		T returnObject = storage[top - 1].getStoredObject();

		storage[top] = null;
		top--;
		return returnObject;

	};

	public int size() {

		return top;

	};

	public Iterator<T> iterator() {
		return new MyIterator();
	}

	class MyIterator implements Iterator<T> {

		private int iterPos = 0;

		public boolean hasNext() {
			if (iterPos < storage.length)
				return true;
			else
				return false;
		}

		@Override
		public T next() {
			if (storage[iterPos] != null) {
				T nextVal = storage[iterPos].getStoredObject();
				iterPos++;
				return nextVal;
			} else
				iterPos++;
			return null;

		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

	}

	public static void main(String[] args) {

		Stack<String> pile = new Stack<String>();

		System.out.println("amount of elements in stack " + pile.size()); // size
																			// test
		pile.push("1"); // push() test
		System.out.println("amount of elements in stack " + pile.size()); // check
																			// push
																			// test
		pile.push("2");
		pile.push("3");
		pile.push("4");
		System.out.println("this is poped element " + pile.pop()); // pop() test
		System.out.println("amount of elements in stack " + pile.size());
		pile.push("5");
		pile.push("6");
		pile.push("7");
		System.out.println("amount of elements in stack " + pile.size());
		pile.push("8");
		pile.push("9");

		System.out.println("amount of elements in stack " + pile.size());

		System.out.println("Stack for each test:");
		for (String iter : pile) {
			if (iter != null)
				System.out.println(iter);

		}
		System.out.println("finish ");

	}

}
