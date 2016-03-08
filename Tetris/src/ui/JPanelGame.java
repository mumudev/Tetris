package ui;

import java.awt.Graphics;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import config.FrameConfig;
import config.GameConfig;
import config.LayerConfig;
import control.PlayerControl;
import dto.GameDto;

@SuppressWarnings("serial")
public class JPanelGame extends JPanel{
	/**
	 * 
	 */
	
	private List<Layer> layers=null;
	
	private GameDto dto = null;
	
	public JPanelGame(GameDto dto){
//		获得游戏数据
		this.dto=dto;
//		初始化组件
		initComponent();
//		初始化层
		initLayer();
	}
	public void setPlaerControl(PlayerControl playerControl) {
		this.addKeyListener(playerControl);
	}
	/*
	 * 初始化组件
	 */
	private void initComponent() {
		
	}
	/*
	 * 初始化层
	 */
	private void initLayer() {

		try {
//			获得游戏配置
			FrameConfig cfg=GameConfig.getframeConfig();
//			获得层配置
			List<LayerConfig> layersCfg = cfg.getLayersConfig();
//			创建游戏层数组
			layers =new ArrayList<Layer>(layersCfg.size());
//			创建所有层对象
			for(LayerConfig layerCfg : layersCfg){
//			获得类对象
					Class<?> cls =Class.forName(layerCfg.getClassName());
//			获得构造函数
					Constructor<?> ctr = cls.getConstructor(int.class,int.class,int.class,int.class);
//			调用构造函数创建对象
					Layer layer = (Layer)ctr.newInstance(
							layerCfg.getX(),
							layerCfg.getY(),
							layerCfg.getW(),
							layerCfg.getH()
							);
//					设置游戏数据对象
					layer.setDto(this.dto);
//					把创建的Layer对象放入集合
					layers.add(layer);
					
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	@Override
	public void paintComponent(Graphics g){
//		调用基类方法
		super.paintComponent(g);
//		绘制游戏界面
		for(Layer l:layers){
//			刷新层窗口
			l.paint(g);
		}
		this.requestFocus();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
