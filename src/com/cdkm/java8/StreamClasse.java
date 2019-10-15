package com.cdkm.java8;

import java.util.stream.IntStream;

public class StreamClasse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntStream.rangeClosed(1, 10)
		.skip(5).findFirst();
		//.forEach(System.out::print);

		//test
		
	}

}
