package config;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/*
 * ��Ϸ������
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
//			����XML��ȡ��
			SAXReader reader = new SAXReader();
//			��ȡXML�ļ�
			doc = reader.read("config/cfg.xml");
//			���XML�ļ��ĸ��ڵ�
			Element game = doc.getRootElement();
//			�����������ö���
			FRAME_CONFIG = new FrameConfig(game.element("frame"));
//			����ϵͳ���ö���
			SYSTEM_CONFIG = new SystemConfig(game.element("system"));
//			�������ݶ���
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


