package pixelsculptor.utilities;

import java.util.Hashtable;
import java.util.Map;

import processing.core.PApplet;
import processing.core.PVector;

public class ConfigurationFile implements IPixelSculptorConfiguration {

	private String _fileName;
	private PApplet _pApplet;
	private Map<String, String> _map;

	public ConfigurationFile(PApplet pApplet, String file) {
		_fileName = file;
		_pApplet = pApplet;
		Init();
	}

	private void Init() {
		String[] lines = _pApplet.loadStrings(_fileName);
		_map = new Hashtable<String, String>(lines.length);

		for (int i = 0; i < lines.length; i++) {
			int sep = lines[i].indexOf("=");

			if (sep > 0) {
				String key = lines[i].substring(0, sep).trim();
				String value = lines[i].substring(sep + 1, lines[i].length())
						.trim();
				_map.put(key, value == "" ? " " : value);

			}
		}
	}

	
	public int get_init_background() {
		return Integer.parseInt(_map.get("INIT.BACKGROUND"));
	}

	
	public int get_init_lightsdir() {
		return Integer.parseInt(_map.get("INIT.LIGHTSDIR"));
	}

	
	public int get_init_rotation_x() {
		return Integer.parseInt(_map.get("INIT.CUBE.ROTATIONX"));
	}

	
	public int get_init_rotation_z() {
		return Integer.parseInt(_map.get("INIT.CUBE.ROTATIONZ"));
	}

	
	public char get_keymap_background_down() {
		return get_char(_map.get("KEYMAP.BACKGROUND.DOWN"));
	}

	
	public char get_keymap_background_up() {
		return get_char(_map.get("KEYMAP.BACKGROUND.UP"));
	}

	
	public char get_keymap_camera_backward() {
		return get_char(_map.get("KEYMAP.CAMERA.BACKWARD"));
	}

	
	public char get_keymap_camera_forward() {
		return get_char(_map.get("KEYMAP.CAMERA.FORWARD"));
	}

	
	public char get_keymap_camera_left() {
		return get_char(_map.get("KEYMAP.CAMERA.LEFT"));
	}

	
	public char get_keymap_camera_right() {
		return get_char(_map.get("KEYMAP.CAMERA.RIGHT"));
	}
	
	
	public char get_keymap_camera_crouch() {
		return get_char(_map.get("KEYMAP.CAMERA.CROUCH"));
	}

	
	public char get_keymap_camera_jump() {
		return get_char(_map.get("KEYMAP.CAMERA.JUMP"));
	}

	
	public char get_keymap_cubes_decscale() {
		return get_char(_map.get("KEYMAP.CUBES.DECSCALE"));
	}

//	
//	public char get_keymap_cubes_decx() {
//		return get_char(_map.get("KEYMAP.CUBES.DECX"));
//	}
//
//	
//	public char get_keymap_cubes_decz() {
//		return get_char(_map.get("KEYMAP.CUBES.DECZ"));
//	}
//
	
	public char get_keymap_cubes_incscale() {
		return get_char(_map.get("KEYMAP.CUBES.INCSCALE"));
	}
//
//	
//	public char get_keymap_cubes_incx() {
//		return get_char(_map.get("KEYMAP.CUBES.INCX"));
//	}

//	
//	public char get_keymap_cubes_incz() {
//		return get_char(_map.get("KEYMAP.CUBES.INCZ"));
//	}

	
	public char get_keymap_do_loadfile() {
		return get_char(_map.get("KEYMAP.DO.LOADFILE"));
	}

	
	public char get_keymap_do_screenshot() {
		return get_char(_map.get("KEYMAP.DO.SCREENSHOT"));
	}

	
	public char get_keymap_do_switch_cube_renderer() {
		return get_char(_map.get("KEYMAP.DO.SWITCHCUBERENDERER"));
	}

	
	public char get_keymap_do_toggle_debug_info() {
		return get_char(_map.get("KEYMAP.DO.TOGGLEDEBUGINFO"));
	}

	
	public char get_keymap_lightning_decdir() {
		return get_char(_map.get("KEYMAP.LIGHTNING.DECDIR"));
	}

	
	public char get_keymap_lightning_incdir() {
		return get_char(_map.get("KEYMAP.LIGHTNING.INCDIR"));
	}

	
	public int get_rgb_scale_factor() {
		return Integer.parseInt(_map.get("INIT.RGBSCALEFACTOR"));
	}

	
	public int get_screen_height() {
		return Integer.parseInt(_map.get("INIT.SCREEN.HEIGHT"));
	}

	
	public int get_screen_width() {
		return Integer.parseInt(_map.get("INIT.SCREEN.WIDTH"));
	}

	
	public PVector get_init_camera_position() {

		return get_pvector(_map.get("INIT.CAMERA.POSITION"));
	}

	
	public PVector get_init_camera_rotation() {
		return get_pvector(_map.get("INIT.CAMERA.ROTATION"));
	}

	private char get_char(String value) {
		if (value.startsWith("\\")) {
			return (char) Integer.parseInt(value.substring(2), 16);
		} else {
			return value.charAt(0);
		}
	}

	private PVector get_pvector(String value) {
		String[] coords = value.split(",");

		PVector result = new PVector(0, 0, 0);
		if (coords.length == 3) {
			result.x = Integer.parseInt(coords[0]);
			result.y = Integer.parseInt(coords[1]);
			result.z = Integer.parseInt(coords[2]);
		}
		return result;
	}

	
	public float get_lightning_speed() {
		return Float.parseFloat(_map.get("INIT.LIGHTNING.SPEED"));
	}

	
	public float get_camera_speed() {
		return Float.parseFloat(_map.get("INIT.CAMERA.SPEED"));
	}
	
	
	public float get_camera_rotationspeed() {
		return Float.parseFloat(_map.get("INIT.CAMERA.ROTATIONSPEED"));
	}

	
	public char get_keymap_do_toggle_autolights() {
		return get_char(_map.get("KEYMAP.DO.TOGGLEAUTOLIGHTS"));
	}

	
	
	public char get_keymap_lightning_decdist() {
		return get_char(_map.get("KEYMAP.LIGHTNING.DECDIST"));
	}

	
	public char get_keymap_lightning_decheight() {
		return get_char(_map.get("KEYMAP.LIGHTNING.DECHEIGHT"));
	}

	
	public char get_keymap_lightning_incdist() {
		return get_char(_map.get("KEYMAP.LIGHTNING.INCDIST"));
	}

	
	public char get_keymap_lightning_incheight() {
		return get_char(_map.get("KEYMAP.LIGHTNING.INCHEIGHT"));
	}

	
	public char get_keymap_cubes_decstroke() {
		return get_char(_map.get("KEYMAP.CUBES.DECSTROKE"));
	}

	
	public char get_keymap_cubes_incstroke() {
		return get_char(_map.get("KEYMAP.CUBES.INCSTROKE"));
	}

	
	public char get_keymap_do_activate_ui() {
		return get_char(_map.get("KEYMAP.DO.ACTIVATE.UI"));
	}

	public String get_init_imagesource_directory()
	{
		return _map.get("INIT.IMAGESOURCE.DIRECTORY");
	}

	public String get_init_imagesource_onefile()
	{
		return _map.get("INIT.IMAGESOURCE.ONEFILE");
	}

	public char get_keymap_do_toggle_interactive()
	{

		return get_char(_map.get("KEYMAP.DO.TOGGLEINTERACTIVE"));
	}

	public int get_init_camera()
	{
		return Integer.parseInt(_map.get("INIT.IMAGESOURCE.CAMERA"));
	}

	

	

}
