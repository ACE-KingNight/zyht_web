package com.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@SuppressWarnings("serial")
public class DateTimeTag extends TagSupport {
	
	private Object value;    //值
	private String oldFormat = "yyyy-MM-dd";   //原来的日期时间格式
	private String newFormat = "yyyy-MM-dd";   //新的日期时间格式

	@Override
	public int doStartTag() throws JspTagException {
		if (this.value == null) {
			return SKIP_BODY;
		}
		Date date = null;
		if(value instanceof Date){
			date = (Date)value;
		}else if(value instanceof Long){
			date = new Date((Long)value);
		}
		else if(value instanceof String){
			SimpleDateFormat oldSdf = new SimpleDateFormat(oldFormat);
			try {
				date = oldSdf.parse((String)value);
			} catch (ParseException e) {
				System.out.println("请检查oldFormat日期格式");
				e.printStackTrace();
				throw new JspTagException(e.getMessage());
			}
		}
		
		SimpleDateFormat newSdf = new SimpleDateFormat(newFormat);
		String text = newSdf.format(date);
		
		try {
			pageContext.getOut().print(text);
			//return EVAL_BODY_INCLUDE;
			return SKIP_BODY;
		} catch (IOException e) {
			e.printStackTrace();
			throw new JspTagException(e.getMessage());
		}
		
	}
	
	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
		//return SKIP_PAGE;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public void setOldFormat(String oldFormat) {
		this.oldFormat = oldFormat;
	}
	public void setNewFormat(String newFormat) {
		this.newFormat = newFormat;
	}
	
}
