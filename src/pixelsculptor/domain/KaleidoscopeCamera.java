package pixelsculptor.domain;

import pixelsculptor.engine.IConfigurationRepository;
import pixelsculptor.engine.IPixelSculptorStateRepository;
import pixelsculptor.utilities.KeyMap;
import processing.core.PVector;
import ruben.common.processing.applet.BasePApplet;
import kaleidoscope.AppCamera;

public class KaleidoscopeCamera implements ICamera {

	private BasePApplet _applet;
	private AppCamera _camera;
	private KeyMap _keyMap;
	private PVector _pos;
	private PVector _rot;
	private IPixelSculptorStateRepository _stateRepo;
	
	public KaleidoscopeCamera(BasePApplet applet,
			IConfigurationRepository configRepo, KeyMap keyMap, IPixelSculptorStateRepository stateRepo) {

		_applet = applet;
		_keyMap = keyMap;
		_camera = new AppCamera(applet);
		_camera.remapBackwards(keyMap.get_camera_backward());
		_camera.remapForward(keyMap.get_camera_forward());
		_camera.remapLeft(keyMap.get_camera_left());
		_camera.remapRight(keyMap.get_camera_right());
		_camera.remapEscape(keyMap.get_do_activate_ui());
		_camera.setMoveSpeed(configRepo.get_configuration().get_camera_speed());
		_camera.setRotateSpeed(configRepo.get_configuration()
				.get_camera_rotationspeed());

		_pos = configRepo.get_configuration().get_init_camera_position();
		_rot = configRepo.get_configuration().get_init_camera_rotation();
		_stateRepo = stateRepo;
		
	}

	public void begin2D() {
		_camera.begin2D();
	}

	public void end2D() {
		_camera.end2D();
	}

	public void moveDown(int step) {
		_camera.moveDown(step);

	}

	public void moveUp(int step) {
		_camera.moveUp(step);

	}

	
	public void setPosition(float x, float y, float z) {
		_camera.setPosition(x, y, z);
	}

	public void setRotation(float x, float y, float z) {
		_camera.setRotation(x, y, z);
	}

	public void reset() {
		this.setPosition(_pos.x, _pos.y, _pos.z);
		this.setRotation(_rot.x, _rot.y, _rot.z);
	}
	
	public void step() {
		
		
		
		if (!_stateRepo.get_pixelsculptor_state().interactive_camera){
			
			if (!_applet.keyPressed || _applet.key != _keyMap.get_do_activate_ui()) {
				_camera.moveLeft(
						_stateRepo.get_pixelsculptor_state().auto_camera_direction.get_value() *
						_stateRepo.get_pixelsculptor_state().auto_camera_speed.get_value());
				
				_camera.lookAtPoint(-_applet.height/2, 0, _applet.width/2);
			
			}
		}
	}
}
