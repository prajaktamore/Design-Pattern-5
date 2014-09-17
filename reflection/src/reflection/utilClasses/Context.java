package reflection.utilClasses;

import reflection.interfaces.IContext;
import reflection.interfaces.IStrategy;
/**
 * @author Prajakta More
 * Use the Context to see change in behaviour when it changes its Strategy
 */
public class Context implements IContext{
	 private IStrategy strategy;

	   /**
	 * @param strategy
	 */
	public Context(IStrategy strategy){
	      this.strategy = strategy;
	   }

	   /**
	 * @param data
	 * @return
	 */
	public boolean executeStrategy(String data){
	      return strategy.check(data);
	   }
	@Override
	public String toString() {
	    StringBuilder result = new StringBuilder();
	    String NEW_LINE = System.getProperty("line.separator");

	    result.append(""+ NEW_LINE);
	    
	    return result.toString();
	  }

}
