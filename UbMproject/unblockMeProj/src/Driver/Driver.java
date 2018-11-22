package Driver;

import java.util.Set;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.heuristics.relaxation.Heuristic;
import fr.uga.pddl4j.planners.statespace.search.strategy.BreadthFirstSearch;
import fr.uga.pddl4j.planners.statespace.search.strategy.DepthFirstSearch;
import fr.uga.pddl4j.planners.statespace.search.strategy.StateSpaceStrategy;
import fr.uga.pddl4j.util.BitOp;
import fr.uga.pddl4j.util.Plan;
import mvc.controller.MyController;
import mvc.model.Model;
import mvc.view.MyView;

public class Driver {
	public static void main(String[] args) {
		//CodedProblem codedProblem =Tools.generateCodedProblem("C:\\Users\\rami\\Desktop\\unblockMe\\unblockmePddl4j\\unblockMeD.pddl", "C:\\Users\\rami\\Desktop\\unblockMe\\unblockmePddl4j\\unblockMe-problem3.pddl");
		//StateSpaceStrategy stateSpaceStrategy =new BreadthFirstSearch(60 * 1000);
		//final Plan plan =stateSpaceStrategy.searchPlan(codedProblem);
		//for(BitOp bitop : plan.actions())
		//	System.out.print(codedProblem.toShortString(bitop)+"\n");
		//**************to do: MVC******************

		Model m=new Model();
		MyView v=new MyView();
		MyController controller=new MyController(m,v);
		m.addObserver(controller);
		v.addObserver(controller);
		v.start();


	}

}
