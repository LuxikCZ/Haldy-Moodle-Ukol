package cz.spsejecna.titera2.haldy;

import java.util.Arrays;



public class Halda {
	public final int DEFAULT_BUFFER_SIZE=16;
	int[] pole = null;
	int virtualniVelikost = 0;
	public int getParent(int i) {
		if(i%2==0) {
			return (i-1)/2;
		}else {
			return i/2;
		}
	}
	public int getLeftChild(int i) {
		return 2*i+1;
	}
	public int getRightChild(int i) {
		return 2*i+2;
	}
	public void insert(int v) {
		if(virtualniVelikost<=0) {
			virtualniVelikost=1;
			pole = new int[DEFAULT_BUFFER_SIZE];
			pole[virtualniVelikost-1] = v;
		}else {
			if(virtualniVelikost>=pole.length) {
				int[] pole2 = new int[pole.length*2];
				for(int i=0; i<pole.length; i++) {
					pole2[i] = pole[i];
				}
				pole = pole2;
			}
			pole[virtualniVelikost++]=v;
			int soucasnyIndex=virtualniVelikost-1;
			while(soucasnyIndex!=0 && pole[soucasnyIndex]<pole[getParent(soucasnyIndex)]) {
				int temp = pole[getParent(soucasnyIndex)];
				pole[getParent(soucasnyIndex)]=pole[soucasnyIndex];
				pole[soucasnyIndex]=temp;
				soucasnyIndex=getParent(soucasnyIndex);
			}
			
		}
	}
	public int min() {
		int nejmensi = pole[0];
		for(int i=0; i<virtualniVelikost; i++) {
			if(nejmensi > pole[i]) {
				nejmensi = pole[i];
			}
		}
		return nejmensi;
	}
	public int extractMin() {
		int nejmensi = min();
		for(int i = 0; i < virtualniVelikost; i++) {
			if(min() == pole[i]) {
				for(int j = i; j < virtualniVelikost-1; j++) {
					pole[j] = pole[j+1];
				}
				virtualniVelikost--;
				pole[virtualniVelikost] = 0;
				int soucasnyIndex=virtualniVelikost-1;
				for(int j = 0; j<virtualniVelikost; j++) {
					if(pole[j]<pole[getParent(j)]) {
						int temp = pole[getParent(j)];
						pole[getParent(j)] = pole[j];
						pole[j]=temp;
					}
				}
			
			}
			break;
		}
		return nejmensi;
	}
	public int size() {
		return virtualniVelikost;
	}
	public String toString() {
		return Arrays.toString(pole);
	}
	
}
