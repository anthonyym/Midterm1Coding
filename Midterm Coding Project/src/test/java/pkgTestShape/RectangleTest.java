package pkgTestShape;

import org.junit.Test;

import pkgShape.Rectangle;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

public class RectangleTest {

	@Test
	public void testConstruction() {
		Rectangle r = new Rectangle(3, 4);

		assertEquals(r.getiLength(), 4);
		assertEquals(r.getiWidth(), 3);
	}

	@Test
	public void testGetSet() {
		Rectangle r = new Rectangle(3, 4);

		r.setiWidth(5);
		r.setiLength(6);
		assertEquals(r.getiWidth(), 5);
		assertEquals(r.getiLength(), 6);
	}

	@Test
	public void testArea() {
		Rectangle r = new Rectangle(3, 4);

		assertEquals((int) r.area(), 12);
	}

	@Test
	public void testPerimeter() {
		Rectangle r = new Rectangle(3, 4);

		assertEquals((int) r.perimeter(), 14);
	}

	@Test
	public void testCompareTo() {
		Rectangle r1 = new Rectangle(3, 4);
		Rectangle r2 = new Rectangle(5, 6);

		assertEquals(r1.compareTo(r2), -18);
		assertEquals(r2.compareTo(r1), 18);
		assertEquals(r1.compareTo(r1), 0);
	}

	@Test
	public void testSorting() {
		ArrayList<Rectangle> ar = new ArrayList<Rectangle>();
		ar.add(new Rectangle(3, 4));
		ar.add(new Rectangle(4, 5));
		ar.add(new Rectangle(1, 6));

		String unsorted = "";
		for (int i = 0; i < ar.size(); i++)
			unsorted += ar.get(i).toString() + ",";
		assertEquals("[3,4],[4,5],[1,6],", unsorted);

		Collections.sort(ar);
		String sorted = "";
		for (int i = 0; i < ar.size(); i++)
			sorted += ar.get(i).toString() + ",";
		assertEquals("[1,6],[3,4],[4,5],", sorted);
		
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorIllegalArgumentException() {
		new Rectangle(-3, 4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetterIllegalArgumentException() {
		Rectangle c = new Rectangle(3, 4);
		c.setiWidth(0);
	}

}
