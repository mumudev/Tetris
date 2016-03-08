package config;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/*
 * 游戏配置器
 * 
 * @author CarrollRaider
 * 
 */
public class GameConfig {

	private static FrameConfig FRAME_CONFIG = null;
	
	private static SystemConfig SYSTEM_CONFIG = null;
	
	private static DataConfig DATACONFIG = null;
	static{
		Document doc;
		try {
//			创建XML读取器
			SAXReader reader = new SAXReader();
//			读取XML文件
			doc = reader.read("config/cfg.xml");
//			获得XML文件的根节点
			Element game = doc.getRootElement();
//			创建界面配置对象
			FRAME_CONFIG = new FrameConfig(game.element("frame"));
//			创建系统配置对象
			SYSTEM_CONFIG = new SystemConfig(game.element("system"));
//			创建数据对象
			DATACONFIG = new DataConfig(game.element("data"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private GameConfig(){}
	
	public static FrameConfig getframeConfig() {
		return FRAME_CONFIG;
	}

	public static SystemConfig getSystemConfig() {
		return SYSTEM_CONFIG;
	}

	public static DataConfig getDataConfig() {
		return DATACONFIG;
	}

}


