package pixelsculptor.utilities;

import pixelsculptor.engine.IConfigurationRepository;
import pixelsculptor.engine.IPixelSculptorStateRepository;
import codeanticode.gsvideo.GSMovieMaker;
import ruben.common.processing.applet.BaseAppletDrawer;
import ruben.common.processing.applet.BasePApplet;

public class VideoDrawer extends BaseAppletDrawer
{
	IConfigurationRepository _configRepo;
	GSMovieMaker _movie;
	BasePApplet _applet;
	IPixelSculptorStateRepository _stateRepo;

	public VideoDrawer(BasePApplet applet, IConfigurationRepository configRepo,
			IPixelSculptorStateRepository stateRepo)
	{
		_configRepo = configRepo;
		_applet = applet;
		_stateRepo = stateRepo;
	}

	public void draw()
	{
		if (_stateRepo.get_pixelsculptor_state().doRecord)
		{
			if (_movie == null)
			{
				BasePApplet.println(String.format("Starting movie '%s'",
						_configRepo.get_configuration().get_target_movie()));
				_movie = new GSMovieMaker(
						_applet, 
						_applet.width,
						_applet.height, 
						_configRepo.get_configuration().get_target_movie(),
						GSMovieMaker.XVID,
						GSMovieMaker.HIGH,
						_configRepo.get_configuration().get_framerate());
				
				_movie.start();
			}
			_applet.loadPixels();
			_movie.addFrame(_applet.pixels);
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

	public void cleanup()
	{
		if (_movie != null)
		{
			BasePApplet.println(String.format("Finishing movie '%s'",
					_configRepo.get_configuration().get_target_movie()));
			_movie.finish();
		}
	}

}
