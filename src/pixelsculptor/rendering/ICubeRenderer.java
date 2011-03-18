package pixelsculptor.rendering;

import pixelsculptor.domain.PixelCube;
import pixelsculptor.domain.PixelGrid;
import processing.core.PApplet;

public interface ICubeRenderer {

	PApplet get_applet();

	void render(PixelGrid grid, PixelCube cube, float x, float y, float z);

}
