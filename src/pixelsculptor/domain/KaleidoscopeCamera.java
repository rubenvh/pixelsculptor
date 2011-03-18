package pixelsculptor.domain;

import pixelsculptor.engine.IConfigurationRepository;
import pixelsculptor.utilities.KeyMap;
import processing.core.PVector;
import ruben.common.processing.applet.BasePApplet;
import kaleidoscope.AppCamera;

public class KaleidoscopeCamera implements ICamera {

	private AppCamera _camera;
	private PVector _pos;
	private PVector _rot;

	public KaleidoscopeCamera(BasePApplet applet,
			IConfigurationRepository configRepo, KeyMap keyMap) {

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
}
