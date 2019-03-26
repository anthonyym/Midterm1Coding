package pkgShape;

public class Rectangle extends Shape implements Comparable<Object> {
	private int iWidth;

	private int iLength;

	public Rectangle(int iWidth, int iLength) {
		if (iWidth <= 0 || iLength <= 0) {
			throw new IllegalArgumentException("iWidth and iLength must be positive");
		}
		this.iWidth = iWidth;
		this.iLength = iLength;
	}

	public int getiWidth() {
		return iWidth;
	}

	public void setiWidth(int iWidth) {
		if (iWidth <= 0) {
			throw new IllegalArgumentException("iWidth must be positive");
		}
		this.iWidth = iWidth;
	}

	public int getiLength() {
		return iLength;
	}

	public void setiLength(int iLength) {
		if (iLength <= 0) {
			throw new IllegalArgumentException("iLength must be positive");
		}
		this.iLength = iLength;
	}

	@Override
	public double area() {
		return iWidth * iLength;
	}

	@Override
	public double perimeter() {
		return (2 * iWidth) + (2 * iLength);
	}

	public int compareTo(Object r) {
		double inputRectArea = ((Rectangle) r).area();
		double thisRectArea = this.area();

		if ((thisRectArea - inputRectArea > 0)) {
			return (int) Math.ceil(thisRectArea - inputRectArea);
		} else if (thisRectArea - inputRectArea < 0) {
			return (int) Math.floor(thisRectArea - inputRectArea);
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "[" + iWidth + ", " + iLength + "]";
	}

}
