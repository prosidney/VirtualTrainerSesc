package br.com.sesc.virtualtrainersesc.util;

import java.io.Serializable;
import java.util.List;

public class JsonReturn implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<Object> listData;
	private Object data;

	public JsonReturn() {
	}
	
	public List<Object> getListData() {
		return listData;
	}

	public void setListData(List<Object> listData) {
		this.listData = listData;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
