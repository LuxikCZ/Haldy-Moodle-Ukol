package cz.spsejecna.titera2.haldy;

public class Main {

	public static void main(String[] args) {
		Halda h= new Halda();
		h.insert(5);
		h.insert(4);
		h.insert(3);
		h.insert(2);
		h.insert(1);
		h.insert(0);
		System.out.println(h);
		System.out.println(h.size());
		System.out.println(h.min());
		System.out.println(h.extractMin());
		System.out.println(h);
		
	}

}
