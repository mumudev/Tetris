package config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

public class FrameConfig {
	/*
	 * 游戏名称
	 */
	private String title;
	/*
	 * 主界面宽度
	 */
	private int width;
	/*
	 * 主界面高度
	 */
	private int height;
	/*
	 * 背景图片宽度
	 */
	private int imageWidth;
	/*
	 * 背景图片高度
	 */
	private int imageHeight;
	/*
	 * 主界面拔高
	 */
	private int windowUp;
	/**********************/
	/*
	 * 边框厚度
	 */
	private int border;
	/*
	 * 方框长宽大小
	 */
	private int boximage;
	/*
	 * 小窗口标题偏移量
	 */
	private int padding;
	/*
	 * 图层属性
	 */
	private List<LayerConfig> layersConfig;
	/***********************/
	/*
	 * 俄罗斯方块大小
	 */
	private int actSize;
	/*
	 * 俄罗斯方块位移
	 * （用于乘法）
	 */
	private int sizeRol;
	/*
	 * 地图宽度
	 */
	private int mapW;
	/*
	 * 地图高度
	 */
	private int mapH;
	/***********************/
	public FrameConfig(Element frame) {
//		设置UI属性
		setUiConfig(frame);
//		设置背景属性
		setBackgoundConfig(frame.element("background"));
//		设置地图属性（长宽）
		setGameMapConfig(frame.element("gameMap"));
//		设置地图属性（长宽）
		setGameMapConfig(frame.element("gameMap"));
//		设置图片参数
		setphotographConfig(frame.element("photograph"));
	}
	/*
	 * 设置UI参数
	 */
	private void setUiConfig(Element frame) {
//		获得主界面宽度参数
		this.width = Integer.parseInt(frame.attributeValue("width"));
//		获得主界面高度参数
		this.height = Integer.parseInt(frame.attributeValue("height"));
//		主界面拔高
		this.windowUp = Integer.parseInt(frame.attributeValue("windowUp"));
//		获得边框厚度
		this.border = Integer.parseInt(frame.attributeValue("border"));
//		获得小窗口标题偏移量
		this.padding = Integer.parseInt(frame.attributeValue("padding"));
//		小窗口参数设置（className,x,y,w,h）
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
	 * 设置背景参数
	 */
	private void setBackgoundConfig(Element background){
//		获取背景图片宽度
		this.imageWidth = Integer.parseInt(background.attributeValue("imageWidth"));
//		获取背景图片高度
		this.imageHeight = Integer.parseInt(background.attributeValue("imageHeight"));
	}
	/*
	 * 设置地图属性
	 */
	private void setGameMapConfig(Element gameMap) {
//		获得地图宽度
		this.mapW = Integer.parseInt(gameMap.attributeValue("width"));
//		获得地图高度
		this.mapH = Integer.parseInt(gameMap.attributeValue("height"));
	}
	/*
	 * 设置地图属性
	 */
	private void setphotographConfig(Element photograph) {
//		获得方框大小参数
		this.boximage = Integer.parseInt(photograph.attributeValue("boximage"));
//		俄罗斯方块大小
		this.actSize = Integer.parseInt(photograph.attributeValue("actSize"));
//		俄罗斯方块位移
		this.sizeRol = Integer.parseInt(photograph.attributeValue("sizeRol"));
		
	}
	/*
	 * 获取游戏窗口数据
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
