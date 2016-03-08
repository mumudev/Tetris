package config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

public class FrameConfig {
	/*
	 * ��Ϸ����
	 */
	private String title;
	/*
	 * ��������
	 */
	private int width;
	/*
	 * ������߶�
	 */
	private int height;
	/*
	 * ����ͼƬ���
	 */
	private int imageWidth;
	/*
	 * ����ͼƬ�߶�
	 */
	private int imageHeight;
	/*
	 * ������θ�
	 */
	private int windowUp;
	/**********************/
	/*
	 * �߿���
	 */
	private int border;
	/*
	 * ���򳤿��С
	 */
	private int boximage;
	/*
	 * С���ڱ���ƫ����
	 */
	private int padding;
	/*
	 * ͼ������
	 */
	private List<LayerConfig> layersConfig;
	/***********************/
	/*
	 * ����˹�����С
	 */
	private int actSize;
	/*
	 * ����˹����λ��
	 * �����ڳ˷���
	 */
	private int sizeRol;
	/*
	 * ��ͼ���
	 */
	private int mapW;
	/*
	 * ��ͼ�߶�
	 */
	private int mapH;
	/***********************/
	public FrameConfig(Element frame) {
//		����UI����
		setUiConfig(frame);
//		���ñ�������
		setBackgoundConfig(frame.element("background"));
//		���õ�ͼ���ԣ�����
		setGameMapConfig(frame.element("gameMap"));
//		���õ�ͼ���ԣ�����
		setGameMapConfig(frame.element("gameMap"));
//		����ͼƬ����
		setphotographConfig(frame.element("photograph"));
	}
	/*
	 * ����UI����
	 */
	private void setUiConfig(Element frame) {
//		����������Ȳ���
		this.width = Integer.parseInt(frame.attributeValue("width"));
//		���������߶Ȳ���
		this.height = Integer.parseInt(frame.attributeValue("height"));
//		������θ�
		this.windowUp = Integer.parseInt(frame.attributeValue("windowUp"));
//		��ñ߿���
		this.border = Integer.parseInt(frame.attributeValue("border"));
//		���С���ڱ���ƫ����
		this.padding = Integer.parseInt(frame.attributeValue("padding"));
//		С���ڲ������ã�className,x,y,w,h��
		@SuppressWarnings("unchecked")
		List<Element> layers=frame.elements("layer");
		layersConfig = new ArrayList<LayerConfig>();
		for(Element layer:layers){
			LayerConfig lc = new LayerConfig(
				layer.attributeValue("className"),
				Integer.parseInt(layer.attributeValue("x")),
				Integer.parseInt(layer.attributeValue("y")),
				Integer.parseInt(layer.attributeValue("w")),
				Integer.parseInt(layer.attributeValue("h"))
			);
			layersConfig.add(lc);
		}
		
	}
	/*
	 * ���ñ�������
	 */
	private void setBackgoundConfig(Element background){
//		��ȡ����ͼƬ���
		this.imageWidth = Integer.parseInt(background.attributeValue("imageWidth"));
//		��ȡ����ͼƬ�߶�
		this.imageHeight = Integer.parseInt(background.attributeValue("imageHeight"));
	}
	/*
	 * ���õ�ͼ����
	 */
	private void setGameMapConfig(Element gameMap) {
//		��õ�ͼ���
		this.mapW = Integer.parseInt(gameMap.attributeValue("width"));
//		��õ�ͼ�߶�
		this.mapH = Integer.parseInt(gameMap.attributeValue("height"));
	}
	/*
	 * ���õ�ͼ����
	 */
	private void setphotographConfig(Element photograph) {
//		��÷����С����
		this.boximage = Integer.parseInt(photograph.attributeValue("boximage"));
//		����˹�����С
		this.actSize = Integer.parseInt(photograph.attributeValue("actSize"));
//		����˹����λ��
		this.sizeRol = Integer.parseInt(photograph.attributeValue("sizeRol"));
		
	}
	/*
	 * ��ȡ��Ϸ��������
	 */
	public String getTitle() {
		return title;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public int getWindowUp() {
		return windowUp;
	}
	public int getImageWidth() {
		return imageWidth;
	}
	public int getImageHeight() {
		return imageHeight;
	}
	public int getboder() {
		return border;
	}
	public int getPadding() {
		return padding;
	}
	public int getBoximage() {
		return boximage;
	}
	public List<LayerConfig> getLayersConfig() {
		return layersConfig;
	}
	public int getActSize() {
		return actSize;
	}
	public int getSizeRol() {
		return sizeRol;
	}
	public int getMapW() {
		return mapW;
	}
	public int getMapH() {
		return mapH;
	}
	
}
