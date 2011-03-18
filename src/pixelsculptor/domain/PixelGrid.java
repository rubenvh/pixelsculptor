package pixelsculptor.domain;

import java.util.ArrayList;

import pixelsculptor.engine.PixelSculptor;
import pixelsculptor.rendering.CubeRendererFactory;
import pixelsculptor.rendering.CubeRendererType;
import pixelsculptor.rendering.ICubeRenderer;
import processing.core.PApplet;
import processing.core.PImage;

public class PixelGrid {

	private ArrayList<ArrayList<PixelCube>> _grid;
	private ICubeRenderer _renderer;
	private PImage _image;
	private int _scaleRGB;
	private PixelSculptor _pApplet;
	int _dimension;
	int _rows;
	int _cols;
	private int _rotationZ = 120;
	private int _rotationX = 120;

	public PixelGrid(PixelSculptor applet, PImage image, int width, int height,
			int scaleRGB) {
		_pApplet = applet;
		_image = image;
		_image.loadPixels();

		_scaleRGB = scaleRGB;
		_dimension = (_image.width * _image.height);

		_cols = width / Math.max(_image.width, 1);
		_rows = height / Math.max(_image.height, 1);

		_grid = new ArrayList<ArrayList<PixelCube>>(_image.width);
		for (int i = 0; i < _image.width; i++) {
			_grid.add(new ArrayList<PixelCube>(_image.height));
		}

		float red, green, blue;

		for (int j = 0; j < _image.height; j++) {
			for (int i = 0; i < _image.width; i++) {

				red = applet.red(_image.get(i, j));
				green = applet.green(image.get(i, j));
				blue = applet.blue(_image.get(i, j));
				_grid.get(i).add(new PixelCube(red, green, blue));

			}
		}
	}

	public void set_renderer(ICubeRenderer renderer) {
		_renderer = renderer;
	}

	public int getScaleRGB() {
		return _scaleRGB;
	}

	public void setScaleRGB(int newScaleRGB) {
		_scaleRGB = newScaleRGB;
	}

	public void incRotationX() {
		_rotationX += 10;
	}

	public void decRotationX() {
		_rotationX -= 10;
	}

	public int getRotationX() {
		return _rotationX;
	}

	public void incRotationZ() {
		_rotationZ += 10;
	}

	public void decRotationZ() {
		_rotationZ -= 10;
	}

	public int getRotationZ() {
		return _rotationZ;
	}

	public int get_width() {
		return _grid.size();
	}

	public void draw() {

		for (int i = 0; i < _grid.size(); i++) {
			for (int j = 0; j < _grid.get(i).size(); j++) {
				_renderer.render(this, _grid.get(i).get(j), i * _cols + _cols
						/ 2, j * _rows + _rows / 2, 0);
			}
		}
	}
	
	public void print()
	{
		ICubeRenderer renderer = CubeRendererFactory.create_cube_renderer(CubeRendererType.Text, _pApplet);
		
		for (int i = 0; i < _grid.size(); i++) {
			for (int j = 0; j < _grid.get(i).size(); j++) {
				renderer.render(this, _grid.get(i).get(j), i * _cols + _cols
						/ 2, j * _rows + _rows / 2, 0);
			}
			PApplet.println("");
		}
			
	}

}
