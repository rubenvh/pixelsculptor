package pixelsculptor.ui;

import pixelsculptor.engine.IConfigurationRepository;
import pixelsculptor.engine.IGridRepository;
import pixelsculptor.engine.IPixelSculptorStateRepository;
import pixelsculptor.engine.PixelSculptorState;
import ruben.common.processing.applet.BaseAppletDrawer;
import ruben.common.processing.applet.BasePApplet;

public class DebugInfoAppletDrawer extends BaseAppletDrawer {

	private BasePApplet _applet;
	private IConfigurationRepository _configRepo;
	private IPixelSculptorStateRepository _stateRepo;
	private IGridRepository _gridRepo;
	
	public DebugInfoAppletDrawer(BasePApplet applet,IConfigurationRepository configRepo, IPixelSculptorStateRepository stateRepo, IGridRepository gridRepo) {
		_applet = applet;
		_configRepo = configRepo;
		_stateRepo = stateRepo;
		_gridRepo = gridRepo;
	}
	
	public void draw() {
		if (_stateRepo.get_pixelsculptor_state().show_debug) {
			show_debug();
		}
	}

	
	public void keyPressed() {
		// TODO Auto-generated method stub

	}

	public void keyReleased() {
		// TODO Auto-generated method stub

	}

	public void mousePressed() {
		// TODO Auto-generated method stub

	}

	public void mouseReleased() {
		// TODO Auto-generated method stub

	}
	
	
	private void show_debug() {
		_applet.fill(_stateRepo.get_pixelsculptor_state().foreground());

		PixelSculptorState state = _stateRepo.get_pixelsculptor_state();

		String output = String
				.format(
						//"SCREENWIDTH = %d\nSCREENHEIGHT = %d\nBACKGROUND = %d\nSTROKEWIDTH = %d\nLIGHTSDIR[X,Y] = %.2f[%.2f,%.2f]\nLIGHTNING[distance,height] = [%.2f,%.2f]\nSCALE = %d\nCAMERA POS = %.2f,%.2f,%.2f\nCAMERA ROTATION = %.2f, %.2f, %.2f\nCAMERA UPVECTOR = %.2f, %.2f, %.2f\nCAMERA LOOK = %.2f, %.2f, %.2f\nFPS = %.2f",
						"FPS = %.2f",
						/*_configRepo.get_configuration().get_screen_width(),
						_configRepo.get_configuration().get_screen_height(), _stateRepo.get_pixelsculptor_state().background.get_value() , _stateRepo.get_pixelsculptor_state().strokeWeight.get_value(), _stateRepo.get_pixelsculptor_state().lights_dir.get_value(),
						_lightsDirX, _lightsDirZ, state.lightningDistance.get_value(), state.lightningHeight.get_value(), 						
						_gridRepo.get_grid().getScaleRGB(), _camera.getPosition().x,
						_camera.getPosition().y, _camera.getPosition().z,
						_camera.getRotation().x, _camera.getRotation().y,
						_camera.getRotation().z, _camera.getUpVector().x,
						_camera.getUpVector().y, _camera.getUpVector().z,
						_camera.getLook().x, _camera.getLook().y, _camera
								.getLook().z, */_applet.frameRate);
		
		_applet.text(output, _applet.width-110, _applet.height-5);
	}

}
