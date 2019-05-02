
public class ListReversalRecursive {
	Node start = null;
	public static void main(String[] args){
		ListReversalRecursive foo = new ListReversalRecursive();
		foo.start = new Node(1);
		foo.start.add(2).add(3).add(4).add(5).add(6).add(7).add(8).add(9).add(10);
		System.out.println("Original List: "+foo.start);
		Node temp = foo.start;
		foo.reverseList(foo.start);
		temp.next = null;
		System.out.println("Reversed List: "+foo.start);
	}
	
	void reverseList(Node ptr){
		if(ptr.next.next == null){
			this.start = ptr.next;
			ptr.next.next = ptr;
			return;
		}
		reverseList(ptr.next);
		ptr.next.next = ptr;
	}
}

class Node{
	int data;
	Node next; 
	
	Node(int data){
		this.data = data;
		this.next = null;
	}
	
	Node add(int data)
	{
		Node iterator = this;
		while(iterator.next != null){
			iterator = iterator.next;
		}
		iterator.next = new Node(data);
		return this;
	}
	
	@Override
	public String toString(){
		Node temp = this;
		String str = "";
		while(temp!=null){
			str = str + ""+temp.data + (temp.next==null?"":"-->");
			temp = temp.next;
		}
		return str;
	}
}