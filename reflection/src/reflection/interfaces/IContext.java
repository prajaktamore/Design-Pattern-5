package reflection.interfaces;
/**
 * @author Prajakta More
 * Use the Context to see change in behaviour when it changes its Strategy
 * As this interface is for Context class
 */
public interface IContext {
	/**
	 * @param data
	 * @return boolean
	 */
	public boolean executeStrategy(String data);
}
