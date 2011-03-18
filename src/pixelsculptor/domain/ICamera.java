package pixelsculptor.domain;

public interface ICamera {
	
	void begin2D();
	void end2D();
	void moveUp(int step);
	void moveDown(int step);
	void setPosition(float x, float y, float z);
	void setRotation(float x, float y, float z);
	void reset();

}
