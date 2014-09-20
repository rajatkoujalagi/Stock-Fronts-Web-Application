package net.rk.struts2.action;

import org.apache.struts2.util.SubsetIteratorFilter.Decider;

import com.opensymphony.xwork2.ActionSupport;
public class Test extends ActionSupport{
	public String execute(){
		System.out.println("In test");
		return "test";
	}
	
}
