package pixelsculptor.engine;

import pixelsculptor.domain.ImageSourceType;
import ruben.common.processing.applet.BasePApplet;
import ruben.common.processing.utils.FileLoadStrategy;
import ruben.common.processing.video.DirImageSource;
import ruben.common.processing.video.IImageSource;
import ruben.common.processing.video.ImageSource;
import ruben.common.processing.video.OpenCVVideoSource;
import ruben.common.state.IParameter;

public class ImageSourceFactory {
	
	private IImageSource _selected;
	private IImageSource _oneImage;
	private IImageSource _directory;
	private IImageSource _camera;
	private BasePApplet _applet;
	private IConfigurationRepository _configRepo;
	private IPixelSculptorStateRepository _stateRepo;
	
	public ImageSourceFactory(BasePApplet applet, IConfigurationRepository configRepo, IPixelSculptorStateRepository stateRepo) {
		_applet = applet;
		_configRepo = configRepo;
		_stateRepo = stateRepo;
	}
	
	public IImageSource create(ImageSourceType type, IParameter<Integer> maxPixels) {
	
		switch (type) {
		case OneImage:
			if (_oneImage == null) _oneImage = new ImageSource(_applet, maxPixels);
			_oneImage.load(_configRepo.get_configuration().get_init_imagesource_onefile());
			_selected = _oneImage;
			break;
		case Directory:
			if (_directory == null) _directory = new DirImageSource(_applet, maxPixels);
			_directory.load(_configRepo.get_configuration().get_init_imagesource_directory());
			_selected = _directory;
			break;
		case Camera:
			if (_camera == null) _camera = OpenCVVideoSource.Create(_applet, 1, 320, 200, _stateRepo.get_pixelsculptor_state().cameraNumber.get_value(), maxPixels, new CameraNumberLoadStrategy(_stateRepo));
			_selected = _camera;
			break;
		}
		
		return _selected;
	}

}
