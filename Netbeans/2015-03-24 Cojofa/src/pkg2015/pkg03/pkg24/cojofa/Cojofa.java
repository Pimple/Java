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
public class Cojofa
{
	public static void main(String[] args)
	{
		TestInterface computer = new DeepThought();
		System.out.println(computer.getCurrentAnswer());
	}
}
