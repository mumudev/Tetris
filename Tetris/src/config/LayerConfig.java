package config;

public class LayerConfig {

	/*
	 * ���ڲ�������
	 */
	private String className;
	/*
	 * ��������x
	 */
	private int x;
	/*
	 * ��������y
	 */
	private int y;
	/*
	 * ���ڿ��
	 */
	private int w;
	/*
	 * ���ڸ߶�
	 */
	private int h;
	/*
	 * ���ڲ��������ʼ��
	 */
	public LayerConfig(String className, int x, int y, int w, int h) {
		this.className = className;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	/*
	 * ���ݷ��غ���
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
