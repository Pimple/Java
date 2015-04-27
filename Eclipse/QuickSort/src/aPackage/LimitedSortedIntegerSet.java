package aPackage;



public class LimitedSortedIntegerSet {

    public final int limit;


    /*@ public invariant (\forall int i;
      @                           0 < i && i < size;
      @                           arr[i-1] <= arr[i]);
      @*/

    private /*@ spec_public @*/ int arr[];
    private /*@ spec_public @*/ int size = 0;
    

    public LimitedSortedIntegerSet(int limit) {
	this.limit = limit;
	this.arr = new int[limit];
    }


    /*@ public normal_behavior
      @ requires size < limit && !contains(elem);
      @ ensures \result == true;
      @ ensures contains(elem); 
      @ ensures (\forall int e;
      @                  e != elem;
      @                  contains(e) <==> \old(contains(e)));
      @ ensures size == \old(size) + 1;
      @
      @ also
      @
      @ public normal_behavior
      @ requires (size == limit) || contains(elem);
      @ ensures \result == false; 
      @ ensures (\forall int e;
      @                  contains(e) <==> \old(contains(e)));
      @ ensures size == \old(size);
      @*/
    public boolean add(int elem) {/*...*/ return true;}
    

    /*@ public normal_behavior
      @ ensures !contains(elem); 
      @ ensures (\forall int e;
      @                  e != elem;
      @                  contains(e) <==> \old(contains(e)));
      @ ensures \old(contains(elem))
      @         ==> size == \old(size) - 1;
      @ ensures !\old(contains(elem))
      @         ==> size == \old(size);
      @*/
    public void remove(int elem) {/*...*/}


    /*@ public normal_behavior
      @ ensures \result == (\exists int i;
      @                             0 <= i && i < size;
      @                             arr[i] == elem);
      @*/
    public /*@ pure @*/ boolean contains(int elem) {/*...*/ return true;}
    
    // other methods
}
