import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegisterOfCountries {
//    public static final String DELIMITER = "\t";

    private List<Country> countries = new ArrayList<>();

    public void readCountriesFromFile(String filename) throws CountryException {
        String nextLine = null;
        String[] countries = new String[0];

        String name = null;
        String state = null;
        Double fullRate = null;
        Double reducedRate = null;
        Boolean usesRate = null;

        int lineNumber = 0;
        String separator = "\t";

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (scanner.hasNextLine()) {
                lineNumber++;
                nextLine = scanner.nextLine();
                countries = nextLine.split(separator);
                name = countries[0];
                state = countries[1];
                fullRate = Double.parseDouble(countries[2]);
                reducedRate = Double.parseDouble(countries[3]);
                usesRate = Boolean.getBoolean(countries[4]);

            }
        } catch (FileNotFoundException e) {
            throw new CountryException(
                    "Nepodařilo se najít soubor "+filename+":"+e.getLocalizedMessage());
        }
    }
}
