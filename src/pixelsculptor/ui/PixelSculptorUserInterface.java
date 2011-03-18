package pixelsculptor.ui;

import pixelsculptor.engine.*;
import pixelsculptor.rendering.*;
import pixelsculptor.domain.*;
import processing.core.PImage;
import ruben.common.processing.applet.*;
import controlP5.Button;
import controlP5.ControlEvent;
import controlP5.ControlP5;
import controlP5.DropdownList;
import controlP5.Slider;

public class PixelSculptorUserInterface extends BaseAppletDrawer
{

	private DropdownList _cubeRendererSelection_ddl;
	private DropdownList _imageSourceSelection_ddl;
	private Button _loadImage_btn;
	private Button _browseDir_btn;
	private Button _takeScreenshot_btn;
	private Button _moveLights_btn;
	private Button _interactiveCamera_btn;
	private Slider _camera_sld;
	private Slider _maxPixels_sld;
	private Slider _rgbScale_sld;
	private Slider _lineWeight_sld;
	private Slider _background_sld;
	private Slider _lightsDistance_sld;
	private Slider _lightsHeight_sld;
	private Slider _lightsRotation_sld;

	private IRenderSelector _renderSelector;
	private ISourceSelector _srcSelector;
	private IScreenMaterializer _screenMaterializer;
	private BasePApplet _applet;
	private ControlP5 _controls;
	private IPixelSculptorStateRepository _stateRepo;
	private IImageSourceRepository _imageSourceRepo;
	private IGridRepository _gridRepo;

	public PixelSculptorUserInterface(BasePApplet a, ControlP5 controls,
			IRenderSelector renderSelector,
			IScreenMaterializer screenMaterializer,
			ISourceSelector srcSelector,
			IPixelSculptorStateRepository stateRep,
			IImageSourceRepository imageSourceRepo, IGridRepository gridRepo)
	{
		_applet = a;
		_controls = controls;
		_renderSelector = renderSelector;
		_srcSelector = srcSelector;
		_screenMaterializer = screenMaterializer;
		_stateRepo = stateRep;
		_imageSourceRepo = imageSourceRepo;
		_gridRepo = gridRepo;

		create_dropdown_cuberenderer(10, 60, 150, 200);
		_takeScreenshot_btn = _controls.addButton("take screenshot", 0, 170,
				39, 80, 20);
		_moveLights_btn = _controls.addButton("auto lights", 0, 260, 39, 60, 20);
		_interactiveCamera_btn = controls.addButton("interactive mode", 0, 330, 39, 80, 20);
		create_dropdown_imagesource(10, 30, 150, 200);
		_loadImage_btn = _controls.addButton("open", 0, 170, 9, 50, 20);
		_browseDir_btn = _controls.addButton("browse", 0, 170, 9, 50, 20);
		_browseDir_btn.hide();
		_camera_sld = _controls.addSlider("", 0, 3, 170, 9, 50, 20);
		_camera_sld.setNumberOfTickMarks(4);
		_camera_sld.showTickMarks(false);
		_camera_sld.setSliderMode(Slider.VERTICAL);
		_camera_sld.hide();

		_maxPixels_sld = _controls.addSlider("maximum number of pixels", 1, 50,
				10, 10, _applet.height - 140, 200, 10);
		_maxPixels_sld.setNumberOfTickMarks(50);
		_maxPixels_sld.showTickMarks(false);
		_maxPixels_sld.setSliderMode(Slider.VERTICAL);
		_rgbScale_sld = _controls.addSlider("rgb scaling", 1, 20, 5, 10,
				_applet.height - 120, 200, 10);
		_rgbScale_sld.setNumberOfTickMarks(20);
		_rgbScale_sld.showTickMarks(false);
		_rgbScale_sld.setSliderMode(Slider.VERTICAL);
		_lineWeight_sld = _controls.addSlider("line weight", 0, 5, 1, 10,
				_applet.height - 100, 200, 10);
		_lineWeight_sld.setNumberOfTickMarks(6);
		_lineWeight_sld.showTickMarks(false);
		_lineWeight_sld.setSliderMode(Slider.VERTICAL);
		_background_sld = _controls.addSlider("background color", 0, 255, 125,
				10, _applet.height - 80, 200, 10);
		_background_sld.setNumberOfTickMarks(255);
		_background_sld.showTickMarks(false);
		_background_sld.setSliderMode(Slider.VERTICAL);
		_lightsDistance_sld = _controls.addSlider("lightsource distance", 500,
				1000, 500, 10, _applet.height - 60, 200, 10);
		_lightsDistance_sld.setSliderMode(Slider.VERTICAL);
		_lightsHeight_sld = _controls.addSlider("lightsource height", 0, 500,
				400, 10, _applet.height - 40, 200, 10);
		_lightsHeight_sld.setSliderMode(Slider.VERTICAL);
		_lightsRotation_sld = _controls.addSlider("lightsource rotation", 0,
				629, 0, 10, _applet.height - 20, 200, 10);
		_lightsRotation_sld.setSliderMode(Slider.VERTICAL);
	}

	public void controlEvent(ControlEvent theEvent)
	{

		if (theEvent.isGroup())
		{

			if (theEvent.group().equals(_cubeRendererSelection_ddl))
			{

				_renderSelector.select_renderer(CubeRendererType
						.valueOf(_cubeRendererSelection_ddl.stringValue()));

			}
			else if (theEvent.group().equals(_imageSourceSelection_ddl))
			{

				select_image_source();
			}

		}
		else if (theEvent.isController())
		{

			if (theEvent.controller().equals(_loadImage_btn))
			{
				_srcSelector.load_image();
			}
			else if (theEvent.controller().equals(_takeScreenshot_btn))
			{
				_screenMaterializer.materialize_screen();
			}
			else if (theEvent.controller().equals(_moveLights_btn))
			{
				_stateRepo.get_pixelsculptor_state().auto_lights = !_stateRepo.get_pixelsculptor_state().auto_lights;
			}
			else if (theEvent.controller().equals(_interactiveCamera_btn))
			{
				_stateRepo.get_pixelsculptor_state().interactive_camera = !_stateRepo.get_pixelsculptor_state().interactive_camera;
			}
			else if (theEvent.controller().equals(_background_sld))
			{
				_stateRepo.get_pixelsculptor_state().background
						.set_value((int) _background_sld.value());
			}
			else if (theEvent.controller().equals(_lineWeight_sld))
			{
				_stateRepo.get_pixelsculptor_state().strokeWeight
						.set_value((int) _lineWeight_sld.value());
			}
			else if (theEvent.controller().equals(_lightsDistance_sld))
			{
				_stateRepo.get_pixelsculptor_state().lightningDistance
						.set_value(_lightsDistance_sld.value());
			}
			else if (theEvent.controller().equals(_lightsHeight_sld))
			{

				_stateRepo.get_pixelsculptor_state().lightningHeight
						.set_value(-1 * _lightsHeight_sld.value());
			}
			else if (theEvent.controller().equals(_lightsRotation_sld))
			{

				_stateRepo.get_pixelsculptor_state().lights_dir
						.set_value(_lightsRotation_sld.value() / 100.0f);
			}
			else if (theEvent.controller().equals(_rgbScale_sld))
			{

				_gridRepo.get_grid().setScaleRGB((int) _rgbScale_sld.value());
			}
			else if (theEvent.controller().equals(_maxPixels_sld))
			{
				_stateRepo.get_pixelsculptor_state().maxPixels
						.set_value(((int) _maxPixels_sld.value()));
			}
			else if (theEvent.controller().equals(_camera_sld))
			{
				if (_stateRepo.get_pixelsculptor_state().cameraNumber.get_value() != (int)_camera_sld.value())
				{
					_stateRepo.get_pixelsculptor_state().cameraNumber.set_value((int)_camera_sld.value());
					_srcSelector.load_image();
				}
			}

		}
	}

	public void draw()
	{
		if (_stateRepo.get_pixelsculptor_state().show_debug)
		{

			update_values();

			_applet.noLights();
			_stateRepo.get_pixelsculptor_state().camera.begin2D();
			_controls.draw();

			PImage image = _imageSourceRepo.get_image_source()
					.get_current_image();
			_applet.image(image, _applet.width - 120, _applet.height - 120,
					100, 100);

			_applet.fill(_stateRepo.get_pixelsculptor_state().foreground());
			_applet.text(_imageSourceRepo.get_image_source().get_source_name(),
					230, 25);

			_stateRepo.get_pixelsculptor_state().camera.end2D();
		}
	}

	public void keyPressed()
	{
		// TODO Auto-generated method stub

	}

	public void keyReleased()
	{
		// TODO Auto-generated method stub

	}

	public void mousePressed()
	{
		// TODO Auto-generated method stub

	}

	public void mouseReleased()
	{
		// TODO Auto-generated method stub

	}

	private void update_values()
	{
		PixelSculptorState state = _stateRepo.get_pixelsculptor_state();

		_maxPixels_sld.setValue(state.maxPixels.get_value());
		_background_sld.setValue(state.background.get_value());
		_rgbScale_sld.setValue(_gridRepo.get_grid().getScaleRGB());
		_lineWeight_sld.setValue(state.strokeWeight.get_value());
		_lightsDistance_sld.setValue(state.lightningDistance.get_value());
		_lightsHeight_sld.setValue(-1 * state.lightningHeight.get_value());
		_lightsRotation_sld.setValue(state.lights_dir.get_value() * 100);
		
		_moveLights_btn.setColorBackground(state.auto_lights? _applet.color(0, 125, 100) : _applet.color(60));
		_interactiveCamera_btn.setColorBackground(state.interactive_camera? _applet.color(0, 125, 100) : _applet.color(60));
	}

	private void select_image_source()
	{
		ImageSourceType type = ImageSourceType
				.valueOf(_imageSourceSelection_ddl.stringValue());
		_srcSelector.select_image_source(type);

		_loadImage_btn.hide();
		_browseDir_btn.hide();
		_camera_sld.hide();
		switch (type)
		{
		case OneImage:
			_loadImage_btn.show();
			break;
		case Directory:
			_browseDir_btn.show();
			break;
		case Camera:
			_camera_sld.show();
			break;
		}

	}

	private void create_dropdown_cuberenderer(int x, int y, int w, int h)
	{
		// dropdown: cube renderer
		_cubeRendererSelection_ddl = _controls.addDropdownList("myList-p1", x,
				y, w, h);
		_cubeRendererSelection_ddl.setBackgroundColor(_applet.color(190));
		_cubeRendererSelection_ddl.setItemHeight(30);
		_cubeRendererSelection_ddl.setBarHeight(20);
		_cubeRendererSelection_ddl.captionLabel().set("Select a renderer ...");
		_cubeRendererSelection_ddl.captionLabel().style().marginTop = 5;
		_cubeRendererSelection_ddl.captionLabel().style().marginLeft = 5;
		_cubeRendererSelection_ddl.valueLabel().style().marginTop = 5;
		CubeRendererType[] types = CubeRendererType.values();
		for (int i = 0; i < types.length; i++)
		{
			if (types[i] == CubeRendererType.Text) continue;
			_cubeRendererSelection_ddl.addItem(types[i].name(), i);
		}
		_cubeRendererSelection_ddl.setColorBackground(_applet.color(60));
		_cubeRendererSelection_ddl.setColorActive(_applet.color(255, 128));
	}

	private void create_dropdown_imagesource(int x, int y, int w, int h)
	{
		// dropdown: image source selection
		_imageSourceSelection_ddl = _controls.addDropdownList("myList-p2", x,
				y, w, h);
		_imageSourceSelection_ddl.setBackgroundColor(_applet.color(190));
		_imageSourceSelection_ddl.setItemHeight(30);
		_imageSourceSelection_ddl.setBarHeight(20);
		_imageSourceSelection_ddl.captionLabel().set(
				"Select an image source ...");
		_imageSourceSelection_ddl.captionLabel().style().marginTop = 5;
		_imageSourceSelection_ddl.captionLabel().style().marginLeft = 5;
		_imageSourceSelection_ddl.valueLabel().style().marginTop = 5;
		ImageSourceType[] types = ImageSourceType.values();
		for (int i = 0; i < types.length; i++)
		{
			_imageSourceSelection_ddl.addItem(types[i].name(), i);
		}
		_imageSourceSelection_ddl.setColorBackground(_applet.color(60));
		_imageSourceSelection_ddl.setColorActive(_applet.color(255, 128));
	}
}
