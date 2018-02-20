package e2e;

import actions.SinoptikUaActions;
import base.SeleniumBaseTest;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:01 PM
 * purpose of the class is to contain relatively "long" scenarios like search and verify results
 */
public class SinoptikUaGetPressuresTest extends SeleniumBaseTest {

	private static final SinoptikUaActions googleActions = new SinoptikUaActions();

	/**
	 *  * purpose of the method is to check following scenario:
	 * 1. Opens sinoptik.ua in browser (HtmlUnit is preferred, but you're free to use any)
	 * 2. fill search field with "Воскресенье"(Sunday) and press Enter
	 * 3. find pressures (for nignt, morning, day, evening)
	 * 4. verify that pressures are in required range
	 * */
	@Test
	public void test() {
		googleActions.navigateTo();
		googleActions.searchString("Драгобрат");
		googleActions.clickSunday();
		googleActions.verifyPressures(600, 700);
	}

}
