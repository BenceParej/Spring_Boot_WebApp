package StockTracker;

import com.baeldung.soap.ws.client.generated.MNBArfolyamServiceSoap;
import com.baeldung.soap.ws.client.generated.MNBArfolyamServiceSoapImpl;
import com.baeldung.soap.ws.client.generated.ObjectFactory;
import jakarta.xml.bind.JAXBElement;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import java.io.StringReader;

public class MNBTest {
    @Test
    public void aaa() {
        MNBArfolyamServiceSoapImpl impl = new MNBArfolyamServiceSoapImpl();
        MNBArfolyamServiceSoap service = impl.getCustomBindingMNBArfolyamServiceSoap();
        try {
            String resp = service.getCurrencies();
            ObjectFactory a = new ObjectFactory();
            var response = a.createGetCurrenciesResponseBodyGetCurrenciesResult(resp);
            var o = a.createGetCurrenciesResponseBody();
            o.setGetCurrenciesResult(response);
            System.out.println(resp);
            parseXml(resp);
        } catch (Exception e) {
            System.err.print(e);
        }
    }

    @Test
    public void aada() {
        MNBArfolyamServiceSoapImpl impl = new MNBArfolyamServiceSoapImpl();
        MNBArfolyamServiceSoap service = impl.getCustomBindingMNBArfolyamServiceSoap();
        try {
            String resp = service.getExchangeRates("2022-12-12", "2022-12-25", "HUF,USD");
            System.out.println(resp);
            parseXml(resp);
        } catch (Exception e) {
            System.err.print(e);
        }
    }

    public void parseXml(String xmlString) {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                    .parse(new InputSource(new StringReader(xmlString)));
            NodeList rateList = doc.getElementsByTagName("Rate");
            for (int i = 0; i < rateList.getLength(); i++) {
                String date = rateList.item(i).getParentNode().getAttributes().getNamedItem("date").getTextContent();
                String curr = rateList.item(i).getAttributes().getNamedItem("curr").getTextContent();
                String rate = rateList.item(i).getTextContent();
                System.out.println("Date: " + date + ", Currency: " + curr + ", Rate: " + rate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
