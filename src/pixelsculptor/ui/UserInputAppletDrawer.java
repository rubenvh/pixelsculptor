package pixelsculptor.ui;

import pixelsculptor.engine.IGridRepository;
import pixelsculptor.engine.IPixelSculptorStateRepository;
import pixelsculptor.engine.PixelSculptorState;
import pixelsculptor.utilities.KeyMap;
import processing.core.PApplet;
import ruben.common.processing.applet.BaseAppletDrawer;
import ruben.common.processing.applet.BasePApplet;

public class UserInputAppletDrawer extends BaseAppletDrawer {

	private BasePApplet _applet;
	private IPixelSculptorStateRepository _stateRepo;
	private KeyMap _keyMap;
	private PixelSculptorState _state;
	private IGridRepository _gridRepo;
	private IScreenMaterializer _screenMaterializer;
	
	public UserInputAppletDrawer(BasePApplet applet, IPixelSculptorStateRepository stateRepo, IGridRepository gridRepo, IScreenMaterializer s, KeyMap keymap) {
		_applet = applet;
		_stateRepo = stateRepo;
		_keyMap = keymap;
		_gridRepo = gridRepo;
		_screenMaterializer = s;
	}
	
	public void draw() {
		// TODO Auto-generated method stub

	}

	
	
	public void keyPressed() {

		_state = _stateRepo.get_pixelsculptor_state();
		
		if (_applet.key == _keyMap.get_lightning_incdir()) {
			_state.lights_dir.set_value(_state.lights_dir.get_value() + 0.1f);
		} else if (_applet.key == _keyMap.get_lightning_decdir()) {
			_state.lights_dir.set_value(_state.lights_dir.get_value() - 0.1f);
		} else if (_applet.key == _keyMap.get_lightning_decdist()) {
			_state.lightningDistance.set_value(_state.lightningDistance.get_value()- 10);		
		} else if (_applet.key == _keyMap.get_lightning_incdist()) {
			_state.lightningDistance.set_value(_state.lightningDistance.get_value()+ 10);	
		} else if (_applet.key == _keyMap.get_lightning_decheight()) {
			_state.lightningHeight.set_value(_state.lightningHeight.get_value()+ 10);
		} else if (_applet.key == _keyMap.get_lightning_incheight()) {
			_state.lightningHeight.set_value(_state.lightningHeight.get_value()- 10);
		} else if (_applet.key == _keyMap.get_cubes_incscale()) {
			adjustScaleRGB(Math.max(1, _gridRepo.get_grid().getScaleRGB() - 1));
		} else if (_applet.key == _keyMap.get_cubes_decscale()) {
			adjustScaleRGB(_gridRepo.get_grid().getScaleRGB() + 1);
		} else if (_applet.key == _keyMap.get_cubes_incstroke()) {
			_state.strokeWeight.set_value(_state.strokeWeight.get_value()+1);
		} else if (_applet.key == _keyMap.get_cubes_decstroke()) {
			_state.strokeWeight.set_value(_state.strokeWeight.get_value()-1);
		} else if (_applet.key == _keyMap.get_background_down()) {
			_state.background.set_value(Math.max(_state.background.get_value() - 10, 0));
		} else if (_applet.key == _keyMap.get_background_up()) {
			_state.background.set_value(Math.min(_state.background.get_value() + 10, 255));
		} else if (_applet.key == _keyMap.get_do_toggle_debug_info()) {
			_state.show_debug = !_state.show_debug;
		} else if (_applet.key == _keyMap.get_camera_jump()) {
			_state.camera.moveUp(20);
		} else if (_applet.key == _keyMap.get_camera_crouch()) {
			_state.camera.moveDown(20);
		} else if (_applet.key == _keyMap.get_do_toggle_autolights()) {
			_state.auto_lights = !_state.auto_lights;
		}
	}

	public void keyReleased() {
		if (_applet.key == _keyMap.get_do_screenshot()) {
			_screenMaterializer.materialize_screen();
		}
	
	}

	public void mousePressed() {
		// TODO Auto-generated method stub

	}

	public void mouseReleased() {
		// TODO Auto-generated method stub

	}
	
	
	private void adjustScaleRGB(int scale) {
		PApplet.println("Adjusting SCALE RGB value:");
		_gridRepo.get_grid().setScaleRGB(scale);
		//_grid.print();
	}

}
