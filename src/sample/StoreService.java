package sample;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService(serviceName = "DisplayAssortment", portName = "DisplayAssortmentPort", targetNamespace = "http://asu.dgtu.donetsk.ua/ex/passexam")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public class StoreService {
    // store Clothes assortment
    private static Clothes[] clothesData = {
            new Clothes("1", "Addidas", "Winter clothes", "Jacket", "L",8000),
            new Clothes("2", "Puma", "Summer clothes", "T-shirt", "L",1500),
            new Clothes("3", "Nike", "Winter clothes", "Cap", "M",1200),
            new Clothes("4", "Nike", "Summer clothes", "Shorts", "XL",1500),
            new Clothes("5", "Puma ", "Winter clothes", "Jacket", "XXL",7000)
    };
    // the number of products in the store
    private static int[] quantityData = {5, 4, 3, 2, 1};
    private static StoreAssortment storeAssortment = new StoreAssortment(clothesData, quantityData);

    @WebMethod(operationName = "GetStoreAssortment")
    public StoreAssortment getStoreAssortment() {
        return storeAssortment;
    }

}