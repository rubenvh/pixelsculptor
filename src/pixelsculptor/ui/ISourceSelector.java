package pixelsculptor.ui;

import pixelsculptor.domain.ImageSourceType;

public interface ISourceSelector {
	
	void select_image_source(ImageSourceType type);
	
	void load_image();

}
