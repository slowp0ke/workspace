package ru.spbstu.telematics.ivanov722.lab3mm;

import java.util.Random;

public class CarRedWE implements Runnable {

	@Override
	public void run() {
		while (true) {
			try {
				
				long sleepTime = new Random().nextInt(2000);
//				long sleepTime = 2000;
				Thread.sleep(sleepTime);
				
				CrossRoad.getLockCardirW().lock();
				System.out.println("red car (W) drive up crossroad");
				CrossRoad.setBusyCardirW(true);
				
				
				while (CrossRoad.isBusyCardirS())
					continue;
				
//				CrossRoad.getLockCardirN().lock();
				System.out.println("red car (W) come out to crossroad");
//				CrossRoad.setBusyCardirN(true);
				
				CrossRoad.getLockSectionWS().lock();
				System.out.println("red car (W) lock section WS");
				CrossRoad.setBusySectionWS(true);
				
				CrossRoad.getLockSectionSE().lock();
				System.out.println("red car (W) lock section SE");
				CrossRoad.setBusySectionSE(true);
				
				try {		
					
					Thread.sleep(1);
					
					
					CrossRoad.setBusyCardirW(false);	
					CrossRoad.setBusyCardirN(false);	
					CrossRoad.setBusySectionWS(false);		
					CrossRoad.setBusySectionSE(false);
					
				} finally {
					CrossRoad.getLockCardirW().unlock();
//					CrossRoad.getLockCardirN().unlock();
					CrossRoad.getLockSectionWS().unlock();
					CrossRoad.getLockSectionSE().unlock();
				}
				
				System.out.println("red car (W) leave crossroad");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}