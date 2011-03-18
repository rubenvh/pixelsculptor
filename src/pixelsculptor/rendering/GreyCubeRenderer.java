package pixelsculptor.rendering;

import pixelsculptor.domain.PixelCube;
import pixelsculptor.domain.PixelGrid;
import processing.core.PApplet;
import ruben.common.state.IParameter;

public class GreyCubeRenderer extends BaseCubeRenderer {

	IParameter<Integer> _strokeWeight;
	
	public GreyCubeRenderer(PApplet applet,  IParameter<Integer> stokeWeight) {
		super(applet);
		_strokeWeight = stokeWeight;
	}

	public void render(PixelGrid grid, PixelCube cube, float x, float y, float z) {
		get_applet().stroke(100);
		get_applet().strokeWeight(_strokeWeight.get_value());
		get_applet().fill(255);

		super.render(grid, cube, x, y, z);
	}
}
