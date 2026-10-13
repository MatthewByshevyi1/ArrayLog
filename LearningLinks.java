public class LearningLinks {
    public static void main(String[] args) {
        Node one = new Node(20);

        //Node two = new Node(33);
        one.setLink(new Node(33));

        //Node three = new Node(1);
        one.getNext().setLink(new Node(1));

        Node temp = one;

        while(temp.getNext() != null) {
            //System.out.println(temp.getData());
            temp = temp.getNext();
        }

        temp.setLink(new Node(5));
        print(one);

        System.out.println("");

        Node hold = one;
        one = new Node(4);
        one.setLink(hold);
        print(one);

        System.out.println("");

        temp = one;
        while (one.getNext() != null) {
            if (Integer.valueOf(5).equals(temp.getNext().getData())) {
                if (temp.getNext().getNext() != null) {
                    temp.setLink(temp.getNext().getNext());
                } else {
                    temp.setLink(null);
                }
                break;
            }
            temp = temp.getNext();
        }
        print(one);
    }

    public static void print(Node head) {
        Node temp = head;

        while(temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
}
