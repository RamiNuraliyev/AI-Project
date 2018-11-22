package mvc.model;

import java.util.Observable;

import Driver.Tools;
import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.planners.statespace.search.strategy.BreadthFirstSearch;
import fr.uga.pddl4j.planners.statespace.search.strategy.DepthFirstSearch;
import fr.uga.pddl4j.planners.statespace.search.strategy.StateSpaceStrategy;
import fr.uga.pddl4j.util.BitOp;
import fr.uga.pddl4j.util.Plan;

public class Model extends Observable{

	String planText=" "; // plan + number of steps
	long startTime=System.currentTimeMillis();
	long endTime;
	int steps=0;
	StateSpaceStrategy stateSpaceStrategy=new BreadthFirstSearch(60 * 1000); //strategy DFS,BFS,more in pddl4j
	
	public void updateModel(Object arg)
	{
		startTime=System.currentTimeMillis();
		
		if(arg.equals("easy"))
		{
			
			CodedProblem codedProblem =Tools.generateCodedProblem("C:\\Users\\rami\\Desktop\\þþunblockMe\\unblockmePddl4j\\unblockMeD.pddl","C:\\Users\\rami\\Desktop\\þþunblockMe\\unblockmePddl4j\\unblockMe-problem3.pddl");
			final Plan plan =stateSpaceStrategy.searchPlan(codedProblem);
			for(BitOp bitop : plan.actions())
			{
				planText+=codedProblem.toShortString(bitop)+"\n";
				steps++;
				//System.out.print(codedProblem.toShortString(bitop)+"\n");
			}
		}
		else if(arg.equals("medium"))
		{
			CodedProblem codedProblem =Tools.generateCodedProblem("C:\\Users\\rami\\Desktop\\þþunblockMe\\unblockmePddl4j\\unblockMeD.pddl", "C:\\Users\\rami\\Desktop\\þþunblockMe\\unblockmePddl4j\\unblockMe-problem4.pddl");
			final Plan plan =stateSpaceStrategy.searchPlan(codedProblem);
			for(BitOp bitop : plan.actions())
			{
				planText+=codedProblem.toShortString(bitop)+"\n";
				steps++;
				//System.out.print(codedProblem.toShortString(bitop)+"\n");
			}
		}
		else if(arg.equals("hard"))
		{
			CodedProblem codedProblem =Tools.generateCodedProblem("C:\\Users\\rami\\Desktop\\þþunblockMe\\unblockmePddl4j\\unblockMeD.pddl", "C:\\Users\\rami\\Desktop\\þþunblockMe\\unblockmePddl4j\\unblockMe-problem7.pddl");
			final Plan plan =stateSpaceStrategy.searchPlan(codedProblem);
			for(BitOp bitop : plan.actions())
			{
				planText+=codedProblem.toShortString(bitop)+"\n";
				steps++;
				//System.out.print(codedProblem.toShortString(bitop)+"\n");
			}
		}
		else if(arg.equals("extreme"))
		{
			CodedProblem codedProblem =Tools.generateCodedProblem("C:\\Users\\rami\\Desktop\\þþunblockMe\\unblockmePddl4j\\unblockMeD.pddl","C:\\Users\\rami\\Desktop\\þþunblockMe\\unblockmePddl4j\\unblockMe-problem600.pddl");
			final Plan plan =stateSpaceStrategy.searchPlan(codedProblem);
			for(BitOp bitop : plan.actions())
			{
				planText+=codedProblem.toShortString(bitop)+"\n";
				steps++;
				//System.out.print(codedProblem.toShortString(bitop)+"\n");
			}
		}
		
		endTime=System.currentTimeMillis()-startTime;
		planText+="\n Time: "+endTime+" ms"+"\n Steps: "+steps;
		setChanged();
		notifyObservers(planText);
		planText=null;
		steps=0;
	}





}
