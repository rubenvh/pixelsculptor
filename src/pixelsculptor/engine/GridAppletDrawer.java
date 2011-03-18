package pixelsculptor.engine;

import ruben.common.processing.applet.BaseAppletDrawer;
import ruben.common.processing.applet.BasePApplet;

public class GridAppletDrawer extends BaseAppletDrawer {

	private BasePApplet _applet;
	private IPixelSculptorStateRepository _stateRepo;
	private IConfigurationRepository _configRepo;
	private IGridRepository _gridRepo;
	
	public GridAppletDrawer(BasePApplet applet, IPixelSculptorStateRepository stateRepo, IConfigurationRepository configRepo, IGridRepository gridRepo) {
		_applet = applet;
		_stateRepo = stateRepo;
		_configRepo = configRepo;
		_gridRepo = gridRepo;
	}
	
	public void draw() {
		// TODO Auto-generated method stub
		handleLightning();
		
		_gridRepo.get_grid().draw();
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
	
	private float _lightsDirX;
	private float _lightsDirZ;

	
	private void handleLightning() {
		int x = 255;
		int y = 25;
		PixelSculptorState state = _stateRepo.get_pixelsculptor_state();
		
		_applet.ambientLight(y, y, y);
		if (state.auto_lights) {
			state.lights_dir.set_value(state.lights_dir.get_value() + _configRepo.get_configuration().get_lightning_speed());
		}
		if (state.lights_dir.get_value() > 2 * Math.PI) state.lights_dir.set_value(0.0f);
		if (state.lights_dir.get_value() < 0) state.lights_dir.set_value((float) (2 * Math.PI));
		_lightsDirX = (float) Math.sin(state.lights_dir.get_value()); 
		_lightsDirZ = (float) Math.cos(state.lights_dir.get_value());
		
		float camPosX = _lightsDirX*state.lightningDistance.get_value()-_applet.width/2;
		float camPosZ = _lightsDirZ*state.lightningDistance.get_value()+_applet.height/2;
		float camPosY = state.lightningHeight.get_value();
		_applet.spotLight(x, x, x, camPosX, camPosY, camPosZ, 0, 1, 0, _applet.PI/2, -0.5f);
		
		// show light source when debug
		if (state.show_debug) {
			_applet.pushMatrix();
			_applet.translate(camPosX, camPosY, camPosZ);
			_applet.box(10,10,10);
			_applet.popMatrix();
		}
		
	}

}
