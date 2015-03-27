package pkg2015.pkg03.pkg24.cojofa;

import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

@Invariant("getCurrentAnswer() <= 42")
public interface TestInterface
{
	public int getCurrentAnswer();
	
	@Requires("theWrongQuestion.equals(\"What is the answer to the life, the universe and everything?\")")
	@Ensures("getCurrentAnswer() == 42")
	public int getTheRightAnswer(String theWrongQuestion);
	
	@Requires("multiplier >= 0")
	public int messUpUniverse(int multiplier);
}
