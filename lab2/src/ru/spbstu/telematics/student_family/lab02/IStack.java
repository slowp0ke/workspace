package lab2;

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
