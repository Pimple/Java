/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2015.pkg03.pkg24.cojofa;

/**
 *
 * @author HenrikBN
 */
public class DeepThought implements TestInterface
{
	private int currentAnswer;
	
	public DeepThought()
	{
		currentAnswer = 42;
	}

	@Override
	public int getCurrentAnswer()
	{
		return currentAnswer;
	}

	@Override
	public int getTheRightAnswer(String theWrongQuestion)
	{
		if (theWrongQuestion.equals(""))
			return 42;
		else
			return 9001;
	}

	@Override
	public int messUpUniverse(int multiplier)
	{
		currentAnswer *= multiplier;
		return currentAnswer;
	}
	
}
