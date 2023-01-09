package async;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.Endpoint;

@WebService(serviceName = "Reservation", portName = "ReservationPort", targetNamespace = "http://asu.dgtu.donetsk.ua/ex/students")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public class ReservationService {

	// store Clothes assortment
	//TODO поменять
	private static Clothes[] clothesData = {
			new Clothes("1", "Addidas", "Winter clothes", "Jacket", "L",8000),
			new Clothes("2", "Puma", "Summer clothes", "T-shirt", "L",1500),
			new Clothes("3", "Nike", "Winter clothes", "Cap", "M",1200),
			new Clothes("4", "Nike", "Summer clothes", "Shorts", "XL",1500),
			new Clothes("5", "Puma ", "Winter clothes", "Jacket", "XXL",7000)
	};
	// the number of products in the store
	private static int[] quantityData = {0, 2, 3, 5, 1};
	private static StoreAssortment storeAssortment = new StoreAssortment(clothesData, quantityData);
	private UserReserve goReserveClothes(String type, int quantity) {
		int size = storeAssortment.getClothess().length;
		for (int i = 0; i < size; i++) {
			Clothes currentClothes = storeAssortment.getClothess()[i];
			int currentQuantity = storeAssortment.getQuantity()[i];
			if (type.equals(currentClothes.getType()) && quantity <= currentQuantity) {
				storeAssortment.setQuantityFromIndex(i, currentQuantity - quantity);
				return new UserReserve(currentClothes, quantity);
			}
		}
		return null;
	}

	@WebMethod(operationName = "ReserveClothes")
	public UserReserve reserveClothes(String type, int quantity) {
		try {
			Thread.sleep(1000*10); // Sleep for 10 seconds
			return goReserveClothes(type, quantity);
		} catch(InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}

	 public static void main(String args[]) {
	        Endpoint.publish("http://localhost:8088/Reservation", new ReservationService());
	  }
}
