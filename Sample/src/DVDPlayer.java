public class DVDPlayer implements ExPlayer{
	public void play() {
		System.out.println("DVD 재생 시작");
	}
	public void stop() {
		System.out.println("DVD 재생 정지");
	}
	public void slow() {
		System.out.println("DVD 느린 재생 시작");
	}
}