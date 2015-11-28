
package hello;

import countries.wsdl.Country;
import countries.wsdl.GetCountryRequest;
import countries.wsdl.GetCountryResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CountriesClient extends WebServiceGatewaySupport {

    public Country getCountry(String name) {
        GetCountryRequest request = new GetCountryRequest();
        request.setName(name);

        return ((GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        "http://localhost:8090/ws",
                        request,
                        new SoapActionCallback("getCountryRequest")))
                .getCountry();
    }

}
