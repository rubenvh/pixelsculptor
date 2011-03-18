package pixelsculptor.rendering;

import pixelsculptor.domain.PixelCube;
import pixelsculptor.domain.PixelGrid;
import processing.core.PApplet;

public abstract class BaseCubeRenderer implements ICubeRenderer {

	private PApplet _pApplet;

	public BaseCubeRenderer(PApplet applet) {
		_pApplet = applet;
	}

	public PApplet get_applet() {
		return _pApplet;
	}

	public void render(PixelGrid grid, PixelCube cube, float x, float y, float z) {
		_pApplet.pushMatrix();

		// Actually correct, but couldn't get camera right so updated the rendering of boxes instead
//		_pApplet.translate(x, y, z);		
//		_pApplet.rotateX(PConstants.PI / 3 + grid.getRotationX()
//				/ (float) _pApplet.width * PConstants.PI);
//		_pApplet.rotateZ(PConstants.PI / 3 + grid.getRotationZ()
//				/ (float) _pApplet.height * PConstants.PI);
//		_pApplet.box(cube.getHeight() / grid.getScaleRGB(), cube.getWidth()
//				/ grid.getScaleRGB(), cube.getDepth() / grid.getScaleRGB());

		
		_pApplet.translate(-y, -z, x);
		_pApplet.box(cube.getDepth() / grid.getScaleRGB(), cube.getHeight() / grid.getScaleRGB(), cube.getWidth()/ grid.getScaleRGB());
		
		_pApplet.popMatrix();
	}
}
