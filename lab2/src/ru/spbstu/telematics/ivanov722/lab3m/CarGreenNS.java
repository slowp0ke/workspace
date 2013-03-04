package ru.spbstu.telematics.ivanov722.lab3m;

import java.util.Random;

public class CarGreenNS implements Runnable {

	@Override
	public void run() {
		while (true) {
			try {
				//ждем до 2 секунд прежде чем респауниться
				long sleepTime = new Random().nextInt(2000);
				Thread.sleep(sleepTime);
				
								
				CrossRoad.getLockCardirN().lock();
				System.out.println("Зеленая машина (N) подъезжает к перекрестку");
				CrossRoad.getLockCardirE().lock();
				System.out.println("Зеленая машина (N) выезжает на перекресток");
				CrossRoad.getLockSectionWN().lock();
				System.out.println("Зеленая машина (N) занимает секцию WN");
				CrossRoad.getLockSectionWS().lock();
				System.out.println("Зеленая машина (N) занимает секцию WS");
				try {
					//захватываем участки
					CrossRoad.setBusyCardirN(true);	
					CrossRoad.setBusyCardirE(true);	
					CrossRoad.setBusySectionWN(true);		
					CrossRoad.setBusySectionWS(true);
					
					//захватили, ждем какое-то время
					Thread.sleep(500);
					
					//отпускаем всех, кого захватили
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
				
				System.out.println("Зеленая машина (N) покинула перекресток");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
