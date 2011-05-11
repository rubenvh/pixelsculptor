package pixelsculptor.utilities;

public class KeyMap {

	// private Map<String,Character> _keyMap;
	IPixelSculptorConfiguration _config;

	public KeyMap(IPixelSculptorConfiguration config) {
		_config = config;
	}

	public char get_background_down() {
		return _config.get_keymap_background_down();
	}

	public char get_background_up() {
		return _config.get_keymap_background_up();
	}

	public char get_camera_backward() {
		return _config.get_keymap_camera_backward();
	}

	public char get_camera_forward() {
		return _config.get_keymap_camera_forward();
	}

	public char get_camera_left() {
		return _config.get_keymap_camera_left();
	}

	public char get_camera_right() {
		return _config.get_keymap_camera_right();
	}
	
	public char get_camera_jump() 
	{
		return _config.get_keymap_camera_jump();
	}
	
	public char get_camera_crouch() 
	{
		return _config.get_keymap_camera_crouch();
	}
	

	public char get_cubes_decscale() {
		return _config.get_keymap_cubes_decscale();
	}

//	public char get_cubes_decx() {
//		return _config.get_keymap_cubes_decx();
//	}
//
//	public char get_cubes_decz() {
//		return _config.get_keymap_cubes_decz();
//	}

	public char get_cubes_incscale() {
		return _config.get_keymap_cubes_incscale();
	}
	
	public char get_cubes_decstroke() {
		return _config.get_keymap_cubes_decstroke();
	}
	
	public char get_cubes_incstroke() {
		return _config.get_keymap_cubes_incstroke();
	}

//	public char get_cubes_incx() {
//		return _config.get_keymap_cubes_incx();
//	}
//
//	public char get_cubes_incz() {
//		return _config.get_keymap_cubes_incz();
//	}

	public char get_do_loadfile() {
		return _config.get_keymap_do_loadfile();
	}

	public char get_do_activate_ui() {
		return _config.get_keymap_do_activate_ui();
	}
	public char get_do_screenshot() {
		return _config.get_keymap_do_screenshot();
	}

	public char get_do_switch_cube_renderer() {
		return _config.get_keymap_do_switch_cube_renderer();
	}

	public char get_do_toggle_debug_info() {
		return _config.get_keymap_do_toggle_debug_info();
	}
	
	public char get_do_toggle_autolights() {
		return _config.get_keymap_do_toggle_autolights();
	}

	public char get_lightning_decdir() {
		return _config.get_keymap_lightning_decdir();
	}

	public char get_lightning_incdir() {
		return _config.get_keymap_lightning_incdir();
	}
	
	public char get_lightning_decdist() {
		return _config.get_keymap_lightning_decdist();
	}

	public char get_lightning_incdist() {
		return _config.get_keymap_lightning_incdist();
	}
	
	public char get_lightning_decheight() {
		return _config.get_keymap_lightning_decheight();
	}

	public char get_lightning_incheight() {
		return _config.get_keymap_lightning_incheight();
	}

	public char get_do_toggle_interactive()
	{
		return _config.get_keymap_do_toggle_interactive();
	}

	public char get_do_record()
	{
		return _config.get_keymap_do_record();
	}
}
