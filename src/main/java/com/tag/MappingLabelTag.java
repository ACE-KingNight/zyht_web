package com.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@SuppressWarnings("serial")
public class MappingLabelTag extends BodyTagSupport {

	private Map<String, String> mappingItem; // 放置在request中的属性名称
	private String mappingString; // 映射值字符串，用逗号间隔多个映射关系，每个映射的键与值用冒号间隔
	private String value;    //
		
	@Override
	public int doStartTag() throws JspException {
		if (mappingItem == null && mappingString == null) {
			new JspException("MappingLabelTag必须输入mappingItem或者mappingString");
		}
		//0:总行,1:一级分行,2:二级分行,3:支行,4:网点,9:部门
		if(mappingString != null){
			this.mappingItem = new HashMap<String, String>();
			String[] strArr = mappingString.split(",");
			for(String str:strArr){
				String[] strMap = str.split(":");
				if(strMap.length ==1){
					mappingItem.put(strMap[0], strMap[0]);				
				}
				else if(strMap.length>1){
					mappingItem.put(strMap[0], strMap[1]);
				}				
			}
		}
		String text = mappingItem.get(value);
		if(text == null){
			text ="";
		}
		try {
			pageContext.getOut().print(text);
		} catch (IOException e) {
			e.printStackTrace();
			throw new JspException(e.getMessage());
		}
		
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}
	public void setMappingItem(Map<String, String> mappingItem) {
		this.mappingItem = mappingItem;
	}

	public void setMappingString(String mappingString) {
		this.mappingString = mappingString;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
