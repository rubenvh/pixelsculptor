package pixelsculptor.engine;

import pixelsculptor.domain.ICamera;
import pixelsculptor.domain.ImageSourceType;
import pixelsculptor.domain.KaleidoscopeCamera;
import pixelsculptor.rendering.CubeRendererType;
import pixelsculptor.utilities.IPixelSculptorConfiguration;
import pixelsculptor.utilities.KeyMap;
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
		doRecord = false;
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
	public Boolean 				doRecord;
	
	
	public static PixelSculptorState create_state(
			PixelSculptor sculptor,
			IPixelSculptorConfiguration config,
			KeyMap keyMap)
	{
		PixelSculptorState state = new PixelSculptorState();
		state.background.set_value(config.get_init_background());
		state.lights_dir.set_value((float) config.get_init_lightsdir());
		state.camera = new KaleidoscopeCamera(sculptor, sculptor, keyMap, sculptor);
		state.camera.reset();
		state.cameraNumber.set_value(config.get_init_camera());
		state.maxPixels.set_value(config.get_init_maxcubes());
		state.lightningDistance.set_value(config.get_init_lightning_distance());

		return state;
	}
}
