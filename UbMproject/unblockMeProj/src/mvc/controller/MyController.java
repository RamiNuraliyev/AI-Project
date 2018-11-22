package mvc.controller;

import java.util.Observable;

import mvc.model.Model;
import mvc.view.MyView;

public class MyController implements Controller{
	Model model;
	MyView view;
	
	public MyController(Model m,MyView v) {
		this.model=m;
		this.view=v;
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof MyView) {
			model.updateModel(arg);
		}else if(o instanceof Model){
			view.udateView(arg);
		}
	}
	

}
