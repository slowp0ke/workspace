package ru.spbstu.telematics.ivanov722.lab3m;

import java.util.Random;

public class CarBrownES implements Runnable {

	@Override
	public void run() {
		while (true) {
			try {
				//���� �� 2 ������ ������ ��� ������������
				long sleepTime = new Random().nextInt(2000);
				Thread.sleep(sleepTime);
				
								
				CrossRoad.getLockCardirE().lock();
				System.out.println("���������� ������ (E) ���������� � �����������");
				CrossRoad.getLockCardirS().lock();
				System.out.println("���������� ������ (�) �������� �� �����������");
				CrossRoad.getLockSectionNE().lock();
				System.out.println("���������� ������ (�) �������� ������ NE");
				CrossRoad.getLockSectionWS().lock();
				System.out.println("���������� ������ (�) �������� ������ WS");
				try {
					
					//����������� �������
					CrossRoad.setBusyCardirE(true);	 
					CrossRoad.setBusyCardirS(true);	
					CrossRoad.setBusySectionNE(true);		
					CrossRoad.setBusySectionWS(true);
					
					//���������, ���� �����-�� �����
					Thread.sleep(500);
					
					//��������� ����, ���� ���������
					CrossRoad.setBusyCardirE(false);	
					CrossRoad.setBusyCardirS(false);	
					CrossRoad.setBusySectionNE(false);		
					CrossRoad.setBusySectionWS(false);
					
				} finally {
					CrossRoad.getLockCardirE().unlock();
					CrossRoad.getLockCardirS().unlock();
					CrossRoad.getLockSectionNE().unlock();
					CrossRoad.getLockSectionWS().unlock();
				}
				
				System.out.println("���������� ������ (�) �������� �����������");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}	
	}

}
