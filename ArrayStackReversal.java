public class ArrayStackReversal {
    static class ArrayStack {
        private int[] data;
        private int top;

        public ArrayStack(int initialCapacity) {
            data = new int[initialCapacity];
            top = 0;
        }

        public void push(int value) {
            if (top == data.length) {
                expandCapacity();
            }
            data[top++] = value;
        }

        public int pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return data[--top];
        }

        public int peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return data[top - 1];
        }

        public boolean isEmpty() {
            return top == 0;
        }

        public int size() {
            return top;
        }

        private void expandCapacity() {
            int[] bigger = new int[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                bigger[i] = data[i];
            }
            data = bigger;
        }
    }

    public static int[] reverseArray(int[] numbers) {
        ArrayStack stack = new ArrayStack(2);

        for (int i = 0; i < numbers.length; i++) {
            stack.push(numbers[i]);
        }

        int[] reversed = new int[numbers.length];

        int i = 0;
        while (!stack.isEmpty()) {
            reversed[i] = stack.pop();
            i++;
        }

        return reversed;
    }

    public static int[] reverseFirstK(int[] numbers, int k) {
        if (k > numbers.length) k = numbers.length;
        if (k <= 1) return numbers.clone();

        ArrayStack stack = new ArrayStack(2);

        for (int i = 0; i < k; i++) {
            stack.push(numbers[i]);
        }

        int i = 0;
        while (!stack.isEmpty()) {
            numbers[i] = stack.pop();
            i++;
        }

        return numbers;
    }

    public static void main(String[] args) {

        System.out.println("=== Main Problem: reverseArray ===");

        int[] numbers = {10, 20, 30, 40, 50};
        int[] result = reverseArray(numbers);
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Example 1: " +
                java.util.Arrays.toString(reverseArray(new int[]{101, 102, 103, 104, 105})));

        System.out.println("Example 2: " +
                java.util.Arrays.toString(reverseArray(new int[]{10, 20, 30})));

        System.out.println("Example 3: " +
                java.util.Arrays.toString(reverseArray(new int[]{7})));

        System.out.println("\n=== Bonus Challenge: reverseFirstK ===");

        int[] bonus = {10, 20, 30, 40, 50};
        int[] bonusResult = reverseFirstK(bonus, 3);
        for (int num : bonusResult) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}