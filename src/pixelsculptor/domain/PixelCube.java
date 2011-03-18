package pixelsculptor.domain;

public class PixelCube {

	private float _height = 0;
	private float _width = 0;
	private float _depth = 0;

	public PixelCube(float red, float green, float blue) {
		_height = red;
		_width = green;
		_depth = blue;

	}

	public float getHeight() {
		return _height;
	}

	public float getWidth() {
		return _width;
	}

	public float getDepth() {
		return _depth;
	}

}
