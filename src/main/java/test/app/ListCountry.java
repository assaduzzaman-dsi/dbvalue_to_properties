package test.app;

import java.util.Locale;

public class ListCountry {

    public static void main(String[] args) {

	ListCountry obj = new ListCountry();
	obj.run();

    }

    public void run() {

	String[] locales = Locale.getISOCountries();

	for (String countryCode : locales) {

		Locale obj = new Locale("", countryCode);

		System.out.println("Country Code = " + obj.getCountry()
			+ ", Country Name = " + obj.getDisplayCountry() + " language = " + obj.getLanguage());

	}

	System.out.println("Done");
    }

}