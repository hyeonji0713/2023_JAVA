//6-1
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceLowerCase {

	public static void main(String[] args) {
		List<String> listNames = Arrays.asList(new String[]
				{"Apple", "Banana", "Cherry"});
		
		List<String> lowerCaseList = listNames.stream()
				.map(str -> str.toLowerCase()) // 람다식 사용해 소문자로 변환
                .collect(Collectors.toList());

        // 변환된 리스트 출력
        lowerCaseList.forEach(System.out::println);
	}
}