package pixelsculptor.rendering;

import pixelsculptor.domain.PixelCube;
import pixelsculptor.domain.PixelGrid;
import processing.core.PApplet;

public class ColouredCubeRenderer extends BaseCubeRenderer {

	public ColouredCubeRenderer(PApplet applet) {
		super(applet);
		// TODO Auto-generated constructor stub
	}

	public void render(PixelGrid grid, PixelCube cube, float x, float y, float z) {
		get_applet().noStroke();
		// cube.getHeight(),
		// cube.getWidth(),
		// cube.getDepth());

		get_applet().fill(cube.getHeight(), cube.getWidth(), cube.getDepth());

		super.render(grid, cube, x, y, z);
	}

}
