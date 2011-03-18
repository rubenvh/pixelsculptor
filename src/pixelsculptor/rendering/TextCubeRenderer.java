package pixelsculptor.rendering;

import pixelsculptor.domain.PixelCube;
import pixelsculptor.domain.PixelGrid;
import processing.core.PApplet;

public class TextCubeRenderer implements ICubeRenderer {

	private PApplet _applet;
	
	public TextCubeRenderer(PApplet applet) {
		_applet = applet;
	}
	
	
	public void render(PixelGrid grid, PixelCube cube, float x, float y, float z) {
		
		
		PApplet.print(String.format("(%.2f,%.2f,%.2f)\t", 
				cube.getHeight()/grid.getScaleRGB(), 
				cube.getWidth()/grid.getScaleRGB(),
				cube.getDepth()/grid.getScaleRGB()));
		
		
	}


	public PApplet get_applet() {
		
		return _applet;
	}

}
