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

		// storage[top] = (Cell<T>) o;
		storage[top] = new Cell(o);
		top++;
		// top = storage.length - 1;

	};

	public T pop() {
		T returnObject = storage[top].getStoredObject();

		storage[top] = null;
		top--;
		// top = storage.length - 1;
		return returnObject;

	};

	public int size() {

		return top;

	};

	// public T get(){
	// return storage[top].getStoredObject();

	// };

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
		// System.out.println("hello");

		Stack<String> pile = new Stack<String>();
		System.out.println("size " + pile.size());
		pile.push("1");
		System.out.println("size " + pile.size());
		pile.push("2");
		pile.push("3");
		pile.push("4");
		pile.pop();
		// System.out.println("top element is  " + pile.pop());

		System.out.println("size " + pile.size());
		pile.push("5");
		pile.push("6");
		pile.push("7");
		System.out.println("size " + pile.size());
		// System.out.println("top element is  " + pile.get());

		pile.push("8");
		pile.push("9");
		pile.push("10");
		pile.pop();
		System.out.println("size " + pile.size());
		// System.out.println("top element is  " + pile.get());

		/*
		 * for(String iter : pile){ if(iter!=null)
		 * System.out.println(pile.pop()); } Iterator <String> it =
		 * pile.iterator();
		 */

		/*
		 * String key = "10";
		 * 
		 * System.out.println(
		 * "��� �������� �������  � ������� for each:"
		 * ); for(String iter : pile){ if(iter!=null)
		 * System.out.println(pile.pop()); }
		 * 
		 * Iterator <String> it = pile.iterator(); System.out.println(
		 * "��� �������� ������� � ������� hasNext():"
		 * );
		 * 
		 * while(it.hasNext()){ key = it.next(); if(key!=null)
		 * System.out.println("����: " + key +
		 * " ��������: " + pile.size() ); pile.pop(); }
		 * 
		 * System.out.println("Done!");
		 */

	}

}
