package SystemDesign;

public class Testing {

	
    public static String idToShortKey(int id) {
        String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String short_url = "";
        while (id > 0) {
            short_url = chars.charAt(id % 62) + short_url;
            id = id / 62;
        }
        while (short_url.length() < 6) {
            short_url = "0" + short_url;
        }
        return short_url;
    }
    
    
	public static void main(String[] args) {
		System.out.println(idToShortKey(1));
		System.out.println(idToShortKey(2));
		System.out.println(idToShortKey(3));
		System.out.println(idToShortKey(200001));
		System.out.println(idToShortKey(200002));
		
	}

}
