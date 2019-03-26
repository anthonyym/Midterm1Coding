package pkgShape;

import java.util.Comparator;

public class Cuboid extends Rectangle {
	private int iDepth;
	
	public static class SortByVolume implements Comparator<Cuboid> {

		@Override
		public int compare(Cuboid c1, Cuboid c2) {

			double c1Volume = c1.volume();
			double c2Volume = c2.volume();
			
			if (c1Volume - c2Volume > 0) {
				return (int) Math.ceil(c1Volume - c2Volume);
			} else if (c1Volume - c2Volume < 0) {
				return (int) Math.floor(c1Volume - c2Volume);
			} else {
				return 0;
			}
		}
	}

	public static class SortByArea implements Comparator<Cuboid> {

		@Override
		public int compare(Cuboid c1, Cuboid c2) {

			double c1Area = c1.area();
			double c2Area = c2.area();
			
			if (c1Area - c2Area > 0) {
				return (int) Math.ceil(c1Area - c2Area);
			} else if (c1Area - c2Area < 0) {
				return (int) Math.floor(c1Area - c2Area);
			} else {
				return 0;
			}
		}
	}
	
	public Cuboid(int iWidth, int iLength, int iDepth) throws IllegalArgumentException {
		super(iWidth, iLength);
		if (iDepth <= 0) {
			throw new IllegalArgumentException("iDepth must be positive");
		}
		this.setiDepth(iDepth);
	}

	public int getiDepth() {
		return iDepth;
	}

	public void setiDepth(int iDepth) {
		if (iDepth <= 0) {
			throw new IllegalArgumentException("iDepth must be positive");
		}
		this.iDepth = iDepth;
	}
	
	public double volume() {
		return getiWidth() * getiLength() * iDepth;
	}
	
	@Override
	// Computes surface area of object
	public double area() {
		return 2*getiWidth()*getiLength() + 
				2*getiWidth()*iDepth +
				2*getiLength()*iDepth;
	}
	
	@Override
	// Perimeter method unsupported on Cuboid
	public double perimeter() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("perimeter method cannot be called on a cuboid");
	}
	
	@Override
	public String toString() {
		
		return "[" + getiWidth() + "," + getiLength() + "," + iDepth + "]";
	}
}
