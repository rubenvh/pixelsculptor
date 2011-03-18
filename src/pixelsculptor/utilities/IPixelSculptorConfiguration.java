package pixelsculptor.utilities;

import processing.core.PVector;

public interface IPixelSculptorConfiguration {

	int get_screen_width();

	int get_screen_height();

	int get_rgb_scale_factor();
	
	float get_lightning_speed();
	
	float get_camera_speed();
	
	float get_camera_rotationspeed();

	int get_init_background();

	int get_init_lightsdir();

	int get_init_rotation_x();

	int get_init_rotation_z();
	
	PVector get_init_camera_position();
	
	PVector get_init_camera_rotation();

	String get_init_imagesource_onefile();
	
	String get_init_imagesource_directory();
	
	char get_keymap_camera_forward();

	char get_keymap_camera_backward();

	char get_keymap_camera_left();

	char get_keymap_camera_right();
	
	char get_keymap_camera_jump();
	
	char get_keymap_camera_crouch();

	char get_keymap_cubes_incscale();

	char get_keymap_cubes_decscale();
	
	char get_keymap_cubes_incstroke();

	char get_keymap_cubes_decstroke();

	char get_keymap_lightning_incdir();

	char get_keymap_lightning_decdir();
	
	char get_keymap_lightning_incdist();

	char get_keymap_lightning_decdist();
	
	char get_keymap_lightning_incheight();

	char get_keymap_lightning_decheight();

	char get_keymap_do_screenshot();

	char get_keymap_do_loadfile();

	char get_keymap_background_up();

	char get_keymap_background_down();

	char get_keymap_do_toggle_debug_info();

	char get_keymap_do_toggle_autolights();
	
	char get_keymap_do_switch_cube_renderer();

	char get_keymap_do_activate_ui();

}
