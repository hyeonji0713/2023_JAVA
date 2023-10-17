import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//6-3
enum Type {
	MEAT, FISH, OTHER
}	//열거형 상수집합을 정의하는 데이터 유형

public class FoodTest {
	public static void main(String[] args) {
		List<Food> menu = new ArrayList<>();
		menu.add(new Food("Steak", false, 500, Type.MEAT));
	    menu.add(new Food("Salmon", false, 300, Type.FISH));
	    menu.add(new Food("Vegetable Stir-Fry", true, 200, Type.OTHER));
	    menu.add(new Food("Chicken Salad", false, 350, Type.MEAT));

		
		 // 람다식과 스트림 사용해 칼로리가 300 이하의 채식 음식 이름 추출
        List<String> vegetarianLowCalorieFoods = menu.stream()
                .filter(food -> food.isVege() && food.getCalories() <= 300)
                .map(Food::getName)
                .collect(Collectors.toList());

        // 결과 출력
        System.out.println("칼로리가 300 이하이고 채식에 속하는 음식:");
        vegetarianLowCalorieFoods.forEach(System.out::println);
	}
}
