public class PostfixCalculator implements IPostfixCalculator {

    private IStack<Integer> stack;

    public PostfixCalculator(IStack<Integer> stack) {
        this.stack = stack;
    }

    @Override
    public int evaluate(String expression) {
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (token.matches("\\d+")) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperation(a, b, token);
                stack.push(result);
            }
        }
        return stack.pop();
    }

    private int applyOperation(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("División entre cero");
                }
                return a / b;
            case "%": return a % b;
            default:
                throw new IllegalArgumentException("Operador inválido");
        }
    }
}
