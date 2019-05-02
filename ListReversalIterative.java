
public class ListReversalIterative {

	Node2 start = null;
	public static void main(String[] args){
		ListReversalIterative foo = new ListReversalIterative();
		foo.start = new Node2(1);
		foo.start.add(2).add(3).add(4).add(5).add(6).add(7).add(8).add(9).add(10);
		System.out.println("Original List: "+foo.start);
		foo.reverseList(foo.start);
		System.out.println("Reversed List: "+foo.start);
	}
	
	void reverseList(Node2 ptr){
		Node2 nextNode = ptr.next;
		Node2 nextnextNode = nextNode.next;
		ptr.next = null;
		while(nextnextNode!=null){
			nextnextNode = nextNode.next;
			nextNode.next = ptr;
			ptr = nextNode;
			nextNode = nextnextNode;
		}
		this.start = ptr;
	}
}

class Node2{
	int data;
	Node2 next; 
	
	Node2(int data){
		this.data = data;
		this.next = null;
	}
	
	Node2 add(int data)
	{
		Node2 iterator = this;
		while(iterator.next != null){
			iterator = iterator.next;
		}
		iterator.next = new Node2(data);
		return this;
	}
	
	@Override
	public String toString(){
		Node2 temp = this;
		String str = "";
		while(temp!=null){
			str = str + ""+temp.data + (temp.next==null?"":"-->");
			temp = temp.next;
		}
		return str;
	}
}
