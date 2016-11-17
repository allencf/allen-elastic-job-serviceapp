package com.allen.elastic.configurer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.PropertySources;

public class CommonpPropertyPlaceholderConfigurer extends PropertySourcesPlaceholderConfigurer {

	private Map<String, Object> ctxPropertiesMap = new HashMap<String, Object>();
	private Map<String, String> nodePathMap = new HashMap<String, String>();
	
	
	@Override
	public void setPropertySources(PropertySources propertySources) {
		
		for (Iterator iter = propertySources.iterator(); iter.hasNext();) {
			PropertySource propSource = (PropertySource)iter.next();
			if(propSource instanceof PropertiesResource){
				for (Object key : ((Properties)propSource.getSource()).keySet()) {  
		            String keyStr = key.toString();  
		            String value = ((Properties)propSource.getSource()).getProperty(keyStr);  
		            ctxPropertiesMap.put(keyStr, value);  
		        }
			}else{
				/*ConfigNode configNode = (ConfigNode)propSource.getSource();
				for (Object key : configNode.keySet()) {  
		            String keyStr = key.toString();  
		            String value = configNode.get(keyStr);  
		            ctxPropertiesMap.put(keyStr, value);
		            nodePathMap.put(keyStr, configNode.getNode());
		        }
				groupPropertiesMap.put(configNode.getNode(), configNode);*/
			}
		}
		super.setPropertySources(propertySources);
	}


	public Map<String, Object> getCtxPropertiesMap() {
		return ctxPropertiesMap;
	}


	public void setCtxPropertiesMap(Map<String, Object> ctxPropertiesMap) {
		this.ctxPropertiesMap = ctxPropertiesMap;
	}


	public Map<String, String> getNodePathMap() {
		return nodePathMap;
	}


	public void setNodePathMap(Map<String, String> nodePathMap) {
		this.nodePathMap = nodePathMap;
	}
	
	
	

}
