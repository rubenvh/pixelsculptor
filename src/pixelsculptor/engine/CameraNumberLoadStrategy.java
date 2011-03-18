package pixelsculptor.engine;

import ruben.common.processing.utils.ILoadStrategy;

public class CameraNumberLoadStrategy implements ILoadStrategy
{
	private IPixelSculptorStateRepository _stateRepo;
	
	public CameraNumberLoadStrategy(IPixelSculptorStateRepository stateRepo)
	{
		_stateRepo = stateRepo;		
	}
	
	public String get_source()
	{
		return Integer.toString(_stateRepo.get_pixelsculptor_state().cameraNumber.get_value());
	}

}
