package ru.spbstu.telematics.ivanov722.lab3mm;

import java.util.Random;

public class CarGreenNS implements Runnable {

	@Override
	public void run() {
		while (true) {
			try {
				
				long sleepTime = new Random().nextInt(2000);
//				long sleepTime = 20;
				Thread.sleep(sleepTime);
				
				CrossRoad.getLockCardirN().lock();
				System.out.println("green car (N) drive up crossroad");
				CrossRoad.setBusyCardirN(true);
				
				while (CrossRoad.isBusyCardirW() == true) {
//					System.out.println("green has to give road to red");
					continue;
				}
				
//				CrossRoad.getLockCardirE().lock();
				System.out.println("green car (N) come out to crossroad");
//				CrossRoad.setBusyCardirE(true);
				
				CrossRoad.getLockSectionWN().lock();
				System.out.println("green car (N) lock section WN");
				CrossRoad.setBusySectionWN(true);
				
				CrossRoad.getLockSectionWS().lock();
				System.out.println("green car (N) lock section WS");
				CrossRoad.setBusySectionWS(true);
				
				try {					
					
					Thread.sleep(1);
					
					
					CrossRoad.setBusyCardirN(false);	
					CrossRoad.setBusyCardirE(false);	
					CrossRoad.setBusySectionWN(false);		
					CrossRoad.setBusySectionWS(false);
					
				} finally {
					CrossRoad.getLockCardirN().unlock();
//					CrossRoad.getLockCardirE().unlock();
					CrossRoad.getLockSectionWN().unlock();
					CrossRoad.getLockSectionWS().unlock();
				}
				
				System.out.println("green car (N) leave crossroad");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}