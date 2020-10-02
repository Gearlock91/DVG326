package ovn1.del3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TradTest {


	Tree firstTree;
	Tree secondTree;
	
	@BeforeEach
	void setUp() throws Exception {
		firstTree = new Tree(11,"Björk");
		secondTree = new Tree(1, "Asp");
	}

	@AfterEach
	void tearDown() throws Exception {
		firstTree = null;
		secondTree = null;
	}

	@Test
	void test() {
		
		System.out.println(firstTree.toString());
		System.out.println(secondTree.toString());
		
		firstTree.ageing();
		secondTree.ageing();
		
		assertEquals(12, firstTree.getAge());
		assertEquals(2, secondTree.getAge());
		
		System.out.println(firstTree.toString());
		System.out.println(secondTree.toString());
		
		firstTree.setAge(50);
		secondTree.setAge(10);
		
		System.out.println(firstTree.toString());
		System.out.println(secondTree.toString());
		
	}

}
