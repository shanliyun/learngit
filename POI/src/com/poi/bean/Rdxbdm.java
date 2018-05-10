package com.poi.bean;

public class Rdxbdm {
	private Integer id;
	
	private String dm;
	
	private String mc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDm() {
		return dm;
	}

	public void setDm(String dm) {
		this.dm = dm;
	}

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	@Override
	public String toString() {
		return "Rdxbdm [id=" + id + ", dm=" + dm + ", mc=" + mc + "]";
	}
	
	
	
}
