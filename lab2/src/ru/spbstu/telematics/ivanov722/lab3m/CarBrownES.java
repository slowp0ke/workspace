package ru.spbstu.telematics.ivanov722.lab3m;

import java.util.Random;

public class CarBrownES implements Runnable {

	@Override
	public void run() {
		while (true) {
			try {
				//ждем до 2 секунд прежде чем респауниться
				long sleepTime = new Random().nextInt(2000);
				Thread.sleep(sleepTime);
				
								
				CrossRoad.getLockCardirE().lock();
				System.out.println("Коричневая машина (E) подъезжает к перекрестку");
				CrossRoad.getLockCardirS().lock();
				System.out.println("Коричневая машина (Е) выезжает на перекресток");
				CrossRoad.getLockSectionNE().lock();
				System.out.println("Коричневая машина (Е) занимает секцию NE");
				CrossRoad.getLockSectionWS().lock();
				System.out.println("Коричневая машина (Е) занимает секцию WS");
				try {
					
					//захватываем участки
					CrossRoad.setBusyCardirE(true);	 
					CrossRoad.setBusyCardirS(true);	
					CrossRoad.setBusySectionNE(true);		
					CrossRoad.setBusySectionWS(true);
					
					//захватили, ждем какое-то время
					Thread.sleep(500);
					
					//отпускаем всех, кого захватили
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
				
				System.out.println("Коричневая машина (Е) покинула перекресток");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}	
	}

}
