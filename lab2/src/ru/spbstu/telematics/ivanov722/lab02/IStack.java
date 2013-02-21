package ru.spbstu.telematics.ivanov722.lab02;

public interface IStack<T> {

	/**
	 * �������� ������� �� �����.
	 * ������� ���������
	 * 
	 * @return
	 */
	T pop();

	/**
	 * ������ ������� � ����.
	 * 
	 * @param o
	 */
	void push(T o);

	/**
	 * ���������� ������ �������
	 * 
	 * @return
	 */
	int size();
}
