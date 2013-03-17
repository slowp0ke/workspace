package ru.spbstu.telematics.ivanov722.lab3mm;



import java.util.Random;

public class CarBrownES implements Runnable {

	@Override
	public void run() {
		while (true) {
			try {
				
				long sleepTime = new Random().nextInt(2000);
//				long sleepTime = 20;
				Thread.sleep(sleepTime);
				
				CrossRoad.getLockCardirE().lock();
				System.out.println("brown car (E) drive up crossroad");
				CrossRoad.setBusyCardirE(true);
				
				while (CrossRoad.isBusyCardirS() == true || CrossRoad.isBusyCardirS() == true)
					continue;
				
//				CrossRoad.getLockCardirS().lock();
				System.out.println("brown car (E) come out to crossroad");
//				CrossRoad.setBusyCardirS(true);
				
				CrossRoad.getLockSectionNE().lock();
				System.out.println("brown car (E) lock section NE");
				CrossRoad.setBusySectionNE(true);
				

//				while (CrossRoad.isBusyCardirW() == true)
//					continue;
				
				CrossRoad.getLockSectionWS().lock();
				System.out.println("brown car (E) lock section WS");
				CrossRoad.setBusySectionWS(true);
				
				try {					
					
					Thread.sleep(1);
					
				
					CrossRoad.setBusyCardirE(false);	
					CrossRoad.setBusyCardirS(false);	
					CrossRoad.setBusySectionNE(false);		
					CrossRoad.setBusySectionWS(false);
					
				} finally {
					CrossRoad.getLockCardirE().unlock();
//					CrossRoad.getLockCardirS().unlock();
					CrossRoad.getLockSectionNE().unlock();
					CrossRoad.getLockSectionWS().unlock();
				}
				
				System.out.println("brown car (E) leave crossroad");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}	
	}

}