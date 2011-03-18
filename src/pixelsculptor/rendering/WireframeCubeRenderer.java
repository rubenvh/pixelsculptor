package pixelsculptor.rendering;

import pixelsculptor.domain.PixelCube;
import pixelsculptor.domain.PixelGrid;
import ruben.common.state.IParameter;
import processing.core.PApplet;

public class WireframeCubeRenderer extends BaseCubeRenderer {

	IParameter<Integer> _strokeWeight;
	
	public WireframeCubeRenderer(PApplet applet, IParameter<Integer> stokeWeight) {
		super(applet);
		
		_strokeWeight = stokeWeight;
	}

	// TODO: get strokeWidth from configuration file

	public void render(PixelGrid grid, PixelCube cube, float x, float y, float z) {
		get_applet().stroke(255);
		get_applet().strokeWeight(_strokeWeight.get_value());

		get_applet().noFill();

		super.render(grid, cube, x, y, z);
	}

}
