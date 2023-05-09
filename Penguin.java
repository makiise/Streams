package pgdp.streams;

import java.util.List;
import java.util.stream.Collectors; 

public class Penguin {
  private List<Geo> locations;
  private String trackID;

  public Penguin(List<Geo> locations, String trackID) {
    this.locations = locations;
    this.trackID = trackID;
  }

  @Override
  public String toString() {
    return "Penguin{" +
        "locations=" + locations +
        ", trackID='" + trackID + '\'' +
        '}';
  }

  public List<Geo> getLocations() {
    return locations;
  }

  public String getTrackID() {
    return trackID;
  }

  public String toStringUsingStreams() {
    String t = "Penguin{locations=[" + locations.stream().sorted((a, b) -> {
        int lat = Double.compare(b.getLatitude(), a.getLatitude());
        int lon = Double.compare(b.getLongitude(), a.getLongitude());
        return (lat == 0) ? lon : lat;
      }).map(a -> a.toString())
      .collect(Collectors.joining(", "));
    t += "], trackID='";
    t += trackID;
    t += "'}";
    return t;
  }
}
