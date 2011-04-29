package pixelsculptor.engine;

import pixelsculptor.domain.ICamera;
import pixelsculptor.domain.ImageSourceType;
import pixelsculptor.rendering.CubeRendererType;
import ruben.common.state.IParameter;
import ruben.common.state.Parameter;

public class PixelSculptorState {

	public PixelSculptorState()
	{
		
		background = new Parameter<Integer>(0);
		show_debug = true;
		auto_lights = false;
		interactive_camera = true;
		auto_camera_speed = new Parameter<Float>(1.0f);
		auto_camera_direction = new Parameter<Integer>(1);
		lights_dir = new Parameter<Float>(0.0f);
		strokeWeight =  new Parameter<Integer>(1);
		lightningDistance = new Parameter<Float>(500.0f);
		lightningHeight = new Parameter<Float>(-400f);
		selectedImageSourceType = ImageSourceType.OneImage;
		selectedRenderer = CubeRendererType.Coloured;
		maxPixels = new Parameter<Integer>(20);
		cameraNumber = new Parameter<Integer>(0);
	}
	
	public int foreground() {
		return background.get_value() > 125 ? 0 : 255;
	}
	public IParameter<Integer> 	background; 
	public Boolean 				show_debug;
	public Boolean 				auto_lights;
	public Boolean 				interactive_camera;
	public IParameter<Float>	auto_camera_speed;
	public IParameter<Integer>	auto_camera_direction;
	public IParameter<Float> 	lights_dir;
	public IParameter<Integer> 	strokeWeight;
	public ICamera 				camera;
	public IParameter<Float> 	lightningDistance;
	public IParameter<Float> 	lightningHeight;
	public ImageSourceType 		selectedImageSourceType;
	public CubeRendererType 	selectedRenderer;
	public IParameter<Integer> 	maxPixels;
	public IParameter<Integer> 	cameraNumber;
}
