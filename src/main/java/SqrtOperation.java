/**
 * <p>Реализуйте метод sqrt(), вычисляющий квадратный корень числа. В отличие от Math.sqrt(),
 * это метод при передаче отрицательного параметра должен бросать исключение
 * java.lang.IllegalArgumentException с сообщением "Expected non-negative number, got ?",
 * где вместо вопросика будет подставлено фактически переданное в метод число.</p>
 */

public class SqrtOperation {
    public double sqrt(double number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("Expected non-negative number, got " + number);
        }

        StringBuilder result = new StringBuilder();
        StringBuilder numberView = new StringBuilder(Double.toString(number));

        fillWithZero(numberView);

        int numberForCheck = Integer.parseInt(numberView.substring(0, 2));
        numberView.delete(0, 2);

        int firstValue = getFirstValue(numberForCheck);
        result.append(firstValue);

        int reducer = firstValue * firstValue;
        int dotPos = 1;

        while (numberView.length() > 0) {
            if (numberView.indexOf(".") == 0) {
                numberView.delete(0, 1);
                continue;
            } else if (numberView.indexOf(".") > 0) {
                dotPos++;
            }

            numberForCheck = 100 * (numberForCheck - reducer);
            numberForCheck += Integer.parseInt(numberView.substring(0, 2));
            numberView.delete(0, 2);

            reducer = getReducer(numberForCheck, result);
        }

        result.insert(dotPos, ".");

        return Double.parseDouble(result.toString());
    }

    public static int getReducer(int reducible, StringBuilder number) {
        int numberForCheck = 20 * Integer.parseInt(number.toString());
        int index = 1;

        while (true) {
            if ((numberForCheck + index) * index > reducible) {
                index--;
                break;
            }

            index++;
        }

        number.append(index);

        return (numberForCheck + index) * index;
    }

    public static int getFirstValue(int number) {
        int index = 0;

        while (true) {
            if (index * index > number) {
                index--;
                break;
            }

            index++;
        }

        return index;
    }

    public static void fillWithZero(StringBuilder number) {
        int dotPos = number.indexOf(".");

        if ((number.length() - dotPos + 1) % 2 != 0) {
            number.append(0);
        }

        if (dotPos % 2 != 0) {
            number.insert(0, 0);
        }
    }
}
