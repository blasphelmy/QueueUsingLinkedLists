package Main;

public class Queue<TYPE> extends LinkedList<TYPE> {
	
	private int	 		_limit = 2147483647;
	
	public 			Queue	(TYPE data, int limit) {        super(data);
									_limit = limit;			}
	
	public 			Queue	(TYPE data) 		{ 	super(data); 			}

	public void 		enqueue	(TYPE data)		{	if(this.getSize() > _limit) return;
									this.insert(data);		}
	
	public Node<TYPE> 	dequeue	() 			{ 	return this.deleteHead(); 	}
	
	public void 		setLimit(int limit) 		{ 	_limit = limit; 		}
	
	public Node<TYPE> 	peek	()			{ 	return this.getHead(); 		}
}
