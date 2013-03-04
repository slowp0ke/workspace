package ru.spbstu.telematics.ivanov722.lab3m;

import java.util.Random;

public class CarGreenNS implements Runnable {

	@Override
	public void run() {
		while (true) {
			try {
				//���� �� 2 ������ ������ ��� ������������
				long sleepTime = new Random().nextInt(2000);
				Thread.sleep(sleepTime);
				
								
				CrossRoad.getLockCardirN().lock();
				System.out.println("������� ������ (N) ���������� � �����������");
				CrossRoad.getLockCardirE().lock();
				System.out.println("������� ������ (N) �������� �� �����������");
				CrossRoad.getLockSectionWN().lock();
				System.out.println("������� ������ (N) �������� ������ WN");
				CrossRoad.getLockSectionWS().lock();
				System.out.println("������� ������ (N) �������� ������ WS");
				try {
					//����������� �������
					CrossRoad.setBusyCardirN(true);	
					CrossRoad.setBusyCardirE(true);	
					CrossRoad.setBusySectionWN(true);		
					CrossRoad.setBusySectionWS(true);
					
					//���������, ���� �����-�� �����
					Thread.sleep(500);
					
					//��������� ����, ���� ���������
					CrossRoad.setBusyCardirN(false);	
					CrossRoad.setBusyCardirE(false);	
					CrossRoad.setBusySectionWN(false);		
					CrossRoad.setBusySectionWS(false);
					
				} finally {
					CrossRoad.getLockCardirN().unlock();
					CrossRoad.getLockCardirE().unlock();
					CrossRoad.getLockSectionWN().unlock();
					CrossRoad.getLockSectionWS().unlock();
				}
				
				System.out.println("������� ������ (N) �������� �����������");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
