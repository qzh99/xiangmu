package com.yc.qas.entity;

/**
 * easyui树的工具实体
 * 
 * @author Q
 *
 */
public class TreeNode {
	private int id;//树的节点
	private String text;//标题

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "TreeNode [id=" + id + ", text=" + text + "]";
	}

	

}
