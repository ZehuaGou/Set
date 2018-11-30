import java.util.ArrayList;

/**
 * @author Li Ersan
 */
public class Main {

    private static double testSet(Set<String> set, String filename) {
        long startTime = System.nanoTime();

        System.out.println(filename);

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile(filename, words1)) {
            System.out.println("总共单词数: " + words1.size());

            for (String word : words1) {
                set.add(word);
            }

            System.out.println("共有不同单词数：" + set.getSize());
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        String filename = "pride-and-prejudice.txt";
        Set<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("BST Set: " + time1 + " s");
        System.out.println();

        Set<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, filename);
        System.out.println("LinkedList Set: " + time2 + " s");
        System.out.println();

        Set<String> avlSet = new AVLSet<>();
        double time3 = testSet(avlSet, filename);
        System.out.println("AVL Set: " + time3 + " s");
    }
}
