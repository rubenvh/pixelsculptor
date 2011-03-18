package pixelsculptor.rendering;

import pixelsculptor.engine.PixelSculptor;

public class CubeRendererFactory {

	public static ICubeRenderer create_cube_renderer(CubeRendererType key,
			PixelSculptor pApplet) {
		switch (key) {
		case Coloured:
			return new ColouredCubeRenderer(pApplet);
		case Wireframe:
			return new WireframeCubeRenderer(pApplet, pApplet.get_pixelsculptor_state().strokeWeight);
		case Grey:
			return new GreyCubeRenderer(pApplet, pApplet.get_pixelsculptor_state().strokeWeight);
		case Text:
			return new TextCubeRenderer(pApplet);
		default:
			return new ColouredCubeRenderer(pApplet);
		}
	}
}
