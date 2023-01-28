package Main;

public class Node<TYPE> {
	
	public Node<TYPE> 	next		;
	public Node<TYPE> 	prev		;
	public TYPE 		_data = null;
	
	public Node(TYPE data) 	{ this._data = data; 	}
	public Node(         ) 	{			}
}
