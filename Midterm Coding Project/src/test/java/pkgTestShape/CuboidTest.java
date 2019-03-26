package pkgTestShape;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import pkgShape.Cuboid;

public class CuboidTest {

	@Test
	public void testContruction() {
		Cuboid c = new Cuboid(1, 2, 3);

		assertEquals(c.getiWidth(), 1);
		assertEquals(c.getiLength(), 2);
		assertEquals(c.getiDepth(), 3);
	}

	@Test
	public void testGetSet() {
		Cuboid c = new Cuboid(1, 2, 3);

		c.setiWidth(4);
		c.setiLength(5);
		c.setiDepth(6);

		assertEquals(c.getiWidth(), 4);
		assertEquals(c.getiLength(), 5);
		assertEquals(c.getiDepth(), 6);
	}

	@Test
	public void testArea() {
		Cuboid c = new Cuboid(1, 2, 3);
		
		assertEquals((int)c.area(), (4+6+12));
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testPerimeter() {
		Cuboid c = new Cuboid(1, 2, 3);
		c.perimeter();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorIllegalArgumentException() {
		new Cuboid(-1, 2, 3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetterIllegalArgumentException() {
		Cuboid c = new Cuboid(1, 2, 3);

		c.setiDepth(0);
	}
	
	@Test
	public void testSortByArea() {
		Cuboid c1 = new Cuboid(1, 2, 3);
		Cuboid c2 = new Cuboid(1, 2, 4);
		Cuboid c3 = new Cuboid(1, 1, 1);
		
		ArrayList<Cuboid> cList = new ArrayList<Cuboid>();
		cList.add(c1);
		cList.add(c2);
		cList.add(c3);
		
		String unsorted = "";
		for (int i = 0; i < cList.size(); i++)
			unsorted += cList.get(i).toString() + ",";
		assertEquals("[1,2,3],[1,2,4],[1,1,1],", unsorted);
		
		Collections.sort(cList, new Cuboid.SortByArea());
		String sorted = "";
		for (int i = 0; i < cList.size(); i++)
			sorted += cList.get(i).toString() + ",";
		assertEquals("[1,1,1],[1,2,3],[1,2,4],", sorted);
	}
	
	@Test
	public void testSortByVolume() {
		Cuboid c1 = new Cuboid(1, 2, 3);
		Cuboid c2 = new Cuboid(1, 2, 4);
		Cuboid c3 = new Cuboid(1, 1, 1);
		
		ArrayList<Cuboid> cList = new ArrayList<Cuboid>();
		cList.add(c1);
		cList.add(c2);
		cList.add(c3);
		
		String unsorted = "";
		for (int i = 0; i < cList.size(); i++)
			unsorted += cList.get(i).toString() + ",";
		assertEquals("[1,2,3],[1,2,4],[1,1,1],", unsorted);
		
		Collections.sort(cList, new Cuboid.SortByVolume());
		String sorted = "";
		for (int i = 0; i < cList.size(); i++)
			sorted += cList.get(i).toString() + ",";
		assertEquals("[1,1,1],[1,2,3],[1,2,4],", sorted);
	}
}
