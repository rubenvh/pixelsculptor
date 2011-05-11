package pixelsculptor.engine;

import java.util.Vector;
import controlP5.ControlEvent;
import controlP5.ControlP5;
import processing.core.*;
import pixelsculptor.domain.*;
import pixelsculptor.rendering.*;
import pixelsculptor.ui.*;
import pixelsculptor.utilities.*;
import ruben.common.processing.applet.*;
import ruben.common.processing.video.*;

//import processing.opengl.*;
//import javax.media.opengl.*;

@SuppressWarnings("serial")
public class PixelSculptor extends BasePApplet implements IRenderSelector,
		ISourceSelector, IConfigurationRepository, IScreenMaterializer,
		IPixelSculptorStateRepository, IImageSourceRepository, IGridRepository,
		IGridListener
{

	public static void main(String args[])
	{

		PApplet.main(new String[] { "display=1", "--bgcolor=#000000",
				"--present-stop-color=#000000", "--exclusive", "--present",
				"pixelsculptor.engine.PixelSculptor" });
	}

	IPixelSculptorConfiguration _config;
	PixelGrid _grid;
	KeyMap _keyMap;
	PixelSculptorUserInterface _ui;
	IImageSource _imageSource;
	PixelSculptorState _state;
	ImageSourceFactory _imageSourceFactory;

	public void setup()
	{

		super.setup();

		_config = new ConfigurationFile(this, "app.config");
		_keyMap = new KeyMap(_config);
		_state = PixelSculptorState.create_state(this, _config, _keyMap);

		size(_config.get_screen_width(), _config.get_screen_height(), P3D);
		frameRate(_config.get_framerate());
		
		PFont font = createFont("Courier", 10, false);
		textFont(font);
		textMode(SCREEN);

		_imageSourceFactory = new ImageSourceFactory(this, this, this);
		select_image_source(ImageSourceType.OneImage);
		
		_drawers.add(new VideoDrawer(this, this, this));
	}

	public void controlEvent(ControlEvent theEvent)
	{

		_ui.controlEvent(theEvent);
	}

	public void draw()
	{

		if (_imageSource.has_next())
		{
			_imageSource.step();
			resetGrid();
		}

		background(_state.background.get_value());

		super.draw();

		_state.camera.step();
	}

	public void mouseReleased()
	{

		if (this.key != _keyMap.get_do_activate_ui())
		{
			_state.camera.reset();
		}

		super.mouseReleased();
	}

	public void keyPressed()
	{

		super.keyPressed();
	}

	public void stop()
	{
		super.stop();
	}

	public void keyReleased()
	{

		if (this.key == _keyMap.get_do_loadfile())
		{
			_imageSource.step();
			resetGrid();
		}
		super.keyReleased();
	}

	public void select_renderer(CubeRendererType type)
	{

		_grid
				.set_renderer(CubeRendererFactory.create_cube_renderer(type,
						this));

		_state.selectedRenderer = type;
	}

	protected void load_applet_drawers()
	{
		_drawers = new Vector<IAppletDrawer>(3);
		_drawers
				.add(new UserInputAppletDrawer(this, this, this, this, _keyMap));
		_drawers.add(new GridAppletDrawer(this, this, this, this));
		_drawers.add(new DebugInfoAppletDrawer(this, this, this, this));

		// ui
		ControlP5 controls = new ControlP5(this);
		controls.setAutoDraw(false);

		_ui = new PixelSculptorUserInterface(this, controls, this, this, this,
				this, this, this, this);
		_drawers.add(_ui);

		

	}

	public IPixelSculptorConfiguration get_configuration()
	{

		return _config;
	}

	public PixelSculptorState get_pixelsculptor_state()
	{
		return _state;
	}

	public IImageSource get_image_source()
	{
		return _imageSource;
	}

	public PixelGrid get_grid()
	{

		return _grid;
	}

	public void select_image_source(ImageSourceType type)
	{

		println("IMAGESOURCE: '" + type.toString() + "' selected");

		_state.selectedImageSourceType = type;
		_imageSource = _imageSourceFactory.create(type, _state.maxPixels);

		while (!_imageSource.is_ready())
			_imageSource.load();

		resetGrid();
	}

	public void load_image()
	{
		_imageSource.load();
		resetGrid();
	}

	private void resetGrid()
	{

		int scale = _config.get_rgb_scale_factor();
		if (_grid != null)
		{
			scale = _grid.getScaleRGB();
		}
		_grid = new PixelGrid(this, _imageSource.get_current_small_image(),
				width, height, scale);
		select_renderer(_state.selectedRenderer);
		// reset_camera();
	}

	public void materialize_screen()
	{
		PApplet.print("Taking a screenshot...");
		this.saveFrame();
		PApplet.println("ok!");

	}

	

	public void reload_grid()
	{
		_imageSource.update();
		resetGrid();
	}
}
