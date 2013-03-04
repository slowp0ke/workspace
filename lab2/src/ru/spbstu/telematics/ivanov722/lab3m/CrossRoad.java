package ru.spbstu.telematics.ivanov722.lab3m;

import java.util.concurrent.locks.ReentrantLock;

public class CrossRoad {
	 //критические секции переосмыслены - теперь это
	 //просто секции и "стороны света" - направлени€,
	 //откуда приезжают автомобили
	
	 //стороны света:
	private static boolean isBusyCardirN;
	private static boolean isBusyCardirW;
	private static boolean isBusyCardirE;
	private static boolean isBusyCardirS;
	
	private static ReentrantLock lockCardirN = new ReentrantLock();
	private static ReentrantLock lockCardirW = new ReentrantLock();
	private static ReentrantLock lockCardirE = new ReentrantLock();
	private static ReentrantLock lockCardirS = new ReentrantLock();
	
	
	

	public static boolean isBusyCardirN() {
		return isBusyCardirN;
	}
	public static void setBusyCardirN(boolean isBusyCardirN) {
		CrossRoad.isBusyCardirN = isBusyCardirN;
	}
	public static boolean isBusyCardirW() {
		return isBusyCardirW;
	}
	public static void setBusyCardirW(boolean isBusyCardirW) {
		CrossRoad.isBusyCardirW = isBusyCardirW;
	}
	public static boolean isBusyCardirE() {
		return isBusyCardirE;
	}
	public static void setBusyCardirE(boolean isBusyCardirE) {
		CrossRoad.isBusyCardirE = isBusyCardirE;
	}
	public static boolean isBusyCardirS() {
		return isBusyCardirS;
	}
	public static void setBusyCardirS(boolean isBusyCardirS) {
		CrossRoad.isBusyCardirS = isBusyCardirS;
	}
	public static boolean isBusySectionWN() {
		return isBusySectionWN;
	}
	public static void setBusySectionWN(boolean isBusySectionWN) {
		CrossRoad.isBusySectionWN = isBusySectionWN;
	}
	public static boolean isBusySectionNE() {
		return isBusySectionNE;
	}
	public static void setBusySectionNE(boolean isBusySectionNE) {
		CrossRoad.isBusySectionNE = isBusySectionNE;
	}
	public static boolean isBusySectionWS() {
		return isBusySectionWS;
	}
	public static void setBusySectionWS(boolean isBusySectionWS) {
		CrossRoad.isBusySectionWS = isBusySectionWS;
	}
	public static boolean isBusySectionSE() {
		return isBusySectionSE;
	}
	public static void setBusySectionSE(boolean isBusySectionSE) {
		CrossRoad.isBusySectionSE = isBusySectionSE;
	}
	public static ReentrantLock getLockCardirN() {
		return lockCardirN;
	}
	public static ReentrantLock getLockCardirW() {
		return lockCardirW;
	}
	public static ReentrantLock getLockCardirE() {
		return lockCardirE;
	}
	public static ReentrantLock getLockCardirS() {
		return lockCardirS;
	}
	public static ReentrantLock getLockSectionWN() {
		return lockSectionWN;
	}
	public static ReentrantLock getLockSectionNE() {
		return lockSectionNE;
	}
	public static ReentrantLock getLockSectionWS() {
		return lockSectionWS;
	}
	public static ReentrantLock getLockSectionSE() {
		return lockSectionSE;
	}
	 //секции - просто разбиваем перекресток на 4 части
	private static boolean isBusySectionWN;
	private static boolean isBusySectionNE;
	private static boolean isBusySectionWS;
	private static boolean isBusySectionSE;
	
	private static ReentrantLock lockSectionWN = new ReentrantLock();
	private static ReentrantLock lockSectionNE = new ReentrantLock();
	private static ReentrantLock lockSectionWS = new ReentrantLock();
	private static ReentrantLock lockSectionSE = new ReentrantLock();


}
