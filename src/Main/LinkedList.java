package Main;

public class LinkedList<TYPE> {
	private Node<TYPE> _head 	= null;
	private Node<TYPE> _tail 	= null;
	private Node<TYPE> _it_curr = null;
	private int  	   _size	= 0;
	
	interface SearchCallBack<TYPE> { Boolean call(TYPE a, TYPE b); }
	
	public LinkedList(TYPE data) {
		_head 		= new Node<TYPE>(data);
		_tail 		= new Node<TYPE>();
		_head._data = data;
		_tail.prev 	= _head;
		_head.next 	= _tail;
		_size++;
	}
	public Boolean insert(TYPE data) {
		if(_tail._data == null) {
			_tail._data = data;
			_size++;
			return true;
		}
		
		Node<TYPE> newNode 	= new Node<TYPE>(data);
		_tail.next 		= newNode;
		newNode.prev 		= _tail;
		newNode.next 		= null;
		_tail 			= newNode;
		
		_size++;
		return true;
	}
	public void insertHead(TYPE data) {
		Node<TYPE> newNode 	= new Node<TYPE>(data);
		_head.prev 			= newNode;
		newNode.next 		= _head;
		if(_size == 0) { _tail = _head; }
		_head 				= newNode;
		_size++;
	}
	public Node<TYPE> deleteHead(){
		Node<TYPE> currentHead 	= _head;
		if(_head.next == null) {
			_head 		= null;
			_head 		= new Node<TYPE>();
			_head.next 	= new Node<TYPE>();
			_head.prev 	= new Node<TYPE>();
		}if(_head.next != null) {
			_head.next.prev = null;
			_head 		= _head.next;
			_size--;
			return currentHead;
		}
		return null;
	}
	public void insertTail(TYPE data) { 
		insert(data);
	}
	public void deleteTail() {
		_tail 		= _tail.prev;
		_tail.next 	= null;
		_size--;
	}
	public void insertPOS(int POS, TYPE data) {
		if(POS == 0) {
			insertHead(data);
			return;
		}
		if(POS > _size) {
			insertTail(data);
			return;
		}
		for(int i = 0; Iterator() == true; i++) {
			if(i == POS) {
				Node<TYPE> newNode 	= new Node<TYPE>(data);
				newNode	.prev 		= _it_curr.prev;
				_it_curr.prev.next 	= newNode;
				_it_curr.prev 		= newNode;
				newNode.next 		= _it_curr;
				_it_curr 		= null;
				_size++;
				return;
			}
		}
	}
	public void SearchAndRemoveFirstInstance(TYPE data) {
		_it_curr = null;
		while(Iterator()) {
			if(_it_curr._data.equals(data)) {
				if(_it_curr.prev == null) {
					deleteHead();
					_it_curr = null;
					_size--;
					return;
				}
				if(_it_curr.next == null) {
					_it_curr = null;
					_size--;
					deleteTail();
					return;
				}
				_it_curr.prev.next = _it_curr.next;
				_it_curr.next.prev = _it_curr.prev;
				_it_curr = null;
				return;
			}
		}
	}
	public void SearchAndRemoveFirstInstance(TYPE searchTerm, SearchCallBack<TYPE> callback) {
		_it_curr = null;
		while(Iterator()) {
			if(callback.call(searchTerm, _it_curr._data)) {
				if(_it_curr.prev == null) {
					deleteHead();
					_size--;
					_it_curr = null;
					return;
				}
				if(_it_curr.next == null) {
					deleteTail();
					_size--;
					_it_curr = null;
					return;
				}
				_it_curr.prev.next = _it_curr.next;
				_it_curr.next.prev = _it_curr.prev;
				_size--;
				_it_curr = null;
				return;
			}
		}
	}
	public void searchAndRemove(TYPE searchTerm, SearchCallBack<TYPE> callback) {
		_it_curr = null;
		while(Iterator()) {
			if(callback.call(searchTerm, _it_curr._data)) {
				if(_it_curr.prev == null) {
					deleteHead();
					_size--;
					continue;
				}
				if(_it_curr.next == null) {
					deleteTail();
					_size--;
					return;
				}
				_it_curr.prev.next = _it_curr.next;
				_it_curr.next.prev = _it_curr.prev;
				_size--;
			}
		}
	}
	public Boolean Iterator(Boolean reverse) {
		
		if(_it_curr == null) {
			if(reverse == false) _it_curr = _head;
			if(reverse == true && _size > 1) {
				_it_curr = _tail;
			}else if(reverse == true) {
				return false;
			}
			return true;
		}
		
		if(reverse == false) {
			_it_curr = _it_curr.next;
			
			if(_it_curr == null) return false;
		}
		
		if(reverse == true) {
			_it_curr = _it_curr.prev;
			
			if(_it_curr == null) return false;
		}
		
		return true;
	}
	public Boolean 			Iterator		() 	{ return Iterator(false); 	}
	public Node		<TYPE> 	getCurrentNode		() 	{ return _it_curr; 		}
	public Node		<TYPE> 	getHead			()	{ return _head; 		}
	public Node		<TYPE> 	getTail			() 	{ return _tail; 		}
	public int 			getSize			()	{ return _size;			}
	public Boolean			isEmpty			()	{ if(_size == 0) return true;
								  	return false;    		}
}
