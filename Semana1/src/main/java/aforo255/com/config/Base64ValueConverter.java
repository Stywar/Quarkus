package aforo255.com.config;
import org.eclipse.microprofile.config.spi.Converter;
public class Base64ValueConverter  implements Converter<Base64Value>{

	@Override
	public Base64Value convert(String value) {
		// TODO Auto-generated method stub
		 return new Base64Value(value);
	}

}
