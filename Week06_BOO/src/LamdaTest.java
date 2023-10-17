//6-2
interface ArrayProcessing{
	double apply(double[] array);
}

public class LamdaTest {
//(1)
	public static final ArrayProcessing maxer = array -> {
		if (array.length == 0) return 0; // 배열이 비어있는 경우 0을 반환
        double max = array[0];
        for (double num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    };
//(2)
	public static final ArrayProcessing miner = array -> {
		if (array.length == 0) return 0; // 배열이 비어있는 경우 0을 반환
        double min = array[0];
        for (double num : array) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    };
//(3)
	public static final ArrayProcessing sumer = array -> {
		if (array.length == 0) return 0; // 배열이 비어있는 경우 0을 반환
        double sum = 0;
        for (double num : array) {
            sum += num;
        }
        return sum / array.length;
    };

    public static void main(String[] args) {
        double[] numbers = { 12.5, 6.7, 9.2, 5.3, 18.6 };

        // 테스트
        double maxResult = maxer.apply(numbers);
        double minResult = miner.apply(numbers);
        double avgResult = sumer.apply(numbers);

        System.out.println("최대값: " + maxResult);
        System.out.println("최소값: " + minResult);
        System.out.println("평균값: " + avgResult);
    }
}