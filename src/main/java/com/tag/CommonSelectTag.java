
package com.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;
import java.util.Map;
import java.util.Set;


@SuppressWarnings("serial")
public class CommonSelectTag extends BodyTagSupport {
	
	private static final long serialVersionUID = 996559816261001992L;
	private String id;      //Select的id
	private String name;    //Select的name
	private String classes; //Select的classes
	private String style;   //Select的style
	private String disabled;//Select的style
	private String onClick; //Select的单击事件
	private String onChange;//Select的更改事件
	
	private Map<String, String> mappingItem; // 放置在request中的属性名称
	private String checkedValue;    //
	@Override
	public int doStartTag() throws JspException {
		
		StringBuffer sb = new StringBuffer();
		sb.append("<select ");
		if(id != null){
			sb.append(" id=\"" + id + "\"");
		}
		if(name != null){
			sb.append(" name=\"" + name + "\"");
		}
		if(classes != null){
			sb.append(" class=\"" + classes + "\"");
		}
		if(style != null){
			sb.append(" style=\"" + style + "\"");
		}
		if(disabled != null){
			sb.append(" disabled=\"" + disabled + "\"");
		}
		if(onClick != null){
			sb.append(" onClick=\"" + onClick + "\"");
		}
		if(onChange != null){
			sb.append(" onChange=\"" + onChange + "\"");
		}
		
		sb.append(">");
		Set<String> keySet = mappingItem.keySet();
		for(String key:keySet){
			Object val =mappingItem.get(key);
			if(key.equals(checkedValue)){
				sb.append("<option selected='selected' value='" + key + "'>");
			}else{
				sb.append("<option value=\'" + key + "'>");
			}
			sb.append(val);
			sb.append("</option>");
		}
		
		sb.append("</select>");
		
		try {
			pageContext.getOut().print(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
			throw new JspException(e.getMessage());
		}
		
		return SKIP_BODY;
		//return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() throws JspException {
		//return SKIP_PAGE;
		return EVAL_PAGE;
	}

	public Map<String, String> getMappingItem() {
		return mappingItem;
	}


	public void setMappingItem(Map<String, String> mappingItem) {
		this.mappingItem = mappingItem;
	}


	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getClasses() {
		return classes;
	}


	public String getStyle() {
		return style;
	}


	public String getDisabled() {
		return disabled;
	}


	public String getOnClick() {
		return onClick;
	}


	public String getOnChange() {
		return onChange;
	}
	
 
	public void setClasses(String classes) {
		this.classes = classes;
	}


	public void setId(String id) {
		this.id = id;
	}

 


	public void setName(String name) {
		this.name = name;
	}

	
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}


	public void setOnChange(String onChange) {
		this.onChange = onChange;
	}


	public void setOnClick(String onClick) {
		this.onClick = onClick;
	}

 


	public String getCheckedValue() {
		return checkedValue;
	}


	public void setCheckedValue(String checkedValue) {
		this.checkedValue = checkedValue;
	}


	public void setStyle(String style) {
		this.style = style;
	}
	
	
}
