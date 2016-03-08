package config;

public class LayerConfig {

	/*
	 * 窗口参数基类
	 */
	private String className;
	/*
	 * 窗口坐标x
	 */
	private int x;
	/*
	 * 窗口坐标y
	 */
	private int y;
	/*
	 * 窗口宽度
	 */
	private int w;
	/*
	 * 窗口高度
	 */
	private int h;
	/*
	 * 窗口参数基类初始化
	 */
	public LayerConfig(String className, int x, int y, int w, int h) {
		this.className = className;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	/*
	 * 数据返回函数
	 */
	public String getClassName() {
		return className;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}
}
