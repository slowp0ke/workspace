package ru.spbstu.telematics.ivanov722.lab3m;

import java.util.Random;

public class CarBlueSN implements Runnable {

	@Override
	public void run() {
		while (true) {
			try {
				//���� �� 2 ������ ������ ��� ������������
				long sleepTime = new Random().nextInt(2000);
				Thread.sleep(sleepTime);
				
				CrossRoad.getLockCardirS().lock();
				System.out.println("����� ������ (S) ���������� � �����������");
				CrossRoad.getLockCardirW().lock();
				System.out.println("����� ������ (S) �������� �� �����������");
				CrossRoad.getLockSectionSE().lock();
				System.out.println("����� ������ (S) �������� ������ SE");
				CrossRoad.getLockSectionNE().lock();
				System.out.println("����� ������ (S) �������� ������ NE");
				try {
					//����������� �������
					CrossRoad.setBusyCardirS(true);	
					CrossRoad.setBusyCardirW(true);	
					CrossRoad.setBusySectionSE(true);		
					CrossRoad.setBusySectionNE(true);
					
					//���������, ���� �����-�� �����
					Thread.sleep(500);
					
					//��������� ����, ���� ���������
					CrossRoad.setBusyCardirS(false);	
					CrossRoad.setBusyCardirW(false);	
					CrossRoad.setBusySectionSE(false);		
					CrossRoad.setBusySectionNE(false);
					
				} finally {
					CrossRoad.getLockCardirS().unlock();
					CrossRoad.getLockCardirW().unlock();
					CrossRoad.getLockSectionSE().unlock();
					CrossRoad.getLockSectionNE().unlock();
				}
				
				System.out.println("����� ������ (S) �������� �����������");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
