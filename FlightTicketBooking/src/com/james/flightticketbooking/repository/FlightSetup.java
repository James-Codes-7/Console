package repositary;

import model.Flight;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import view.FlightBookingManagementView;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class FlightSetup {

    private FlightBookingManagementView flightView;
    private FlightBookingDatabase flightBookingDatabase;

    public FlightSetup() {
        flightBookingDatabase = FlightBookingDatabase.getInstance();
    }
    public void flightSetUp() {

        try {
            Flight flight = new Flight();
            JSONParser jsonParser = new JSONParser();
            JSONObject object = (JSONObject) jsonParser.parse(new FileReader("C:\\Users\\HP\\IdeaProjects\\Script\\routes.json"));
            for (int j = 0; j < object.size(); j++) {
                JSONObject jsonObject = (JSONObject) object.get("flight" + (j + 1));
                Long integer = (Long) jsonObject.get("flightId");
                int convertValue = (int) integer.longValue();
                flight.setFlightId(convertValue);
                flight.setFlightName((String) jsonObject.get("flightName"));
                integer = (Long) jsonObject.get("noOfSeats");
                convertValue = (int) integer.longValue();
                flight.setNoOfSeats(convertValue);
                flight.setArraivalTime((String) jsonObject.get("arraivalTime"));
                flight.setDepartureTime((String) jsonObject.get("departureTime"));
                integer = (Long) jsonObject.get("fare");
                convertValue = (int) integer.longValue();
                flight.setFare(convertValue);
                ArrayList<String> routes = new ArrayList<>();
                JSONArray jsonArray = (JSONArray) jsonObject.get("routes");
                for (int index = 0; index < jsonArray.size(); index++) {
                    routes.add((String) jsonArray.get(index));
                }
                flight.setFlightRoutes(routes);
                flightBookingDatabase.setFlightList(flight);
            }
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
    }
}
